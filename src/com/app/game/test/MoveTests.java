package com.app.game.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.app.game.components.board.Board;
import com.app.game.components.board.Square;
import com.app.game.components.pieces.Piece;
import com.app.game.exception.InvalidMoveException;
import com.app.game.exception.MoveErrorCode;
import com.app.game.play.GameUtil;
import com.app.game.play.Move;

import junit.framework.TestCase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoveTests extends TestCase{

	public MoveTests() {
			
		Board.setup();
	}
	
	@Test
	public void test1PawnLegalMove1() throws InvalidMoveException{
		
		String m = "a2a3";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void test2PawnIllegalMove1() throws InvalidMoveException{
		
		String m = "a3b3";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void test3PawnIllegalMove2() throws InvalidMoveException{
		
		String m = "b2c2";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Piece targetPiece = end.getPiece();
		Move move = new Move(m);
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
	public void test4PawnIllegalMove3() {
		
		String m = "a3k2";
		Square[] square = null;
		try {
			
			square = GameUtil.moveMapper(m);
		
		} catch (InvalidMoveException e) {

			System.out.println(e.getMessage());
			assertNull(square);
			assertEquals(e.getMessage(), MoveErrorCode.THE_MOVE_IS_OUT_OF_BOARD_SCOPE.toString());
		}
		
	}
	
	@Test
	public void test5KnightLegalMove() throws InvalidMoveException{
		
		String m = "Nb1c3";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void test6KnightLegalMove() throws InvalidMoveException{
		
		String m = "Nc3e4";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void test7KnightLegalMove() throws InvalidMoveException{
		
		String m = "Nc3a2";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void test8KnightLegalMove() throws InvalidMoveException{
		
		String m = "Na2c3";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void test9KnightLegalMove() throws InvalidMoveException{
		
		String m = "Nc3b5";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void testA10KnightLegalMove() throws InvalidMoveException{
		
		String m = "Nb5c3";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void testA11KnightLegalMove() throws InvalidMoveException{
		
		String m = "Nc3d5";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void testA12KnightLegalMove() throws InvalidMoveException{
		
		String m = "Nd5c3";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void testA13KnightLegalMove() throws InvalidMoveException{
		
		String m = "Nc3a4";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void testA14KnightLegalMove() throws InvalidMoveException{
		
		String m = "Na4c3";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void testA15KnightLegalMove() throws InvalidMoveException{
		
		String m = "Nc3b1";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
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
	public void testA16KnightIllegalMove1() throws InvalidMoveException{
		
		String m = "Nb1b3";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		Move move = new Move(m);
		try {
			
			move.move();
		} catch (InvalidMoveException e) {
			
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), MoveErrorCode.ILLEGAL_MOVE.toString());
		}
		
		assertEquals (start.getPiece(), movedPiece);
		assertNull(end.getPiece());
	}
	
}
