package com.app.game.exception;

public enum MoveErrorCode {

	ILLEGAL_MOVE(401),
	THE_PIECE_WAS_NOT_MOVED(401),
	THE_MOVE_IS_OUT_OF_BOARD_SCOPE(402),
	THE_TARGET_POSITION_HAS_A_BLOCKING_PIECE(403),
	THERE_WAS_A_BLOCKING_PIECE(404);
	
	private final int errorCode;

	private MoveErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public int getValue() {
		return errorCode;
	}
	
}
