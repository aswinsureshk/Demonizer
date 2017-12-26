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
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 E X X X X X X X
	 S X X X X X X X
	 X X X X X X X X
	 
	 */
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 S X X X X X X X
	 E X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void test2PawnIllegalMove1() throws InvalidMoveException{
		
		String m = "a3a2";
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X S E X X X X X
	 X X X X X X X X
	 
	 */
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 S X X X X X X X
	 X X X X X X X X   E
	 X X X X X X X X
	 
	 */
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X E X X X X X
	 X X X X X X X X
	 X S X X X X X X
	 
	 */
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X E X X X
	 X X S X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 
	 */
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X S X X X
	 X X E X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void test7KnightLegalMove() throws InvalidMoveException{
		
		String m = "Ne4c3";
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X S X X X X X
	 E X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void test8KnightLegalMove() throws InvalidMoveException{
		
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X E X X X X X
	 S X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void test9KnightLegalMove() throws InvalidMoveException{
		
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X E X X X X X X
	 X X X X X X X X
	 X X S X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void testA10KnightLegalMove() throws InvalidMoveException{
		
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X S X X X X X X
	 X X X X X X X X
	 X X E X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void testA11KnightLegalMove() throws InvalidMoveException{
		
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X E X X X X
	 X X X X X X X X
	 X X S X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void testA12KnightLegalMove() throws InvalidMoveException{
		
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X S X X X X
	 X X X X X X X X
	 X X E X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void testA13KnightLegalMove() throws InvalidMoveException{
		
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 E X X X X X X X
	 X X S X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void testA14KnightLegalMove() throws InvalidMoveException{
		
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 S X X X X X X X
	 X X E X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void testA15KnightLegalMove() throws InvalidMoveException{
		
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X S X X X X X
	 X X X X X X X X
	 X E X X X X X X
	 
	 */
	@Test
	public void testA16KnightLegalMove() throws InvalidMoveException{
		
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X E X X X X X X
	 X X X X X X X X
	 X S X X X X X X
	 
	 */
	@Test
	public void testA17KnightIllegalMove() throws InvalidMoveException{
		
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
		
		}finally{
			
			Board.setup();
		}
		
		assertEquals (start.getPiece(), movedPiece);
		assertNull(end.getPiece());
	}
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X E X X X X X X
	 X X S X X X X X
	 
	 */
	@Test
	public void testA18BishopLegalMove() throws InvalidMoveException{
		
		Move move = new Move("b2b3");
		move.move();
		String m = "Bc1b2";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		move = new Move(m);
		try {
			
			move.move();
		} catch (InvalidMoveException e) {
			
			System.out.println(e.getMessage());
			org.junit.Assert.fail();
		}
		
		assertEquals(end.getPiece(), movedPiece);
		assertNull(start.getPiece());
	}
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X E X X X X
	 X X X X X X X X
	 X S X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void testA19BishopLegalMove() throws InvalidMoveException{
		
		String m = "Bb2d4";
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X S X X X X
	 X X X X X X X X
	 X E X X X X X X
	 X X X X X X X X
	 
	 */
	@Test
	public void testA20BishopLegalMove() throws InvalidMoveException{
		
		String m = "Bd4b2";
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
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X S X X X X X X
	 X X E X X X X X
	 
	 */
	@Test
	public void testA21BishopLegalMove() throws InvalidMoveException{
		
		String m = "Bb2c1";
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
		
		}finally{
			
			Board.setup();
		}
		
		assertEquals(end.getPiece(), movedPiece);
		assertNull(start.getPiece());
	}
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X E
	 X X X X X X X X
	 X X X X X X X S
	 
	 */
	@Test
	public void testA22RookLegalMove() throws InvalidMoveException{
		
		Move move = new Move("h2h3");
		move.move();
		move = new Move("h3h4");
		move.move();
		String m = "Rh1h3";
		Square[] square = GameUtil.moveMapper(m);
		Square start = square[0];
		Square end = square[1];
		Piece movedPiece = start.getPiece();
		move = new Move(m);
		try {
			
			move.move();
		} catch (InvalidMoveException e) {
			
			System.out.println(e.getMessage());
			org.junit.Assert.fail();
			
		}
		
		assertEquals(end.getPiece(), movedPiece);
		assertNull(start.getPiece());
	}
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 E X X X X X X S
	 X X X X X X X X
	 X X X X X X X x
	 
	 */
	@Test
	public void testA23RookLegalMove() throws InvalidMoveException{
		
		String m = "Rh3a3";
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 S X X X X X X E
	 X X X X X X X X
	 X X X X X X X x
	 
	 */
	@Test
	public void testA24RookLegalMove() throws InvalidMoveException{
		
		String m = "Ra3h3";
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
	
	/*
	 
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X X
	 X X X X X X X S
	 X X X X X X X X
	 X X X X X X X E
	 
	 */
	@Test
	public void testA25RookLegalMove() throws InvalidMoveException{
		
		String m = "Rh3h1";
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
			
		}finally{
			
			Board.setup();
		}
		
		assertEquals(end.getPiece(), movedPiece);
		assertNull(start.getPiece());
	}
	
}
