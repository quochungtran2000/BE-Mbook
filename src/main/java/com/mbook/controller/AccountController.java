package com.mbook.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbook.entity.Account;
import com.mbook.entity.Password;
import com.mbook.entity.Poster;
import com.mbook.entity.User;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.AccountRepository;
import com.mbook.service.AccountService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService AccService;
	
	@Autowired
	private AccountRepository AccRepo;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/get")
	public List<Account> list() {
		return AccService.ListAll();
	}

	@GetMapping("/{id}")
	public Account get(@PathVariable UUID id) {
		return AccService.get(id);
	}
	@GetMapping("/details/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(AccService.get(id));
	}

	// Đăng nhập
		@PostMapping("/signin")
		public ResponseEntity<Account> login(@RequestBody User data) {
			String passwordEn = AccService.Encrypt(data.getPassword());
			List<Account> list = AccService.ListAll();
			UUID accID = null;
			boolean found = false;
			for (Account account : list) {
				if(account.getUsername()!= null) {
					if(account.getUsername().equals(data.getUsername())
							&& account.getPassword().equals(passwordEn)
							) {
						if( account.isStatus() == true) {
							account.setToken(jwtTokenUtil.generateTokenAcc(account));
							accID = account.getId();
							found = true;
						}else {
							accID = account.getId();
							found = false; // Tìm được nhưng tài khoản bị khóa
						}
							
					}
				}
			}
			if(accID != null) {
				if(found == true) {
					return ResponseEntity.status(HttpStatus.OK).body(AccService.get(accID)); // 200 - OK
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_MODIFIED); //304 - Vô Hiệu Hóa
				}
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AccService.get(accID)); // 200
			}
		}
		@PostMapping("/dashboard/signin")
		public ResponseEntity<Account> LoginDashboard(@RequestBody User data) {
			String passwordEn = AccService.Encrypt(data.getPassword());
			List<Account> list = AccService.ListAll();
			UUID accID = null;
			boolean found = false;
			for (Account account : list) {
				if(account.getUsername().equals(data.getUsername())
						&& account.getPassword().equals(passwordEn)
						) {
					if( account.isRoleid() == true) {
						account.setToken(jwtTokenUtil.generateTokenAcc(account));
						accID = account.getId();
						found = true;
					}else {
						accID = account.getId();
						found = false; // Tìm được nhưng không đủ quyền
					}
						
				}
			}
			if(accID != null) {
				if(found == true) {
					return ResponseEntity.status(HttpStatus.OK).body(AccService.get(accID)); // 200
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_MODIFIED); //304
				}
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AccService.get(accID)); // 200
			}
			
				
		}
	// Đăng kí
	@PostMapping("/signup")
	public String SignIn(@RequestBody Account acc) {
		String passwordEn = AccService.Encrypt(acc.getPassword());
		try {
			List<Account> list = AccService.ListAll();
			for (Account account : list) {
				if (account.getUsername().equals(acc.getUsername())) {
					return "Tài Khoản Đã Tồn Tại";
				}
			}
			acc.setPassword(passwordEn);
			AccService.save(acc);
			return "Đăng Ký Thành Công";
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return null;
	}
	
	// Đổi mật khẩu
	@PostMapping("/changepassword")
	public ResponseEntity<Account> login(@RequestBody Password data,HttpServletRequest request) {
		String passwordEn = AccService.Encrypt(data.getPasswordOld());
		String passwordNewEn = AccService.Encrypt(data.getPasswordNew());
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		Account acc = AccRepo.findOneByUsername(username);
		if(acc.getPassword().contains(passwordEn)) {
			if(acc.getPassword() == passwordNewEn) { 
				return new ResponseEntity<>(HttpStatus.CONFLICT); // Mật khẩu mới == mật khẩu cũ return 409
			}else {
				acc.setPassword(passwordNewEn);
				return ResponseEntity.status(HttpStatus.OK).body(AccRepo.save(acc)); //200
			}
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED); //Mật khẩu cũ chưa đúng return 304
		}
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody Account accNew, @PathVariable UUID id,HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		if(AccRepo.findOneByUsername(username).isRoleid() == true) {
			Account acc = AccRepo.findById(id).get();
			acc.setFullname(accNew.getFullname());
			accNew.setModifiedby(username);
			AccRepo.save(acc);
			return "true";
		}else {
			return "false";
		}
		
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			AccService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
