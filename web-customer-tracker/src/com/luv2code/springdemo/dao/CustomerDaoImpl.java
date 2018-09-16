package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = 
			session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<Customer> query = session.createQuery("delete from Customer where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
    public List<Customer> searchCustomers(String searchName) {

        Session session = sessionFactory.getCurrentSession();
        
		Query query = null;
        
        //
        // only search by name if searchName is not empty
        //
        if (searchName != null && searchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");

        } else {
            // searchName is empty ... so just get all customers
            query = session.createQuery("from Customer", Customer.class);            
        }

		List<Customer> customers = query.list();
      
        return customers;
        
    }
}
