package moveHistory;

import board.ChessBoard;
import pieces.Piece;
import pieces.Position;

public class EnPassant extends Standard {

        private final Piece capturedPiece;
        /**
         * Constructor of the move
         *
         * @param startPosition
         * @param endPosition
         * @param moved
         */
        public EnPassant(Position startPosition, Position endPosition, Piece moved, Piece captured) {
                super(startPosition, endPosition, moved);
                this.capturedPiece = captured;
        }

        //private void removeCapturedPawn
        @Override
        public void undo(ChessBoard board) {
                /*Position pos = endPosition;
                String colour = capturedPiece.getColour();
                int xprev = colour.equals("black")? pos.getX()-1 : pos.getX()+1;
                pos.setX(xprev);
                board.setPiece(pos, capturedPiece);

                xprev = colour.equals("black")? pos.getX()+2 : pos.getX()-2;
                pos.setX(xprev);
                board.removePiece(pos);
                super.undo(board);*/
        }

        @Override
        public void redo(ChessBoard board) {
                /*Position pos = endPosition;
                String colour = capturedPiece.getColour();
                int xprev = colour.equals("black")? pos.getX()+2 : pos.getX()-2;
                pos.setPosition(xprev, pos.getY());
                board.setPiece(pos, capturedPiece);

                xprev = colour.equals("black")? pos.getX()+2 : pos.getX()-2;
                pos.setPosition(xprev, pos.getY());
                board.removePiece(pos);
                super.redo(board);*/

        }
}
