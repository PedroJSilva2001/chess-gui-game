package pieces;
import java.util.Vector;
import java.util.*;
import board.ChessBoard;
import pieceBehaviour.PieceBehaviour;
public class Bishop extends Piece implements PieceBehaviour {
    public Bishop(int x, int y, String colour) {
        super(x,y,colour, "bishop");
    }
    public int[][] moves1() {
        return new int[3][3];
    }

    public Vector<Vector<Integer>> getMoves(ChessBoard board) {
        Vector<Vector<Integer>> possibleMoves = new Vector<Vector<Integer>>();
        for (int dir1 = -1; dir1 <= 1; dir1+=2) {
            for (int dir2 = -1; dir2 <=1; dir2+=2) {
                getLongLine(x, y, dir1, dir2, board, possibleMoves);
            }
        }
        return possibleMoves;
    }


}
