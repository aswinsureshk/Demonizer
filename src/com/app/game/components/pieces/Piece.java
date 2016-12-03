package com.app.game.components.pieces;

public class Piece {

	private int colour; //1 for white, 0 for black
	private int value;
	private char notation;
	private char colNotation; //+ for white, - for black
	private String pieceName;
	
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

	public void setNotation(char notation) {
		this.notation = notation;
	}

	public char getColNotation() {
		return colNotation;
	}

	public void setColNotation(char colNotation) {
		this.colNotation = colNotation;
	}

	public String getPieceName() {
		return pieceName;
	}

	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
	 
}
