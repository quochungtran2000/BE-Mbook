package com.mbook.jwt.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mbook.entity.Account;
import com.mbook.repository.AccountRepository;
import com.mbook.service.AccountService;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	AccountRepository repo;
	@Autowired
	AccountService AccService;
    @Override
    //Tìm và chứng thực user với database
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Account user = repo.findOneByUsername(username);
       if(user == null) throw new UsernameNotFoundException(username);
       return new UserPrinciple(user);
    }
}
