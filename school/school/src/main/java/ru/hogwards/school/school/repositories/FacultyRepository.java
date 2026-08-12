package ru.hogwards.school.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwards.school.school.models.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
