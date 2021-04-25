package com.mbook.service;

import java.util.List;

import com.mbook.dto.PosterDTO;
import com.mbook.entity.Poster;

public interface PosterServiceInterface {
	public List<Poster> ListAll();
	public Poster save(PosterDTO post);
	public Poster get(Long id) ;
	public void delete(Long id) ;
	
}
