package com.msquare.sms.delegate;

import java.util.List;

import com.msquare.sms.beans.Student;

public interface StudentManagementServiceDelegate {
	public Student queryStudent(Long id);
	
	public List<Student> queryAllStudents();

	public void updateStudent(Student student);
	
	public void deleteStudent(Long id);
	
	public void createStudent(Student student);
}
