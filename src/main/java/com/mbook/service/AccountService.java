package com.mbook.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	public Account save(Account acc) {
		
		return AccRepo.save(acc);
	}
	public Account get(UUID id) {
		return AccRepo.findById(id).get();
	}
	public void delete(UUID id) {
		AccRepo.deleteById(id);
	}

	@Override
	public String Encrypt(String password) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
        return generatedPassword;
    }

	
}
