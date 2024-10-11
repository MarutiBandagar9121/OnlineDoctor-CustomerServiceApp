CREATE TABLE IF NOT EXISTS doctors(
    firstname varchar(50) NOT NULL,
    lastname varchar(50),
    username varchar(50) PRIMARY KEY,
    age INT,
    qualification varchar(50),
    yearsOfExperience varchar(50),
    speciality varchar(30),
    gender varchar(15),
    city varchar(30),
    state varchar(30),
    pincode INT,
    password varchar(30)
)