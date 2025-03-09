package com.otto.modelmapper.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String nomeCompleto;
    private String email;
    private String senha;
    private EnderecoDTO endereco;
}
