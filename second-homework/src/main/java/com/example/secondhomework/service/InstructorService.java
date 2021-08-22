package com.example.secondhomework.service;

import com.example.secondhomework.dao.InstructorDAO;
import com.example.secondhomework.dao.StudentDAO;
import com.example.secondhomework.model.Instructor;
import com.example.secondhomework.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class InstructorService implements BaseService<Instructor>{
    private InstructorDAO instructorDAO;

    public InstructorService(@Qualifier("instructorDAOJPAImpl") InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public List<Instructor> findAll() {

        return instructorDAO.findAll();
    }

    @Override
    public Instructor findById(int id) {

        return (Instructor) instructorDAO.findById(id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {

        return (Instructor) instructorDAO.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorDAO.deleteById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return (Instructor) instructorDAO.update(instructor);
    }
}
