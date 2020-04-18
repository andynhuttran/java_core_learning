package com.javalearning.mongodb_demo.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CommentBuilder {
	
	public CommentBuilder(){
		
	}
	
	
	public Comment buildOneComment() {
		Comment comment = new Comment(CommentBuilder.getName(), 
									UUID.randomUUID().toString(), 
									new Random().nextInt(10), 
									Arrays.asList(UUID.randomUUID().toString(), 
											UUID.randomUUID().toString()));
		return comment;
	}
	
	
	public List<Comment> buildComments(int n) {
		List<Comment> list = new ArrayList<Comment>();
		
		for (int i = 0; i < n; ++i) {
			list.add(buildOneComment());
		}
		
		return list;
	}
	
	
	public static String getName() {
		String[] names = new String[] {"cole", "nhut", "andy"};
		int idx = new Random().nextInt(names.length);
		
		return names[idx];
	}
	
}
