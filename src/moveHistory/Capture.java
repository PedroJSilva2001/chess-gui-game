package moveHistory;

import board.ChessBoard;
import pieces.Displacement;
import pieces.Piece;
import pieces.Position;

public class Capture extends Move {

        protected Piece capturedPiece;

        /**
         * Constructor of the move
         *
         * @param startPosition
         * @param endPosition
         * @param moved
         */
        /*public Capture(Position startPosition, Position endPosition, Piece moved, Piece captured) {
                super(startPosition, endPosition, moved);
                this.capturedPiece = captured;
        }*/
        public Capture(Displacement path, Piece moved, Piece captured) {
                super(path, moved);
                this.capturedPiece = captured;
        }

        @Override
        public void undo(ChessBoard board) {
                //board.setPiece(startPosition, movedPiece);
                //board.setPiece(endPosition, capturedPiece);
                board.setPiece(path.getStart(), movedPiece);
                board.setPiece(path.getEnd(), capturedPiece);

        }

        @Override
        public void redo(ChessBoard board) {
                //board.setPiece(endPosition, movedPiece);
                //board.removePiece(startPosition);
                board.setPiece(path.getEnd(), movedPiece);
                board.removePiece(path.getStart());
        }
}
