package com.mbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbook.convert.PosterConvert;
import com.mbook.dto.PosterDTO;
import com.mbook.entity.CategoryEntity;
import com.mbook.entity.Poster;
import com.mbook.repository.CategoryRepository;
import com.mbook.repository.PosterRepository;

@Service
public class PosterService implements PosterServiceInterface{

	@Autowired
	private PosterRepository PosterRepo;	
	
	@Autowired
	private PosterConvert convertPost;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Poster> ListAll() {
		return PosterRepo.findAll();
	}

//	@Override
//	public void delete(long[] ids) {
//		for(long item: ids) {
//			newRepository.delete(item);
//		}
//	}
	@Override
	public Poster save(PosterDTO postDTO) {
		System.out.print(postDTO);
		Poster postEntity = new Poster();
		CategoryEntity categoryEntity =  categoryRepository.findOneByCode(postDTO.getCategoryCode());
		postEntity.getCategoryId().add(categoryEntity);
		System.out.print("/////////////////////");
		System.out.print(postEntity);
//		postEntity = PosterRepo.save(postEntity);
		
		return postEntity;
	}

	@Override
	public Poster get(Long id) {
		return PosterRepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		PosterRepo.deleteById(id);;
		
	}

}
