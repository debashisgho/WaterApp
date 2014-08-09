package com.dgtech.app.WaterApp.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.dgtech.app.WaterApp.jpa.entity.OrderDetail;

public class OrderDetailsDao extends EntityGenericDaoImpl<OrderDetail>implements EntityGenericDao<OrderDetail> {

	@Override
	public List<OrderDetail> listAll() {
		setUpConnection();
		Query query = getEm().createQuery("select o from OrderDetail o order by o.orderid ASC");
		@SuppressWarnings("unchecked")
		List<OrderDetail> orderDetailList= query.getResultList();
		if (orderDetailList == null){
			orderDetailList = new ArrayList<OrderDetail>();
		}
		return orderDetailList;
	}

	@Override
	public List<OrderDetail> searchById(Long uniqueId) {
		setUpConnection();
		Query query = getEm().createQuery("select o from OrderDetail o where o.orderid ="+uniqueId);
		@SuppressWarnings("unchecked")
		List<OrderDetail> orderDetailList= query.getResultList();
		if (orderDetailList == null){
			orderDetailList = new ArrayList<OrderDetail>();
		}
		return orderDetailList;
	}

	
	 
}
