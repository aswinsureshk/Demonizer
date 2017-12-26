package com.app.game.components.pieces;

import com.app.game.constants.PIECE;

public class Rook extends Piece{
	
	private static final int VALUE = 5;
	private static final char NOTATION = 'R';
	private static final PIECE NAME = PIECE.ROOK;

	public Rook(int colour) {
		setColour(colour);
		setValue(VALUE);
		setNotation(NOTATION);
		setColNotation((colour==1)?'+':'-');
		setPieceName(NAME);
	}
	
	public static char getRookNotation(){
		
		return NOTATION;
	}
}
