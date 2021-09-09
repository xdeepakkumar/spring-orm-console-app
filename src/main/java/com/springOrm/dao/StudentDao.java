package com.springOrm.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springOrm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	public Student getStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	public List<Student> getAllStudent() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	@Transactional
	public void deleteStudent(int id) {
		Student s = this.hibernateTemplate.get(Student.class,id);
		this.hibernateTemplate.delete(s);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
