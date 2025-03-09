package com.otto.modelmapper.controller;

import com.otto.modelmapper.dto.ProdutoDTO;
import com.otto.modelmapper.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> getProdutos() {
        return produtoService.obterTodosOsProdutos();
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {

        return ResponseEntity.ok(produtoService.salvarProduto(produtoDTO));
    }
}
