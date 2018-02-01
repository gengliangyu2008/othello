package com.othello.service;

import com.othello.constants.Constants;
import com.othello.entity.Board;
import com.othello.entity.NodeType;

public class FlipService implements Constants {
	
	private MovementService moveService;
	
	private Board board;
	
	private NodeType currentType;
	
	public FlipService( MovementService moveService, Board board ) {
		this.moveService = moveService;
		this.board = board;
	}
	
	public void setCurrentType(NodeType type) {
		currentType = type;
	}
	
	private void convertUp(int x, int y ) {
        if (moveService.checkUp(x, y)) {
            int i = y - 1;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((i >= 0) && (contiguous)) {
            	tempType = board.getNodeType(x, i);
                if (tempType == currentType) {
                    contiguous = false;
                } else {
                	board.setNodeType(x, i, currentType);
                    i--;
                }
            }
        }
    }

    private void convertDown(int x, int y) {
        
        if (moveService.checkDown(x, y)) {
        	
        	int max = DIMENSION - 1;
        	
            int i = y + 1;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((i <= max) && (contiguous)) {
            	tempType = board.getNodeType(x, i);
                if (tempType == currentType) {
                    contiguous = false;
                } else {
                    board.setNodeType(x, i, currentType);
                    i++;
                }
            }
        }
    }

    private void convertRight(int x, int y) {
        
        if (moveService.checkRight(x, y)) {
        	
        	int max = DIMENSION - 1;
        	
            int i = x + 1;
            boolean contiguous = true;
            while ((i <= max) && (contiguous)) {
            	NodeType tempType = board.getNodeType(i, y);
                if (tempType == currentType) {
                    contiguous = false;
                } else {
                	board.setNodeType(i,y, currentType);
                    i++;
                }
            }
        }
    }

    private void convertLeft(int x, int y ) {
        
    	if (moveService.checkLeft(x, y)) {
        	
            int i = x - 1;
            boolean contiguous = true;
            while ((i >= 0) && (contiguous)) {
            	NodeType tempType = board.getNodeType(i, y);
                if (tempType == currentType) {
                    contiguous = false;
                } else {
                	board.setNodeType(i, y, currentType);
                    i--;
                }
            }
        }
    }

    private void convertLeftUp(int x, int y ) {
        if (moveService.checkLeftUp(x, y )) {
            int j = y - 1;
            int i = x - 1;
            
            boolean contiguous = true;
            while ((j >= 0) && (i >= 0) && (contiguous)) {
            	NodeType tempType = board.getNodeType(i, j);
                if (tempType == currentType) {
                    contiguous = false;
                } else {
                	board.setNodeType(i, j, currentType);
                    j--;
                    i--;
                }
            }
        }
    }

    private void convertLeftDown(int x, int y) {
    	
        if (moveService.checkLeftDown(x, y )) {
        	
            int max = DIMENSION - 1;
            
            int j = y + 1;
            int i = x - 1;
            boolean contiguous = true;
            while ((j <= max) && (i >= 0) && (contiguous)) {
            	NodeType tempType = board.getNodeType(i, j);
                if (tempType == currentType) {
                    contiguous = false;
                } else {
                	board.setNodeType(i, j, currentType);
                    j++;
                    i--;
                }
            }
        }
    }

    private void convertRightUp(int x, int y ) {
    	
        if (moveService.checkRightUp(x, y)) {
        	
            int max = DIMENSION - 1;
            int j = y - 1;
            int i = x + 1;
            
            boolean contiguous = true;
            while ((j >= 0) && (i <= max) && (contiguous)) {
            	NodeType tempType = board.getNodeType(i, j);
            	if (tempType == currentType) {
                    contiguous = false;
                } else {
                	board.setNodeType(i, j, currentType);
                    j--;
                    i++;
                }
            }
        }
    }

    private void convertRightDown(int x, int y ) {
        if (moveService.checkRightDown(x, y )) {
            int max = DIMENSION - 1;
            int j = y + 1;
            int i = x + 1;

            boolean contiguous = true;
            while ((j <= max) && (i <= max) && (contiguous)) {
            	NodeType tempType = board.getNodeType(i, j);
            	if (tempType == currentType) {
                    contiguous = false;
                } else {
                	board.setNodeType(i, j, currentType);
                    j++;
                    i++;
                }
            }
        }
    }

    public void flip(int x, int y, NodeType currentType) {
    	
    	setCurrentType(currentType);
    	
        convertLeft(x, y);
        convertRight(x, y);
        convertUp(x, y);
        convertDown(x, y);
        convertLeftUp(x, y);
        convertLeftDown(x, y);
        convertRightUp(x, y);
        convertRightDown(x, y);
        
        board.setNode(x, y, currentType);
    }
}
