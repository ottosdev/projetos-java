package com.otto.modelmapper.repository;

import com.otto.modelmapper.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
