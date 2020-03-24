package br.com.erudio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;

	public PersonVO create(PersonVO p) {
		Person entity = DozerConverter.parseObject(p, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVO update(PersonVO p) {

		Person entity = repository.findById(p.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No data Found for this Id !!"));

		entity.setName(p.getName());
		entity.setLastName(p.getLastName());
		entity.setAddres(p.getAddres());
		entity.setGender(p.getGender());

		return DozerConverter.parseObject(repository.save(entity),PersonVO.class);
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No data Found for this Id !!"));
		repository.delete(entity);
	}

	public PersonVO findById(Long id) {

		return DozerConverter.parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No data Found for this Id !!")), PersonVO.class);

	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}
}
