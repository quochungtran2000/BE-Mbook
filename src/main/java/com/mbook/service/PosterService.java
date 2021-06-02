package com.mbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbook.convert.PosterConvert;
import com.mbook.dto.PosterDTO;
import com.mbook.entity.CategoryEntity;
import com.mbook.entity.Poster;
import com.mbook.repository.CategoryRepository;
import com.mbook.repository.PosterRepository;
import com.mbook.repository.PosterServiceInterface;

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

	@Override
	public Poster save(PosterDTO postDTO) {
		Poster postEntity = new Poster();
		List<CategoryEntity> cateList = categoryRepository.findAll();
		List<CategoryEntity> newList = new ArrayList<CategoryEntity>();
		for (String item : postDTO.getCategoryCode()) {
			CategoryEntity categoryEntity = cateList.get(Integer.parseInt(item));
			newList.add(categoryEntity);
		}
		postEntity = convertPost.toEntity(postDTO);
		postEntity.setCategoryId(newList);
		return PosterRepo.save(postEntity);
	}

	@Override
	public Poster get(UUID id) {
		return PosterRepo.findById(id).get();
	}

	@Override
	public void delete(UUID id) {
		PosterRepo.deleteById(id);
		
	}

}
