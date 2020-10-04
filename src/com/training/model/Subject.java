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
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECTS")
public class Subject {

	private int id;

	private String name;

	private Set<SubjectClass> subjectClassSet;

	public Subject() {
	}

	public Subject(String name) {
		super();
		this.name = name;
	}

	public Subject(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBJECT_ID",unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "SUBJECT_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public Set<SubjectClass> getSubjectClassSet() {
		return subjectClassSet;
	}

	public void setSubjectClassSet(Set<SubjectClass> subjectClassSet) {
		this.subjectClassSet = subjectClassSet;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}

}
