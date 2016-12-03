package com.app.game.components.pieces;

public class Pawn extends Piece{
	
	private static final int VALUE = 1;
	private static final char NOTATION = 'P';
	private static final String NAME = "PAWN";


	public Pawn(int colour) {
		setColour(colour);
		setValue(VALUE);
		setNotation(NOTATION);
		setColNotation((colour==1)?'+':'-');
		setPieceName(NAME);
	}

}
