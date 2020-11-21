package pieces;
import board.ChessBoard;
import pieceBehaviour.PieceBehaviour;
import java.util.Vector;

public class Queen extends Piece implements PieceBehaviour{

    public Queen(int x, int y, String colour) {
        super(x,y,colour, "queen");
    }

    @Override
    public Vector<Vector<Integer>> getMoves(ChessBoard board) {
        Vector<Vector<Integer>> possibleMoves = new Vector<Vector<Integer>>();
        for (int dir1 = -1; dir1 <= 1; dir1++) {
            for (int dir2 = -1; dir2 <=1; dir2++) {
                if (dir1 == 0 && dir2 == 0) {
                    continue;
                }
                getLongLine(x,y,dir1, dir2, board, possibleMoves);
            }
        }
        return possibleMoves;
    }
}
