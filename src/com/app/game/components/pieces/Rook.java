package com.app.game.components.pieces;

public class Rook extends Piece{
	
	private static final int VALUE = 5;
	private static final char NOTATION = 'R';
	private static final String NAME = "ROOK";


	public Rook(int colour) {
		setColour(colour);
		setValue(VALUE);
		setNotation(NOTATION);
		setColNotation((colour==1)?'+':'-');
		setPieceName(NAME);
	}
}
