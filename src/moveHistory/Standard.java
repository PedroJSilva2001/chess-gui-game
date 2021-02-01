package moveHistory;

import board.ChessBoard;
import pieces.Piece;
import pieces.Position;

public class Standard extends Move {

        /**
         * Constructor of the move
         *
         * @param startPosition
         * @param endPosition
         * @param moved
         */
        public Standard(Position startPosition, Position endPosition, Piece moved) {
                super(startPosition, endPosition, moved);
        }

        @Override
        public void undo(ChessBoard board) {
                board.setPiece(startPosition, movedPiece);
                board.removePiece(endPosition);
        }

        @Override
        public void redo(ChessBoard board) {
                board.setPiece(endPosition, movedPiece);
                board.removePiece(startPosition);
        }
    }
