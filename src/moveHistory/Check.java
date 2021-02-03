package moveHistory;

import pieces.Displacement;
import pieces.Piece;
import pieces.Position;

public class Check extends Standard {
        Position kingPosition;
        Piece king;
        /**
         * Constructor of the move
         *
         * @param path
         * @param moved
         */
        public Check(Displacement path, Piece moved, Position kingPosition, Piece king) {
                super(path, moved);
                this.king = king;
                this.kingPosition = kingPosition;
        }
}
