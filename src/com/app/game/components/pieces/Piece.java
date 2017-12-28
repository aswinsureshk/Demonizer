package com.app.game.components.pieces;

import com.app.game.constants.PIECE;

public abstract class Piece {

	private int colour; //1 for white, 0 for black
	private int value;
	private char notation;
	private char colNotation; //+ for white, - for black
	private PIECE pieceName;
	
	public int getColour() {
		return colour;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public char getNotation() {
		return notation;
	}
	
	public char getPieceNotation() {
		return notation;
	}

	public void setNotation(char notation) {
		this.notation = notation;
	}

	public char getColNotation() {
		return colNotation;
	}

	public void setColNotation(char colNotation) {
		this.colNotation = colNotation;
	}

	public PIECE getPieceName() {
		return pieceName;
	}

	public void setPieceName(PIECE pieceName) {
		this.pieceName = pieceName;
	}
	
	@Override
	public boolean equals(Object other){
		
		if (!(other instanceof Piece))
			return false;
		
		Piece op = (Piece) other;
		
		if (this.getColour() == op.getColour() && this.getPieceName() == op.getPieceName())
			return true;
		
		return false;
	}
	 
}
