package com.api.SafetyNetAlerts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.SafetyNetAlerts.model.Allergies;
import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Medications;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.AllergieService;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.JsonFileParser;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.MedicationService;
import com.api.SafetyNetAlerts.service.PersonService;

@SpringBootApplication
public class SafetyNetAlertsApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(SafetyNetAlertsApplication.class);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	
	@Autowired
	private PersonService personService;

	@Autowired
	private FireStationService fireStationService;

	@Autowired
	private MedicalRecordService medicalRecordService;

	@Autowired
	private AllergieService allergieService;
	
	@Autowired
	private MedicationService medicationService;
	
	public static void main(String[] args) {
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//JsonFileParser.readFile();

		JSONObject o =JsonFileParser.readJsonFromUrl(JsonFileParser.URL);
		//ObjectMapper mapper = new ObjectMapper();
		JSONArray persons = (JSONArray)o.get("persons");

		if (persons != null) {
			for (int i=0;i<persons.length();i++){
				Person person = new Person();
				person.setFirstName((String) persons.getJSONObject(i).get("firstName"));
				person.setLastName((String) persons.getJSONObject(i).get("lastName"));
				person.setAddress((String) persons.getJSONObject(i).get("address"));
				person.setCity((String) persons.getJSONObject(i).get("city"));
				person.setZip((String) persons.getJSONObject(i).get("zip"));
				person.setPhone((String) persons.getJSONObject(i).get("phone"));
				person.setEmail((String) persons.getJSONObject(i).get("email"));

				personService.addPerson(person);
			}
		}

		JSONArray firestations = (JSONArray)o.get("firestations");
		if (firestations != null) {
			for (int i=0;i<firestations.length();i++){
				FireStation fireStation = new FireStation();
				fireStation.setAddress((String) firestations.getJSONObject(i).get("address"));
				fireStation.setStation((String) firestations.getJSONObject(i).get("station"));

				fireStationService.addFirestation(fireStation);
			}
		}


		JSONArray mrJsonArray = (JSONArray)o.get("medicalrecords");
		List<MedicalRecord> mrList = new ArrayList<>();
		if (mrJsonArray != null) {
			for (int i=0;i<mrJsonArray.length();i++){
				MedicalRecord medicalRecord = new MedicalRecord();
				List<Medications> medicationsList = new ArrayList<>(); 
				JSONArray medicationsArray = mrJsonArray.getJSONObject(i).getJSONArray("medications");
				for (int j = 0; j < medicationsArray.length(); j++) {
					String med = (String) medicationsArray.get(j);
					Medications medication = new Medications();
					medication.setMedication(med);
					medicationsList.add(medication);
					medicationService.addMedication(medication);
				}
				List<Allergies> allergies = new ArrayList<>();
				String firstName = (String)mrJsonArray.getJSONObject(i).get("firstName");
				String lastName = (String)mrJsonArray.getJSONObject(i).get("lastName");
				
				//personService.getPersonByFirstNameAndLastName(firstName, lastName).get();
				medicalRecord.setFirstName(firstName);
				medicalRecord.setLastName(lastName);
				medicalRecord.setBirthdate(LocalDate.parse((String)mrJsonArray.getJSONObject(i).get("birthdate"), formatter));
				
				
				JSONArray alls = mrJsonArray.getJSONObject(i).getJSONArray("allergies");
				for (int j = 0; j < alls.length(); j++) {
					String all = (String) alls.get(j);
					Allergies allergy = new Allergies();
					allergy.setAllergie(all);
					allergies.add(allergy);
					allergieService.addAllergy(allergy);
				}
				medicalRecord.setMedications(medicationsList);
				mrList.add(medicalRecord);
				medicalRecord.setAllergies(allergies);
				mrList.add(medicalRecord);

				medicalRecord.setAllergies(allergies);
				medicalRecordService.saveMedicalRecord(medicalRecord);
			}
		}
	}
}