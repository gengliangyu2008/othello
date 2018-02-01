package com.othello.testcases;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.othello.constants.Constants;
import com.othello.entity.Board;
import com.othello.entity.Node;
import com.othello.entity.NodeType;
import com.othello.service.BoardService;

public class TestBoardAndNodes implements Constants {
	
	@Test
	public void testInitialBoardAndNodesInside() {

		Board board = BoardService.initializeBoard();

		for( int i=0; i<DIMENSION; i++ ) {
			
			for( int j=0; j<DIMENSION; j++ ) {
				
				if( (i== 3 && j == 3) || (i== 4 && j == 4) ) {
					assertEquals(board.getNodeType(i, j), NodeType.WHITE);
					
				} else if ( (i== 3 && j == 4) || (i== 4 && j == 3) ) {
					assertEquals(board.getNodeType(i, j), NodeType.BLACK);
					
				} else {
					assertEquals(board.getNodeType(i, j), NodeType.EMPTY);
				}
				
			}
		}
	}
	
	@Test
	public void testNodesHashCode() {

		Set<Integer> set = new HashSet<>();
		
		for( int i=0; i<DIMENSION; i++ ) {
			
			for( int j=0; j<DIMENSION; j++ ) {
				
				set.add( new Node(i,j).hashCode() );
			}
		}
		//make sure there is no duplicated hashcode value
		assertEquals( set.size(), DIMENSION*DIMENSION );
	}
}
