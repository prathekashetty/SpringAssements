package com.wolken.mvc.dao;


	import java.util.List;

	import javax.persistence.RollbackException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
	import org.hibernate.query.Query;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;

import com.wolken.mvc.controller.PhoneController;
import com.wolken.mvc.entity.PhoneEntity;





	@Component
	public class PhoneDetailsImpl implements PhoneDetailsDAO{
		Logger logger=Logger.getLogger(PhoneDetailsImpl.class);
		@Autowired
		SessionFactory factory;

		public String save(PhoneEntity entity) {
			
			Session session = null;
			try {
		    	session = factory.openSession();
		    	Transaction tx = session.beginTransaction();
		    	logger.info(entity);
		    	session.save(entity);
		    	tx.commit();
			}
			catch(RollbackException e) {
				return "Save Failed";
			}
			finally {
				if(session!=null)
					session.close();
			}
			
			return "Saved Successfully";
		}

		public PhoneEntity updatePriceByModelNo(PhoneEntity entity, float price) {
			Session session = null;
			entity.setPrice(price);
			try {
		    	session = factory.openSession();
		    	Transaction tx = session.beginTransaction();
		    	session.saveOrUpdate(entity);
		    	tx.commit();
			}
			catch(RollbackException e) {
				System.err.println(e.getMessage());
			}
			finally {
				if(session!=null)
					session.close();
			}
			
			return entity;
		}
		
		public PhoneEntity updateAvailabilityByModelNo(PhoneEntity entity, boolean availability) {
			Session session = null;
			entity.setAvailability(availability);
			try {
		    	session = factory.openSession();
		    	Transaction tx = session.beginTransaction();
		    	session.saveOrUpdate(entity);
		    	tx.commit();
			}
			catch(RollbackException e) {
				System.err.println(e.getMessage());
			}
			finally {
				if(session!=null)
					session.close();
			}
			
			return entity;
		}
		
		public List<PhoneEntity> getByPrice(float price) {
			Session session = null;
			List<PhoneEntity> entity= null;
			try{
		    	session = factory.openSession();
		    	Query query = session.getNamedQuery("getByPrice");
		    	query.setParameter("price", price);
		    	entity = query.list();
			}
			finally {
				if(session!=null)
					session.close();
			}
			return entity;
		}
		
		public List<PhoneEntity> getByBrandName(String brandName) {
			Session session = null;
			List<PhoneEntity> entity= null;
			try{
		    	session = factory.openSession();
		    	Query query = session.getNamedQuery("getByBrandName");
		    	query.setParameter("brandName", brandName);
		    	entity = query.list();
			}
			finally {
				if(session!=null)
					session.close();
			}
			return entity;
		}

		public PhoneEntity getByModelNo(int modelNo) {
			Session session = null;
			PhoneEntity entity= null;
			try{
		    	session = factory.openSession();
		    	Query query = session.getNamedQuery("getByModelNo");
		    	query.setParameter("modelNo", modelNo);
		    	entity = (PhoneEntity) query.uniqueResult();
			}
			finally {
				if(session!=null)
					session.close();
			}
			return entity;
		}

	

}
