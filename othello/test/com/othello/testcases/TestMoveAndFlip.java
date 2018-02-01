package com.othello.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.othello.entity.Board;
import com.othello.entity.Node;
import com.othello.entity.NodeType;
import com.othello.service.BoardService;
import com.othello.service.FlipService;
import com.othello.service.MovementService;

public class TestMoveAndFlip {

	@Test
	public void testInitialAvailableMove() {
		
		Board board = BoardService.initializeBoard();
		
		MovementService moveService = new MovementService(board);
		
		Set<Node> blackSet = moveService.getValidMoves(NodeType.BLACK);
		
		assertEquals( blackSet.size(), 4 );
		assertTrue( blackSet.contains( new Node(4, 5) ) );
		assertTrue( blackSet.contains( new Node(2, 3) ) );
		assertTrue( blackSet.contains( new Node(5, 4) ) );
		assertTrue( blackSet.contains( new Node(3, 2) ) );
		
		Set<Node> whiteSet = moveService.getValidMoves(NodeType.WHITE);
		
		assertEquals( whiteSet.size(), 4 );
		assertTrue( whiteSet.contains( new Node(5, 3) ) );
		assertTrue( whiteSet.contains( new Node(3, 5) ) );
		assertTrue( whiteSet.contains( new Node(4, 2) ) );
		assertTrue( whiteSet.contains( new Node(2, 4) ) );
	}
	
	
	@Test
	public void testAvailableMovesAndFlipVertical() {
		
		// check convert up.
		Board board = BoardService.createEmptyBoard();

		board.setNode(1, 2, NodeType.BLACK);
		board.setNode(1, 3, NodeType.BLACK);
		board.setNode(1, 4, NodeType.WHITE);
		
		MovementService moveService = new MovementService(board);
		FlipService flipService = new FlipService(moveService, board);
		
		Set<Node> set = moveService.getValidMoves( NodeType.WHITE );
		assertEquals(set.size(), 1);
		
		Node currNode = null;
		Iterator<Node> iter = set.iterator();
		while( iter.hasNext() ) {
			currNode = iter.next();
		}

		flipService.flip(currNode.getX(), currNode.getY(), NodeType.WHITE);
		
		for(int i=1; i<5; i++) {
			Node tempNode = board.getNode(1, i);
			assertEquals(tempNode.getType(), NodeType.WHITE); 
		}
		
		// check convert down.
		board.setNode(1, 0, NodeType.BLACK);
		
		set = moveService.getValidMoves( NodeType.BLACK );
		assertEquals(set.size(), 1);
		
		iter = set.iterator();
		while( iter.hasNext() ) {
			currNode = iter.next();
		}

		flipService.flip(currNode.getX(), currNode.getY(), NodeType.BLACK);
		
		for(int i=1; i<5; i++) {
			Node tempNode = board.getNode(1, i);
			assertEquals(tempNode.getType(), NodeType.BLACK); 
		}
	}
	
	@Test
	public void testAvailableMovesAndFlipHorizontal() {
		
		// check convert left.
		Board board = BoardService.createEmptyBoard();

		board.setNode(2, 6, NodeType.BLACK);
		board.setNode(3, 6, NodeType.BLACK);
		board.setNode(4, 6, NodeType.WHITE);
		
		MovementService moveService = new MovementService(board);
		FlipService flipService = new FlipService(moveService, board);
		
		Set<Node> set = moveService.getValidMoves( NodeType.WHITE );
		assertEquals(set.size(), 1);
		
		Node currNode = null;
		Iterator<Node> iter = set.iterator();
		while( iter.hasNext() ) {
			currNode = iter.next();
		}

		flipService.flip(currNode.getX(), currNode.getY(), NodeType.WHITE);
		
		for(int i=1; i<5; i++) {
			Node tempNode = board.getNode(i, 6);
			assertEquals(tempNode.getType(), NodeType.WHITE); 
		}
		
		// check convert right.
		board.setNode(5, 6, NodeType.BLACK);
		
		set = moveService.getValidMoves( NodeType.BLACK );
		assertEquals(set.size(), 1);
		
		iter = set.iterator();
		while( iter.hasNext() ) {
			currNode = iter.next();
		}

		flipService.flip(currNode.getX(), currNode.getY(), NodeType.BLACK);
		
		for(int i=1; i<5; i++) {
			Node tempNode = board.getNode(i, 6);
			assertEquals(tempNode.getType(), NodeType.BLACK); 
		}
	}
	
	@Test
	public void testAvailableMovesAndFlipDiagonalLeftToRight() {
		
		// check convert diagonalUp.
		Board board = BoardService.createEmptyBoard();

		board.setNode(3, 3, NodeType.BLACK);
		board.setNode(4, 4, NodeType.BLACK);
		board.setNode(5, 5, NodeType.WHITE);
		
		MovementService moveService = new MovementService(board);
		FlipService flipService = new FlipService(moveService, board);
		
		Set<Node> set = moveService.getValidMoves( NodeType.WHITE );
		assertEquals(set.size(), 1);
		
		Node currNode = null;
		Iterator<Node> iter = set.iterator();
		while( iter.hasNext() ) {
			currNode = iter.next();
		}

		flipService.flip(currNode.getX(), currNode.getY(), NodeType.WHITE);
		
		for(int i=3; i<6; i++) {
			Node tempNode = board.getNode(i, i);
			assertEquals(tempNode.getType(), NodeType.WHITE); 
		}
		
		// check convert diagonalDown.
		board.setNode(2, 2, NodeType.BLACK);
		
		set = moveService.getValidMoves( NodeType.BLACK );
		assertEquals(set.size(), 1);
		
		iter = set.iterator();
		while( iter.hasNext() ) {
			currNode = iter.next();
		}

		flipService.flip(currNode.getX(), currNode.getY(), NodeType.BLACK);
		
		for(int i=2; i<7; i++) {
			Node tempNode = board.getNode(i, i);
			assertEquals(tempNode.getType(), NodeType.BLACK); 
		}
	}
	
