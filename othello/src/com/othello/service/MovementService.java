package com.othello.service;

import java.util.HashSet;
import java.util.Set;

import com.othello.entity.Board;
import com.othello.entity.Node;
import com.othello.entity.NodeType;

public class MovementService {

	private Board board;
	
	private NodeType currentType;
	
	public MovementService(Board board) {
		this.board = board;
	}
	
	public void setCurrentType(NodeType type) {
		currentType = type;
	}
	
	protected boolean checkLeftUp(int x, int y ) {
        if ((y == 0) || (x == 0)) {
            return false;
        }

        NodeType opponentType = currentType.getOpponentType();

        if (board.getNodeType(x - 1, y - 1) != opponentType) {
            return false;
            
        } else {
            int j = y - 2;
            int i = x - 2;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((j >= 0) && (i >= 0) && (contiguous)) {
            	tempType = board.getNodeType(i, j);
                if (tempType != opponentType) {
                    contiguous = false;
                    if (tempType == currentType) {
                        return true;
                    }
                } else {
                    j--;
                    i--;
                }
            }
            return false;
        }

    }

    protected boolean checkLeftDown(int x, int y ) {
        int max = board.getHeight() - 1;
        if ((y == max) || (x == 0)) {
            return false;
        }

        NodeType opponentType = currentType.getOpponentType();

        if (board.getNodeType(x - 1, y + 1) != opponentType) {
            return false;
        } else {
            int j = y + 2;
            int i = x - 2;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((j <= max) && (i >= 0) && (contiguous)) {
            	tempType = board.getNodeType(i, j);
                if (tempType != opponentType) {
                    contiguous = false;
                    if (tempType == currentType) {
                        return true;
                    }
                } else {
                    j++;
                    i--;
                }
            }
            return false;
        }

    }

    protected boolean checkRightUp(int x, int y ) {
        int max = board.getHeight() - 1;
        if ((y == 0) || (x == max)) {
            return false;
        }

        NodeType opponentType = currentType.getOpponentType();

        if (board.getNodeType(x + 1, y - 1) != opponentType) {
            return false;
        } else {
            int j = y - 2;
            int i = x + 2;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((j >= 0) && (i <= max) && (contiguous)) {
            	tempType = board.getNodeType(i, j);
                if (tempType != opponentType) {
                    contiguous = false;
                    if (tempType == currentType) {
                        return true;
                    }
                } else {
                    j--;
                    i++;
                }
            }
            return false;
        }

    }

    protected boolean checkRightDown(int x, int y) {
        int max = board.getHeight() - 1;
        if ((y == max) || (x == max)) {
            return false;
        }

        NodeType opponentType = currentType.getOpponentType();

        if (board.getNodeType(x + 1, y + 1) != opponentType) {
            return false;
        } else {
            int j = y + 2;
            int i = x + 2;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((j <= max) && (i <= max) && (contiguous)) {
            	tempType = board.getNodeType(i, j);
                if (tempType != opponentType) {
                    contiguous = false;
                    if (tempType == currentType) {
                        return true;
                    }
                } else {
                    j++;
                    i++;
                }
            }
            return false;
        }

    }

    protected boolean checkUp( int x, int y ) {
        if (y == 0) {
            return false;
        }

        NodeType opponentType = currentType.getOpponentType();

        if (board.getNodeType(x, y - 1) != opponentType) {
            return false;
        } else {
            int j = y - 2;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((j >= 0) && (contiguous)) {
            	tempType = board.getNodeType(x, j);
                if (tempType != opponentType) {
                    contiguous = false;
                    if (tempType == currentType) {
                        return true;
                    }
                } else {
                    j--;
                }
            }
            return false;
        }
    }

    protected boolean checkDown(int x, int y ) {
        int max = board.getHeight() - 1;
        if (y == max) {
            return false;
        }

        NodeType opponentType = currentType.getOpponentType();

        if (board.getNodeType(x, y + 1) != opponentType) {
            return false;
        } else {
            int j = y + 2;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((j <= max) && (contiguous)) {
            	tempType = board.getNodeType(x, j);
                if (tempType != opponentType) {
                    contiguous = false;
                    if (tempType == currentType) {
                        return true;
                    }
                } else {
                    j++;
                }
            }
            return false;
        }

    }
    
    protected boolean checkLeft(int x, int y) {
        if (x == 0) {
            return false;
        }

        NodeType opponentType = currentType.getOpponentType();

        if (board.getNodeType(x - 1, y) != opponentType) {
            return false;
        } else {
            int i = x - 2;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((i >= 0) && (contiguous)) {
            	tempType = board.getNodeType(i, y);
            	
                if (tempType != opponentType) {
                    contiguous = false;
                    if (tempType == currentType) {
                        return true;
                    }
                } else {
                    i--;
                }
            }
            return false;
        }
    }

    protected boolean checkRight(int x, int y) {
        int max = board.getWidth() - 1;
        if (x == max) {
            return false;
        }

        NodeType opponentType = currentType.getOpponentType();

        if ( board.getNodeType(x + 1, y) != opponentType ) {
            return false;
        } else {
            int i = x + 2;
            NodeType tempType = null;
            boolean contiguous = true;
            while ((i <= max) && (contiguous)) {
            	tempType = board.getNodeType(i, y);
            	
                if (tempType != opponentType) {
                    contiguous = false;
                    if (tempType == currentType) {
                        return true;
                    }
                } else {
                    i++;
                }
            }
            return false;
        }
    }

    protected boolean checkHorizontal( int x, int y ) {
        if ( checkLeft( x, y ) ) {
            return true;
        }
        if ( checkRight( x, y ) ) {
            return true;
        }
        return false;
    }

    protected boolean checkVertical( int x, int y ) {
        if ( checkUp( x, y ) ) {
            return true;
        }
        if (checkDown(x, y ) ) {
            return true;
        }
        return false;
    }

    protected boolean checkDiagonal(int x, int y ) {
        if (checkLeftUp(x, y )) {
            return true;
        }
        if (checkLeftDown(x, y )) {
            return true;
        }
        if (checkRightUp(x, y )) {
            return true;
        }
        if (checkRightDown(x, y )) {
            return true;
        }
        return false;
    }

    protected boolean checkPosition(int x, int y ) {
        if ( !board.isEmtpyNode(x, y) ) {
            return false;
        }
        if ( checkHorizontal( x, y ) ) {
            return true;
        }
        if (this.checkVertical(x, y )) {
            return true;
        }
        if (this.checkDiagonal(x, y )) {
            return true;
        }
        return false;
    }
    
    public Set<Node> getValidMoves(NodeType type) {
    	
    	setCurrentType(type);
    	
    	Set<Node> results = new HashSet<Node>();
        for (int j = 0; j < board.getHeight(); j++) {
            for (int i = 0; i < board.getWidth(); i++) {

            	if (checkPosition(i, j ) ) {
                	Node node = new Node(i, j);
                	results.add(node);
                }
            }
        }
        
        return results;
    }
}
