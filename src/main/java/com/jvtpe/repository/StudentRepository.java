package com.jvtpe.repository;

import com.jvtpe.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository implements IStudentRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAll() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<Student> listOfStudent =
                session.createQuery("FROM Student", Student.class).getResultList();

        tx.commit();
        session.close();

        return listOfStudent;


    }

    @Override
    public Optional<Student> findById(Long id) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class,id);

        Optional<Student> opt = Optional.ofNullable(student);

        tx.commit();
        session.close();
        return opt;

    }

    @Override
    public void save(Student student) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(student);

        tx.commit();
        session.close();

    }

    @Override
    public void update(Student student) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(student);

        tx.commit();
        session.close();


    }

    @Override
    public void delete(Long id) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.load(Student.class, id);

        session.delete(student);

        tx.commit();
        session.close();

    }
}
