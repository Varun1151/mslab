package com.example.Student.controller;

import com.example.Student.entity.Studdata;
import com.example.Student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public List<Studdata> getAllStuddatas() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getByUsn/{usn}")
    public Studdata getStuddata(@PathVariable String usn) {
        return studentService.getStuddataByUsn(usn);
    }

    // @GetMapping("/getByName/{name}")
    // public List<Studdata> getStuddataByName(@PathVariable String name) {
    //     return studentService.getStuddataByName(name);
    // }

    // @GetMapping("/getByCgpa/{cgpa}")
    // public List<Studdata> getStuddataByCgpa(@PathVariable float cgpa) {
    //     return studentService.getStuddataByCgpa(cgpa);
    // }

    @PostMapping("/createStudent")
    public Studdata createStuddata(@RequestBody Studdata student) {
        return studentService.create(student);
    }

    @DeleteMapping("/deleteStuddata/{usn}")
    public String deleteStuddata(@PathVariable String usn) {
        studentService.delete(usn);
        return "Student Deleted";
    }

    @PutMapping("/updateStuddata/{usn}")
    public Studdata updateStuddata(@RequestBody Studdata student, @PathVariable String usn) {
        return studentService.update(student, usn);
    }

    @DeleteMapping("/deleteAll")
    public String deleteStuddatas() {
        studentService.deleteAll();
        return "All Students data deleted";
    }
}
