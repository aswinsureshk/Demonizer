package com.app.game.components.pieces;

public class Queen extends Piece{
	
	private static final int VALUE = 9;
	private static final char NOTATION = 'Q';
	private static final String NAME = "QUEEN";


	public Queen(int colour) {
		setColour(colour);
		setValue(VALUE);
		setNotation(NOTATION);
		setColNotation((colour==1)?'+':'-');
		setPieceName(NAME);
	}

}
