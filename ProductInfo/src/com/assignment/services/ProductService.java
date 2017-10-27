package com.assignment.services;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.assignment.model.ProductReturn;
import com.google.gson.Gson;
import com.sun.research.ws.wadl.Application;

@Path("/products") 
public class ProductService {

    @GET
    @Path("/{rfqid}/{actid}/{prno}/{prcat}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductReturn getPrice(@PathParam("rfqid") int rfqid,@PathParam("actid") String actid,
    		@PathParam("prno") int prno,@PathParam("prcat") String pract,@PathParam("qty") int qty) {
    	
    	DatabaseConnection dc = new DatabaseConnection();
    	Document doc = dc.getPrice(rfqid, actid, prno, pract);
    	
    	ProductReturn prod = new ProductReturn();
    	
    	prod.setRfqId((int)Double.parseDouble(doc.get("RFQID").toString()));
    	prod.setAccountId(doc.get("AccountID").toString());
    	prod.setProductNumber((int)Double.parseDouble(doc.get("ProductNumber").toString()));
    	prod.setQuantity((int)Double.parseDouble(doc.get("Quantity").toString()));
    	prod.setProductCategory(doc.get("ProductCategory").toString());
    	prod.setTotalPrice((int)(Double.parseDouble(doc.get("Quantity").toString())*Double.parseDouble(doc.get("Price").toString())));
    	prod.setValidationPeriod(doc.get("ValidStartDate").toString());
        
        	    return prod;
        	
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProductReturn getActualPrice(Product prod){
    	Gson serialize = new Gson();
		String finalOutput = serialize.toJson(prod);
		System.out.println(finalOutput);
    	ProductReturn prodReturn = new ProductReturn();
    	prodReturn.setRfqId(prod.getRfqId());
    	prodReturn.setAccountId(prod.getAccountId());
    	prodReturn.setProductCategory(prod.getProductCategory());
    	prodReturn.setQuantity(prod.getQuantity());
    	prodReturn.setProductNumber(prod.getProductNumber());
    	DatabaseConnection dc = new DatabaseConnection();
    	Document doc = dc.getPrice(prodReturn.getRfqId(), prodReturn.getAccountId(), prodReturn.getProductNumber(), prodReturn.getProductCategory());
    	double dd = Double.parseDouble(doc.get("Price").toString());
    	prodReturn.setTotalPrice((int)(prodReturn.getQuantity()*Double.parseDouble(doc.get("Price").toString())));
    	prodReturn.setCurrency(doc.get("PriceUnit").toString());
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
    	Date startDate =  null;
    	
    	    try {
				startDate = df.parse(doc.get("ValidStartDate").toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    String newDateString = df.format(startDate);
    	    System.out.println(newDateString);
    	

    	prodReturn.setValidationPeriod("3 months after manufacturing date: "+newDateString);
    	return prodReturn;
    }

}