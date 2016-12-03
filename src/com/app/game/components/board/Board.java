package com.app.game.components.board;


import com.app.game.components.pieces.Bishop;
import com.app.game.components.pieces.King;
import com.app.game.components.pieces.Knight;
import com.app.game.components.pieces.Pawn;
import com.app.game.components.pieces.Queen;
import com.app.game.components.pieces.Rook;

public class Board {
	
	private static final int RANK_SIZE = 9;
	private static final int FILE_SIZE = 9;
	private Square squares[][];
	
	public void setup(){
		
		squares = new Square[RANK_SIZE][FILE_SIZE];
		for (int rank = 1; rank < RANK_SIZE; rank++) 
			for (int file = 1; file < FILE_SIZE; file++) {
				
				squares[rank][file] = new Square(rank, file, rank*file % 2);
				
				if (rank==2 || rank==7)
					squares[rank][file].setPiece(new Pawn(1-rank%2));
				
				else if (rank==1 || rank==8){
					
					if (file==1 || file==8)
						squares[rank][file].setPiece(new Rook(rank%2));
					else if (file==2 || file==7)
						squares[rank][file].setPiece(new Knight(rank%2));
					else if (file==3 || file==6)
						squares[rank][file].setPiece(new Bishop(rank%2));
					else if (file==4)
						squares[rank][file].setPiece(new Queen(rank%2));
					else if (file==5)
						squares[rank][file].setPiece(new King(rank%2));
				}
				
			}
	}
	
	public void displayPosition(){
		
		int rankDecr= 8;
		for (int rank = RANK_SIZE-1; rank>0; rank--) {
			System.out.print(rankDecr + "\t");
			for (int file = 1; file < FILE_SIZE; file++) 
				if (squares[rank][file].getPiece() != null)
					System.out.print(squares[rank][file].getPiece().getNotation() + "" + squares[rank][file].getPiece().getColNotation() + "\t");
			rankDecr --;
			System.out.print("\n\n");	
			if (rank == 1)
				System.out.print("\n");	
		}
		System.out.print("\t");
		for (int fileIncr = 1; fileIncr < FILE_SIZE; fileIncr++) {
			char rankIndex = (char) (fileIncr + 'a' - 1);
			System.out.print(rankIndex + "\t");
		}
	}
	
	
}
