package com.joeknowles.Relationships.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joeknowles.Relationships.models.Person;

@Repository
public interface PersonsRepository extends CrudRepository<Person, Integer> {
	List<Person> findAll();
	
//	@Query(value="SELECT first_name, last_name FROM persons")
//	List<String> getNames();
}
