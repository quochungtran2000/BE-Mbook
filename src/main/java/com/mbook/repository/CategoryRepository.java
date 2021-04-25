package com.mbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mbook.entity.CategoryEntity;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}