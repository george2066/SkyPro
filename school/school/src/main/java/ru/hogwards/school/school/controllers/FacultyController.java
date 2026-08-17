package ru.hogwards.school.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwards.school.school.exceptions.BadRequestNullFieldsException;
import ru.hogwards.school.school.exceptions.NotFoundFacultyException;
import ru.hogwards.school.school.exceptions.NotFoundStudentException;
import ru.hogwards.school.school.interfaces.FacultyService;
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.models.Student;
import ru.hogwards.school.school.services.FacultyServiceImpl;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("faculties")
public class FacultyController {
    private final FacultyService service;


    public FacultyController(FacultyServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> get(@PathVariable long id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (NotFoundFacultyException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(service.add(faculty));
    }

    @PutMapping
    public ResponseEntity<Faculty> change(@RequestBody Faculty faculty) {
        try {
            return ResponseEntity.ok(service.change(faculty));
        } catch (NotFoundFacultyException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> delete(@PathVariable long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (NotFoundFacultyException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("getByColorOrName")
    public ResponseEntity<Faculty> getByColorOrName(
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "name", required = false) String name
    ) {
        try {
            return ResponseEntity.ok(service.getByColorOrName(color, name));
        } catch (BadRequestNullFieldsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("getStudents/{id}")
    public ResponseEntity<Set<Long>> getStudents(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getStudents(id));
        } catch (NotFoundStudentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
