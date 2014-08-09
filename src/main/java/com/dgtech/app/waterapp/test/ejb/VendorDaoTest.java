package com.dgtech.app.WaterApp.test.ejb;

import com.dgtech.app.WaterApp.ejb.VendorDao;
import com.dgtech.app.WaterApp.jpa.entity.AddressDetail;
import com.dgtech.app.WaterApp.jpa.entity.VendorMaster;


public class VendorDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VendorDao vdao = new VendorDao();
	
	
		VendorMaster v1 = new VendorMaster();
		
		/*//Insert test -works perfect
        v1.setFname("Sashi");
        v1.setLname("Tharoor");
        AddressDetail addr1 = new AddressDetail();
        addr1.setAddressline1("Marathalli");
        addr1.setAddressline2("KarthikNagar");
        addr1.setCity("Bangalore");
        addr1.setCountry("India");
        addr1.setEmailId("sashi@gmail.com");
        addr1.setPhoneNum("1234567890");
        addr1.setState("KN");

        v1.setAddressDetail(addr1);       
        vdao.add(v1);
        */
         
		
		/*//remove test  --why does it try to select the order ids ?
		v1.setFname("Sashi");
        v1.setLname("Tharoor");
		v1.setVendorid(22);
		AddressDetail addr1 = new AddressDetail();
		addr1.setAddressid(43);
		addr1.setAddressline1("Marathalli");
        addr1.setAddressline2("KarthikNagar");
        addr1.setCity("Bangalore");
        addr1.setCountry("India");
        addr1.setEmailId("sashi@gmail.com");
        addr1.setPhoneNum("1234567890");
        addr1.setState("KN");
		v1.setAddressDetail(addr1);
        vdao.delete(v1);*/
		
		
		//Update test -  --why does it try to select the order ids ?
		
	    v1.setFname("Sashi2");
        v1.setLname("Tharoor2");
		v1.setVendorid(23);
        AddressDetail addr1 = new AddressDetail();
        
        addr1.setAddressid(45);
        addr1.setAddressline1("Marathalli2");
        addr1.setAddressline2("KarthikNagar");
        addr1.setCity("Bangalore");
        addr1.setCountry("India");
        addr1.setEmailId("sashi@gmail.com");
        addr1.setPhoneNum("1234567890");
        addr1.setState("KN");

        v1.setAddressDetail(addr1);       
        vdao.update(v1);
		
        System.out.println("Vendor DAO test succeeded");
		
		

	}

}
