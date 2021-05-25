package com.mbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbook.entity.Account;
import com.mbook.repository.AccountRepository;
import com.mbook.repository.AccountServiceInterface;


@Service
public class AccountService implements AccountServiceInterface {
	
	
	@Autowired
	private AccountRepository AccRepo;	
	
	public List<Account> ListAll(){
		return AccRepo.findAll();
	}
	
	public void save(Account acc) {
		AccRepo.save(acc);
	}
	public Account get(Long id) {
		return AccRepo.findById(id).get();
	}
	public void delete(Long id) {
		AccRepo.deleteById(id);
	}
	
}
