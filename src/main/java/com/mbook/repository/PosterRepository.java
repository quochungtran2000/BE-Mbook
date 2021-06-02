package com.mbook.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbook.entity.Poster;

public interface PosterRepository extends JpaRepository<Poster, UUID>{
}
