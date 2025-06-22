CREATE TABLE preparador (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    area VARCHAR(50) NOT NULL,
    cref BIGINT NOT NULL UNIQUE,
    data_criacao TIMESTAMP NOT NULL
);

ALTER TABLE atleta
ADD COLUMN preparador_id VARCHAR(255);

ALTER TABLE atleta
ADD CONSTRAINT fk_preparador
FOREIGN KEY (preparador_id)
REFERENCES preparador(id);