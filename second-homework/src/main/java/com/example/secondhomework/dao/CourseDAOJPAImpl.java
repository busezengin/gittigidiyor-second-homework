package com.example.secondhomework.dao;
import com.example.secondhomework.model.Course;
import com.example.secondhomework.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO<Course> {
    private static final Logger logger = LoggerFactory.getLogger(CourseDAOJPAImpl.class);
    private EntityManager entityManager;
    @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Course course = this.findById(id);

        if(course == null){
            logger.error("There is no course with id : " + id);
        }

        entityManager.remove(course);
    }

    @Override
    public Course update(Course course) {
        return entityManager.merge(course);
    }
}
