package com.othello.entity;

public enum NodeType {

	EMPTY	("-"),
	BLACK	("X"),
	WHITE	("O");
	
	private String value;
	
	private NodeType(String value){
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	public boolean isBlack() {
		return this == BLACK;
	}
	
	public boolean isWhite() {
		return this == WHITE;
	}
	
	public boolean isEmpty() {
		return this == EMPTY;
	}
	
	public NodeType getOpponentType() {
		if( !isEmpty() ) {
			return isBlack() ? WHITE : BLACK;
		}
		
		return EMPTY;
	}
}
