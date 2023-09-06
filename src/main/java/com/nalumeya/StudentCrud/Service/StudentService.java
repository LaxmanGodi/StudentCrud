package com.nalumeya.StudentCrud.Service;

import com.nalumeya.StudentCrud.Model.StudentEntity;
import com.nalumeya.StudentCrud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String createStudent(StudentEntity student)
    {
        studentRepository.save(student);
        return "Record is created with roll number: "+student.getId();
    }

    public List<StudentEntity> getStudents()
    {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getStudentByID(int id)
    {
        return studentRepository.findById(id);
    }

    public String updateStudent(StudentEntity updatedStudent,int id)
    {
        Optional<StudentEntity> existingStudent=studentRepository.findById(id);
        if (existingStudent.isPresent())
        {
            StudentEntity student=existingStudent.get();
            student.setStudName(updatedStudent.getStudName());
            student.setEmail(updatedStudent.getEmail());
            studentRepository.save(student);
            return "Updated student with rollNo: "+id+"is "+student;
        }
        else
        {
            return "Required Student data is not available";
        }
    }

    public String deleteStudent(int id)
    {
        studentRepository.deleteById(id);
        return "Student with id:"+id+" is deleted";
    }
}
