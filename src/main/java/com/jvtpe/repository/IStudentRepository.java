package com.jvtpe.repository;

import com.jvtpe.domain.Student;
import java.util.List;
import java.util.Optional;

public interface IStudentRepository {

    List<Student> getAll();

    Optional<Student> findById(Long id);

    void save(Student student);

    void update(Student student);

    void delete(Long id);
}
