package com.insurance.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.main.bean.ZipBean;

@Service
public class DataDaoImplementation implements DataDao{
	@Autowired  
	 SessionFactory sessionFactory;  
	public List<ZipBean> getList() {
		 Session session = sessionFactory.openSession();  
		  @SuppressWarnings("unchecked")  
		  List<ZipBean> zipList = session.createQuery("from ZipBean")  
		    .list();  
		  session.close();  
		  return zipList;  
	}
	
	public List<String> getZipList(String zip) {

		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		List<String> zipList=session.createQuery("select z.zipCode from ZipBean z where z.zipCode like '"+zip+"%'").list();
		
		return zipList;
	}

	public List<ZipBean> getZipData(String zip) {
Session session = sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		List<ZipBean> zipList=session.createQuery("from ZipBean z where z.zipCode like '"+zip+"%'").list();
		
		return zipList;
	}


}
