package com.app.game.components.pieces;

import com.app.game.constants.PIECE;

public class King extends Piece{
	
	private static final int VALUE = 100;
	private static final char NOTATION = 'K';
	private static final PIECE NAME = PIECE.KING;

	public King(int colour) {
		setColour(colour);
		setValue(VALUE);
		setNotation(NOTATION);
		setColNotation((colour==1)?'+':'-');
		setPieceName(NAME);
	}

}
