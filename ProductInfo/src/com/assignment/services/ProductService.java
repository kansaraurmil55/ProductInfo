package com.assignment.services;


import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import com.assignment.databaseconnection.DatabaseConnection;
import com.assignment.model.Product;
import com.google.gson.Gson;
import com.sun.research.ws.wadl.Application;

@Path("/products") 
public class ProductService {

    @GET
    @Path("/{rfqid}/{actid}/{prno}/{prcat}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getPrice(@PathParam("rfqid") int rfqid,@PathParam("actid") String actid,
    		@PathParam("prno") int prno,@PathParam("prcat") String pract,@PathParam("qty") int qty) {
    	
    	DatabaseConnection dc = new DatabaseConnection();
    	Document doc = dc.getPrice(rfqid, actid, prno, pract);
    	
    	Product prod = new Product();
    	
    	prod.setRfqId((int)Double.parseDouble(doc.get("RFQID").toString()));
    	prod.setAccountId(doc.get("AccountID").toString());
    	prod.setProductNumber((int)Double.parseDouble(doc.get("ProductNumber").toString()));
    	prod.setQuantity((int)Double.parseDouble(doc.get("Quantity").toString()));
    	prod.setProductCategory(doc.get("ProductCategory").toString());
    	prod.setUnitPrice((int)(Double.parseDouble(doc.get("Quantity").toString())*Double.parseDouble(doc.get("Price").toString())));
    	prod.setValidateionPeriod(doc.get("ValidStartDate").toString());
        String output =  doc.toString();
        
        	    return prod;
        	
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product getActualPrice(Product prod){
    	DatabaseConnection dc = new DatabaseConnection();
    	Document doc = dc.getPrice(prod.getRfqId(), prod.getAccountId(), prod.getProductNumber(), prod.getProductCategory());
    	double dd = Double.parseDouble(doc.get("Price").toString());
    	prod.setUnitPrice((int)(prod.getQuantity()*Double.parseDouble(doc.get("Price").toString())));
    	prod.setValidateionPeriod(doc.get("ValidStartDate").toString());
    	return prod;
    }

}