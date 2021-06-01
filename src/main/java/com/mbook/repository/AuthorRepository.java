package com.mbook.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbook.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID>{

	Author findOneByName(String name);
	
}
