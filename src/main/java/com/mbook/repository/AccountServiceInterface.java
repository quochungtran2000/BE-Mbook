package com.mbook.repository;

import java.util.List;
import java.util.UUID;

import com.mbook.entity.Account;

public interface AccountServiceInterface {
	public List<Account> ListAll();
	public Account save(Account acc);
	public Account get(UUID id) ;
	public void delete(UUID id) ;
	public String Encrypt(String password);
}
