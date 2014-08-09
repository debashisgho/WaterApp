package com.dgtech.app.WaterApp.test.ejb;

import com.dgtech.app.WaterApp.ejb.CustomerDao;
import com.dgtech.app.WaterApp.jpa.entity.AddressDetail;
import com.dgtech.app.WaterApp.jpa.entity.CustomerMaster;

public class CustomerDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomerDao cdao = new CustomerDao();
	
	
		CustomerMaster c1 = new CustomerMaster();
		
		//Insert test -works perfect
        c1.setFname("TestFName");
        c1.setLname("TestLname");
        AddressDetail addr1 = new AddressDetail();
        addr1.setAddressline1("TestAddressLine1");
        addr1.setAddressline2("TestAddressLine2");
        addr1.setCity("TestCity");
        addr1.setCountry("TestCountry");
        addr1.setEmailId("testEmail@gmail.com");
        addr1.setPhoneNum("8583018301");
        addr1.setState("TestState");

        c1.setAddressDetail(addr1);       
        cdao.add(c1);
        
         
		
		/*//remove test  --why does it try to select the order ids ?
		c1.setFname("Debashis2");
		c1.setLname("Ghosh");
		c1.setCustomerid(16);
        AddressDetail addr1 = new AddressDetail();
        addr1.setAddressline1("Marathalli2");
        addr1.setAddressline2("AshwathNagar");
        addr1.setCity("Bangalore");
        addr1.setCountry("India1");
        addr1.setEmailId("debashisgho@gmail.com");
        addr1.setPhoneNum("8095661249");
        addr1.setState("KN");

        c1.setAddressDetail(addr1);
		cdao.delete(c1);
		*/
		
		//Update test -  --why does it try to select the order ids ?
		
	/*	c1.setFname("Debashis2");
		c1.setLname("Ghosh");
		c1.setCustomerid(16);
        AddressDetail addr1 = new AddressDetail();
        addr1.setAddressline1("Marathalli2");
        addr1.setAddressline2("AshwathNagar");
        addr1.setCity("Bangalore");
        addr1.setCountry("India1");
        addr1.setEmailId("debashisgho@gmail.com");
        addr1.setPhoneNum("8095661249");
        addr1.setState("KN");

        c1.setAddressDetail(addr1);       
        cdao.update(c1);*/
		
        System.out.println("Customer DAO test succeeded");
		
		

	}

}
