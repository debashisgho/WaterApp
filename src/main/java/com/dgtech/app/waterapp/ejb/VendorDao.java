package com.dgtech.app.WaterApp.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.dgtech.app.WaterApp.jpa.entity.VendorMaster;

public class VendorDao extends EntityGenericDaoImpl<VendorMaster> implements EntityGenericDao<VendorMaster> {

	@Override
	public List<VendorMaster> listAll() {
		setUpConnection();
		Query query = getEm().createQuery("select v from VendorMaster v order by v.vendorid ASC");
		@SuppressWarnings("unchecked")
		List<VendorMaster> vendorList= query.getResultList();
		if (vendorList == null){
			vendorList = new ArrayList<VendorMaster>();
		}
		return vendorList;
	}

	@Override
	public List<VendorMaster> searchById(Long uniqueId) {
		setUpConnection();
		Query query = getEm().createQuery("select v from VendorMaster v where v.vendorid ="+uniqueId);
		@SuppressWarnings("unchecked")
		List<VendorMaster> vendorList= query.getResultList();
		if (vendorList == null){
			vendorList = new ArrayList<VendorMaster>();
		}
		return vendorList;
	}



		
}
