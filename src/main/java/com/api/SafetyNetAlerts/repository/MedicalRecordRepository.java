package com.api.SafetyNetAlerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.SafetyNetAlerts.model.MedicalRecord;



//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long> {

}
