package com.api.SafetyNetAlerts.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.SafetyNetAlerts.model.MedicalRecord;



//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long> {

}
