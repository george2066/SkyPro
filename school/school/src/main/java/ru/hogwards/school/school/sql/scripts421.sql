CREATE TABLE faculty (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         color VARCHAR(50)
);

CREATE INDEX idx_student_faculty_id ON student(faculty_id);

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

-- Вариант поведения при удалении: RESTRICT (запретить удаление факультета, пока есть студенты)
-- CONSTRAINT fk_student_faculty_restrict
--     FOREIGN KEY (faculty_id)
--     REFERENCES faculty(id)
--     ON DELETE RESTRICT;