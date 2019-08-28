package com.joeknowles.Relationships.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.joeknowles.Relationships.models.FormLicense;
import com.joeknowles.Relationships.models.License;
import com.joeknowles.Relationships.models.Person;
import com.joeknowles.Relationships.services.RelationshipService;

@Controller
public class RelationshipsController {
	RelationshipService service;
	
	public RelationshipsController(RelationshipService svc) { this.service = svc; }
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("persons", service.allPersons());
		return "index.jsp";
	}
	
	@InitBinder
	public void customizeBinding(WebDataBinder binder) {
		SimpleDateFormat dFmt = new SimpleDateFormat("dd-MMM-yyyy");
		dFmt.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dFmt, true));
		binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	@GetMapping("/addPerson")
	public String addPerson(Model model) {
		model.addAttribute("person", new Person());
		return "addPerson.jsp";
	}
	
	@GetMapping("/addLicense")
	public String addLicense(Model model) {
		model.addAttribute("license", new FormLicense());
		List<Person> pList = service.allPersons();
		Map<String, String> map = new HashMap<>();
		for (Person p : pList) {
			map.put(String.valueOf(p.getId()), 
					String.format("%s %s", p.getFirstName(), p.getLastName()));
		}
		model.addAttribute("persons", map);
		return "addLicense.jsp";
	}

	@PostMapping("/show/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		Optional<Person> p = service.findPersonById(id);
		if (p.isPresent())
			model.addAttribute("person", p.get());
		return "show.jsp";
	}
	
	@PutMapping("/pCreate")
	public String pCreate(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addPerson.jsp";
        }
    	service.createPerson(person);
        return "redirect:/";
	}
	
	@PutMapping("/lCreate")
	public String lCreate(@Valid @ModelAttribute("license") FormLicense license, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addLicense.jsp";
        }
        License l = new License();
        int id = license.getPersonId();
        Optional<Person> p = service.findPersonById(id);
        if (p.isPresent()) {
            l.setPerson((Person)p.get());	
        }
        l.setState(license.getState());
        l.setNumber(service.getNextLicenseNumber());
        l.setExpirationDate(license.getExpirationDate());
    	service.createLicense(l);
        return "redirect:/";
	}
}
