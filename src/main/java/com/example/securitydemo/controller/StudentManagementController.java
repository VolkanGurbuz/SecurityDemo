package com.example.securitydemo.controller;

import com.example.securitydemo.model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

  Logger logger = LogManager.getLogger(StudentManagementController.class);

  private static final List<Student> students =
      Arrays.asList(new Student(1, "volkan"), new Student(2, "jessy"));

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public List<Student> getStudents() {
    return students;
  }

  @PostMapping
  @PreAuthorize("hasAuthority('student:write')")
  public void registerNewStudent(@RequestBody Student student) {
    logger.info(student.toString());
  }

  @DeleteMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void deleteStudent(@PathVariable("studentId") Integer studentId) {
    logger.info(studentId.toString());
  }

  @PutMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void updateStudent(
      @PathVariable("studentId") Integer studentId, @RequestBody Student student) {

    logger.info(student.toString());
  }
}
