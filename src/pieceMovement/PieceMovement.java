package pieceMovement;

import board.ChessBoard;
import pieces.Position;
import java.util.ArrayList;
import java.util.Collections;

public class PieceMovement {
    
        public static boolean canCapture(int x, int y, int newX, int newY, ChessBoard board) {
                return !board.hasPieceSameColour(newX, newY, board.getPiece(x, y));
        }

        public static ArrayList<Position> getLine(int x, int y, int dir1, int dir2, ChessBoard board, int step) {
                ArrayList<Position> possibleMoves = new ArrayList<>();

                for (int i = 1; i < step; ++i) {
                    int newX = x + i*dir1;
                    int newY = y + i*dir2;

                    if (board.positionOutBorders(newX, newY)) break;

                    if (board.hasPiece(newX, newY)) {
                        //ser bloqueado por uma peça da mesma cor
                        if (!canCapture(x, y, newX, newY, board)) break;
                    }

                    possibleMoves.add(new Position(x, y));

                    if (board.hasPiece(newX, newY)) {
                        //o movimento é bloqueado quando se encontra uma peça que se consegue capturar
                        if (canCapture(x, y, newX, newY, board)) break;
                    }
                }

                return possibleMoves;
        }

        static ArrayList<Integer> getShortLine(int x, int y, int step, int dir1, int dir2, ChessBoard board) {
                int newX = x + step*dir1;
                int newY = y + step*dir2;
                ArrayList<Integer> move = new ArrayList<>();
                if (!board.positionOutBorders(newX, newY)) {
                    Collections.addAll(move, newX, newY);
                }
                return move;
        }
}
