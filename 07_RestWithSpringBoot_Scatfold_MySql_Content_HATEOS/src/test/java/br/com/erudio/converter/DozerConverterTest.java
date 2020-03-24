package br.com.erudio.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.erudio.converter.mocks.MockPerson;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.model.Person;

public class DozerConverterTest {
	
	MockPerson inputObject;
	
	@Before
	public void setUp() {
		inputObject = new MockPerson();
	}
	
	@Test
	public void parseEntityToVOTest() {
		PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
		
		Assert.assertEquals(0L, output.getKey());
		Assert.assertEquals("Name Test: 0", output.getName());
		Assert.assertEquals("Last Name Test: 0", output.getLastName());
		Assert.assertEquals("Addres Test: 0", output.getAddres());
		Assert.assertEquals("Male Test", output.getGender());
	}
	
	@Test
	public void parseEntityListToVOListTest() {
		List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
		
		PersonVO output = outputList.get(0);
		
		Assert.assertEquals(0L, output.getKey());
		Assert.assertEquals("Name Test: 0", output.getName());
		Assert.assertEquals("Last Name Test: 0", output.getLastName());
		Assert.assertEquals("Addres Test: 0", output.getAddres());
		Assert.assertEquals("Male Test", output.getGender());

		output = outputList.get(4);
		
		Assert.assertEquals(4L, output.getKey());
		Assert.assertEquals("Name Test: 4", output.getName());
		Assert.assertEquals("Last Name Test: 4", output.getLastName());
		Assert.assertEquals("Addres Test: 4", output.getAddres());
		Assert.assertEquals("Male Test", output.getGender());
		
		output = outputList.get(7);
		
		Assert.assertEquals(7L, output.getKey());
		Assert.assertEquals("Name Test: 7", output.getName());
		Assert.assertEquals("Last Name Test: 7", output.getLastName());
		Assert.assertEquals("Addres Test: 7", output.getAddres());
		Assert.assertEquals("Famale Test", output.getGender());
		
	}
	
	
	
	@Test
	public void parseVOToEntityTest() {		
		Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
		
		Assert.assertEquals(0L, output.getId());
		Assert.assertEquals("Name Test: 0", output.getName());
		Assert.assertEquals("Last Name Test: 0", output.getLastName());
		Assert.assertEquals("Addres Test: 0", output.getAddres());
		Assert.assertEquals("Male Test", output.getGender());		
		
	}
	
	@Test
	public void parseVOListToEntityListTest() {
		List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
		
		Person output = outputList.get(0);
		
		Assert.assertEquals(0L, output.getId());
		Assert.assertEquals("Name Test: 0", output.getName());
		Assert.assertEquals("Last Name Test: 0", output.getLastName());
		Assert.assertEquals("Addres Test: 0", output.getAddres());
		Assert.assertEquals("Male Test", output.getGender());	

		output = outputList.get(4);
		
		Assert.assertEquals(4L, output.getId());
		Assert.assertEquals("Name Test: 4", output.getName());
		Assert.assertEquals("Last Name Test: 4", output.getLastName());
		Assert.assertEquals("Addres Test: 4", output.getAddres());
		Assert.assertEquals("Male Test", output.getGender());
		
		output = outputList.get(7);
		
		Assert.assertEquals(7L, output.getId());
		Assert.assertEquals("Name Test: 7", output.getName());
		Assert.assertEquals("Last Name Test: 7", output.getLastName());
		Assert.assertEquals("Addres Test: 7", output.getAddres());
		Assert.assertEquals("Famale Test", output.getGender());
		
	}
}
