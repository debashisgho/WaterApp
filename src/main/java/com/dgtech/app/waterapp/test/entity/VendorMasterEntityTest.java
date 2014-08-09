package com.dgtech.app.WaterApp.test.jpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.dgtech.app.WaterApp.jpa.entity.AddressDetail;
import com.dgtech.app.WaterApp.jpa.entity.VendorMaster;

public class VendorMasterEntityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		try {
			EntityManager em = (EntityManager)Persistence.createEntityManagerFactory("WaterAppPU").createEntityManager();
	        em.getTransaction().begin();
			VendorMaster v1 = new VendorMaster();
	        v1.setFname("Debashis");
	        v1.setLname("Ghosh");
	        AddressDetail addr1 = new AddressDetail();
	        addr1.setAddressline1("VMarathalli");
	        addr1.setAddressline2("VAshwathNagar");
	        addr1.setCity("VBangalore");
	        addr1.setCountry("VIndia");
	        addr1.setEmailId("Vdebashisgho@gmail.com");
	        addr1.setPhoneNum("V8095661249");
	        addr1.setState("VKN");

	        v1.setAddressDetail(addr1);
	        System.out.println("initialized the vendor v1 data");
	        em.persist(v1);
	        em.getTransaction().commit();
	       //em.flush();
	        
		}
		
		catch(Exception e){
			System.out.println(e.toString());			
		}
		
		
	}

}
