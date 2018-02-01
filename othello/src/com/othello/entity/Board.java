package com.othello.entity;

import com.othello.constants.Constants;

public class Board implements Constants{

	private int height;
	private int width;
	
	// 2d array used to store all the nodes
	private Node[][] boardArr;
	
	public Board(int height, int width) {
		this.height = height;
		this.width = width;

		boardArr = initEmptyBoard();
	}
	
	private Node[][] initEmptyBoard() {
		
		Node[][] boardArr = new Node[height][width];

		for (int i = 0; i < boardArr.length; i++) {
		
			for (int j = 0; j < boardArr[i].length; j++) {
				boardArr[i][j] = new Node(i, j);
			}
		}
		return boardArr;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setNode(int x, int y, NodeType type) {
		boardArr[y][x] = new Node(x, y, type);
	}
	
	public void setNodeType(int x, int y, NodeType type) {
		boardArr[y][x].setType(type);
	}
	
	public Node getNode(int x, int y) {
		return boardArr[y][x];
	}
	
	public NodeType getNodeType(int x, int y) {
		return getNode(x, y).getType();
	}
	
	public boolean isEmtpyNode(int x, int y) {
		return getNodeType(x, y).isEmpty();
	}
	
	/**
	 * Method to print out the board, with index on top bottom left right, like below:
	 * 
	 *    a b c d e f g h 
	 *	1 - - - - - - - - 1 
	 *	2 - - - - - - - - 2 
	 *	3 - - - - - - - - 3 
	 *	4 - - - O X - - - 4 
	 *	5 - - - X O - - - 5 
	 *	6 - - - - - - - - 6 
	 *	7 - - - - - - - - 7 
	 *	8 - - - - - - - - 8 
	 *	  a b c d e f g h 
	 * 
	 */
	public void print() {
		System.out.println();
		
		printWidthIndex();
		
		for(int i=0; i<boardArr.length; i++) {
			
			printHeightIndex(i);
			
			for( int j=0; j<boardArr[i].length; j++) {
				System.out.print(boardArr[i][j].getType().getValue() + " ");
			}
			
			printHeightIndex(i);
			
			System.out.println();
		}
		
		printWidthIndex();
		
		System.out.println();
	}
	

	private void printHeightIndex(int y) {
		System.out.print((y+1) + " " );
	}
	
	private void printWidthIndex() {
		
		System.out.print("  ");
		
		char startChar = 'a';
		for( int i=0; i<width; i++ ) {
			System.out.print(String.valueOf(startChar) + " ");
			startChar = (char) (startChar + 1);
		}
		System.out.println();
	}
}
