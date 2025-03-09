package com.otto.modelmapper.mapper;

import com.otto.modelmapper.dto.ProdutoDTO;
import com.otto.modelmapper.model.Produtos;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    Produtos toEntity(ProdutoDTO dto);
    ProdutoDTO toDTO(Produtos produtos);
    List<ProdutoDTO> toDTOs(List<Produtos> produtos);
}
