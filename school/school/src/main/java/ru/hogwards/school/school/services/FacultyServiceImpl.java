package ru.hogwards.school.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.school.exceptions.BadRequestNullFieldsException;
import ru.hogwards.school.school.exceptions.NotFoundFacultyException;
import ru.hogwards.school.school.interfaces.FacultyService;
import ru.hogwards.school.school.exceptions.HogwardsConstantException;
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.models.Student;
import ru.hogwards.school.school.repositories.FacultyRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository repository;

    public FacultyServiceImpl(FacultyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Faculty add(Faculty faculty) {
        return repository.save(faculty);
    }

    @Override
    public Faculty get(long id) {
        Optional<Faculty> faculty = repository.findById(id);
        if (faculty.isEmpty()) {
            throw new NotFoundFacultyException(HogwardsConstantException.NOT_FOUND_FACULTY);
        }
        return faculty.get();
    }

    @Override
    public Collection<Faculty> getAll() {
        return repository.findAll();
    }

    @Override
    public Faculty change(Faculty faculty) {
        if (!repository.existsById(faculty.getId())) {
            throw new NotFoundFacultyException(HogwardsConstantException.NOT_FOUND_FACULTY);
        }
        return add(faculty);
    }

    @Override
    public Faculty delete(long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundFacultyException(HogwardsConstantException.NOT_FOUND_FACULTY);
        }
        Faculty faculty = get(id);
        repository.deleteById(id);
        return faculty;
    }

    @Override
    public Faculty getByColorOrName(String color, String name) {
        if (color == null && name == null) {
            throw new BadRequestNullFieldsException(HogwardsConstantException.NULL_FIELDS);
        }
        Faculty faculty;
        if (name != null) {
            faculty = repository.findByNameIgnoreCase(name);
        } else {
            faculty = repository.findByColorIgnoreCase(color);
        }
        return faculty;
    }

    @Override
    public Set<Long> getStudents(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundFacultyException(HogwardsConstantException.NOT_FOUND_FACULTY);
        }
        Faculty faculty = get(id);
        return faculty.getStudents();
    }
}
