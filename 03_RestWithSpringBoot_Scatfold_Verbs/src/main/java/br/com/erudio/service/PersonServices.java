package br.com.erudio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person p) {
		return p;
	}
	
	public Person update(Person p) {
		return p;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findById(String id) {		
		
		Person p = new Person();
		
		p.setId(counter.incrementAndGet());
		p.setName("Daniel");
		p.setLastName("Trondoli");
		p.setAddres("um endereco qualquer!!");
		p.setGender("Male");		
		return p;
		
	}
	
public List<Person> findAll() {		
		
		List<Person> list = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) {
			list.add(mockPerson(i));
		}
		
		return list;
		
	}

private Person mockPerson(int i) {
	
	Person p = new Person();	
	p.setId(counter.incrementAndGet());
	p.setName("Name: "+i );
	p.setLastName("Sobrenome: "+i);
	p.setAddres("um endereco qualquer " + i);
	p.setGender("Male");		
	return p;
}
}
