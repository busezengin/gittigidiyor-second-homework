package com.example.secondhomework.controller;

import com.example.secondhomework.model.Instructor;
import com.example.secondhomework.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {
    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor saveCourse(@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructors(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "Deleted...";
    }
}
