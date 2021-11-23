package com.example.Student.repositories;

import com.example.Student.entity.Studdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Studdata, String> {
}
