package pieces;

import board.ChessBoard;

import java.util.Vector;

public class King extends Piece{
    public King(int x, int y, String colour) {
        super(x, y, colour, "king");
    }

    @Override
    public Vector<Vector<Integer>> getMoves(ChessBoard board) {
        Vector<Vector<Integer>> possibleMoves = new Vector<Vector<Integer>>();

        return possibleMoves;
    }
}
