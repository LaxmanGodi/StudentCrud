package com.nalumeya.StudentCrud.Repository;

import com.nalumeya.StudentCrud.Model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <StudentEntity,Integer> {
}
