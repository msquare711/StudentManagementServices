package com.msquare.sms.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

import org.springframework.stereotype.Component;

import com.msquare.sms.beans.Student;

@Component
public class StudentManagementServiceCacheDelegate implements StudentManagementServiceDelegate{

	private static final String STUDENT_CACHE_NAME = "student";
	
	private CacheManager cacheManager;
	
	public StudentManagementServiceCacheDelegate() {
		cacheManager = CacheManager.create();
		cacheManager.addCache(new Cache(new CacheConfiguration(STUDENT_CACHE_NAME, 1000).eternal(true)));
		loadCacheWithDefaultStudents();
	}
	
	private void loadCacheWithDefaultStudents() {
		Cache studentCache = cacheManager.getCache(STUDENT_CACHE_NAME);
		Student one = new Student();
		one.setId(1L);
		one.setFirstName("Bobby");
		one.setLastName("Smith");
		one.setPhone("5551231212");
		one.setState("AZ");
		one.setStreet("123 Main St.");
		one.setCity("Mesa");
		one.setZipCode("85207");
		studentCache.put(new Element(one.getId(), one));
		
		Student two = new Student();
		two.setId(2L);
		two.setFirstName("Cindy");
		two.setLastName("Lou");
		two.setPhone("5552334567");
		two.setState("AZ");
		two.setStreet("555 Ohnoe Ave.");
		two.setCity("Tempe");
		two.setZipCode("85205");
		studentCache.put(new Element(two.getId(), two));
		
		Student three = new Student();
		three.setId(3L);
		three.setFirstName("Justin");
		three.setLastName("Douche");
		three.setPhone("5554567890");
		three.setState("AZ");
		three.setStreet("666 Douche Ln.");
		three.setCity("Phoenix");
		three.setZipCode("85203");
		studentCache.put(new Element(three.getId(), three));
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
