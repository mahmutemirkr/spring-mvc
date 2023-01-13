package com.jvtpe.service;

import com.jvtpe.domain.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudent();

    Student findStudentById(Long id);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);


}
