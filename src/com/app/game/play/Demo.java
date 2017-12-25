package com.app.game.play;

import com.app.game.components.board.Board;
import com.app.game.components.board.Square;
import com.app.game.exception.InvalidMoveException;

public class Demo {
	
	public static void main(String[] args) throws InvalidMoveException {
		
		Board.setup();
		Board.displayPosition();
		
		Square start = Board.getSquares()[2][1];
		Square end = Board.getSquares()[3][1];
		Move move = new Move(start, end);
		move.move();
		
		System.out.println("\n\n\n\n\n");
		
		Board.displayPosition();
		
	}

}
