package com.dhlee.rest.client;

import java.net.URLEncoder;
import java.util.Collections;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.dhlee.cxf.vo.BookVO;

public class CxfWebClient {

	public CxfWebClient() {

	}

	public static void main(String[] args) {
		try {
				String bookName = "kotlin";
				String path = URLEncoder.encode(bookName, "UTF-8");;
				
				WebClient client = WebClient
				.create("http://localhost:8080/SimpleCXF/bookservice/getbook",
				Collections.singletonList(new JacksonJsonProvider()))
				.path(path).accept(MediaType.APPLICATION_JSON);
//				BookVO message = client.get(BookVO.class);
//				System.out.println("response : " + message.toString());
				
				/// get object
				BookVO message = client.post(null, BookVO.class);
				System.out.println("response : " + message.toString());
				
				/// get json string
				String jsonString = client.post(null, String.class);
				System.out.println("response : " + jsonString);

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
