package com.otto.modelmapper.controller;

import com.otto.modelmapper.dto.UsuarioDTO;
import com.otto.modelmapper.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuairoController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.salvar(usuarioDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obterUsuarios() {
        return ResponseEntity.ok(usuarioService.obterUsuarios());
    }
}
