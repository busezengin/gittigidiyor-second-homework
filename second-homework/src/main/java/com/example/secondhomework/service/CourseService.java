package com.example.secondhomework.service;

import com.example.secondhomework.dao.CourseDAO;
import com.example.secondhomework.dao.InstructorDAO;
import com.example.secondhomework.model.Course;
import com.example.secondhomework.model.Instructor;
import com.example.secondhomework.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CourseService implements BaseService<Course>{
    private CourseDAO courseDAO;

    public CourseService(@Qualifier("icourseDAOJPAImpl") CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {

        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {

        return (Course) courseDAO.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {

        return (Course) courseDAO.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }

    @Override
    public Course update(Course course) {
        return (Course) courseDAO.update(course);
    }
}
