package com.dgtech.app.WaterApp.test.jpa.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.dgtech.app.WaterApp.jpa.entity.OrderDetail;

public class OrderDetailsTestEntity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			EntityManager em = (EntityManager)Persistence.createEntityManagerFactory("WaterAppPU").createEntityManager();
	        em.getTransaction().begin();
	        
	        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date orderDate = sdf.parse(sdf.format(new Date()));
	
	        
			OrderDetail o1 = new OrderDetail();
			o1.setOrderstatus(0);
			o1.setOrderdate(orderDate);
			o1.setCustomerid(31);
			o1.setVendorid(23);			
				
			
			o1.setOrderquantity(1);
			o1.setComments("please deliver ASAP");			
	        System.out.println("initialized the order  o1 data");	        
	        em.persist(o1);	        
	        em.getTransaction().commit();
	        
		}
		
		catch(Exception e){
			System.out.println(e.toString());			
		}
		
		
		
		
	}

}
