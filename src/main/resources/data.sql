DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL DEFAULT '',
    last_name varchar(255) NOT NULL DEFAULT '',
    email varchar(255) NOT NULL DEFAULT '',
    age int NOT NULL,
    address varchar(255) NOT NULL DEFAULT '',
    join_date DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE questions (
    id int NOT NULL AUTO_INCREMENT,
    question varchar(255) NOT NULL,
    answer_1 varchar(255) NOT NULL,
    answer_2 varchar(255) NOT NULL,
    answer_3 varchar(255) NOT NULL,
    answer_4 varchar(255) NOT NULL,
    customer_id int NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE answers (
    id int NOT NULL AUTO_INCREMENT,
    question_id int NOT NULL,
    answer_option varchar(255) NOT NULL,
    user_id int NOT NULL,
    customer_id int NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (question_id) REFERENCES questions(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);


INSERT INTO customer (first_name, last_name, email, age, address, join_date)
VALUES
('John', 'Doe', 'john.doe@example.com', 30, '123 Main St', '2023-01-01'),
('Jane', 'Smith', 'jane.smith@example.com', 25, '456 Oak St', '2023-02-15'),
('Bob', 'Johnson', 'bob.johnson@example.com', 40, '789 Pine St', '2023-03-20');


INSERT INTO questions (question, answer_1, answer_2, answer_3, answer_4, customer_id)
VALUES
('What is your favorite color?', 'Red', 'Blue', 'Green', 'Yellow', 1),
('Which programming language do you prefer?', 'Java', 'Python', 'C++', 'JavaScript', 2),
('What is your favorite hobby?', 'Reading', 'Gaming', 'Sports', 'Traveling', 3);


INSERT INTO answers (question_id, answer_option, user_id, customer_id)
VALUES
(1, 'Blue', 1, 1),
(1, 'Python', 2, 2),
(3, 'Traveling', 3, 3);