package com.api.SafetyNetAlerts.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.api.SafetyNetAlerts.model.Allergies;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
//@Transactional
@Qualifier("allergies")
@Repository
public interface AllergiesRepository extends CrudRepository<Allergies, Integer> {

}
