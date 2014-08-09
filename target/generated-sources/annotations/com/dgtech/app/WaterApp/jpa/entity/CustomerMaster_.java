package com.dgtech.app.WaterApp.jpa.entity;

import com.dgtech.app.WaterApp.jpa.entity.AddressDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-08-09T13:29:08")
@StaticMetamodel(CustomerMaster.class)
public class CustomerMaster_ { 

    public static volatile SingularAttribute<CustomerMaster, String> lname;
    public static volatile SingularAttribute<CustomerMaster, Long> customerid;
    public static volatile SingularAttribute<CustomerMaster, byte[]> photo;
    public static volatile SingularAttribute<CustomerMaster, AddressDetail> addressDetail;
    public static volatile SingularAttribute<CustomerMaster, String> fname;

}