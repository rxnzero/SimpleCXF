package com.dhlee.cxf.services.rest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dhlee.cxf.vo.BookVO;

@Service("bookService")
public class BookService {
	protected final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	private static HashMap<String, BookVO> hashMap = new HashMap<String, BookVO>();
	
	@POST
	@Path("/getbook/{name}")
	@Consumes( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED} )
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Response getBucket(@PathParam("name") String name) {
		logger.debug(">> name : {}", name);
		
		BookVO bookVO = null;
		try {
			bookVO = hashMap.get(name);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			logger.error(">> ERROR : ", ex);
		}
		
		if(bookVO == null) {
			logger.warn(">> Book not found name : {} ", name);
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		else {
			logger.warn(">> Book found name : {}  - {}", name, bookVO);
			return Response.ok(bookVO, MediaType.APPLICATION_JSON).build();
		}
	}
	
	@POST
	@Path("/addbook")
	@Consumes( {MediaType.APPLICATION_FORM_URLENCODED} )
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Response addBook(@FormParam("name") String name, @FormParam("author") String author) {
		logger.debug("inside addBook");
		BookVO bookVO = new BookVO();
		bookVO.setBookName(name);
		bookVO.setAuthor(author);
		
		hashMap.put(name, bookVO);
		
		if(hashMap.get(name) == null) {
			logger.warn(">> Add Failed, Book not found name : {} ", name);
			return Response.status(Response.Status.BAD_REQUEST).build();	
		}
		else {
			logger.warn(">> Add Success,  name : {}  - {}", name, bookVO);
			return Response.ok(bookVO, MediaType.APPLICATION_JSON).build();
		}
	}
	
	@POST
	@Path("/addbook")
	@Consumes( {MediaType.APPLICATION_JSON} )
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Response addBookJson(BookVO bookVO) {
		logger.debug("inside addBookJson - {}", bookVO);
		
		String name = bookVO.getBookName();
		hashMap.put(name, bookVO);
		
		if(hashMap.get(name) == null) {
			logger.warn(">> Add Failed, Book not found name : {} ", name);
			return Response.status(Response.Status.BAD_REQUEST).build();	
		}
		else {
			logger.warn(">> Add Success,  name : {}  - {}", name, bookVO);
			return Response.ok(bookVO, MediaType.APPLICATION_JSON).build();
		}
	}
	
	@POST
	@Path("/addbook")
	@Consumes( {MediaType.APPLICATION_XML} )
	@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Response addBookXml(BookVO bookVO) {
		logger.debug("inside addBookXml - {}", bookVO);
		
		String name = bookVO.getBookName();
		hashMap.put(name, bookVO);
		
		if(hashMap.get(name) == null) {
			logger.warn(">> Add Failed, Book not found name : {} ", name);
			return Response.status(Response.Status.BAD_REQUEST).build();	
		}
		else {
			logger.warn(">> Add Success,  name : {}  - {}", name, bookVO);
			return Response.ok(bookVO, MediaType.APPLICATION_XML).build();
		}
	}
}
