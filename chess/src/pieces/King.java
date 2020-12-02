package pieces;

import board.ChessBoard;
import pieceMovement.PieceMovement;

import java.util.ArrayList;

public class King extends Piece{

    private boolean inCheck;

    public King(int x, int y, String colour) {
        super(x, y, colour, "king");
        this.inCheck = false;
    }

    @Override
    public ArrayList<Position> getUnfilteredMoves(ChessBoard board) {
        ArrayList<Position> unfilteredMoves = new ArrayList<>();
        int step = 1;

        for (int dir1 = -1; dir1 <= 1; dir1++) {
            for (int dir2 = -1; dir2 <=1; dir2++) {
                if (dir1 == 0 && dir2 == 0) {
                    continue;
                }
                unfilteredMoves.addAll(PieceMovement.getLine(x,y,dir1, dir2, board, step));
            }
        }

        return unfilteredMoves;
    }

    public boolean isChecked() {
        return inCheck;
    }

    public void setCheckState(boolean inCheck) {
        this.inCheck = inCheck;
    }

}
