package pieces;

import board.ChessBoard;

import java.util.Vector;

import pieceBehaviour.PieceBehaviour;
public class Rook extends Piece implements PieceBehaviour{
    public Rook(int x, int y, String colour) {
        super(x,y,colour, "rook");
    }
    public Vector<Vector<Integer>> getMoves(ChessBoard board) {
        Vector<Vector<Integer>> possibleMoves = new Vector<Vector<Integer>>();
        for (int dir1 = -1; dir1 <= 1; dir1++) {
            for (int dir2 = -1; dir2 <=1; dir2++) {
                if ((dir1 == 0 && dir2 == 0) || (Math.abs(dir1) == 1 && Math.abs(dir2) == 1)) {
                    continue;
                }
                else {
                    getLongLine(x, y, dir1, dir2, board, possibleMoves);
                }
            }
        }
        return possibleMoves;
    }
}
