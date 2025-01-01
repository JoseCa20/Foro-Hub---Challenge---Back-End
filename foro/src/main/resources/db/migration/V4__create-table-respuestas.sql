CREATE TABLE respuestas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje VARCHAR(500) NOT NULL,
    topico INT,
    fechaRespuesta DATETIME NOT NULL,
    autor INT,
    solucion BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_respuestas_topico FOREIGN KEY (topico) REFERENCES topicos(id),
    CONSTRAINT fk_respuestas_autor FOREIGN KEY (autor) REFERENCES usuarios(id)
);