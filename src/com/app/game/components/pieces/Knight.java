package com.app.game.components.pieces;

public class Knight extends Piece{
	
	private static final int VALUE = 3;
	private static final char NOTATION = 'N';
	private static final String NAME = "KNIGHT";

	public Knight(int colour) {
		setColour(colour);
		setValue(VALUE);
		setNotation(NOTATION);
		setColNotation((colour==1)?'+':'-');
		setPieceName(NAME);
	}

}
