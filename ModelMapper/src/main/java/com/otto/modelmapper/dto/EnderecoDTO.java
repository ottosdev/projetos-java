package com.otto.modelmapper.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
}
