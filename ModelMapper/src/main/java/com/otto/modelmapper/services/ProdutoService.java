package com.otto.modelmapper.services;

import com.otto.modelmapper.dto.ProdutoDTO;
import com.otto.modelmapper.mapper.ProdutoMapper;
import com.otto.modelmapper.mapper.UsuarioMapper;
import com.otto.modelmapper.model.Produtos;
import com.otto.modelmapper.model.Usuario;
import com.otto.modelmapper.repository.ProdutoRepository;
import com.otto.modelmapper.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProdutoMapper produtoMapper;
    private final UsuarioMapper usuarioMapper;

    public List<ProdutoDTO> obterTodosOsProdutos() {
        List<Produtos> produtos = produtoRepository.findAll();
        return  produtoMapper.toDTOs(produtos);
    }

    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Usuario usuario = usuarioRepository.findById(produtoDTO.getUsuario().getId()).orElseThrow(() ->
                new RuntimeException("Usuario nao encontrado " +   produtoDTO.getUsuario()));

        Produtos produto = produtoMapper.toEntity(produtoDTO);
        produto.setUsuario(usuario);

        Produtos produtoSalvo = produtoRepository.save(produto);

        ProdutoDTO produtoDTOSalvoRetorno = produtoMapper.toDTO(produtoSalvo);
        produtoDTOSalvoRetorno.setUsuario(usuarioMapper.toDTO(usuario));

        return produtoDTOSalvoRetorno;
    }
}
