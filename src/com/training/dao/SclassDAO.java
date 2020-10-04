package com.training.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.model.Sclass;
import com.training.util.HibernateUtil;



public class SclassDAO {

	public void createClass(Sclass sClass) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(sClass);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void deleteSClass(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			Sclass sClass = session.get(Sclass.class, id);
			if (sClass != null) {

				session.delete(sClass);
			}
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	public void updateSClass(Sclass sClass) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(sClass);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Sclass> getAllSClass() {

		Transaction transaction = null;
		List<Sclass> sClassList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			sClassList = session.createQuery("From Sclass sc" + " order by sc.name ").getResultList();

			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return sClassList;
	}

	public Sclass getSClass(int id) {

		Transaction transaction = null;
		Sclass sClass = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			System.out.println("Open session ");
			sClass = session.get(Sclass.class, id);
			Hibernate.initialize(sClass.getSubjectClassSet());
			Hibernate.initialize(sClass.getStudentSet());
			

			System.out.println("Commit Session");
			transaction.commit();

		} catch (Exception e) {

			System.out.println("Exception Caught :" + e.getMessage());
			transaction.rollback();

		}
		return sClass;

	}

}
