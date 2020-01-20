package br.com.erudio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person p) {
		return repository.save(p);
	}
	
	public Person update(Person p) {
		
		Person entity = repository.findById(p.getId()).orElseThrow(
				() -> new ResourceNotFoundException("No data Found for this Id !!"));
		
		entity.setName(p.getName());
		entity.setLastName(p.getLastName());
		entity.setAddres(p.getAddres());
		entity.setGender(p.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No data Found for this Id !!"));
		repository.delete(entity);
	}
	
	public Person findById(Long id) {		
				
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No data Found for this Id !!"));
		
	}
	
public List<Person> findAll() {		
	return repository.findAll();	
	}
}
