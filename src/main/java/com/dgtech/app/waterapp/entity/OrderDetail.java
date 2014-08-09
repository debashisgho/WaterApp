package com.dgtech.app.WaterApp.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the WATERAPP_ORDER_DETAILS database table.
 * 
 */

@Entity
@Table(name="WATERAPP_ORDER_DETAILS")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;
 
	@Id
	@SequenceGenerator(allocationSize=1, name="ORDER_DETAILS_SEQ", sequenceName="WATERAPP_ORDER_DETAILS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_DETAILS_SEQ")
	private int orderid;
	
	private String comments;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliverydate;  
 
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;	

	private int orderquantity;	

	private int orderstatus;

	private int customerid;	

	private int vendorid;

	public OrderDetail() {
	}

	public int getOrderid() {
		return this.orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDeliverydate() {
		return this.deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getOrderquantity() {
		return this.orderquantity;
	}

	public void setOrderquantity(int orderquantity) {
		this.orderquantity = orderquantity;
	}

	public int getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	
       
    }
