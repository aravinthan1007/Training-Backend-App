package com.training.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSES")
public class Sclass {

	private int id;

	private String name;

	private Set<SubjectClass> subjectClassSet;

	private Set<Student> studentSet;

	public Sclass() {
	}

	public Sclass(String name) {
		super();
		this.name = name;
	}

	public Sclass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLASS_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CLASS_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "sclass", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public Set<SubjectClass> getSubjectClassSet() {
		return subjectClassSet;
	}

	public void setSubjectClassSet(Set<SubjectClass> subjectClassSet) {
		this.subjectClassSet = subjectClassSet;
	}

	@OneToMany(mappedBy = "sclass", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	
	public Set<Student> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", Name=" + name + "]";
	}

}
