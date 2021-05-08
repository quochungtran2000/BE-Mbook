package com.mbook.convert;

import org.springframework.stereotype.Component;

import com.mbook.dto.PosterDTO;
import com.mbook.dto.ProductDTO;
import com.mbook.entity.Poster;
import com.mbook.entity.Product;

@Component
public class ProductConvert {
	public ProductDTO toDTO(Product productEntity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(productEntity.getName());
		productDTO.setDescription(productEntity.getDescription());
		productDTO.setHot(productEntity.isHot());
		productDTO.setSale(productEntity.isSale());
		productDTO.setRating(productEntity.getRating());
		productDTO.setQuantity(productEntity.getQuantity());
		productDTO.setImage(productEntity.getImage());
		productDTO.setImageDetail(productEntity.getImageDetail());
		productDTO.setPriceOld(productEntity.getPriceOld());
		productDTO.setPricePresent(productEntity.getPricePresent());
		productDTO.setDescription(productEntity.getDescription());
		return productDTO;
	}
	public Product toEntity(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setHot(productDTO.isHot());
		product.setSale(productDTO.isSale());
		product.setRating(productDTO.getRating());
		product.setQuantity(productDTO.getQuantity());
		product.setImage(productDTO.getImage());
		product.setImageDetail(productDTO.getImageDetail());
		product.setPriceOld(productDTO.getPriceOld());
		product.setPricePresent(productDTO.getPricePresent());
		product.setDescription(productDTO.getDescription());
		return product;
	}
}