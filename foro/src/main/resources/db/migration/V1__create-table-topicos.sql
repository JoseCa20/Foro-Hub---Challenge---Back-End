CREATE TABLE topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(500) NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    status INT,
    autor INT,
    curso INT

 );