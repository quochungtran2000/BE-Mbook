package com.mbook.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbook.entity.Account;

public interface AccountRepository extends JpaRepository<Account, UUID>{

	Account findOneByUsername(String username);
}
