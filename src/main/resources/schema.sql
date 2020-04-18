create table cars (
	carid INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	manufacturerName VARCHAR(250) NOT NULL,
	model VARCHAR(250) NOT NULL,
	manufacturingYear VARCHAR(250) NOT NULL,
	color VARCHAR(250) NOT NULL
);