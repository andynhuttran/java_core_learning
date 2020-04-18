package com.javalearning.mongodb_demo;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

public class deleteDocument {
	public static void main(String[] args) {
		
		//connect to mongo
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)){
			System.out.println("connect to mongo successfully");
		
			//get database
			MongoDatabase database = mongoClient.getDatabase("my-first-mongo");		
			System.out.println("Database: " + database);
		
			MongoCollection<Document> collection = database.getCollection("comment");
			System.out.println("Collection: " + collection);
			
			//delete 
			Bson where = Filters.lte("point", 1);			
			DeleteResult rs = collection.deleteMany(where);
			
			System.out.println(rs.toString());
			
			//delete all documents
			collection.deleteMany(new Document());
			
		}
		
	}
}
