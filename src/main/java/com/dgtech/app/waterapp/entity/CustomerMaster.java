package com.dgtech.app.WaterApp.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WATERAPP_CUSTOMER_MASTER database table.
 * 
 */

@Entity
@Table(name="WATERAPP_CUSTOMER_MASTER")
public class CustomerMaster implements Serializable { 
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUSTOMER_MASTER_SEQ",sequenceName="WATERAPP_CUSTOMER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_MASTER_SEQ")
	private long customerid;
	private String fname; 

	private String lname;

	@Lob
	private byte[] photo;

	//bi-directional many-to-one association to AddressDetail
	@OneToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL, optional= false, orphanRemoval= true)
	@JoinColumn(name="ADDRESSID")
	private AddressDetail addressDetail;

	/*//bi-directional many-to-one association to OrderDetail
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customerMaster")
	private List<OrderDetail> orderDetails;*/

	public CustomerMaster() {
	}

	public long getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public AddressDetail getAddressDetail() {
		return this.addressDetail;
	}

	public void setAddressDetail(AddressDetail addressDetail) {
		this.addressDetail = addressDetail;
	}

	/*public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}*/

}