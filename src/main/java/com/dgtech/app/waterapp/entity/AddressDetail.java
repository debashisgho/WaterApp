package com.dgtech.app.WaterApp.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the WATERAPP_ADDRESS_DETAILS database table.
 * 
 */
@Entity
@Table(name="WATERAPP_ADDRESS_DETAILS")
public class AddressDetail implements Serializable { 
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name ="ADDRESS_DETAILS_SEQ", sequenceName="WATERAPP_ADDRESS_DETAILS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_DETAILS_SEQ")
	private long addressid;

	private String addressline1;

	private String addressline2;

	private String city;

	private String country;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="PHONE_NUM")
	private String phoneNum;

	@Column(name="\"STATE\"")
	private String state;

	/*
	 //bi-directional many-to-one association to CustomerMaster
	@OneToMany(mappedBy="addressDetail")
	private List<CustomerMaster> CustomerMasters;

	//bi-directional many-to-one association to VendorMaster
	@OneToMany(mappedBy="waterappAddressDetail")
	private List<VendorMaster> waterappVendorMasters;
	*/

	public AddressDetail() {
	}

	public long getAddressid() {
		return this.addressid;
	}

	public void setAddressid(long addressid) {
		this.addressid = addressid;
	}

	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/*public List<CustomerMaster> getCustomerMasters() {
		return this.CustomerMasters;
	}

	public void setCustomerMasters(List<CustomerMaster> CustomerMasters) {
		this.CustomerMasters = CustomerMasters;
	}

	public CustomerMaster addCustomerMaster(CustomerMaster CustomerMaster) {
		getCustomerMasters().add(CustomerMaster);
		CustomerMaster.setAddressDetail(this);

		return CustomerMaster;
	}

	public CustomerMaster removeCustomerMaster(CustomerMaster CustomerMaster) {
		getCustomerMasters().remove(CustomerMaster);
		CustomerMaster.setAddressDetail(null);

		return CustomerMaster;
	}

	public List<VendorMaster> getWaterappVendorMasters() {
		return this.waterappVendorMasters;
	}

	public void setWaterappVendorMasters(List<VendorMaster> waterappVendorMasters) {
		this.waterappVendorMasters = waterappVendorMasters;
	}

	public VendorMaster addWaterappVendorMaster(VendorMaster waterappVendorMaster) {
		getWaterappVendorMasters().add(waterappVendorMaster);
		waterappVendorMaster.setWaterappAddressDetail(this);

		return waterappVendorMaster;
	}

	public VendorMaster removeWaterappVendorMaster(VendorMaster waterappVendorMaster) {
		getWaterappVendorMasters().remove(waterappVendorMaster);
		waterappVendorMaster.setWaterappAddressDetail(null);

		return waterappVendorMaster;
	}
 */
}