CREATE TABLE IF NOT EXISTS doctors(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    lastname VARCHAR(255),
    firstname VARCHAR(255),
    qualification VARCHAR(255),
    yearsofexperience VARCHAR(255),
    speciality VARCHAR(255),
    age INT,
    gender VARCHAR(50),
    city VARCHAR(100),
    state VARCHAR(100),
    pincode INT,
    password VARCHAR(255)
)