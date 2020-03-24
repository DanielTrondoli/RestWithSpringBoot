package br.com.erudio.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.BooksVO;
import br.com.erudio.service.BooksServices;

@RestController
@RequestMapping("/books")
public class BooksController{
	
	@Autowired
	private BooksServices bServices;
	
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public BooksVO findById(@PathVariable(value = "id") Long id) throws Exception {
		BooksVO bVO = bServices.findById(id);
		bVO.add(linkTo(methodOn(BooksController.class).findById(id)).withSelfRel());
		return bVO;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id")Long id) throws Exception{
		bServices.delete(id);
	}
	
	@SuppressWarnings("depecation")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<BooksVO> findAll() throws Exception {
		List<BooksVO> books = bServices.findAll();
		books.stream().forEach( b -> {
			try {
				b.add(linkTo(methodOn(BooksController.class).findById(b.getKey())).withSelfRel());
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		return books;
	}
	
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BooksVO create(@RequestBody BooksVO b) throws Exception{
		BooksVO bVO = bServices.create(b);
		bVO.add(linkTo(methodOn(BooksController.class).findById(bVO.getKey())).withSelfRel());
		return bVO;
	}
	
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BooksVO update(@RequestBody BooksVO b) throws Exception{
		BooksVO bVO = bServices.update(b);
		bVO.add(linkTo(methodOn(BooksController.class).findById(b.getKey())).withSelfRel());
		return bVO;
	}
	
}
