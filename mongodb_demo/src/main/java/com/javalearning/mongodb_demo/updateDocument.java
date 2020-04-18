package com.javalearning.mongodb_demo;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

public class updateDocument {
	public static void main(String[] args) {
		
		//connect to mongo
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)){
			System.out.println("connect to mongo successfully");
		
			//get database
			MongoDatabase database = mongoClient.getDatabase("my-first-mongo");		
			System.out.println("Database: " + database);
			
			MongoCollection<Document> collection = database.getCollection("comment");
			System.out.println("Collection: " + collection);
			
			
			updateExistingDocuments(collection);
			System.out.println("---------------------");
			
			replaceExistingDocuments(collection);
			System.out.println("---------------------");
			
		}
	}
	
	private static void updateExistingDocuments(MongoCollection<Document> collection) {
		Bson filter = Filters.ne("point", 0);
		
		Bson update1 = Updates.set("star", 10); //add new fields
		Bson update2 = Updates.set("content", "good"); //set value for current field
		Bson update = Updates.combine(update1, update2);
		
		UpdateResult rs = collection.updateMany(filter, update);
		System.out.println("rs: " + rs);
	}
	
	
	private static void replaceExistingDocuments(MongoCollection<Document> collection) {
		Bson filter = Filters.eq("point", 0);
		
		Document new_doc = new Document();
		new_doc.append("new_field", "new_value");
		new_doc.append("timestamp", System.currentTimeMillis());
		
		UpdateResult rs = collection.replaceOne(filter, new_doc);
		System.out.println("rs: " + rs);
	}
	
}
