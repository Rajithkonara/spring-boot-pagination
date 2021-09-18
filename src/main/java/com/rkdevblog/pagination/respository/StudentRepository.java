package com.rkdevblog.pagination.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkdevblog.pagination.domain.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {}
