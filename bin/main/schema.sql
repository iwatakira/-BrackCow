CREATE TABLE IF NOT EXISTS employees (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	password VARCHAR(256) NOT NULL,
	name VARCHAR(256) NOT NULL,
	admin BOOLEAN NOT NULL,
	working BOOLEAN NOT NULL,
	inworktime VARCHAR(256) NOT NULL,
	outworktime VARCHAR(256) NOT NULL
);