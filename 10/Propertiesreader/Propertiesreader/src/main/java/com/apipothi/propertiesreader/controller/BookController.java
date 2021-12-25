package com.apipothi.propertiesreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apipothi.propertiesreader.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	
	@GetMapping("/books")
	public void getBookInfo(){
		System.out.println("** Start BookController --getBookInfo**");
		bookService.getFromProperties();
		
		System.out.println("** End BookController --getBookInfo**");
	}
}
