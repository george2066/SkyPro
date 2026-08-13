package ru.hogwards.school.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwards.school.school.exceptions.NotFoundStudentException;
import ru.hogwards.school.school.interfaces.StudentService;
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.models.Student;
import ru.hogwards.school.school.services.StudentServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> get(@PathVariable long id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (NotFoundStudentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student) {
        return ResponseEntity.ok(service.add(student));
    }

    @PutMapping
    public ResponseEntity<Student> change(@RequestBody Student student) {
        try {
            return ResponseEntity.ok(service.change(student));
        } catch (NotFoundStudentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> delete(@PathVariable long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (NotFoundStudentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("getByAgeBetween")
    public ResponseEntity<Collection<Student>> getByAgeBetween(
            @RequestParam("min") Integer min,
            @RequestParam("max") Integer max
    ) {
        return ResponseEntity.ok(service.getAllByAgeBetween(min, max));
    }

    @GetMapping("getFaculty/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getFaculty(id));
        } catch (NotFoundStudentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
