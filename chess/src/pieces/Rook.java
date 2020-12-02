package pieces;

import board.ChessBoard;

import java.util.ArrayList;

import pieceBehaviour.PieceBehaviour;
import pieceMovement.PieceMovement;

public class Rook extends Piece {

    public Rook(int x, int y, String colour) {
        super(x,y,colour, "rook");
    }

    public ArrayList<Position> getUnfilteredMoves(ChessBoard board) {
        ArrayList<Position> unfilteredMoves = new ArrayList<>();
        int step = 8;

        for (int dir1 = -1; dir1 <= 1; dir1++) {
            for (int dir2 = -1; dir2 <=1; dir2++) {
                if ((dir1 == 0 && dir2 == 0) || (Math.abs(dir1) == 1 && Math.abs(dir2) == 1)) {
                    continue;
                }
                else {
                    unfilteredMoves.addAll(PieceMovement.getLine(x, y, dir1, dir2, board, step));
                }
            }
        }
        return unfilteredMoves;
    }
}
