package com.othello.constants;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Constants {

	public static final int DIMENSION = 8;
	
	public static final Set<Character> V_INDEX = Stream.of('1', '2', '3', '4', '5', '6', '7', '8').
			collect(Collectors.toCollection(LinkedHashSet::new));
	
	public static final Set<Character> H_INDEX = Stream.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h').
			collect(Collectors.toCollection(LinkedHashSet::new));
	
	public static final String QUIT_COMMAND					=	"quit";
	
	public static final String LABEL_PLAYER_MOVE			=	"label.player.move";
	
	public static final String LABEL_INPUT_INVALID			=	"label.input.invalid";
	public static final String LABEL_INPUT_INCORRECT_LENGTH	=	"label.input.incorrect.length";
	
	public static final String LABEL_INVALID_MOVE			=	"label.invalid.move";
	public static final String LABEL_SING_NO_VALID_MOVE		=	"label.sing.no.valid.move";
	public static final String LABEL_BOTH_NO_VALID_MOVE		=	"label.both.no.valid.move";
	
	public static final String LABEL_BOARD_FULL				=	"label.board.full";
	
	public static final String LABEL_FINAL_DRAW_RESULT		=	"label.final.draw.result";
	public static final String LABEL_FINAL_WIN_RESULT		=	"label.final.win.result";
}
