CREATE TABLE tb_usuario (
                            id SERIAL PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            email VARCHAR(255) UNIQUE NOT NULL,
                            senha VARCHAR(255) NOT NULL
);

CREATE TABLE tb_produtos (
                             id SERIAL PRIMARY KEY,
                             nome VARCHAR(255) NOT NULL,
                             descricao TEXT,
                             preco DECIMAL(10,2) NOT NULL,
                             usuario_id BIGINT NOT NULL,
                             CONSTRAINT fk_produtos_usuario FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id) ON DELETE CASCADE
);

CREATE TABLE endereco (
                          id SERIAL PRIMARY KEY,
                          logradouro VARCHAR(255) NOT NULL,
                          numero VARCHAR(50) NOT NULL,
                          complemento VARCHAR(255),
                          usuario_id BIGINT UNIQUE NOT NULL,
                          CONSTRAINT fk_endereco_usuario FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id) ON DELETE CASCADE
);