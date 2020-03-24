package br.com.erudio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.vo.BooksVO;
import br.com.erudio.model.Books;
import br.com.erudio.repository.BooksRepository;

@Service
public class BooksServices {

	@Autowired
	BooksRepository repository;

	public BooksVO create(BooksVO b) {
		Books entity = DozerConverter.parseObject(b, Books.class);
		BooksVO bVO = DozerConverter.parseObject(repository.save(entity), BooksVO.class);
		return bVO;
	}

	public BooksVO update(BooksVO b) {

		Books entity = repository.findById(b.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No book Found for this Id !!"));
		entity.setAuthor(b.getAuthor());
		entity.setTitle(b.getTitle());
		entity.setLaunch_date(b.getLaunch_date());
		entity.setPrice(b.getPrice());

		return DozerConverter.parseObject(repository.save(entity), BooksVO.class);
	}

	public void delete(Long id) {
		Books entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No book Found for this Id !!"));
		repository.delete(entity);
	}

	public BooksVO findById(Long id) {
		return DozerConverter.parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book Found for this Id !!")), BooksVO.class);
	}

	public List<BooksVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), BooksVO.class);
	}
}
