package com.joeknowles.Relationships.repository;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.joeknowles.Relationships.models.License;

@Repository
public interface LicensesRepository extends CrudRepository<License, Integer> {
	List<License> findAll();
}

