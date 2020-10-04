package com.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.model.SubjectClass;
import com.training.util.HibernateUtil;


public class SubjectClassDAO {

	public void createSubjectClass(SubjectClass subjectclass) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(subjectclass);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void updateSubjectClass(SubjectClass subjectclass) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(subjectclass);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void deleteSubjectClass(int id) {

		Transaction transaction = null;
		if (id > 0) {

			try (Session session = HibernateUtil.getSessionFactory().openSession()) {

				transaction = session.beginTransaction();
				SubjectClass subjectClass = session.get(SubjectClass.class, id);
				session.delete(subjectClass);
				transaction.commit();

			} catch (Exception e) {

				System.out.println("Exception Caught :" + e.getMessage());
				transaction.rollback();

			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<SubjectClass> getAllSubjectClass() {
        
		
		Transaction transaction = null;
		List<SubjectClass> subjectClassList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			subjectClassList = session.createQuery("From SubjectClass").getResultList();
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return subjectClassList;
	}

	public SubjectClass getSubjectClass(int id) {

		Transaction transaction = null;
		SubjectClass subjectClass = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			subjectClass = session.get(SubjectClass.class, id);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return subjectClass;
	}
  
	
}
