package ru.hogwards.school.school.interfaces;

import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.models.Student;

import java.util.Collection;

public interface StudentService {
    Student add(Student student);
    Student get(long id);
    Collection<Student> getAll();
    Student change(Student student);
    Student delete(Long id);
    Collection<Student> getAllByAgeBetween(Integer min, Integer max);
    Faculty getFaculty(Long id);
}
