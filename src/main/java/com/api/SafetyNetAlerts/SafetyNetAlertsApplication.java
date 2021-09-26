package com.api.SafetyNetAlerts;



import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.JsonFileParser;

@SpringBootApplication
public class SafetyNetAlertsApplication implements CommandLineRunner {
   
   private static final Logger logger = LogManager.getLogger(SafetyNetAlertsApplication.class);
   

   public static void main(String[] args) {
      SpringApplication.run(SafetyNetAlertsApplication.class, args);
   }

   @Override
   public void run(String... args) throws Exception {
      //JsonFileParser.readFile();

      JSONObject o =JsonFileParser.readJsonFromUrl(JsonFileParser.URL);
      //ObjectMapper mapper = new ObjectMapper();
      JSONArray persons = (JSONArray)o.get("persons");
      List<Person> list = new ArrayList<>();
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
           
            list.add(person);
         }
      }
      JSONArray mrJsonArray = (JSONArray)o.get("medicalrecords");
      List<MedicalRecord> mrList = new ArrayList<>();
      if (mrJsonArray != null) {
         for (int i=0;i<mrJsonArray.length();i++){
            MedicalRecord mr = new MedicalRecord();
            List<String> medicationsList = new ArrayList<>(); 
            JSONArray medicationsArray = mrJsonArray.getJSONObject(i).getJSONArray("medications");
            for (int j = 0; j < medicationsArray.length(); j++) {
                String med = (String) medicationsArray.get(j);
                medicationsList.add(med);
         }
            List<String> allergies = new ArrayList<>();
			mr.setFirstName((String)mrJsonArray.getJSONObject(i).get("firstName"));
            mr.setLastName((String)mrJsonArray.getJSONObject(i).get("lastName"));
           // mr.setBirthdate((LocalDate) mrJsonArray.getJSONObject(i).get("birthdate"));
            JSONArray alls = mrJsonArray.getJSONObject(i).getJSONArray("allergies");
            for (int j = 0; j < alls.length(); j++) {
               String all = (String) alls.get(j);
               allergies.add(all);
            }
            mr.setMedications(medicationsList);
            mrList.add(mr);
            mr.setAllergies(allergies);
            mrList.add(mr);
         
         mr.setAllergies(allergies);
         
         }
      }
     
    System.out.println(mrList.get(3));
   }
}
