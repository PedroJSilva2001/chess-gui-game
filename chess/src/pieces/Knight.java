package pieces;

import board.ChessBoard;

import java.util.Vector;

public class Knight extends Piece {
    public Knight(int x, int y, String colour) {
        super(x,y,colour, "knight");
    }

    @Override
    public Vector<Vector<Integer>> getMoves(ChessBoard board) {
        return null;
    }
}
