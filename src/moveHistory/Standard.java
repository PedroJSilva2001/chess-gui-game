package moveHistory;

import board.ChessBoard;
import pieces.Displacement;
import pieces.Piece;
import pieces.Position;

public class Standard extends Move {

        /**
         * Constructor of the move
         *
         * @param Position startPosition
         * @param Position endPosition
         * @param Piece moved
         */
        /*public Standard(Position startPosition, Position endPosition, Piece moved) {
                super(startPosition, endPosition, moved);
        }*/

        public Standard(Displacement path, Piece moved) {
                super(path, moved);
        }

        @Override
        public void undo(ChessBoard board) {
                //board.setPiece(startPosition, movedPiece);
                //board.removePiece(endPosition);
                board.setPiece(path.getStart(), movedPiece);
                board.removePiece(path.getEnd());
        }

        @Override
        public void redo(ChessBoard board) {
                //board.setPiece(endPosition, movedPiece);
                //board.removePiece(startPosition);
                board.setPiece(path.getEnd(), movedPiece);
                board.removePiece(path.getStart());
        }
    }
