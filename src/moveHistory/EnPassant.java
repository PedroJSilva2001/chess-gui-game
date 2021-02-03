package moveHistory;

import board.ChessBoard;
import pieces.Displacement;
import pieces.Piece;
import pieces.Position;

public class EnPassant extends Capture {

        private final Displacement capturedPath;
        /**
         * Constructor of the move
         *
         * @param path
         * @param capturedPath
         * @param moved
         * @param captured
         */
       /* public EnPassant(Position startPosition, Position endPosition, Piece moved, Piece captured) {
                super(startPosition, endPosition, moved);
                this.capturedPiece = captured;
        }*/
        public EnPassant(Displacement path, Displacement capturedPath, Piece moved, Piece captured) {
                super(path, moved, captured);
                this.capturedPath = capturedPath;
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
                board.setPiece(capturedPath.getStart(), capturedPiece);
                board.removePiece(capturedPath.getEnd());
                board.setPiece(path.getStart(), movedPiece);
                board.removePiece(path.getEnd());
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

                board.setPiece(capturedPath.getEnd(), capturedPiece);
                board.removePiece(capturedPath.getStart());
                board.setPiece(path.getEnd(), movedPiece);
                board.removePiece(path.getStart());
        }
}
