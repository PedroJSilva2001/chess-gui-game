package pieces;
import java.util.Vector;
import java.util.*;
import board.ChessBoard;
import pieceBehaviour.PieceBehaviour;
import pieceMovement.PieceMovement;

public class Bishop extends Piece{

    public Bishop(int x, int y, String colour) {
        super(x,y,colour, "bishop");
    }


    public ArrayList<Position> getUnfilteredMoves(ChessBoard board) {
        ArrayList<Position> unfilteredMoves = new ArrayList<>();
        int step = 8;
        for (int dir1 = -1; dir1 <= 1; dir1+=2) {
            for (int dir2 = -1; dir2 <=1; dir2+=2) {
                unfilteredMoves.addAll(PieceMovement.getLine(x, y, dir1, dir2, board, step));
            }
        }
        return unfilteredMoves;
    }


}
