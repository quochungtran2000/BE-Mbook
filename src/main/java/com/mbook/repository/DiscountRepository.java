package com.mbook.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mbook.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, UUID>{
	Discount findOneByName(String name);
}
