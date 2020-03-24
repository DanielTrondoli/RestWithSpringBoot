package br.com.erudio.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.model.Person;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(0);
	}
	
	public PersonVO mockVO() {
		return mockVO(0);
	}
	
	public List<Person> mockEntityList(){
		List<Person> persons = new ArrayList<Person>();
		for(int i =0; i< 14; i++) {
			persons.add(mockEntity(i));
		}			
		return persons;		
	}
	
	public List<PersonVO> mockVOList(){
		List<PersonVO> persons = new ArrayList<PersonVO>();
		for(int i =0; i< 14; i++) {
			persons.add(mockVO(i));
		}			
		return persons;		
	}
	
	public Person mockEntity(Integer number) {
		Person p = new Person();
		p.setId(number.longValue());
		p.setName("Name Test: " + number);
		p.setLastName("Last Name Test: "+ number);
		p.setAddres("Addres Test: " +number);
		p.setGender((number % 2 == 0)? "Male Test" : "Famale Test");
		return p;
	}
	
	public PersonVO mockVO(Integer number) {
		PersonVO p = new PersonVO();
		p.setKey(number.longValue());
		p.setName("Name Test: " + number);
		p.setLastName("Last Name Test: "+ number);
		p.setAddres("Addres Test: " +number);
		p.setGender((number % 2 == 0)? "Male Test" : "Famale Test");
		return p;
	}
}
