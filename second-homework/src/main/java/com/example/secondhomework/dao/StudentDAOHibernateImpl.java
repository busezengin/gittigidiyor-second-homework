package com.example.secondhomework.dao;

import com.example.secondhomework.model.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOHibernateImpl implements StudentDAO<Student>{

    private EntityManager entityManager;

    public StudentDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        Session session = entityManager.unwrap(Session.class);
        return (Student) session.merge(student);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Student update(Student object) {
        return null;
    }
}