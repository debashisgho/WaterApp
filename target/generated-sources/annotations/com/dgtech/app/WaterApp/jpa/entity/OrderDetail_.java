package com.dgtech.app.WaterApp.jpa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-08-09T13:29:08")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Integer> orderstatus;
    public static volatile SingularAttribute<OrderDetail, Integer> customerid;
    public static volatile SingularAttribute<OrderDetail, Integer> vendorid;
    public static volatile SingularAttribute<OrderDetail, Date> orderdate;
    public static volatile SingularAttribute<OrderDetail, Integer> orderquantity;
    public static volatile SingularAttribute<OrderDetail, Date> deliverydate;
    public static volatile SingularAttribute<OrderDetail, Integer> orderid;
    public static volatile SingularAttribute<OrderDetail, String> comments;

}