package com.viki.controllers;

import com.viki.dto.CreateStudentDto;
import com.viki.dto.StudentDto;
import com.viki.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<StudentDto> readAll() {
        return studentService.readAll();
    }

    @PostMapping("create")
    public StudentDto create(@RequestBody CreateStudentDto createStudentDto) {
        return studentService.create(createStudentDto);
    }
}
