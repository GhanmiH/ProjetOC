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

	Optional<MedicalRecord> findByFirstNameAndLastName(String firstname, String lastname);

	void deleteMedicalRecordsByFirstNameAndLastName(String firstName, String lastName);

	List<MedicalRecord> findAllByLastNameAllIgnoreCase(String lastName);

	MedicalRecord findMedicalRecordByLastNameAndFirstName(String lastName, String firstName);

	

}
