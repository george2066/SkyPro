package ru.hogwards.school.school.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwards.school.school.exceptions.NotFoundStudentException;
import ru.hogwards.school.school.exceptions.HogwardsConstantException;
import ru.hogwards.school.school.interfaces.StudentService;
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.models.Student;
import ru.hogwards.school.school.repositories.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;

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
    public Collection<Student> getAll(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return repository.findAll(pageRequest).getContent();
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

    @Override
    public Collection<Student> getAllByAgeBetween(Integer min, Integer max) {
        return repository.findByAgeBetween(min, max);
    }

    @Override
    public Faculty getFaculty(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundStudentException(HogwardsConstantException.NOT_FOUND_STUDENT);
        }
        Student student = get(id);
        return student.getFaculty();
    }

    @Override
    public Integer getAmountStudents() {
        return repository.findAll().size();
    }

    @Override
    public OptionalDouble getAvgAgeStudents() {
        return repository.findAll().stream().mapToInt(Student::getAge).average();
    }

    @Override
    public Collection<Student> getFiveLastStudent() {
        return repository.getFiveLastStudent();
    }
}
