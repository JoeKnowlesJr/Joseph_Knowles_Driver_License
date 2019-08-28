package com.joeknowles.Relationships.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.joeknowles.Relationships.models.License;
import com.joeknowles.Relationships.models.Person;
import com.joeknowles.Relationships.repository.LicensesRepository;
import com.joeknowles.Relationships.repository.PersonsRepository;

@Service
public class RelationshipService {
	private PersonsRepository pRepo;
	private LicensesRepository lRepo;
	
	public RelationshipService(PersonsRepository pRepo, LicensesRepository lRepo) { this.pRepo = pRepo; this.lRepo = lRepo; }
	
    public List<Person> allPersons() { return pRepo.findAll(); }
	public void createPerson(@Valid Person person) { pRepo.save(person); }
	public Optional<Person> findPersonById(Integer id) { return pRepo.findById(id); }
	
    public List<License> allLicenses() { return lRepo.findAll(); }
	public void createLicense(@Valid License license) { lRepo.save(license); }
	public String getNextLicenseNumber() { return String.format("%05d", lRepo.count() + 1); }
}
