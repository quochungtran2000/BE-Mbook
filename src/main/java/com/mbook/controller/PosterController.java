package com.mbook.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RestController;

import com.mbook.dto.PosterDTO;
import com.mbook.dto.ProductDTO;
import com.mbook.entity.Account;
import com.mbook.entity.CategoryEntity;
import com.mbook.entity.Poster;
import com.mbook.jwt.util.JwtUtil;
import com.mbook.repository.AccountRepository;
import com.mbook.repository.CategoryRepository;
import com.mbook.repository.PosterRepository;
import com.mbook.service.PosterService;

@CrossOrigin()
@RestController
@RequestMapping("/poster")
public class PosterController {

	@Autowired
	private PosterService posterService;
	@Autowired
	private CategoryRepository cateRepo;
	@Autowired
	private PosterRepository posterRepo;
	@Autowired
	private AccountRepository accRepo;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/get")
	public ResponseEntity<List<Poster>> list() {
		return new ResponseEntity<>(posterService.ListAll(), HttpStatus.OK);
	}

	@GetMapping("/details/{posterId}")
	public ResponseEntity<Poster> get(@PathVariable UUID posterId) {
		return ResponseEntity.status(HttpStatus.OK).body(posterService.get(posterId));
	}

	@PostMapping("/upload")
	public Poster uploadFile(@RequestBody PosterDTO data, HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		data.setCreatedby(username);
		return posterService.save(data);
	}
	

	@PostMapping("/likes/{posterId}")
	public ResponseEntity<Poster> likes(@PathVariable UUID posterId, HttpServletRequest request) {
		// Tìm và chứng thực account qua token
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		Account acc = accRepo.findOneByUsername(username); // account
		// ------------------------------------------------
		Poster post = posterRepo.findById(posterId).get();
		if (post.getListlike().contains(acc)) {
			post.getListlike().remove(acc);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(posterRepo.save(post));
		} else {
			post.getListlike().add(acc);
			return ResponseEntity.status(HttpStatus.OK).body(posterRepo.save(post));
		}

	}

	@PutMapping("/update/{posterId}")
	Poster addCategoryToPost(@RequestBody Poster dataUpdate,@PathVariable UUID posterId,HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		String jwt = authorizationHeader.substring(7);
		String username = jwtUtil.extractUsername(jwt);
		dataUpdate.setModifiedby(username);
		return posterRepo.save(dataUpdate);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			posterService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
