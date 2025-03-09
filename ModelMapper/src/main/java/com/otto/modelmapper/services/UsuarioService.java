package com.otto.modelmapper.services;

import com.otto.modelmapper.dto.EnderecoDTO;
import com.otto.modelmapper.dto.UsuarioDTO;
import com.otto.modelmapper.mapper.EnderecoMapper;
import com.otto.modelmapper.mapper.UsuarioMapper;
import com.otto.modelmapper.model.Endereco;
import com.otto.modelmapper.model.Usuario;
import com.otto.modelmapper.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final EnderecoMapper enderecoMapper;

    @Transactional
    public void salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);

        if (Objects.nonNull(usuarioDTO.getEndereco())) {
            Endereco endereco = enderecoMapper.toEntity(usuarioDTO.getEndereco());
            endereco.setUsuario(usuario);
            usuario.setEndereco(endereco);
        }

        usuarioRepository.save(usuario);
    }

    public List<UsuarioDTO> obterUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.toDTO(usuarios);
    }
}
