package com.mbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbook.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
}
