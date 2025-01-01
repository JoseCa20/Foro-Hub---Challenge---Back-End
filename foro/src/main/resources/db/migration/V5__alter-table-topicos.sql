ALTER TABLE topicos
    ADD CONSTRAINT fk_topicos_autor FOREIGN KEY (autor) REFERENCES usuarios(id);

ALTER TABLE topicos
    ADD CONSTRAINT fk_topicos_curso FOREIGN KEY (curso) REFERENCES cursos(id);
