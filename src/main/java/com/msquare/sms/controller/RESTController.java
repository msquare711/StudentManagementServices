package com.msquare.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msquare.sms.beans.Student;
import com.msquare.sms.delegate.StudentManagementServiceDelegate;

@RestController
public class RESTController {

	@Autowired
	private StudentManagementServiceDelegate delegate;
	
    @RequestMapping(value="/students", method=RequestMethod.GET, produces="application/json")
    public List<Student> retrieveAllStudents() {        
        return delegate.queryAllStudents();
    }
    
    @RequestMapping(value="/students/{id}", method=RequestMethod.GET)
    public Student retrieveStudentById(@PathVariable Long id) {
    	return delegate.queryStudent(id);
    }
    
    @RequestMapping(value="/students", method=RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {
    	delegate.createStudent(student);
        return "Student: " + student.getId() + " added successfully...";
    }
	
    @RequestMapping(value="/students/{id}", method=RequestMethod.PUT)
    public String updateStudent(@PathVariable String id, @RequestBody Student student) {
        delegate.updateStudent(student);     
        return "Student: updated successfully...";
    }
    
    @RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Long id) {
    	delegate.deleteStudent(id);
        return "Student " + id + " was deleted successfully...";
    }
}
