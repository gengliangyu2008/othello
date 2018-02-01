package com.othello.service;

import java.util.Scanner;

import com.othello.constants.Constants;
import com.othello.entity.Node;
import com.othello.utils.MessageUtil;
import com.othello.utils.StringUtil;

public class InputService implements Constants{

	private String errorMsg = "";
	
	private Scanner input = new Scanner(System.in);
	
	public Node readInput() throws Exception {
		
		Node node = null;
		while( input.hasNextLine() ) {
			String str = StringUtil.removeSpaces(input.nextLine());
			
			checkQuitCommand(str);
			
			if( validateInput(str) ) {
				node = convertInput( str );
				break;
			} else {
				System.out.println( errorMsg );
			}
		}
		return node;
	}
	
	public boolean validateInput(String inputStr) {

		resetMsg();

		inputStr = StringUtil.removeSpaces(inputStr);
		if( inputStr.length() != 2 ) {
			errorMsg = MessageUtil.getMessage(LABEL_INPUT_INCORRECT_LENGTH);
			return false;
		}
		
		char s1 = inputStr.charAt(0);
		char s2 = inputStr.charAt(1);
		
		if( ( V_INDEX.contains( s1 ) && H_INDEX.contains( s2 ) ) || 
				( V_INDEX.contains( s2 ) && H_INDEX.contains( s1 ) ) ) {
			
			return true;
		}
		
		errorMsg =  MessageUtil.getMessage(LABEL_INPUT_INVALID);
		return false;
	}
	
	private Node convertInput(String inputStr) throws Exception {

		char c1 = inputStr.charAt(0);
		char c2 = inputStr.charAt(1);
		
		int x = -1;
		int y = -1;
		
		if( Character.isDigit( c1 ) ) {
			y = Integer.parseInt(String.valueOf( c1 ) ) - 1;
			x = c2 - 97;
		} else {
			x = c1 - 97;
			y = Integer.parseInt(String.valueOf( c2 ) ) - 1;;
		}
		
		return new Node(x, y);
	}
	
	private void resetMsg() {
		errorMsg = "";
	}
	
	private void checkQuitCommand(String str) {
		if( QUIT_COMMAND.equalsIgnoreCase( str )) {
			System.out.println( MessageUtil.getMessage("label.system.quit") );
			System.exit(0);
		}
	}
}
