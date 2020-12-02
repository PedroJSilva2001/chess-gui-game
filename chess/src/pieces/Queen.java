package pieces;
import board.ChessBoard;
import pieceBehaviour.PieceBehaviour;
import pieceMovement.PieceMovement;

import java.util.ArrayList;
import java.util.Vector;

public class Queen extends Piece {

    public Queen(int x, int y, String colour) {
        super(x,y,colour, "queen");
    }

    @Override
    public ArrayList<Position> getUnfilteredMoves(ChessBoard board) {
        int step = 8;
        ArrayList<Position> unfilteredMoves = new ArrayList<>();

        for (int dir1 = -1; dir1 <= 1; dir1++) {
            for (int dir2 = -1; dir2 <= 1; dir2++) {
                if (dir1 == 0 && dir2 == 0) {
                    continue;
                }
                unfilteredMoves.addAll(PieceMovement.getLine(x, y, dir1, dir2, board, step));
            }
        }
        return unfilteredMoves;
    }
}
