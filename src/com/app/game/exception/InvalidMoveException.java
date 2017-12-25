package com.app.game.exception;

public class InvalidMoveException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private final static String DEFAULT_MSG = "INVALID MOVE";
	
	public InvalidMoveException(){
		
		super(DEFAULT_MSG);
	}
	
	public InvalidMoveException(String message){
		
		super(message);
	}
	
	public InvalidMoveException(Exception e){
		
		super(e);
	}
	
	public InvalidMoveException( Throwable t ){
		
		super(t);
	}
}
