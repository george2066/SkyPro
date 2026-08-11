package ru.hogwards.school.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwards.school.school.exceptions.NotFoundStudentException;
import ru.hogwards.school.school.interfaces.FacultyService;
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.services.FacultyServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
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
        } catch (NotFoundStudentException e) {
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
        } catch (NotFoundStudentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> delete(@PathVariable long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (NotFoundStudentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
