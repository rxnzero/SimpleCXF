package com.dhlee.rest.client;

import java.io.InputStream;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

//-----------------------------------------------
// HttpClient Version 4.5.2
// https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/fundamentals.html#d5e49
//-----------------------------------------------
public class RestClient {
	
	public static void main(String[] args) {
		RestClient client = new RestClient();
		client.testGetBook("java-post");
		client.testGetBook("kotlin");
	}
	
	public void testGetBook(String bookName) {
		
		try {
			String url = "http://localhost:8080/SimpleCXF/bookservice/getbook/";
			url = url + URLEncoder.encode(bookName, "UTF-8");
		
			System.out.println(">> request url = " + url);
	    	
			CloseableHttpClient httpclient = HttpClients.createDefault();
		
			HttpPost post = new HttpPost(url);
			CloseableHttpResponse response = httpclient.execute(post);
			
			try {
		    	StatusLine statusLine = response.getStatusLine();
			    int statusCode = statusLine.getStatusCode();
			    
		    	if (statusCode == 200) {
		    		HttpEntity entity = response.getEntity();
				    if (entity != null) {
				    	entity = new BufferedHttpEntity(entity);
				        InputStream instream = entity.getContent();
				        
				        byte[] buffer = new byte[1024];
				        int read = 0;
				        try {
				        	while( (read = instream.read(buffer)) > 0) {
				        		System.out.println( new String(buffer,0,read) );
				        	}
				        } finally {
				            instream.close();
				        }
				    }
		    	}
		    	else {
		    		System.out.println("invalid Http response = " + statusCode);
		    	}
			} finally {
			    response.close();
			}

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
