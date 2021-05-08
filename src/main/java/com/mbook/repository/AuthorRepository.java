package com.mbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbook.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
