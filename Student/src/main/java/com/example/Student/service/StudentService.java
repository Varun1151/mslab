package com.example.Student.service;

import com.example.Student.entity.Studdata;
import com.example.Student.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepository;

    public StudentService(StudentRepo studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Studdata> getAllStudents() {
        return studentRepository.findAll();
    }

    public Studdata getStuddataByUsn(String usn) {
        return studentRepository.findById(usn).orElse(null);
    }

    // public List<Studdata> getStuddataByName(String name) {
    //     return studentRepository.findByName(name).orElse(null);
    // }

    // public List<Studdata> getStuddataByCgpa(float cgpa) {
    //     return studentRepository.findByCgpa(cgpa).orElse(null);
    // }


    public Studdata create(Studdata student) {
        return studentRepository.save(student);
    }

    public void delete(String usn) {
        studentRepository.deleteById(usn);
    }

    public Studdata update(Studdata stud, String usn) {
        Studdata stud1 = studentRepository.findById(usn).get();
        stud1.setName(stud.getName());
        stud1.setCgpa(stud.getCgpa());
        studentRepository.save(stud1);
        return stud1;
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
