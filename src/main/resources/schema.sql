CREATE TABLE author (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL
);

CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    publication_date DATE NOT NULL,
    author_id BIGINT NOT NULL,
    CONSTRAINT fk_author FOREIGN KEY (author_id)
        REFERENCES author(id) ON DELETE CASCADE
);