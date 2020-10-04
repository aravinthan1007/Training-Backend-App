package com.training.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.model.Subject;
import com.training.util.HibernateUtil;


public class SubjectDAO {
	
	

	public void createSubject(Subject subject) {
		

		Transaction transaction = null;
		System.out.println("DAO1");
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void deleteSubject(int id) {
		System.out.println("DAO1");
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			Subject subject = session.get(Subject.class, id);
			
			if (subject != null) {
				
			
				System.out.println("...deleting the subject.....");
				session.delete(subject);
			}
			System.out.println("...commit the transaction....");
			transaction.commit();

		} catch (Exception e) {

			//System.out.println("Exception Caught :" + e.getMessage());
			e.printStackTrace();
			
			transaction.rollback();

		}

	}

	public void updateSubject(Subject subject) {
		System.out.println("DAO1");
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(subject);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubjects() {
		System.out.println("DAO1");
		Transaction transaction = null;
		List<Subject> subjectList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			subjectList = session.createQuery("From Subject su"+ " Order by su.name").getResultList();

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return subjectList;
	}

	public Subject getSubject(int id) {

		Transaction transaction = null;
		Subject subject = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			subject = session.get(Subject.class, id);

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return subject;

	}
	


}
