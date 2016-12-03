package com.app.game.components.pieces;

public class Bishop extends Piece{
	
	private static final int VALUE = 3;
	private static final char NOTATION = 'B';
	private static final String NAME = "BISHOP";

	
	public Bishop(int colour) {
		setColour(colour);
		setValue(VALUE);
		setNotation(NOTATION);
		setColNotation((colour==1)?'+':'-');
		setPieceName(NAME);
	}

}
