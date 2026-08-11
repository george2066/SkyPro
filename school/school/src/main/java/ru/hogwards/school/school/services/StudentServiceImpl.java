package ru.hogwards.school.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.school.exceptions.NotFoundStudentException;
import ru.hogwards.school.school.interfaces.StudentService;
import ru.hogwards.school.school.models.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    @Override
    public Student add(Student student) {
        student.setId(++lastId);
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student get(long id) {
        if (!students.containsKey(id)) {
            throw new NotFoundStudentException("Not found student");
        }
        return students.get(id);
    }

    @Override
    public Collection<Student> getAll() {
        return students.values();
    }

    @Override
    public Student change(Student student) {
        if (!students.containsKey(student.getId())) {
            throw new NotFoundStudentException("Not found student");
        }
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student delete(long id) {
        if (!students.containsKey(id)) {
            throw new NotFoundStudentException("Not found student");
        }
        return students.remove(id);
    }
}
