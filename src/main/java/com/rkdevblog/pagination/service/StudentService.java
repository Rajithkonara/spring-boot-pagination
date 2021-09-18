package com.rkdevblog.pagination.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.rkdevblog.pagination.domain.entity.Student;
import com.rkdevblog.pagination.respository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;
  private final Faker faker;

  public void createDummyData() {

    for (int i = 0; i <= 89; i++) {

      String studentId = UUID.randomUUID().toString();
      String name = faker.name().firstName();
      int age = faker.number().numberBetween(20, 30);
      Student student = new Student(studentId, name, age);

      studentRepository.save(student);
    }
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public Page<Student> getStudentPage(Pageable pageable) {
    return studentRepository.findAll(pageable);
  }
}
