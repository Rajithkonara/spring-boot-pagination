package com.rkdevblog.pagination.domain.response;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rkdevblog.pagination.domain.entity.Student;

import lombok.Getter;

@Getter
public class StudentResponse extends PageResponse {

  private final List<Student> students;

  public StudentResponse(Page<Student> page) {
    super(page);
    this.students = page.getContent();
  }
}
