package com.mbook.repository;

import java.util.List;

import com.mbook.entity.Account;

public interface AccountServiceInterface {
	public List<Account> ListAll();
	public void save(Account acc);
	public Account get(Long id) ;
	public void delete(Long id) ;
}
