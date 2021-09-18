package com.rkdevblog.pagination.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rkdevblog.pagination.domain.entity.Student;
import com.rkdevblog.pagination.domain.response.StudentResponse;
import com.rkdevblog.pagination.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class StudentController {

  private final StudentService studentService;

  @PostMapping("generate")
  public ResponseEntity<Void> generateData() {

    studentService.createDummyData();

    return ResponseEntity.ok().build();
  }

  @GetMapping("all")
  public ResponseEntity<List<Student>> getAllStudents() {
    return ResponseEntity.ok(studentService.getStudents());
  }

  @GetMapping("students")
  public ResponseEntity<StudentResponse> getStudentPagResponse(
      @RequestParam int page, @RequestParam int size) {

    Pageable pageable = PageRequest.of(page, size);
    Page<Student> studentPage = studentService.getStudentPage(pageable);
    StudentResponse studentResponse = new StudentResponse(studentPage);

    return ResponseEntity.ok(studentResponse);
  }
}
