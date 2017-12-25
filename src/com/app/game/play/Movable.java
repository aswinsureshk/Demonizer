package com.app.game.play;

import com.app.game.components.pieces.Piece;
import com.app.game.exception.InvalidMoveException;

public interface Movable {

	Piece move() throws InvalidMoveException;
}
