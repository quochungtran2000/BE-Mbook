package com.mbook.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mbook.entity.Account;
import com.mbook.entity.User;
import com.mbook.repository.AccountRepository;
import com.mbook.service.AccountService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService AccService;
	
	@GetMapping("")
	public List<Account> list() {
		return AccService.ListAll();
	}

	@GetMapping("/{id}")
	public Account get(@PathVariable Long id) {
		return AccService.get(id);
	}
	// Đăng nhập
	@PostMapping("/signin")
	public Account login(@RequestBody User data) {
		List<Account> list = AccService.ListAll();
		Long accID = null;
		
		for (Account account : list) {
			if(account.getUsername().equals(data.getUsername())&& account.getPassword().equals(data.getPassword())) {
				System.out.println("Login Success");
				accID = account.getId();
			}else {
				System.out.println("Not Matching");
			}	
		}
		return AccService.get(accID);
	}
	
	
	
	// Đăng kí
	@PostMapping("/signup")
	public ResponseEntity<?> add(@RequestBody Account acc) {
		try {
			List<Account> list = AccService.ListAll();
			for (Account account : list) {
				if(account.getUsername().equals(acc.getUsername())) {
					
					System.out.println("Be Existed");
					return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
				}
			}
			System.out.println("Register Success");
			AccService.save(acc);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return null;
	}
	
	// Đổi mật khẩu 
	@PostMapping("/changepassword")
	public Account login(@RequestBody Account data) {
		AccService.save(data);
		return AccService.get(data.getId());
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Account accNew, @PathVariable Long id) {
		try {
			Account accOld = AccService.get(id);
			accOld.setUsername(accNew.getUsername());
			accOld.setPassword(accNew.getPassword());
			accOld.setFullname(accNew.getFullname());
			accOld.setStatus(accNew.getStatus());
			accOld.setRoleid(accNew.getRoleid());
			accOld.setCreatedby(accNew.getCreatedby());
			accOld.setCreateddate(accNew.getCreateddate());
			accOld.setModifiedby(accNew.getModifiedby());
			accOld.setModifieddate(accNew.getModifieddate());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			AccService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
