package ru.hogwards.school.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwards.school.school.models.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(Integer mun, Integer max);
    @Query(value = "select * from student limit 5", nativeQuery = true)
    Collection<Student> getFiveLastStudent();
}
