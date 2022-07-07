package com.learning.crm.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.crm.model.Customer;

@Repository
public class CustomerService implements CustomerInterface {

	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;
	private Session session;

	// Session creation definition using the session factory
	@Autowired
	public CustomerService(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;

		try {
			this.session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = sessionFactory.openSession();
		}
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Customer> customers = session.createQuery("from Customer").list();

		return customers;
	}

	@Override
	public Customer findCustomer(int id) {
		// TODO Auto-generated method stub
		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tx.commit();

	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();

	}

}
