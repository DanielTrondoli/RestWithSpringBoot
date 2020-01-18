package br.com.erudio.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.service.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices pService;
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable(value="id") Long id) throws Exception {						
		return pService.findById(id);		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value="id") Long id) throws Exception {						
		pService.delete(id);		
	}
	
	@GetMapping
	public List<Person> findAll() throws Exception {		
		return pService.findAll();	
	}
	
	@PostMapping
	public Person create(@RequestBody Person p) throws Exception {		
		return pService.create(p);	
	}
	
	@PutMapping
	public Person update(@RequestBody Person p) throws Exception {		
		return pService.update(p);	
	}
	
}