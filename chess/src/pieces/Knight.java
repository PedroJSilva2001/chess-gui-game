package pieces;

import board.ChessBoard;

import java.util.ArrayList;
import pieceMovement.PieceMovement;

public class Knight extends Piece {
    public Knight(int x, int y, String colour) {
        super(x,y,colour, "knight");
    }

    @Override
    public ArrayList<Position> getUnfilteredMoves(ChessBoard board) {
        ArrayList<Position> unfilteredMoves = new ArrayList<>();
        return null;
    }
}
