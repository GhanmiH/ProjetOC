package com.api.SafetyNetAlerts.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.SafetyNetAlerts.model.MedicalRecord;

@Repository
@Qualifier("medicalrecords")
@Transactional
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long> {

	Optional<MedicalRecord> findByFirstNameAndLastNameAllIgnoreCase(String firstname, String lastname);

	MedicalRecord findMedicalRecordByLastNameAndFirstName(String lastName, String firstName);

	void deleteMedicalRecordByLastNameAndFirstName(String lastName, String firstName);

	void deleteMedicalRecordsByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);

}