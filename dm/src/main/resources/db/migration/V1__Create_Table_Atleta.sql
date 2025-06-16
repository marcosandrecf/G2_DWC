CREATE TABLE atleta(
    id CHAR(32) NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao_lesao VARCHAR(255) NOT NULL,
    situacao VARCHAR(255) NOT NULL,
    num_camisa INTEGER NOT NULL,
    data_criacao TIMESTAMP NOT NULL
);