package ru.hogwards.school.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwards.school.school.models.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(Integer mun, Integer max);
}
