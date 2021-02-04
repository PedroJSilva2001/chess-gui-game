package moveHistory;

import board.ChessBoard;
import pieces.Displacement;
import pieces.Piece;

public class Promotion extends Standard{
        private final Piece promoted;
        /**
         * Constructor of the move
         *
         * @param path
         * @param moved
         */
        public Promotion(Displacement path, Piece moved, Piece promoted) {
                super(path, moved);
                this.promoted = promoted;
        }

        @Override
        public void undo(ChessBoard board) {
                super.undo(board);
        }

        @Override
        public void redo(ChessBoard board) {
                board.setPiece(path.getEnd(), promoted);
                board.removePiece(path.getStart());
        }
}
