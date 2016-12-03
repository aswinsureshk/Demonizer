package com.app.game.play;

import com.app.game.components.board.Board;

public class Demo {
	
	public static void main(String[] args) {
		
		Board board = new Board();
		board.setup();
		board.displayPosition();
	}

}
