-- liquibase formatted sql
-- changeset grodionov:1
CREATE TABLE faculty (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         color VARCHAR(50)
);

CREATE TABLE student (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         age INT,
                         faculty_id BIGINT,
                         CONSTRAINT fk_student_faculty
                             FOREIGN KEY (faculty_id)
                                 REFERENCES faculty(id)
                                 ON UPDATE CASCADE
                                 ON DELETE SET NULL
);

-- changeset grodionov:2
CREATE INDEX idx_student_faculty_id ON student(faculty_id);
CREATE INDEX student_name_index ON student (name);
CREATE INDEX faculty_name_and_color_indexes ON faculty (name, color);