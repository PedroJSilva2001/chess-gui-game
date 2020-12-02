package pieceBehaviour;

import board.ChessBoard;

import java.util.Vector;
import pieces.Piece;
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

    default Vector<Integer> getShortLine(int x, int y,int step, int dir1, int dir2, ChessBoard board) {
       //  boolean isPawn = board.getBoard()[x][y].getName().equals("pawn");
     //    boolean hasntMoved

        Vector<Integer> move = new Vector<Integer>();
        if (!board.positionOutBorders(x+dir1*step, y+dir2*step)) {
            if (board.getPiece(x+dir1*step, y+dir2*step).getColour().equals(board.getPiece(x,y).getColour())) {
                 if(board.getPiece(x+dir1*step, y+dir2*step).getName().equals("rook")
                         && board.getPiece(x,y).getName().equals("king")) {

                 }
            }
            move.add(x+dir1);
            move.add(y+dir2);
         }
         return move;
    }
}
