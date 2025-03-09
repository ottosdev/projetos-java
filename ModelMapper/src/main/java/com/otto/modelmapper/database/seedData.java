package com.otto.modelmapper.database;

import com.otto.modelmapper.model.Produtos;
import com.otto.modelmapper.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class seedData {

//    @Bean
//    CommandLineRunner initDatabase(ProdutoRepository repository) {
//        return args -> {
//            repository.save(new Produtos(null, "Notebook", "teste"  , new BigDecimal("2500.00")));
//            repository.save(new Produtos(null, "Mouse","teste" ,new BigDecimal("2500.00")));
//            repository.save(new Produtos(null, "Teclado","teste" ,new BigDecimal("2500.00")));
//            System.out.println("✅ Dados iniciais inseridos no banco H2!");
//        };
//    }
}
