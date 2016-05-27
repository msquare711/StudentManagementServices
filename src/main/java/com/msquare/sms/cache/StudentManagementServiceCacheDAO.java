package com.msquare.sms.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.msquare.sms.beans.Student;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

public class StudentManagementServiceCacheDAO {

	private CacheManager cacheManager;
	
	public StudentManagementServiceCacheDAO() {
		CacheManager.create();
		cacheManager.addCache(new Cache(new CacheConfiguration("student", 1000).eternal(true)));
	}
	
	public Student queryStudent(Long id){
		List<Student> students = queryAllStudents();
		for(Student student : students){
			if(id.equals(student.getId())){
				return student;
			}
		}
		return null;
	}
	
	public List<Student> queryAllStudents(){
		Cache cache = cacheManager.getCache("student");
		Map<Object, Element> cacheMap = cache.getAll(cache.getKeys());
		return convertMaptoStudents(cacheMap);
	}
	
	private List<Student> convertMaptoStudents(Map<Object, Element> cacheMap) {
		List<Student> students = new ArrayList<>();
		
		for(Element element: cacheMap.values()){
			students.add((Student) element.getObjectValue());
		}
		return students;
	}

	public void updateStudent(Student student){
		
	}
	
	public void deleteStudent(Long id){
		
	}
	
	public void createStudent(Student student){
		
	}
	
}
