package com.mbook.repository;

import java.util.List;
import java.util.UUID;

import com.mbook.dto.PosterDTO;
import com.mbook.entity.Poster;

public interface PosterServiceInterface {
	public List<Poster> ListAll();
	public Poster save(PosterDTO post);
	public Poster get(UUID id) ;
	public void delete(UUID id) ;
	
}
