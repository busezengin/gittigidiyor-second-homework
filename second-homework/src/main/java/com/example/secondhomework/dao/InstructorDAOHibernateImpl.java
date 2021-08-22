package com.example.secondhomework.dao;

import com.example.secondhomework.model.Instructor;
import com.example.secondhomework.model.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDAOHibernateImpl implements InstructorDAO<Instructor>{
    private EntityManager entityManager;

    public InstructorDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Instructor", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return null;
    }

    @Override
    public Instructor save(Instructor instructor) {
        Session session = entityManager.unwrap(Session.class);
        return (Instructor) session.merge(instructor);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Instructor update(Instructor object) {
        return null;
    }
}
