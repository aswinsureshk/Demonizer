package com.app.game.play;

import java.util.ArrayList;
import java.util.List;

import com.app.game.components.board.Board;
import com.app.game.components.board.Square;
import com.app.game.components.pieces.Bishop;
import com.app.game.components.pieces.King;
import com.app.game.components.pieces.Knight;
import com.app.game.components.pieces.Pawn;
import com.app.game.components.pieces.Queen;
import com.app.game.components.pieces.Rook;
import com.app.game.exception.InvalidMoveException;
import com.app.game.exception.MoveErrorCode;

public class GameUtil {

	private static List<Character> notationList = new ArrayList<Character>(){
		
		private static final long serialVersionUID = 1L;

	{
		add(Pawn.getPawnNotation());
		add(Knight.getKnightNotation());
		add(Bishop.getBishopNotation());
		add(Rook.getRookNotation());
		add(Queen.getQueenNotation());
		add(King.getKingNotation());
	}};
	
	public static Square[] moveMapper(String move) throws InvalidMoveException{
		
		Square start = null, end = null;
		
		boolean startNotationPiece = false, endNotationPiece = false;
		
		for ( int i = 0; i < move.length(); i++){
			
			char ch = move.charAt(i);
			char next = move.charAt(i+1);
			
			if (ch == 'x' || ch == '#' || ch == '+')
				continue;
			
			if (startNotationPiece == false){
				
				startNotationPiece = true;

				if (notationList.contains(ch))
					continue;
			}
			
			
			if (start == null && startNotationPiece == true){
				
				int col = (int) (ch - 'a') + 1;
				int row = (int)  (next - '0');
				i++;
				try{
					
					start = Board.getSquares()[row][col];
				
				}catch (IndexOutOfBoundsException indE){
					
					throw new InvalidMoveException(MoveErrorCode.THE_MOVE_IS_OUT_OF_BOARD_SCOPE.toString());
				}
				continue;
			}
			
			if (endNotationPiece == false){
				
				endNotationPiece = true;

				if (notationList.contains(ch))
					continue;
			}
			
			if (end == null && endNotationPiece == true){
				
				int col = (int) (ch - 'a') + 1;
				int row = (int) (next - '0');
				i++;
				try{
					
					end = Board.getSquares()[row][col];
				
				}catch (IndexOutOfBoundsException indE){
					
					throw new InvalidMoveException(MoveErrorCode.THE_MOVE_IS_OUT_OF_BOARD_SCOPE.toString());
				}
				continue;
			}
		}	
		return new Square[]{start, end};
	}
}
