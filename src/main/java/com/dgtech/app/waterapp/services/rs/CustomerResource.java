package com.dgtech.app.WaterApp.services.rs;

import java.io.StringReader;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dgtech.app.WaterApp.ejb.CustomerDao;
import com.dgtech.app.WaterApp.jpa.entity.AddressDetail;
import com.dgtech.app.WaterApp.jpa.entity.CustomerMaster;

/**
 *
 * @author DGH
 */

@Path("/customer")
public class CustomerResource extends ResourceGenericImpl<CustomerMaster> implements ResourceGeneric<CustomerMaster>{
	
	private CustomerDao dao = new CustomerDao();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllCustomersJson() {
		    
		 	return Response.status(Status.OK).entity(getAllResourcesJson(dao)).build();
	}
	
    	
	@Path("{uniqueId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)   
	public Response getSingleCustomerJson(@PathParam("uniqueId") final Long uniqueId) {
				
		return Response.status(Status.OK).entity(getSingleResourceJson(dao, uniqueId)).build();
	}
    
   
    
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response createCustomer(String jsonString) throws Exception {
	   	
	    	CustomerMaster customer = parseSingleResourceFromJson(jsonString);
	    	//validate customer fields
	    	if(customer.getCustomerid()>0){
	    		customer.setCustomerid(0);
	    	}
	    	if(customer.getAddressDetail().getAddressid()>0){
	    		customer.getAddressDetail().setAddressid(0);
	    	}
	    	createResource(dao, customer);
	    	return Response.status(Status.OK).entity("data was successfully inserted").build();
	    	
	}
   
	@Path("{uniqueId}")
    @DELETE
	public Response deleteCustomerById(@PathParam("uniqueId") final Long uniqueId) {
			deleteResourceById(dao, uniqueId) ;
	   		return Response.status(Status.OK).entity("data was successfully deleted").build();
	}
		
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(String jsonString) throws Exception {
    	    CustomerMaster customer = parseSingleResourceFromJson(jsonString);    	    
			updateResource(dao, customer);
	   		return Response.status(Status.OK).entity("data was successfully updated").build();
	}

   
	@Override
	public String buildResourceJson(List<CustomerMaster> resourceList){
    	
    	JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for(CustomerMaster customer : resourceList){
        	AddressDetail address = customer.getAddressDetail();
        	
            jsonArrayBuilder.add(Json.createObjectBuilder()
                            	.add("id", customer.getCustomerid())
                            	.add("fname", customer.getFname())
                            	.add("lname", customer.getLname())
                            	.add("Address",Json.createObjectBuilder()
                            		.add("addressId", address.getAddressid())
                            		.add("addressLine1", address.getAddressline1())
                            		.add("addressLine2", address.getAddressline2())
                            		.add("city", address.getCity())
                            		.add("state", address.getState())
                            		.add("country", address.getCountry())
                            		)
                            	.add("ContactDetails",Json.createObjectBuilder()
                            		.add("email", address.getEmailId())
                            		.add("phone", address.getPhoneNum())
                            		)
                            	);
                            
         }//end of for loop
        
        JsonArray customerListJson = jsonArrayBuilder.build();
    	System.out.println(customerListJson.toString());
        return (customerListJson.toString());
        
    }// end of buildCustomJson method
	
	@Override
    public CustomerMaster parseSingleResourceFromJson(String jsonString) throws Exception{
    	CustomerMaster customer = new CustomerMaster();
    	AddressDetail address = new AddressDetail();
    	JsonParser jsonParser = Json.createParser(new StringReader(jsonString));
    	String tempJsonKey = null;
    	while(jsonParser.hasNext()){
    		switch (jsonParser.next()) {
			case KEY_NAME:
				tempJsonKey = jsonParser.getString();
				break;
            case VALUE_STRING:
            	switch (tempJsonKey) {
            	case "fname":
            		customer.setFname(jsonParser.getString());
            		break;
            	case "lname":
            		customer.setLname(jsonParser.getString());
            		break;
            	case "addressLine1":
            		address.setAddressline1(jsonParser.getString());
            		break;
            	case "addressLine2":
            		address.setAddressline2(jsonParser.getString());
            		break;
            	case "city":
            		address.setCity(jsonParser.getString());
            		break;
            	case "state":
            		address.setState(jsonParser.getString());
            		break;
            	case "country":
            		address.setCountry(jsonParser.getString());
            		break;
            	case "email":
            		address.setEmailId(jsonParser.getString());
            		break;
            	case "phone":
            		address.setPhoneNum(jsonParser.getString());
            		break;
                default:
					break;
				}            	
            case VALUE_NUMBER:
            	switch (tempJsonKey) {
            	case "id":
					customer.setCustomerid(Integer.parseInt(jsonParser.getString()));					
					break;
            	case "addressId":
					address.setAddressid(Integer.parseInt(jsonParser.getString()));					
					break;
				}
            	
			default:
				break;
			}
    	    	}
    	customer.setAddressDetail(address);
    	return customer;
	}
}//end of class
