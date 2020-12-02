package pieces;
import board.ChessBoard;
import pieceBehaviour.PieceBehaviour;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest  {


    @Test
    void getDiagonal() {
        ChessBoard board = new ChessBoard();

        //suposto estar bloqueado por peças da mesma cor
        //Vector<Vector<Integer>> m1 = board.getPiece(4,7).getMoves(board);
        //assertEquals(0, m1.size());  //suposto estar bloqueado por peça da mesma cor

        board.setPiece(4,4, board.getPiece(4,7));
        board.removePiece(0,7);
        //Vector<Vector<Integer>> m2 = board.getPiece(4,4).getMoves(board);
        //assertEquals(19, m2.size());


    }

    @Test
    void getLine() {
    }

    @Test
    void getMoves() {
    }
}