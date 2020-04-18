package com.javalearning.mongodb_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;

import com.javalearning.mongodb_demo.object.Comment;
import com.javalearning.mongodb_demo.object.CommentBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class createDocument {

	public static void main(String[] args) {		
		
		//connect to mongo
		try (MongoClient mongoClient = new MongoClient("localhost", 27017)){
			System.out.println("connect to mongo successfully");
		
			//get database
			MongoDatabase database = mongoClient.getDatabase("my-first-mongo");		
			System.out.println("Database: " + database);
		
			MongoCollection<Document> collection = database.getCollection("comment");
			System.out.println("Collection: " + collection);
			
			//build document
			CommentBuilder builder = new CommentBuilder(); 
			List<Comment> comments = builder.buildComments(5);
			List<Document> documents = comments.parallelStream()
											.map(c -> {
												return tranferCommentObjectToDocument(c);
											})
											.collect(Collectors.toList());
			
			//insert document
			collection.insertMany(documents);
			 
		}
	}
	
	
	public static Document tranferCommentObjectToDocument(Comment comment) {
		
		Document doc = new Document();
		doc.append("by_user", comment.getUserName());
		doc.append("content", comment.getContent());
		doc.append("point", comment.getPoint());
		doc.append("tags", comment.getTags());
		
		return doc;
		
	}

}
