package com.app.game.components.pieces;

import com.app.game.constants.PIECE;

public class Pawn extends Piece{
	
	private static final int VALUE = 1;
	private static final char NOTATION = 'P';
	private static final PIECE NAME = PIECE.PAWN;
	
	public Pawn(int colour) {
		setColour(colour);
		setValue(VALUE);
		setNotation(NOTATION);
		setColNotation((colour==1)?'+':'-');
		setPieceName(NAME);
	}
	
	public static char getPawnNotation(){
		
		return NOTATION;
	}

}
