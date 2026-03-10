CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensagem VARCHAR(255) NOT NULL UNIQUE,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);