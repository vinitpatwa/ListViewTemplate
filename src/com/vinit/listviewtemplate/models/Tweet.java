package com.vinit.listviewtemplate.models;

import java.util.ArrayList;

public class Tweet {
	
	private String title;
	private String creator;
	private String imageUrl;
	
	public Tweet(String title, String creator, String imageUrl){
		this.title = title;
		this.creator = creator;
		this.imageUrl = imageUrl;
	}

	public String getTitle(){
		return this.title;
	}
	
	public String getCreator(){
		return this.creator;
	}
	
	public String getImageUrl(){
		return this.imageUrl;
	}
	
	public static ArrayList<Tweet> getSampleTweet(){
        ArrayList<Tweet> tweet = new ArrayList<Tweet>();
        Tweet t = new Tweet("First Tweet", "first creator", "http://mrminix.wikispaces.com/file/view/red-number-1.jpeg/365241178/red-number-1.jpeg");
        tweet.add(t);
        Tweet t2 = new Tweet("Second Tweet", "second creator", "http://varungenius.files.wordpress.com/2012/01/red-number-2.jpg");
        tweet.add(t2);
        Tweet t3 = new Tweet("Third Tweet", "third creator", "http://www.officerreports.com/blog/wp-content/uploads/2013/11/red-number-3.jpg");
        tweet.add(t3);
        
        Tweet t4 = new Tweet("Fourth Tweet", "fourth creator", "http://www.redchurch.org.au/wp-content/uploads/2011/11/red-number-4.jpg");
        tweet.add(t4);
        
        return tweet;
	}
}

