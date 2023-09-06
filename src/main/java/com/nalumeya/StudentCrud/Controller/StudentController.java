package com.nalumeya.StudentCrud.Controller;

import com.nalumeya.StudentCrud.Model.StudentEntity;
import com.nalumeya.StudentCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("student")
    public String createStudent(@RequestBody StudentEntity student)
    {
        studentService.createStudent(student);
        return ""+student.getId();
    }

    @GetMapping("student")
    public List<StudentEntity> getStudents()
    {
        return studentService.getStudents();
    }

    @GetMapping("student/{id}")
    public Optional<StudentEntity> getStudentByID(@PathVariable int id)
    {
        return studentService.getStudentByID(id);
    }

    @PutMapping("student/{id}")
    public String updateStudent(@RequestBody StudentEntity updatedStudent,@PathVariable int id)
    {
        return studentService.updateStudent(updatedStudent,id);
    }

    @DeleteMapping("student/{id}")
    public String deleteStudent(@PathVariable int id)
    {
       return studentService.deleteStudent(id);
    }
}
