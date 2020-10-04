package com.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.model.Teacher;
import com.training.util.HibernateUtil;


public class TeacherDAO {

	public void createTeacher(Teacher teacher) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(teacher);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void deleteTeacher(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, id);
			session.save(teacher);
			if (teacher != null) {
				session.delete(teacher);
			}
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void updateTeacher(Teacher teacher) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(teacher);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeachers() {

		Transaction transaction = null;
		List<Teacher> teacherList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			teacherList = session.createQuery("From Teacher").getResultList();

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return teacherList;
	}

	public Teacher getTeacher(int id) {

		Transaction transaction = null;
		Teacher teacher = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			teacher = session.get(Teacher.class, id);

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return teacher;

	}


}