	@Test
	public void testAvailableMovesAndFlipDiagonalRightToLeft() {
		
		// check convert diagonalUp.
		Board board = BoardService.createEmptyBoard();

		board.setNode(6, 1, NodeType.BLACK);
		board.setNode(5, 2, NodeType.BLACK);
		board.setNode(4, 3, NodeType.WHITE);
		
		MovementService moveService = new MovementService(board);
		FlipService flipService = new FlipService(moveService, board);
		
		Set<Node> set = moveService.getValidMoves( NodeType.WHITE );
		assertEquals(set.size(), 1);
		
		Node currNode = null;
		Iterator<Node> iter = set.iterator();
		while( iter.hasNext() ) {
			currNode = iter.next();
		}

		flipService.flip(currNode.getX(), currNode.getY(), NodeType.WHITE);
		
		for(int i=1; i<4; i++) {
			Node tempNode = board.getNode(7-i, i);
			assertEquals(tempNode.getType(), NodeType.WHITE); 
		}
		
		// check convert diagonalDown.
		board.setNode(7, 0, NodeType.BLACK);
		
		set = moveService.getValidMoves( NodeType.BLACK );
		assertEquals(set.size(), 1);
		
		iter = set.iterator();
		while( iter.hasNext() ) {
			currNode = iter.next();
		}

		flipService.flip(currNode.getX(), currNode.getY(), NodeType.BLACK);
		
		for(int i=0; i<5; i++) {
			Node tempNode = board.getNode(7-i, i);
			assertEquals(tempNode.getType(), NodeType.BLACK); 
		}
	}
	
	/**
	 * 1. Create a board with below nodes.
	 * 2. Validate if only one available node. 
	 * 2. Place X in that node which is 3c.
	 * 3. Check if all O converted to X.
	 * 
	 *    a b c d e f g h 
	 *	1 X X X X X - - - 1 
	 *	2 X O O O X - - - 2 
	 *	3 X O - O X - - - 3 
	 *	4 X O O O X - - - 4 
	 *	5 X X X X X - - - 5 
	 *	6 - - - - - - - - 6 
	 *	7 - - - - - - - - 7 
	 *	8 - - - - - - - - 8 
	 *	  a b c d e f g h 
	 * 
	 */
	@Test
	public void testAvailableMovesAndFlipAllDirections() {
		
		Board board = BoardService.createEmptyBoard();

		board.setNode(0, 0, NodeType.BLACK);
		board.setNode(0, 1, NodeType.BLACK);
		board.setNode(0, 2, NodeType.BLACK);
		board.setNode(0, 3, NodeType.BLACK);
		board.setNode(0, 4, NodeType.BLACK);
		
		board.setNode(4, 0, NodeType.BLACK);
		board.setNode(4, 1, NodeType.BLACK);
		board.setNode(4, 2, NodeType.BLACK);
		board.setNode(4, 3, NodeType.BLACK);
		board.setNode(4, 4, NodeType.BLACK);
		
		board.setNode(1, 0, NodeType.BLACK);
		board.setNode(2, 0, NodeType.BLACK);
		board.setNode(3, 0, NodeType.BLACK);
	
		board.setNode(1, 4, NodeType.BLACK);
		board.setNode(2, 4, NodeType.BLACK);
		board.setNode(3, 4, NodeType.BLACK);
		
		board.setNode(1, 1, NodeType.WHITE);
		board.setNode(2, 1, NodeType.WHITE);
		board.setNode(3, 1, NodeType.WHITE);
		
		board.setNode(1, 3, NodeType.WHITE);
		board.setNode(2, 3, NodeType.WHITE);
		board.setNode(3, 3, NodeType.WHITE);
		
		board.setNode(1, 2, NodeType.WHITE);
		board.setNode(3, 2, NodeType.WHITE);
		
		MovementService moveService = new MovementService(board);
		FlipService flipService = new FlipService(moveService, board);
		
		Set<Node> set = moveService.getValidMoves( NodeType.BLACK );
		assertEquals(set.size(), 1);
		
		Node currNode = null;
		Iterator<Node> iter = set.iterator();
		while( iter.hasNext() ) {
			currNode = iter.next();
		}

		flipService.flip(currNode.getX(), currNode.getY(), NodeType.BLACK);
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				Node tempNode = board.getNode(i, j);
				assertEquals(tempNode.getType(), NodeType.BLACK); 
			}
		}
	}
	
	private static void printOneNodeFromSet(Set<Node> set) {
		Iterator<Node> iter = set.iterator();
		
		while( iter.hasNext() ) {
			Node node = iter.next();
			System.out.println( node.getIndexStringAsInput() );
			System.out.println( node.toString() );
		}
	}
}
