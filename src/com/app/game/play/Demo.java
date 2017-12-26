package com.app.game.play;

import com.app.game.components.board.Board;
import com.app.game.exception.InvalidMoveException;

public class Demo {
	
	public static void main(String[] args) throws InvalidMoveException {
		
		Board.setup();
		Board.displayPosition();
		
		String m = "a2a3";
		Move move = new Move(m);
		move.move();
		
		System.out.println("\n\n\n\n\n");
		
		Board.displayPosition();
		
	}

}
