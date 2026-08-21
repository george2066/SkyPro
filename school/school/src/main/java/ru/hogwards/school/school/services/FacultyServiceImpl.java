package ru.hogwards.school.school.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    public FacultyServiceImpl(FacultyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Faculty add(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        return repository.save(faculty);
    }

    @Override
    public Faculty get(long id) {
        Optional<Faculty> faculty = repository.findById(id);
        if (faculty.isEmpty()) {
            logger.error("Not found faculty with id={} in method get", id);
            throw new NotFoundFacultyException(HogwardsConstantException.NOT_FOUND_FACULTY);
        }
        logger.info("Was invoked method for get faculty");
        return faculty.get();
    }

    @Override
    public Collection<Faculty> getAll() {
        logger.info("Was invoked method for get all faculties");
        return repository.findAll();
    }

    @Override
    public Faculty change(Faculty faculty) {
        if (!repository.existsById(faculty.getId())) {
            logger.error("Not found faculty with name={} in method change", faculty.getName());
            throw new NotFoundFacultyException(HogwardsConstantException.NOT_FOUND_FACULTY);
        }
        logger.info("Was invoked method for change faculty");
        return add(faculty);
    }

    @Override
    public Faculty delete(long id) {
        if (!repository.existsById(id)) {
            logger.error("Not found faculty with id={} in method delete", id);
            throw new NotFoundFacultyException(HogwardsConstantException.NOT_FOUND_FACULTY);
        }
        Faculty faculty = get(id);
        repository.deleteById(id);
        logger.info("Was invoked method for delete faculty");
        return faculty;
    }

    @Override
    public Faculty getByColorOrName(String color, String name) {
        if (color == null && name == null) {
            logger.error("Bad request in faculty service in method get by color or name, because name and color is null");
            throw new BadRequestNullFieldsException(HogwardsConstantException.NULL_FIELDS);
        }
        Faculty faculty;
        if (name != null) {
            logger.info("Was invoked method for find faculty by name");
            faculty = repository.findByNameIgnoreCase(name);
        } else {
            logger.info("Was invoked method for find faculty by color");
            faculty = repository.findByColorIgnoreCase(color);
        }
        return faculty;
    }

    @Override
    public Set<Long> getStudents(Long id) {
        if (!repository.existsById(id)) {
            logger.error("Not found faculty with id={} in method get students", id);
            throw new NotFoundFacultyException(HogwardsConstantException.NOT_FOUND_FACULTY);
        }
        Faculty faculty = get(id);
        logger.info("Was invoked method for get students faculty");
        return faculty.getStudents();
    }
}
