package com.jvtpe.service;

import com.jvtpe.domain.Student;
import com.jvtpe.exception.ResourceNotFoundException;
import com.jvtpe.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {


    @Autowired
    private IStudentRepository iStudentRepository;


    @Override
    public List<Student> getAllStudent() {

        return iStudentRepository.getAll();
    }

    @Override
    public Student findStudentById(Long id) {
        Student student = iStudentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("İstenilen id'li Student objesi bulunamadı : " + id));
        return student ;
    }

    @Override
    public void saveStudent(Student student) {

        iStudentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {

        iStudentRepository.update(student);
    }

    @Override
    public void deleteStudent(Long id) {

        iStudentRepository.delete(id);

    }
}
