package com.app.game.play;

import com.app.game.components.board.Board;
import com.app.game.components.board.Square;
import com.app.game.components.pieces.Piece;
import com.app.game.constants.PIECE;
import com.app.game.exception.InvalidMoveException;
import com.app.game.exception.MoveErrorCode;

public class MoveEngine {

	public static boolean isValidMove(Square start, Square end, Piece piece) throws InvalidMoveException{
		
		boolean isValid = false;
		
		if ( start.getRank() == end.getRank() && start.getFileAsInt() == end.getFileAsInt())
			throw new InvalidMoveException(MoveErrorCode.THE_PIECE_WAS_NOT_MOVED.toString());
		
		if (!inBoardScope(start.getRank(), start.getFileAsInt()) || !inBoardScope(end.getRank(), end.getFileAsInt()))
			throw new InvalidMoveException(MoveErrorCode.THE_MOVE_IS_OUT_OF_BOARD_SCOPE.toString());

		if ( end.getPiece() != null && end.getPiece().getColour() == start.getPiece().getColour())
			throw new InvalidMoveException(MoveErrorCode.THE_TARGET_POSITION_HAS_A_BLOCKING_PIECE.toString());
		
		switch (piece.getPieceName()){
		
			case PAWN : 
				
					if (start.getFileAsInt() == end.getFileAsInt()){
						if (piece.getColour() == 1){
							if (start.getRank()+1 == end.getRank())
								isValid = true;
						}
						else{
							if (start.getRank()-1 == end.getRank())
								isValid = true;
						}
					}
					break;
		   
			case KNIGHT : 
				
				 if ( (end.getRank() == start.getRank() + 1 && end.getFileAsInt() == start.getFileAsInt() + 2) ||
					  (end.getRank() == start.getRank() + 1 && end.getFileAsInt() == start.getFileAsInt() - 2) ||
					  (end.getRank() == start.getRank() + 2 && end.getFileAsInt() == start.getFileAsInt() + 1) ||
					  (end.getRank() == start.getRank() + 2 && end.getFileAsInt() == start.getFileAsInt() - 1) ||
					  (end.getRank() == start.getRank() - 1 && end.getFileAsInt() == start.getFileAsInt() + 2) ||
					  (end.getRank() == start.getRank() - 1 && end.getFileAsInt() == start.getFileAsInt() - 2) ||
					  (end.getRank() == start.getRank() - 2 && end.getFileAsInt() == start.getFileAsInt() + 1) ||
					  (end.getRank() == start.getRank() - 2 && end.getFileAsInt() == start.getFileAsInt() - 1) )
					 
					 isValid = true;
				break;
		    
			case BISHOP :
				
				  
				 if (Math.abs(end.getRank() - start.getRank()) == Math.abs(end.getFileAsInt() - start.getFileAsInt()) && !isAnyBlockingPieceInPath(start, end, PIECE.BISHOP))
					 isValid = true;
				 break;
		    
			case ROOK : 
				
				if (end.getRank() == start.getRank() || end.getFileAsInt() == start.getFileAsInt() && !isAnyBlockingPieceInPath(start, end, PIECE.ROOK))
					isValid = true;
				break;
				
			case QUEEN: 
				
				  if (!isAnyBlockingPieceInPath(start, end, PIECE.QUEEN) && end.getRank() - start.getRank() == end.getFileAsInt() - start.getFileAsInt() ||
				      end.getRank() == start.getRank() || end.getFileAsInt() == start.getFileAsInt() )
					  isValid = true;
				  break;
			
			case KING : 
				
				 if ( end.getRank() == start.getRank()+1 && end.getFileAsInt() == start.getFileAsInt()+1 ||
					  end.getRank() == start.getRank()+1 && end.getFileAsInt() == start.getFileAsInt()-1 ||
					  end.getRank() == start.getRank()-1 && end.getFileAsInt() == start.getFileAsInt()+1 ||
					  end.getRank() == start.getRank()-1 && end.getFileAsInt() == start.getFileAsInt()-1 ||
					  end.getRank() == start.getRank()+1 && end.getFileAsInt() == start.getFileAsInt()   ||
					  end.getRank() == start.getRank()-1 && end.getFileAsInt() == start.getFileAsInt()   ||
					  end.getRank() == start.getRank()   && end.getFileAsInt() == start.getFileAsInt()+1 ||
					  end.getRank() == start.getRank()   && end.getFileAsInt() == start.getFileAsInt()-1  )
					 
					 isValid = true;
				 break;

		}
		
		return isValid;
	}
	
	
	private static boolean isAnyBlockingPieceInPath(Square start, Square end, PIECE piece) throws InvalidMoveException {
		
		boolean isAnyBlockingPieceInPath = false;
		
		switch ( piece ){
		
			case BISHOP : 
				
				if (!(Math.abs(end.getRank() - start.getRank()) == Math.abs(end.getFileAsInt() - start.getFileAsInt())))
					return true;
				
				int min_X = Math.min(start.getRank(), end.getRank());
				int min_Y = Math.min(start.getFileAsInt(), end.getFileAsInt());
				int max_X = Math.max(start.getRank(), end.getRank());
				
				int j = min_Y + 1;
				for ( int i = min_X + 1; i<max_X; i++, j++){
					
					if (Board.getSquares()[i][j].getPiece() != null){
						isAnyBlockingPieceInPath = true;
						break;
					}
				}
				break;
				
			case ROOK : 
				
				int min, max;
				boolean RankEq = true;
				if (start.getRank() == end.getRank()){
					min = Math.min(start.getFileAsInt(), end.getFileAsInt());
					max = Math.max(start.getFileAsInt(), end.getFileAsInt());
				}
				else if (start.getFileAsInt() == end.getFileAsInt()){
					min = Math.min(start.getRank(), end.getRank());
					max = Math.max(start.getRank(), end.getRank());
					RankEq = false;
				}
				else
					return true;
				
				for (int i = min+1; i < max; i++) {
					
					if (RankEq){
						if (Board.getSquares()[start.getRank()][i].getPiece() != null ){
							isAnyBlockingPieceInPath = true;
							break;
						}
					}
					else{
						if (Board.getSquares()[i][start.getFileAsInt()].getPiece() != null){
							isAnyBlockingPieceInPath = true;
							break;
						}
					}
				}
				break;
				
			case QUEEN :
				
				 if (isAnyBlockingPieceInPath(start, end, PIECE.BISHOP) && 
						 isAnyBlockingPieceInPath(start, end, PIECE.ROOK))
					 isAnyBlockingPieceInPath = true;
				 
				 break;
				 
			default:
				break;
		
		}
		
		if (isAnyBlockingPieceInPath)
			throw new InvalidMoveException(MoveErrorCode.THERE_IS_A_BLOCKING_PIECE.toString());
		
		return isAnyBlockingPieceInPath;
	}


	private static boolean inBoardScope(int rank, int file){
		
		if ( rank >=1 && rank <= 8 && file >= 1 && file <= 8)
			return true;
		
		return false;
	}
}
