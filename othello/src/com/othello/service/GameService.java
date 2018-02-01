package com.othello.service;

import java.util.Iterator;
import java.util.Set;

import com.othello.constants.Constants;
import com.othello.entity.Board;
import com.othello.entity.Node;
import com.othello.entity.NodeType;
import com.othello.utils.MessageUtil;
import com.othello.utils.Utils;

public class GameService implements Constants {

	private Board board;
	private MovementService moveService;
	private FlipService flipService;
	
	private InputService inputManager;
	private Set<Node> validMoves;
	
	private NodeType currentType = NodeType.BLACK;
	private boolean lastPlayNoValidMoves = false;
	
	public GameService() {
		board = BoardService.initializeBoard();
		moveService = new MovementService(board);
		flipService = new FlipService(moveService, board);
		inputManager = new InputService();
		validMoves =  moveService.getValidMoves(currentType);
	}
	
	public void start() throws Exception {
		
		board.print();
		
		while( true ) {
			
			if ( isGameEnds() ) {
				break;
			}
			
			if( isNoValidMoves() ) {
				continue;
			}

			//printOneNodeFromSet(validMoves);
			System.out.print( MessageUtil.getFormattedMessage(LABEL_PLAYER_MOVE, currentType.getValue()) );
			Node node = inputManager.readInput();
			if( validMoves.contains(node) ) {

				playNextStep(node);
			} else {
				System.out.println( MessageUtil.getMessage(LABEL_INVALID_MOVE) );
			}
		}
		
		BoardService.calcAndPrintFinalResults(board);
	}
	
	private boolean isNoValidMoves() {
		if ( validMoves.isEmpty() ) {
			System.out.println(
					MessageUtil.getFormattedMessage(LABEL_SING_NO_VALID_MOVE, 
							currentType.getValue(), currentType.getOpponentType().getValue() ) );
			
			giveTurnToOpponent();
			
			lastPlayNoValidMoves = true;
		}
		return false;
	}
	
	private boolean isGameEnds() {
		//1. board is full
		if( BoardService.isBoardFull(board) ) {
			System.out.println( MessageUtil.getMessage(LABEL_BOARD_FULL) );
			return true;
		}

		//2. both players do not have valid moves
		if( validMoves.isEmpty() && lastPlayNoValidMoves ) {
			System.out.println( MessageUtil.getMessage(LABEL_BOTH_NO_VALID_MOVE) );
			return true;
		}
		
		return false;
	}
	
	private void playNextStep( Node node ) {
		flipService.flip(node.getX(), node.getY(), currentType);
		board.print();

		lastPlayNoValidMoves = false;
		giveTurnToOpponent();
	}
	
	private void giveTurnToOpponent() {
		currentType = currentType.getOpponentType();
		validMoves = moveService.getValidMoves(currentType);
	}
	
	/**
	 * Call this can start a auto play.
	 */
	public void autoPlay(int intervalTime) throws Exception {
		
		GameService service = new GameService();
		
		service.board.print();
		
		while( true ) {
			
			if ( service.isGameEnds() ) {
				break;
			}
			
			if( service.isNoValidMoves() ) {
				continue;
			}
			
			Node node = Utils.getOneRandomElement(service.validMoves);
			System.out.print( MessageUtil.getFormattedMessage(LABEL_PLAYER_MOVE, service.currentType.getValue()) + node.getIndexStringAsInput() );
			if( service.validMoves.contains(node) ) {

				service.playNextStep(node);
				Thread.sleep(intervalTime);
			} else {
				System.out.println( MessageUtil.getMessage(LABEL_INVALID_MOVE) );
			}
		}
		
		BoardService.calcAndPrintFinalResults(service.board);
	}
	
	/*private static void printOneNodeFromSet(Set<Node> set) {
		
		Node node = Utils.getOneRandomElement(set);
		System.out.println( node.getIndexStringAsInput() );
	}*/
}
