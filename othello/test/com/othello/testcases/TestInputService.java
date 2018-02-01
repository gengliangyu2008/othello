package com.othello.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.othello.entity.Node;
import com.othello.service.InputService;

public class TestInputService {

	InputService inputService = null;
	
	private static String inputTestingNodes = "5d\r\n" + " h   8  \r\n";
	
	private static InputStream stdin = null;
	
	@BeforeClass
	public static void changeSystemIn() {
		stdin = System.in;
		System.setIn(new ByteArrayInputStream(inputTestingNodes.getBytes()));
	}
	
	@AfterClass
	public static void revertSystemIn() {
		System.setIn(stdin);
	}
	
	@Before
	public void initInputService() {
		inputService = new InputService();
	}
	
	@Test
	public void validateWrongInputs() {
		String s1 = "";
		assertFalse( inputService.validateInput(s1) );
		
		s1 = "1i";
		assertFalse( inputService.validateInput(s1) );
		
		s1 = "a9";
		assertFalse( inputService.validateInput(s1) );
		
		s1 = "3m";
		assertFalse( inputService.validateInput(s1) );
		
		s1 = "22";
		assertFalse( inputService.validateInput(s1) );
		
		s1 = "bc";
		assertFalse( inputService.validateInput(s1) );
		
		s1 = "e4f";
		assertFalse( inputService.validateInput(s1) );
	}
	
	@Test
	public void validateCorrectInputs() {
		String s1 = "1a";
		assertTrue( inputService.validateInput(s1) );
		
		s1 = "   5g";
		assertTrue( inputService.validateInput(s1) );
		
		s1 = "  4 h   ";
		assertTrue( inputService.validateInput(s1) );
	}
	
	@Test
	public void validateReadInput() throws Exception {
		
		InputStream stdin = System.in;
		try {

			Node node = inputService.readInput();
			
			//1. read node from "5d\r\n"
			assertEquals(3, node.getX());
			assertEquals(4, node.getY());

			node = inputService.readInput();
			
			//2. read node from " h   8  \r\n"
			assertEquals(7, node.getY());
			assertEquals(7, node.getY());
		} finally {
			System.setIn(stdin);
		}
	}
}
