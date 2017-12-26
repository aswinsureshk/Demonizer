package com.app.game.play;

import com.app.game.components.board.Square;
import com.app.game.components.pieces.Piece;
import com.app.game.exception.InvalidMoveException;
import com.app.game.exception.MoveErrorCode;

public class Move implements Movable{

	private String move;
	private Square start;
	private Square end;
	
	public Move (String move) throws InvalidMoveException{
		
		this.move = move;
		Square[] moves = GameUtil.moveMapper(move);
		this.start = moves[0];
		this.end = moves[1];
	}

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

	public Square getStart() {
		return start;
	}
	public void setStart(Square start) {
		this.start = start;
	}
	public Square getEnd() {
		return end;
	}
	public void setEnd(Square end) {
		this.end = end;
	}
	
	@Override
	public Piece move() throws InvalidMoveException{
		
		Piece pStart = start.getPiece();
		
		if (pStart == null)
			throw new InvalidMoveException(MoveErrorCode.THERE_IS_NO_SUCH_PIECE_AT_START.toString());
		
	    boolean isValidMove = MoveEngine.isValidMove(start, end, pStart);
	    Piece capturedPiece = null;
	    
	    if (isValidMove){
	    	
	    	Piece movedPiece = start.getPiece();
	    	start.setPiece(null);
	    	capturedPiece = end.getPiece();
	    	end.setPiece(movedPiece);
	    }
	    else
	    	throw new InvalidMoveException(MoveErrorCode.ILLEGAL_MOVE.toString());
		
	    return capturedPiece;
	}
	
	
}
