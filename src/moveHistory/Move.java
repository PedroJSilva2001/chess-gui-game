package moveHistory;

import board.ChessBoard;
import pieces.Displacement;
import pieces.Piece;
import pieces.Position;

/**
 * Keeps a register of the information in a move
 */
public abstract class Move {
        //protected Position startPosition;
        //protected Position endPosition;
        protected Displacement path;
        protected Piece movedPiece;
        private Move previous;
        private Move next;

        /**
         * Constructor of the move
         *
         * @param Position The piece start position
         * @param Position The piece end position
         * @param Piece The moved piece
         */
        /*Move(Position startPosition, Position endPosition, Piece moved) {
                this.startPosition = startPosition;
                this.endPosition = endPosition;
                this.movedPiece = moved;
                previous = null;
                next = null;
        }*/
        Move(Displacement path, Piece moved) {
                this.path = path;
                this.movedPiece = moved;
        }

        /**
         * @return Returns the start position of the moved piece
         */
        /*public Position getStartPosition() {
                return startPosition;
        }*/

        /**
         * @return Returns the end position of the moved piece
         */
        /*public Position getEndPosition() {
                return endPosition;
        }*/

        public Displacement getPath() {
                return path;
        }

        public Move getPreviousMove() {
                return previous;
        }

        public  Move getNextMove() {
                return next;

        }

        public void setNextMove(Move next) {
                this.next = next;
        }

        public void setPreviousMove(Move previous) {
                this.previous = previous;
        }

        public String getPlayer() {
                return movedPiece.getColour();
        }

        public abstract void undo(ChessBoard board);

        public abstract void redo(ChessBoard board);

}
