package com.apipothi.propertiesreader.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookService {
	@Value("${apipothi.bookdescription}")
	private String bookDescription;
	
	@Value("${apipothi.bookid}")
	private int[] bookIdArray;
	
	@Value("${apipothi.bookprice}")
	private List<Integer>bookPriceList	;
	
	@Value("${apipothi.booksname}")
	private Set<String> booksNameSet;
	
	@Value("#{${apipothi.bookswithprice}}")
	private Map<String, Integer> valueMap;
	
	@Value("${apipothi.booknotabalable}")
	private boolean  booknotabalable;
	
	
	public void getFromProperties() {
		
		System.out.println("** Start-BookService-getFromProperties()**");
		System.out.println("Description" +bookDescription);
		System.out.println("BookId as array " + Arrays.toString(bookIdArray));
		System.out.println("BookPrice as a Integer List" + bookPriceList);
		System.out.println("BookSName as a Set " + booksNameSet);
		System.out.println("BookDetails as a Map " + valueMap);
		System.out.println("BookDetails as available as Boolean " + booknotabalable);
		System.out.println("** End-BookService-getFromProperties()**");
	}

}
