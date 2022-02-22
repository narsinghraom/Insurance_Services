package com.insurance.main.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.main.bean.CustomerBean;
import com.insurance.main.bean.ZipBean;
import com.insurance.main.constants.CommonConstants;

@Repository
public class DataDaoImplementation implements DataDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<ZipBean> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<ZipBean> zipList = session.createQuery("from ZipBean").list();
		session.close();
		return zipList;
	}

	public List<String> getZipList(String zip) {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<String> zipList = session
				.createQuery("select z.zipCode from ZipBean z where z.zipCode like '" + zip + "%'").list();

		return zipList;
	}

	public List<ZipBean> getZipData(String zip) {
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<ZipBean> zipList = session.createQuery("from ZipBean z where z.zipCode like '" + zip + "%'").list();

		return zipList;
	}

	@Override
	public int insertCustomerData(CustomerBean customerBean) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Serializable serializable=  session.save(customerBean);
		transaction.commit();
		return serializable != null ? 1 : 0;
	}

	@Override
	public int updateCustomerData(CustomerBean customerBean) {
		if (customerBean == null) {
			return 0;
		}
		Session session = sessionFactory.openSession();
		String queryBuilder = customerUpdateQueryBuilder(customerBean);
		Query query = session.createQuery(queryBuilder);
		setQueryParams(query, CommonConstants.CUSTOMER_FIRST_NAME, customerBean.getCustomerFirstName());
		setQueryParams(query, CommonConstants.CUSTOMER_LAST_NAME, customerBean.getCustomerLastName());
		setQueryParams(query, CommonConstants.CUSTOMER_ADDRESS, customerBean.getCustomerAddress());
		setQueryParams(query, CommonConstants.CUSTOMER_DOB, customerBean.getCustomerDOB());
		setQueryParams(query, CommonConstants.CUSTOMER_REF_ID, customerBean.getCustomerReferanceId());
		int result = query.executeUpdate();
		return result;
	}

	/**
	 * 
	 * @param query
	 * @param paramKey
	 * @param paramValue
	 */
	private void setQueryParams(Query query, String paramKey, String paramValue) {
		if (paramValue != null) {
			query.setParameter(paramKey, paramValue);
		}
	}

	/**
	 * @param customerBean
	 * @return
	 */
	private String customerUpdateQueryBuilder(CustomerBean customerBean) {
		//update customerBean set customerFirstname=:customerFirstname
		StringBuilder queryBuilder = new StringBuilder("update CustomerBean set ");
		if (customerBean.getCustomerFirstName() != null) {
			queryBuilder.append(CommonConstants.CUSTOMER_FIRST_NAME + CommonConstants.EQUAL_COLON
					+ CommonConstants.CUSTOMER_FIRST_NAME+CommonConstants.EMPTY_SPACE);
		}
		if (customerBean.getCustomerLastName() != null) {
			queryBuilder.append(CommonConstants.CUSTOMER_LAST_NAME + CommonConstants.EQUAL_COLON
					+ CommonConstants.CUSTOMER_LAST_NAME + CommonConstants.EMPTY_SPACE);
		}
		if (customerBean.getCustomerAddress() != null) {
			queryBuilder.append(
					CommonConstants.CUSTOMER_ADDRESS + CommonConstants.EQUAL_COLON + CommonConstants.CUSTOMER_ADDRESS + CommonConstants.EMPTY_SPACE);
		}
		if (customerBean.getCustomerDOB() != null) {
			queryBuilder
					.append(CommonConstants.CUSTOMER_DOB + CommonConstants.EQUAL_COLON + CommonConstants.CUSTOMER_DOB +CommonConstants.EMPTY_SPACE);
		}
		queryBuilder.append(CommonConstants.WHERE + CommonConstants.EMPTY_SPACE);
		if (customerBean.getCustomerReferanceId() != null) {
			queryBuilder.append(
					CommonConstants.CUSTOMER_REF_ID + CommonConstants.EQUAL_COLON + CommonConstants.CUSTOMER_REF_ID);
		}
		return queryBuilder.toString();
	}

	@Override
	public List<CustomerBean> searchCustomerWithRefID(String customerReferanceId) {
		Session session = sessionFactory.openSession();
		List<CustomerBean> listRes = session
				.createQuery("from CustomerBean c where c.customerReferanceId=" + customerReferanceId).list();

		return listRes;
	}

	@Override
	public int deleteCustomerData(String customerReferanceId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete from CustomerBean where customerReferanceId=:customerReferanceId");
		query.setParameter(CommonConstants.CUSTOMER_REF_ID, customerReferanceId);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<CustomerBean> listRes = session.createQuery("from CustomerBean").list();
		return listRes;
	}

}
