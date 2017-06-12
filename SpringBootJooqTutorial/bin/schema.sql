DROP TABLE IF EXISTS author_book, author, book;
 
CREATE TABLE author 
(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	first_name VARCHAR(50), 
	last_name VARCHAR(50) NOT NULL
);
 
CREATE TABLE book 
(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	title VARCHAR(100) NOT NULL
);
 
CREATE TABLE author_book 
(
	author_id BIGINT NOT NULL, 
	book_id BIGINT NOT NULL, 
	PRIMARY KEY (author_id, book_id), 
	CONSTRAINT fk_author_in_author_book FOREIGN KEY (author_id) REFERENCES author (id) ON UPDATE CASCADE ON DELETE CASCADE, 
	CONSTRAINT fk_book_in_author_book FOREIGN KEY (book_id) REFERENCES book (id)
);
 
INSERT INTO author 
VALUES 
	(1, 'John', 'Sierra'), 
	(2, 'Kate', 'Moss'), 
	(3, 'Bob', 'Hanker');
 
INSERT INTO book 
VALUES 
	(1, 'I am a hero'), 
	(2, 'You can learn Korean'), 
	(3, 'Back to the future');
 
INSERT INTO author_book 
VALUES 
	(1, 1), 
	(1, 3), 
	(2, 1);