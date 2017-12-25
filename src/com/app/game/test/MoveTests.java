package com.app.game.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.app.game.components.board.Board;
import com.app.game.components.board.Square;
import com.app.game.components.pieces.Piece;
import com.app.game.exception.InvalidMoveException;
import com.app.game.exception.MoveErrorCode;
import com.app.game.play.Move;

import junit.framework.TestCase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoveTests extends TestCase{

	public MoveTests() {
			
		Board.setup();
	}
	
	@Test
	public void test1PawnLegalMove1(){
		
		Square start = Board.getSquares()[2][1];
		Square end = Board.getSquares()[3][1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(start, end);
		try {
			
			move.move();
		} catch (InvalidMoveException e) {

			System.out.println(e.getMessage());
			org.junit.Assert.fail();
		}
		
		assertEquals(end.getPiece(), movedPiece);
		assertNull(start.getPiece());
	}
	
	@Test
	public void test2PawnIllegalMove1(){
		
		Square start = Board.getSquares()[3][1];
		Square end = Board.getSquares()[3][2];
		Piece movedPiece = start.getPiece();
		Move move = new Move(start, end);
		try {
			
			move.move();
		} catch (InvalidMoveException e) {
			
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), MoveErrorCode.ILLEGAL_MOVE.toString());
		}
		
		assertEquals (start.getPiece(), movedPiece);
		assertNull(end.getPiece());
	}
	
	@Test
	public void test3PawnIllegalMove2(){
		
		Square start = Board.getSquares()[2][2];
		Square end = Board.getSquares()[2][3];
		Piece movedPiece = start.getPiece();
		Piece targetPiece = end.getPiece();
		Move move = new Move(start, end);
		try {
			
			move.move();
		} catch (InvalidMoveException e) {
			
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), MoveErrorCode.THE_TARGET_POSITION_HAS_A_BLOCKING_PIECE.toString());
		}
		
		assertEquals(end.getPiece(), targetPiece);
		assertEquals (start.getPiece(), movedPiece);
	}
	
	@Test
	public void test4PawnIllegalMove3(){
		
		Square start = Board.getSquares()[2][1];
		Square end = new Square(1, 0, 1);
		Piece movedPiece = start.getPiece();
		Move move = new Move(start, end);
		try {
			
			move.move();
		} catch (InvalidMoveException e) {
			
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), MoveErrorCode.THE_MOVE_IS_OUT_OF_BOARD_SCOPE.toString());
		}
		
		assertEquals (start.getPiece(), movedPiece);
	}
	
}
