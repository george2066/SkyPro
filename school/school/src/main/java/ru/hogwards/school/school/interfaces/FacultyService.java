package ru.hogwards.school.school.interfaces;


import ru.hogwards.school.school.models.Faculty;

import java.util.Collection;

public interface FacultyService {
    Faculty add(Faculty faculty);
    Faculty get(long id);
    Collection<Faculty> getAll();
    Faculty change(Faculty faculty);
    Faculty delete(long id);
}
