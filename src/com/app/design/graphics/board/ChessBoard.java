package com.app.design.graphics.board;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class ChessBoard extends JFrame implements MouseListener, MouseMotionListener {
	  
	JLayeredPane layeredPane;
	  JPanel chessBoard;
	  JLabel chessPiece;
	  int xAdjustment;
	  int yAdjustment;
	 
	  public ChessBoard(){
		  Dimension boardSize = new Dimension(600, 600);
		 
		  //  Use a Layered Pane for this this application
		  layeredPane = new JLayeredPane();
		  getContentPane().add(layeredPane);
		  layeredPane.setPreferredSize(boardSize);
		  layeredPane.addMouseListener(this);
		  layeredPane.addMouseMotionListener(this);
		 
		  //Add a chess board to the Layered Pane 
		 
		  chessBoard = new JPanel();
		  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		  chessBoard.setLayout( new GridLayout(8, 8) );
		  chessBoard.setPreferredSize( boardSize );
		  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		 
		  for (int i = 0; i < 64; i++) {
		  JPanel square = new JPanel( new BorderLayout() );
		  chessBoard.add( square );
		 
		  int row = (i / 8) % 2;
		  if (row == 0)
		  square.setBackground( i % 2 == 0 ? Color.gray : Color.white );
		  else
		  square.setBackground( i % 2 == 0 ? Color.white : Color.gray );
		  }
		 
		  //Add a few pieces to the board
		 
		  for (int i=0; i<64; i++){
			  
			  JLabel piece = null;
			  if ( i<16 ){
				  switch(i){
				  	case 0 : case 7 : piece = new JLabel( new ImageIcon("images/black_rook.png") ); break;
				  	case 1 : case 6 : piece = new JLabel( new ImageIcon("images/black_knight.png") ); break;
				  	case 2 : case 5 : piece = new JLabel( new ImageIcon("images/black_bishop.png") ); break;
				  	case 3 : piece = new JLabel( new ImageIcon("images/black_king.png") ); break;
				  	case 4 : piece = new JLabel( new ImageIcon("images/black_queen.png") ); break;
				  	default : piece = new JLabel( new ImageIcon("images/black_pawn.png") ); break;
				  }
				  JPanel panel = (JPanel)chessBoard.getComponent(i);
				  panel.add(piece);
			  }
			  else if ( i>=48 ){
				  switch(i){
				  	case 56 : case 63 : piece = new JLabel( new ImageIcon("images/white_rook.png") ); break;
				  	case 57 : case 62 : piece = new JLabel( new ImageIcon("images/white_knight.png") ); break;
				  	case 58 : case 61 : piece = new JLabel( new ImageIcon("images/white_bishop.png") ); break;
				  	case 59 : piece = new JLabel( new ImageIcon("images/white_king.png") ); break;
				  	case 60 : piece = new JLabel( new ImageIcon("images/white_queen.png") ); break;
				  	default : piece = new JLabel( new ImageIcon("images/white_pawn.png") ); break;
				  }
				  JPanel panel = (JPanel)chessBoard.getComponent(i);
				  panel.add(piece);
			  }
		  }
	  }
	 
	  public void mousePressed(MouseEvent e){
		  chessPiece = null;
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  if (c instanceof JPanel) 
		  return;
		 
		  Point parentLocation = c.getParent().getLocation();
		  xAdjustment = parentLocation.x - e.getX();
		  yAdjustment = parentLocation.y - e.getY();
		  chessPiece = (JLabel)c;
		  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
	  }
	 
	  //Move the chess piece around
	  
	  public void mouseDragged(MouseEvent me) {
		  if (chessPiece == null) return;
			 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	  }
		 
		  //Drop the chess piece back onto the chess board
		 
	   public void mouseReleased(MouseEvent e) {
		  
		  if(chessPiece == null) return;
		 
		  chessPiece.setVisible(false);
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( chessPiece );
		  }
		  else {
		  Container parent = (Container)c;
		  parent.add( chessPiece );
		  }
		 
		  chessPiece.setVisible(true);
	  }
	 
	  public void mouseClicked(MouseEvent e) {
	  
	  }
	  public void mouseMoved(MouseEvent e) {
	  }
	  public void mouseEntered(MouseEvent e){
	  
	  }
	  public void mouseExited(MouseEvent e) {
	  
	  }
	 
	  public static void main(String[] args) {
	  JFrame frame = new ChessBoard();
	  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	  frame.pack();
	  frame.setResizable(true);
	  frame.setLocationRelativeTo( null );
	  frame.setVisible(true);
	 }
}