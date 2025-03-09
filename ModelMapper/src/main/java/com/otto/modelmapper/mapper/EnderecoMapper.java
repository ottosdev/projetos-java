package com.otto.modelmapper.mapper;

import com.otto.modelmapper.dto.EnderecoDTO;
import com.otto.modelmapper.model.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper extends GenericMapper<EnderecoDTO, Endereco> {

}
