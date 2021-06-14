package com.api.SafetyNetAlerts.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.SafetyNetAlerts.model.MedicalRecord;





public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long> {

}
