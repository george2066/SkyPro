package ru.hogwards.school.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.school.exceptions.NotFoundFacultyException;
import ru.hogwards.school.school.interfaces.FacultyService;
import ru.hogwards.school.school.models.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    @Override
    public Faculty add(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty get(long id) {
        if (!faculties.containsKey(id)) {
            throw new NotFoundFacultyException("Not found faculty");
        }
        return faculties.get(id);
    }

    @Override
    public Collection<Faculty> getAll() {
        return faculties.values();
    }

    @Override
    public Faculty change(Faculty faculty) {
        if (!faculties.containsKey(faculty.getId())) {
            throw new NotFoundFacultyException("Not found faculty");
        }
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty delete(long id) {
        if (!faculties.containsKey(id)) {
            throw new NotFoundFacultyException("Not found student");
        }
        return faculties.remove(id);
    }
}
