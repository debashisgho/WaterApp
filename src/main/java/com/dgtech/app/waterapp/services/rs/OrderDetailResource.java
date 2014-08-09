package com.dgtech.app.WaterApp.services.rs;

import java.io.StringReader;
import java.util.List;

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
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.stream.JsonParser;

import com.dgtech.app.WaterApp.common.Utility;
import com.dgtech.app.WaterApp.ejb.OrderDetailsDao;
import com.dgtech.app.WaterApp.jpa.entity.OrderDetail;

/**
 *
 * @author DGH
 */

@Path("/order")
public class OrderDetailResource extends ResourceGenericImpl<OrderDetail> implements ResourceGeneric<OrderDetail> {
	private OrderDetailsDao dao = new OrderDetailsDao();

	

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllOrdersJson() {
		    
		 	return Response.status(Status.OK).entity(getAllResourcesJson(dao)).build();
		
	}
	
	@Path("{uniqueId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)   
	public Response getSingleOrderJson(@PathParam("uniqueId") final Long uniqueId) {
				
		return Response.status(Status.OK).entity(getSingleResourceJson(dao, uniqueId)).build();
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response createOrder(String jsonString) throws Exception {
	   	
	    	OrderDetail orderDetail = parseSingleResourceFromJson(jsonString);
	    	
	    	if((orderDetail.getOrderid())>0){
	    		orderDetail.setOrderid(0);
	    	}
	    	
	    	if(orderDetail.getOrderdate()!=null){
	    	orderDetail.setOrderdate(Utility.getCurrentDate(Utility.defaultDateFormat));
	    	}
	    	
	    	if((orderDetail.getOrderstatus()!=0)){
	    	orderDetail.setOrderstatus(0);
	    	}
	    	createResource(dao, orderDetail);
	    	return Response.status(Status.OK).entity("data was successfully inserted").build();
	    	
	}
	
	
    
	@Path("{uniqueId}")
    @DELETE
	public Response deleteOrderById(@PathParam("uniqueId") final Long uniqueId) {
			deleteResourceById(dao, uniqueId) ;
	   		return Response.status(Status.OK).entity("data was successfully deleted").build();
	}

	

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrder(String jsonString) throws Exception {
    	    OrderDetail orderDetail = parseSingleResourceFromJson(jsonString);    	    
			updateResource(dao, orderDetail);
	   		return Response.status(Status.OK).entity("data was successfully updated").build();
	}

	
	

		
	//utility methods
	
	@Override
	public String buildResourceJson(List<OrderDetail> resourceList){
    	
    	JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
    		
    	for(OrderDetail order : resourceList){
        	        	
            jsonArrayBuilder.add(Json.createObjectBuilder()
            		           	.add("orderId", order.getOrderid())
                            	.add("customerId", order.getCustomerid())
                            	.add("vendorId",order.getVendorid())
                            	.add("orderQuantity",order.getOrderquantity())
                            	.add("orderDate",""+order.getOrderdate())                       	
                            	.add("deliveryDate", ""+order.getDeliverydate())
                            	.add("orderStatus",order.getOrderstatus())
                            	.add("comments",order.getComments())
                            	);             

         }//end of for loop
        
        JsonArray orderListJson = jsonArrayBuilder.build();
    	System.out.println(orderListJson.toString());
        return (orderListJson.toString());
        
    }// end of buildOrderJson method

	@Override
    public OrderDetail parseSingleResourceFromJson(String jsonString) throws Exception{
    	OrderDetail orderDetail = new OrderDetail();
    	JsonParser jsonParser = Json.createParser(new StringReader(jsonString));
    	String tempJsonKey = null;
    	while(jsonParser.hasNext()){
    		switch (jsonParser.next()) {
			case KEY_NAME:
				tempJsonKey = jsonParser.getString();
				break;
            case VALUE_STRING:
            	switch (tempJsonKey) {
            	case "comments":
            		orderDetail.setComments(jsonParser.getString());
            		break;
            	case "orderDate":
            		orderDetail.setOrderdate(Utility.getFormattedDate(Utility.defaultDateFormat,jsonParser.getString()));
            		break;
            	case "deliveryDate":
            		orderDetail.setDeliverydate(Utility.getFormattedDate(Utility.defaultDateFormat,jsonParser.getString()));
            		break;
            	case "orderStatus":
            		orderDetail.setOrderstatus(Integer.parseInt(jsonParser.getString()));
            		break;
                default:
					break;
				}            	
            case VALUE_NUMBER:
            	switch (tempJsonKey) {
            	case "orderId":
					orderDetail.setOrderid(Integer.parseInt(jsonParser.getString()));
					break;
				case "customerId":
					orderDetail.setCustomerid(Integer.parseInt(jsonParser.getString()));					
					break;
				case "vendorId":
					orderDetail.setVendorid(Integer.parseInt(jsonParser.getString()));	
					break;
				case "orderQuantity":
					orderDetail.setOrderquantity(Integer.parseInt(jsonParser.getString()));	
					break;

				default:
					break;
				}
            	
			default:
				break;
			}
    	}
    	return orderDetail;
    }

}//end of class
