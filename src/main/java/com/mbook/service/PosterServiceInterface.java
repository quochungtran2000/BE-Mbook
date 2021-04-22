package com.mbook.service;

import java.util.List;

import com.mbook.entity.Poster;

public interface PosterServiceInterface {
	public List<Poster> ListAll();
	public void save(Poster post);
	public Poster get(Long id) ;
	public void delete(Long id) ;
	
}
