package ru.hogwards.school.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.school.exceptions.NotFoundStudentException;
import ru.hogwards.school.school.interfaces.HogwardsConstantException;
import ru.hogwards.school.school.interfaces.StudentService;
import ru.hogwards.school.school.models.Student;
import ru.hogwards.school.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student add(Student student) {
        return repository.save(student);
    }

    @Override
    public Student get(long id) {
        Optional<Student> student = repository.findById(id);
        if (student.isEmpty()) {
            throw new NotFoundStudentException(HogwardsConstantException.NOT_FOUND_STUDENT);
        }
        return student.get();
    }

    @Override
    public Collection<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student change(Student student) {
        if (!repository.existsById(student.getId())) {
            throw new NotFoundStudentException(HogwardsConstantException.NOT_FOUND_STUDENT);
        }
        return add(student);
    }

    @Override
    public Student delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundStudentException(HogwardsConstantException.NOT_FOUND_STUDENT);
        }
        Student student = get(id);
        repository.deleteById(id);
        return student;
    }
}
