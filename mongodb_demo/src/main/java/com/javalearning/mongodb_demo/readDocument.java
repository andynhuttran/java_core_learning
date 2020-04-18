package com.javalearning.mongodb_demo;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class readDocument {
	public static void main(String[] args) {
		
		//connect to mongo
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)){
			System.out.println("connect to mongo successfully");
		
			//get database
			MongoDatabase database = mongoClient.getDatabase("my-first-mongo");		
			System.out.println("Database: " + database);
		
			MongoCollection<Document> collection = database.getCollection("comment");
			System.out.println("Collection: " + collection);

			readAllDocument(collection);
			System.out.println("========================");
			
			readDocumentWithCondition_1(collection);
			System.out.println("========================");
			
			readDocumentWithCondition_2(collection);
		}
		
	}
	
	public static void readAllDocument(MongoCollection<Document> collection) {
		//list all data in collection
		FindIterable<Document> docs = collection.find();
		for (Document doc: docs) {
			System.out.println(doc);
		}
	}
	
	public static void readDocumentWithCondition_1(MongoCollection<Document> collection) {
		
		//point >= 1 and point <= 3
		Bson whereClause1 = Filters.gte("point", 1);
		Bson whereClause2 = Filters.lte("point", 3);
		Bson whereClause = Filters.and(whereClause1, whereClause2);
		
		//select fields 'by_user', 'point', 'content'
		Bson selectedFields = Projections.include("by_user", "point", "content");
		
		Bson sortBy = Sorts.ascending("by_user");
		
		for (Document doc: collection.find(whereClause).projection(selectedFields).sort(sortBy) ) {
			System.out.println(doc.get("content"));
		}
	}
	
	public static void readDocumentWithCondition_2(MongoCollection<Document> collection) {
		Document whereClause = new Document("point", new Document("$gte", 1).append("$lte", 3));
		
		Document selectedFields = new Document("by_user", 1);
		selectedFields.append("point", 1);
		
		Bson sortBy = Sorts.ascending("by_user");
		
		//list all data in collection
		for (Document doc: collection.find(whereClause).projection(selectedFields).sort(sortBy) ) {
			System.out.println(doc);
		}
	}
	

}
