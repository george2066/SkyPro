package ru.hogwards.school.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwards.school.school.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
