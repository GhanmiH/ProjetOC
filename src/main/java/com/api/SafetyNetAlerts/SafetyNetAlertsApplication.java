package com.api.SafetyNetAlerts;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.SafetyNetAlerts.controller.MedicalRecordController;
import com.api.SafetyNetAlerts.model.Person;

@SpringBootApplication
public class SafetyNetAlertsApplication implements CommandLineRunner {
   
   private static final Logger logger = LogManager.getLogger(SafetyNetAlertsApplication.class);
   

   public static void main(String[] args) {
      SpringApplication.run(SafetyNetAlertsApplication.class, args);
   }

   @Override
   public void run(String... args) throws Exception {
      JsonFileParser.readFile();

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
      JSONArray medicalRecords = (JSONArray)o.get("medicalrecords");
      List<MedicalRecord> mrList = new ArrayList<>();
      if (medicalRecords != null) {
         for (int i=0;i<medicalRecords.length();i++){
            MedicalRecord mr = new MedicalRecord();
            List<String> allergies = new ArrayList<>();
            mr.setFirstName((String)medicalRecords.getJSONObject(i).get("firstName"));
            mr.setLastName((String)medicalRecords.getJSONObject(i).get("lastName"));
            JSONArray alls = medicalRecords.getJSONObject(i).getJSONArray("medications");
            for (int j = 0; j < alls.length(); j++) {
               String all = (String) alls.get(j);
               allergies.add(all);
            }
            mr.setAllergies(allergies);
            mrList.add(mr);
         }
      }
      System.out.println(mrList);
   }
}
