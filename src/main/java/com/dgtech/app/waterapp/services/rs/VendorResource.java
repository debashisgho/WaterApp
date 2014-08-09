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

import com.dgtech.app.WaterApp.ejb.VendorDao;
import com.dgtech.app.WaterApp.jpa.entity.AddressDetail;
import com.dgtech.app.WaterApp.jpa.entity.VendorMaster;

/**
 *
 * @author DGH
 */

@Path("/vendor")
public class VendorResource extends ResourceGenericImpl<VendorMaster> implements ResourceGeneric<VendorMaster>{
	
	private VendorDao dao = new VendorDao();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllVendorsJson() {
		    
		 	return Response.status(Status.OK).entity(getAllResourcesJson(dao)).build();
		
	}
	
    	
	@Path("{uniqueId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)   
	public Response getSingleVendorJson(@PathParam("uniqueId") final Long uniqueId) {
				
		return Response.status(Status.OK).entity(getSingleResourceJson(dao, uniqueId)).build();
	}
    
   
    
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response createVendor(String jsonString) throws Exception {
	   	
	    	VendorMaster vendor = parseSingleResourceFromJson(jsonString);
	    	if(vendor.getVendorid()>0){
	    		vendor.setVendorid(0);
	    	}
	    	if(vendor.getAddressDetail().getAddressid()>0){
	    		vendor.getAddressDetail().setAddressid(0);
	    	}
	    	createResource(dao, vendor);
	    	return Response.status(Status.OK).entity("data was successfully inserted").build();
	    	
	}
   
	@Path("{uniqueId}")
    @DELETE
	public Response deleteVendorById(@PathParam("uniqueId") final Long uniqueId) {
			deleteResourceById(dao, uniqueId) ;
	   		return Response.status(Status.OK).entity("data was successfully deleted").build();
	}
		
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
	public Response updateVendor(String jsonString) throws Exception {
    	    VendorMaster vendor = parseSingleResourceFromJson(jsonString);    	    
			updateResource(dao, vendor);
	   		return Response.status(Status.OK).entity("data was successfully updated").build();
	}

   
	@Override
	public String buildResourceJson(List<VendorMaster> resourceList){
    	
    	JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for(VendorMaster vendor : resourceList){
        	AddressDetail address = vendor.getAddressDetail();
        	
            jsonArrayBuilder.add(Json.createObjectBuilder()
                            	.add("id", vendor.getVendorid())
                            	.add("fname", vendor.getFname())
                            	.add("lname", vendor.getLname())
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
        
        JsonArray vendorListJson = jsonArrayBuilder.build();
    	System.out.println(vendorListJson.toString());
        return (vendorListJson.toString());
        
    }// end of buildCustomJson method
	
	@Override
    public VendorMaster parseSingleResourceFromJson(String jsonString) throws Exception{
    	VendorMaster vendor = new VendorMaster();
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
            		vendor.setFname(jsonParser.getString());
            		break;
            	case "lname":
            		vendor.setLname(jsonParser.getString());
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
					vendor.setVendorid(Integer.parseInt(jsonParser.getString()));					
					break;
            	case "addressId":
					address.setAddressid(Integer.parseInt(jsonParser.getString()));					
					break;
				}
            	
			default:
				break;
			}
    	    	}
    	vendor.setAddressDetail(address);
    	return vendor;
	}
}//end of class
