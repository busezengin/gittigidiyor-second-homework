package com.example.secondhomework.dao;

import com.example.secondhomework.model.Course;
import com.example.secondhomework.model.Student;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDAOHibernateImpl implements CourseDAO<Course>{
    private EntityManager entityManager;

    public CourseDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Course> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course save(Course course) {
        Session session = entityManager.unwrap(Session.class);
        return (Course) session.merge(course);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Course update(Course object) {
        return null;
    }
}
