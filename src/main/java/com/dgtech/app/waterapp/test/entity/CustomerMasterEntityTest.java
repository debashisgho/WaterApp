package com.dgtech.app.WaterApp.test.jpa.entity;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import com.dgtech.app.WaterApp.jpa.entity.AddressDetail;
import com.dgtech.app.WaterApp.jpa.entity.CustomerMaster;

public class CustomerMasterEntityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		try {
			
			EntityManager em = (EntityManager)Persistence.createEntityManagerFactory("WaterAppPU").createEntityManager();
	        em.getTransaction().begin();
			
	       
	        CustomerMaster c1 = new CustomerMaster();
	        
	        //INSERT -SUCCESS
	        c1.setFname("John");
	        c1.setLname("Smith");
	        AddressDetail addr1 = new AddressDetail();
	        addr1.setAddressline1("10th Ave, NE");
	        addr1.setAddressline2("near station");
	        addr1.setCity("MyCity");
	        addr1.setCountry("MyCountry");
	        addr1.setEmailId("abc@gmail.com");
	        addr1.setPhoneNum("1234567890");
	        addr1.setState("MyState");

	        c1.setAddressDetail(addr1);
	        System.out.println("initialized the customer c1 data");
	        em.persist(c1);
	        
	        /*//UPDATE - WORKS PARTIALLY - LOT OF UNNECESSARY QUERIES GET EXECUTED - THE FETCH TYPE LAZY DOES NOT SEEM TO WORK PROPERLY
	        c1.setCustomerid(18);
	        c1.setFname("John_new");
	        c1.setLname("Smith");
	        AddressDetail addr1 = new AddressDetail();
	        addr1.setAddressline1("10th Ave, NE");
	        addr1.setAddressline2("near station");
	        addr1.setCity("MyCity_new");
	        addr1.setCountry("MyCountry");
	        addr1.setEmailId("abc@gmail.com");
	        addr1.setPhoneNum("1234567890");
	        addr1.setState("MyState");
	        addr1.setAddressid(37);

	        c1.setAddressDetail(addr1);
	       
	        em.merge(c1);*/ 
	        
	        
	      /* //DELETE - WORKS PARTIALLY, EXCEPT THAT ORDER_DETAILS ALSO GET SELECTED, WHY IS LAZY FETCH NOT WORKING ?
	        c1.setCustomerid(18);
	        c1.setFname("John_new");
	        c1.setLname("Smith");
	        AddressDetail addr1 = new AddressDetail();
	        addr1.setAddressline1("10th Ave, NE");
	        addr1.setAddressline2("near station");
	        addr1.setCity("MyCity_new");
	        addr1.setCountry("MyCountry");
	        addr1.setEmailId("abc@gmail.com");
	        addr1.setPhoneNum("1234567890");
	        addr1.setState("MyState");
	        addr1.setAddressid(37);

	        c1.setAddressDetail(addr1);
	        c1=em.merge(c1); 
	        em.remove(c1);	        
	        em.getTransaction().commit();
	        */
		}
		
		catch(Exception e){
			System.out.println(e.toString());			
		}
		
		
	}

}
