package com.mbook.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbook.entity.Account;

public interface AccountRepository extends JpaRepository<Account, UUID>{
	Account findOneByUsername(String username);
//	 @Modifying
//	 @Query(value="insert into account (fullname,password,roleid,status,token,username) VALUES (:fullname,:password,:roleid,:status,:token,:username)", nativeQuery = true)
//	 public int addAdmin(String fullname, String password,boolean roleid,boolean status,String token,String username);
//	 addAdmin("admin", "1", true, true, null, "Nguyễn Hoài Nhớ");
}
