package com.techgen.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techgen.entity.Company;
import com.techgen.entity.CompanyPrimaryKey;
import com.techgen.entity.Employee;
import com.techgen.util.HibernateUtil;

public class Client {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;

		Session session = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.getCurrentSession();

			Transaction transaction = session.getTransaction();

			transaction.begin();

			CompanyPrimaryKey companyPrimaryKey = new CompanyPrimaryKey("Exatip", "Exa-7532");
			Company company = new Company(companyPrimaryKey);
			company.setCity("Indore");
			company.setStatus(true);

			Employee employee = new Employee("Taher1", "Dev1", company);
			company.addEmployee(employee);

			session.persist(company);

			transaction.commit();

		} catch (HibernateException e) {

			System.out.println(e.getMessage());

		} finally {

			if (session != null) {
				session.close();
			}

			if (sessionFactory != null) {
				sessionFactory.close();
			}

		}
	}

}
