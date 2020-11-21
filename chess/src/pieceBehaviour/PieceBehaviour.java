package pieceBehaviour;

import board.ChessBoard;

import java.util.Vector;

public interface PieceBehaviour {
     default void getLongLine(int x, int y, int dir1, int dir2, ChessBoard board, Vector<Vector<Integer>> possibleMoves) {
        for (int step  = 1; step < 8 ; ++step) {
            Vector<Integer> move = new Vector<Integer>();
            if (board.positionOutBorders(x+step*dir1, y+step*dir2)) {
                break;
            }
            if (board.hasPiece(x+step*dir1, y+step*dir2)) {
                if (board.hasPieceSameColour(x + step * dir1, y + step * dir2, board.getPiece(x, y))) {   //capturar ppeça
                    break;
                }
            }
            move.add(x+step*dir1);
            move.add(y+step*dir2);
            possibleMoves.add(move);

            if (board.hasPiece(x+step*dir1, y+step*dir2)) {
                if (!board.hasPieceSameColour(x + step * dir1, y + step * dir2, board.getPiece(x, y))) {   //capturar ppeça
                    break;
                }
            }
        }
    }

    default Vector<Integer> getShortLine(int x, int y, int dir1, int dir2, ChessBoard board) {
        Vector<Integer> move = new Vector<Integer>();
        if (!board.positionOutBorders(x+dir1, y+dir2)) {
            move.add(x+dir1);
            move.add(y+dir2);
        }
        return move;
    }
}
