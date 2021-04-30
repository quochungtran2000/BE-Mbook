package com.mbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbook.dto.PosterDTO;
import com.mbook.entity.CategoryEntity;
import com.mbook.entity.Poster;
import com.mbook.repository.CategoryRepository;
import com.mbook.repository.PosterRepository;
import com.mbook.service.PosterService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/poster")
public class PosterController {

	@Autowired
	private PosterService posterService;
	@Autowired
	private CategoryRepository cateRepo;
	@Autowired
	private PosterRepository posterRepo;
	@GetMapping("/get")
	public List<Poster> list() {
		return posterService.ListAll();
	}

	@GetMapping("/{id}")
	public Poster get(@PathVariable Long id) {
		return posterService.get(id);
	}

	@PostMapping("/upload")
	public Poster uploadFile(@RequestBody PosterDTO data) {
		return posterService.save(data);
	}

	@PutMapping("/{id}/posters/{posterId}")
	Poster addCategoryToPost(@PathVariable Long categoryId, @PathVariable Long posterId) {
		Poster poster = posterRepo.findById(posterId).get();
		CategoryEntity category = cateRepo.findById(categoryId).get();
		poster.getCategoryId().add(category);
		return posterRepo.save(poster);
	}

}
