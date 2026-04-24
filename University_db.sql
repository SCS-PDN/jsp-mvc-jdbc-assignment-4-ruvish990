CREATE DATABASE university_db;

USE university_db;

CREATE TABLE students (
                          student_id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100),
                          email VARCHAR(100),
                          password VARCHAR(100)
);

CREATE TABLE courses (
                         course_id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100),
                         instructor VARCHAR(100),
                         credits INT
);

CREATE TABLE registrations (
                               reg_id INT AUTO_INCREMENT PRIMARY KEY,
                               student_id INT,
                               course_id INT,
                               date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO students (name, email, password)
VALUES
    ('Nikhila', 'nik@gmail.com', '1234'),
    ('John', 'john@gmail.com', '1234');

INSERT INTO courses (name, instructor, credits)
VALUES
    ('Java Programming', 'Dr Silva', 3),
    ('Database Systems', 'Dr Perera', 4),
    ('Web Development', 'Dr Fernando', 3);

SELECT * FROM students;
SELECT * FROM courses;
SELECT * FROM registrations;