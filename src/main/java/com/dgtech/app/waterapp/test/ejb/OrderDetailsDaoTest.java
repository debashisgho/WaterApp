package com.dgtech.app.WaterApp.test.ejb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dgtech.app.WaterApp.ejb.OrderDetailsDao;
import com.dgtech.app.WaterApp.jpa.entity.OrderDetail;

public class OrderDetailsDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		OrderDetailsDao orderDao = new OrderDetailsDao();
					
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date orderDate = sdf.parse(sdf.format(new Date()));

        
		OrderDetail o1 = new OrderDetail();
		
		
		//INSERT - SUCCESS
		o1.setOrderstatus(0);
		o1.setOrderdate(orderDate);
		//set customer
		//CustomerMaster c1 = new CustomerMaster();
		//c1.setCustomerid(31);
		//o1.setCustomerMaster(c1);
		o1.setCustomerid(31);
		//set vendor
		//VendorMaster v1 = new VendorMaster();
		//v1.setVendorid(23);			
		//o1.setVendorMaster(v1);
        o1.setVendorid(23);		
		
		o1.setOrderquantity(1);
		o1.setComments("please deliver ASAP1");			
		orderDao.add(o1);
		

        /*//UPDATE
		o1.setOrderid(9);
		o1.setOrderstatus("NEW");
		o1.setOrderdate(orderDate);
		//set customer
		CustomerMaster c1 = new CustomerMaster();
		c1.setCustomerid(14);
		o1.setCustomerMaster(c1);
		//set vendor
		VendorMaster v1 = new VendorMaster();
		v1.setVendorid(1);			
		o1.setVendorMaster(v1);			
		
		o1.setOrderquantity(1);
		o1.setComments("please deliver ASAP1");
		orderDao.delete(o1);
*/
	}

}
