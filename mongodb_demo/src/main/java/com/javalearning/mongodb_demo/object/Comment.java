package com.javalearning.mongodb_demo.object;

import java.util.List;

public class Comment {
	
	private String userName;
	private String content;
	private int	point;
	private List<String> tags;
	
	public Comment(String userName, String content, int point, List<String> tags) {
		this.userName = userName;
		this.content = content;
		this.point = point;
		this.tags = tags;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getContent() {
		return content;
	}
	
	public int getPoint() {
		return point;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	
	
}
