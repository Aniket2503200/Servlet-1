CREATE DATABASE IF NOT EXISTS mydatabase11;
USE mydatabase11;
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    UNIQUE (email)
);
select *from users;