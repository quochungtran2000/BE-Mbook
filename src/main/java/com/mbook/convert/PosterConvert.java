package com.mbook.convert;

import org.springframework.stereotype.Component;

import com.mbook.dto.PosterDTO;
import com.mbook.entity.Poster;


@Component
public class PosterConvert {
	public PosterDTO toDTO(Poster posterEntity) {
		PosterDTO posterDTO = new PosterDTO();
		posterDTO.setTitle(posterEntity.getTitle());
		posterDTO.setContent(posterEntity.getContent());
		posterDTO.setSub(posterEntity.getSub());
		posterDTO.setUrlImage(posterEntity.getUrlImage());
		posterDTO.setCreateddate(posterEntity.getCreateddate());
		posterDTO.setCreatedby(posterEntity.getCreatedby().toString());
		posterDTO.setModifieddate(posterEntity.getModifieddate());
		posterDTO.setModifiedby(posterEntity.getModifiedby());
		return posterDTO;
	}
	public Poster toEntity(PosterDTO posterDTO) {
		Poster posterEntity = new Poster();
		posterEntity.setTitle(posterDTO.getTitle());
		posterEntity.setContent(posterDTO.getContent());
		posterEntity.setSub(posterDTO.getSub());
		posterEntity.setUrlImage(posterDTO.getUrlImage());
		posterEntity.setCreateddate(posterDTO.getCreateddate());
		posterEntity.setCreatedby(posterDTO.getCreatedby().toString());
		posterEntity.setModifieddate(posterDTO.getModifieddate());
		posterEntity.setModifiedby(posterDTO.getModifiedby());
		return posterEntity;
	}
}
