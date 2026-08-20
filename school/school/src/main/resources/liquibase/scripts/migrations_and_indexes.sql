-- liquibase formatted sql
-- changeset grodionov:1
CREATE INDEX idx_student_faculty_id ON student(faculty_id);
CREATE INDEX student_name_index ON student (name);
CREATE INDEX faculty_name_and_color_indexes ON faculty (name, color);