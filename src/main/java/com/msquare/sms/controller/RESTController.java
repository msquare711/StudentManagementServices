package com.msquare.sms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msquare.sms.beans.Student;

@RestController
public class RESTController {

    @RequestMapping(value="/students", method=RequestMethod.GET)
    public List<Student> retrieveAllStudents() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Michael");
        student1.setLastName("Smith");
        Student student2 = new Student();
        student2.setId(2L);
        student2.setFirstName("Carrie");
        student2.setLastName("Smythe");
        students.add(student1);
        students.add(student2);
        
        return students;
    }
    
    @RequestMapping(value="/students/{id}", method=RequestMethod.GET)
    public Student retrieveStudentById(@PathVariable String id) {

        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Michael");
        student1.setLastName("Smith");
        
        return student1;
    }
    
    @RequestMapping(value="/students", method=RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {

        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Michael");
        student1.setLastName("Smith");
        
        return "Student: " + student.getId() + " added successfully...";
    }
	
    @RequestMapping(value="/students/{id}", method=RequestMethod.PUT)
    public String updateStudent(@PathVariable String id, @RequestBody Student student) {

        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Michael");
        student1.setLastName("Smith");
        
        return "Student: updated successfully...";
    }
    
    @RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
    public String updateStudent(@PathVariable String id) {

        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Michael");
        student1.setLastName("Smith");
        
        return "Student " + id + " was deleted successfully...";
    }
}
