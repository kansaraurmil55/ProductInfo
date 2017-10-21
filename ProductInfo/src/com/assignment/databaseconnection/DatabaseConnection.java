package com.assignment.databaseconnection;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {
	
	public DatabaseConnection(){
		
	}
	public Document getPrice(int rfqid,String actId, int productNo, String productCat){
		 MongoClientURI uri  = new MongoClientURI("mongodb://root:password@ds227555.mlab.com:27555/productinfodb"); 
	        MongoClient client = new MongoClient(uri);
	//MongoClient client = new MongoClient("localhost", 27017);
	MongoDatabase database = client.getDatabase(uri.getDatabase());
	MongoCollection<Document> collection = database.getCollection("ProductInfo");
	 BasicDBObject andQuery = new BasicDBObject();
	 List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
     obj.add(new BasicDBObject("RFQID", rfqid));
     obj.add(new BasicDBObject("AccountID", actId));
     obj.add(new BasicDBObject("ProductNumber",productNo));
     obj.add(new BasicDBObject("ProductCategory",productCat));
     
     andQuery.put("$and", obj);

	List<Document> documents = (List<Document>)collection.find(andQuery).into(new ArrayList<Document>());
	client.close();
	return documents.get(0);
	      
}
}