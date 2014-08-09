package com.dgtech.app.WaterApp.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.dgtech.app.WaterApp.jpa.entity.CustomerMaster;

public class CustomerDao extends EntityGenericDaoImpl<CustomerMaster> implements EntityGenericDao<CustomerMaster> {

	@Override
	public List<CustomerMaster> listAll() {
		setUpConnection();
		Query query = getEm().createQuery("select c from CustomerMaster c order by c.customerid ASC");
		@SuppressWarnings("unchecked")
		List<CustomerMaster> customerList= query.getResultList();
		if (customerList == null){
			customerList = new ArrayList<CustomerMaster>();
		}
		return customerList;
	}

	@Override
	public List<CustomerMaster> searchById(Long uniqueId) {
		setUpConnection();
		Query query = getEm().createQuery("select c from CustomerMaster c where c.customerid ="+uniqueId);
		@SuppressWarnings("unchecked")
		List<CustomerMaster> customerList= query.getResultList();
		if (customerList == null){
			customerList = new ArrayList<CustomerMaster>();
		}
		return customerList;
	}

	
	 
}
