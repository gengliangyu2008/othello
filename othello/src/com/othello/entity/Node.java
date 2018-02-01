package com.othello.entity;

public class Node {

	private int x;
	private int y;
	
	private NodeType type;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = NodeType.EMPTY;
	}
	
	public Node(int x, int y, NodeType type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setType(NodeType type) {
		this.type = type;
	}
	
	public NodeType getType() {
		return this.type;
	}
	
	@Override
    public boolean equals(Object obj){
        
		if( ! (obj instanceof Node) ) {
            return false;
        }
        
    	Node node = (Node) obj;
        if ( this.x == node.getX() && this.y == node.getY() && this.type == node.getType() ) {
            return true;
        }
        return false;
    }
	
	@Override
	public int hashCode() {
		return x*31 + y*199 + type.hashCode();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("x=").append(x).append(", y=").append(y).append(", type=").append(type.name());
		return builder.toString();
	}
	
	public String getIndexStringAsInput() {
		StringBuilder builder = new StringBuilder();
		builder.append(y+1).append(String.valueOf( (char)(x + 97) ) );
		return builder.toString();
	}
}
