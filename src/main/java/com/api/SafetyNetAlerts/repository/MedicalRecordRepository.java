package com.api.SafetyNetAlerts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.SafetyNetAlerts.model.MedicalRecord;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long> {

	//MedicalRecord findByPersonId(int personId);

	//void deleteMedicalRecordsByFirstNameAndLastName(String person);

	List<MedicalRecord> findAllByPersonIdAllIgnoreCase(String person);

	//MedicalRecord findMedicalRecordByLastNameAndFirstName(String person);

	

	void deleteMedicalRecordsByPersonId(int person);

	MedicalRecord findMedicalRecordByPersonId(String person);

	Optional<MedicalRecord> findByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);



}
