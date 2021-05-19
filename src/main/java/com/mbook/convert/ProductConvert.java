package com.mbook.convert;

import org.springframework.stereotype.Component;

import com.mbook.dto.ProductDTO;
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
		productDTO.setImageBef(productEntity.getImageBef());
		productDTO.setImageAf(productEntity.getImageAf());
		productDTO.setPriceOld(productEntity.getPriceOld());
		productDTO.setPricePresent(productEntity.getPricePresent());
		productDTO.setDescription(productEntity.getDescription());
		productDTO.setThumbnails(productEntity.getThumbnails());
		productDTO.setCreatedby(productEntity.getCreatedby());
		productDTO.setCreateddate(productEntity.getCreateddate());
		productDTO.setModifiedby(productEntity.getModifiedby());
		productDTO.setModifieddate(productEntity.getModifieddate());
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
		product.setImageBef(productDTO.getImageBef());
		product.setImageAf(productDTO.getImageAf());
		product.setPriceOld(productDTO.getPriceOld());
		product.setPricePresent(productDTO.getPricePresent());
		product.setDescription(productDTO.getDescription());
		product.setThumbnails(productDTO.getThumbnails());
		product.setCreatedby(productDTO.getCreatedby());
		product.setCreateddate(productDTO.getCreateddate());
		product.setModifiedby(productDTO.getModifiedby());
		product.setModifieddate(productDTO.getModifieddate());
		return product;
	}
}