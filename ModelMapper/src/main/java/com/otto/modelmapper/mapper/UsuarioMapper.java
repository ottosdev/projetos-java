package com.otto.modelmapper.mapper;

import com.otto.modelmapper.dto.UsuarioDTO;
import com.otto.modelmapper.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class})
public interface UsuarioMapper extends GenericMapper<UsuarioDTO, Usuario> {

    @Mapping(source = "nome", target = "nomeCompleto")
    UsuarioDTO toDTO(Usuario usuario);

    @Mapping(source = "nomeCompleto", target = "nome")
    Usuario toEntity(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> toDTO(List<Usuario> usuarios);
}
