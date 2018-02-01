package com.othello.service;

import java.util.ArrayList;
import java.util.List;

import com.othello.constants.Constants;
import com.othello.entity.Board;
import com.othello.entity.Node;
import com.othello.entity.NodeType;
import com.othello.utils.MessageUtil;

public class BoardService implements Constants {

	public static Board initializeBoard() {
		
		Board board = new Board(DIMENSION, DIMENSION);
		
		board.setNode(3, 3, NodeType.WHITE);
		board.setNode(4, 4, NodeType.WHITE);
		
		board.setNode(3, 4, NodeType.BLACK);
		board.setNode(4, 3, NodeType.BLACK);
		
		return board;
	}

	public static Board createEmptyBoard() {
		
		return new Board(DIMENSION, DIMENSION);
	}

    public static boolean isBoardFull(Board board) {

    	for (int j = 0; j < board.getHeight(); j++) {
            for (int i = 0; i < board.getWidth(); i++) {
            	Node node = board.getNode(j, i);
            	if( node.getType().isEmpty() ) {
            		return false;
            	}
            }
        }
        return true;
    }
    
    public static void calcAndPrintFinalResults(Board board) {

    	List<Node> blackNodes = new ArrayList<>();
    	List<Node> whiteNodes = new ArrayList<>();
    	List<Node> emptyNodes = new ArrayList<>();
    	
    	for (int j = 0; j < board.getHeight(); j++) {
            for (int i = 0; i < board.getWidth(); i++) {
            	Node node = board.getNode(j, i);
            	
            	if( node.getType().isBlack() ) {
            		blackNodes.add( node );
            		
            	} else if ( node.getType().isEmpty() ) {
            		
            		emptyNodes.add( node );
            	} else {
            		
            		whiteNodes.add( node );
            	}
            }
        }
        
    	if( blackNodes.size() == whiteNodes.size()) {
    		
    		System.out.println( MessageUtil.getFormattedMessage(LABEL_FINAL_DRAW_RESULT, whiteNodes.size() ) );
    	} else {
    		
    		boolean isBlackWin = blackNodes.size() > whiteNodes.size();
        	
        	String winner = isBlackWin ? NodeType.BLACK.getValue() : NodeType.WHITE.getValue();
        	int winningNodesNum = isBlackWin ? blackNodes.size() : whiteNodes.size();
        	int losingNodesNum = isBlackWin ? whiteNodes.size() : blackNodes.size();
        	
        	System.out.println( MessageUtil.getFormattedMessage(LABEL_FINAL_WIN_RESULT, winner, winningNodesNum, losingNodesNum ) );
    	}
    }
}
