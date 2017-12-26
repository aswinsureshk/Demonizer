package com.app.game.components.board;

import com.app.game.components.pieces.Piece;

public class Square {

	private int rank; //rank coordinate
	private char file; //file coordinate
	
	private int colour; //can be 1 or 0
	
	private Piece piece;
	
	public Square(){
		
	}
	
	public Square(int row, int file, int colour) {
		this.rank = row;
		this.file = (char) (file - 1 + 'a');
		this.colour = colour;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int row) {
		this.rank = row;
	}
	public char getFile() {
		return file;
	}
	public int getFileAsInt() {
		return (int) (file - 'a') + 1;
	}
	public void setFile(int file) {
		this.file = (char) (file - 1 + 'a');	
	}
	public void setFile(char file) {
		this.file = file;	
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public int getColour() {
		return colour;
	}
	public void setColour(int colour) {
		this.colour = colour;
	}
	
	
}
