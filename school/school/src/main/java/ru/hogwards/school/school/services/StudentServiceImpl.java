package ru.hogwards.school.school.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);


    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student add(Student student) {
        logger.info("Was invoked method for create student");
        return repository.save(student);
    }

    @Override
    public Student get(long id) {
        logger.info("Was invoked method for get student by id");
        Optional<Student> student = repository.findById(id);
        if (student.isEmpty()) {
            logger.error("Not found student with id={} in method get", id);
            throw new NotFoundStudentException(HogwardsConstantException.NOT_FOUND_STUDENT);
        }
        return student.get();
    }

    @Override
    public Collection<Student> getAll(Integer pageNumber, Integer pageSize) {
        logger.info("Was invoked method for get all students");
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return repository.findAll(pageRequest).getContent();
    }

    @Override
    public Student change(Student student) {
        if (!repository.existsById(student.getId())) {
            logger.error("Not found student with student={} in method change", student.toString());
            throw new NotFoundStudentException(HogwardsConstantException.NOT_FOUND_STUDENT);
        }
        logger.info("Was invoked method for change student");
        return add(student);
    }

    @Override
    public Student delete(Long id) {
        if (!repository.existsById(id)) {
            logger.error("Not found student with id={} in method delete", id);
            throw new NotFoundStudentException(HogwardsConstantException.NOT_FOUND_STUDENT);
        }
        logger.info("Was invoked method for delete student");
        Student student = get(id);
        repository.deleteById(id);
        return student;
    }

    @Override
    public Collection<Student> getAllByAgeBetween(Integer min, Integer max) {
        logger.info("Was invoked method for get all by age between student");
        return repository.findByAgeBetween(min, max);
    }

    @Override
    public Faculty getFaculty(Long id) {
        if (!repository.existsById(id)) {
            logger.error("Not found faculty of student with id={} in method get faculty", id);
            throw new NotFoundStudentException(HogwardsConstantException.NOT_FOUND_STUDENT);
        }
        logger.info("Was invoked method for get faculty student");
        Student student = get(id);
        return student.getFaculty();
    }

    @Override
    public Integer getAmountStudents() {
        logger.info("Was invoked method for get amount students");
        return repository.findAll().size();
    }

    @Override
    public OptionalDouble getAvgAgeStudents() {
        logger.info("Was invoked method for get ang age students");
        return repository.findAll().stream().mapToInt(Student::getAge).average();
    }

    @Override
    public Collection<Student> getFiveLastStudent() {
        logger.info("Was invoked method for get five last students");
        return repository.getFiveLastStudent();
    }
}
