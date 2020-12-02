package board;

import pieces.*;
import pieces.Piece.*;

import java.util.Arrays;
public class ChessBoard {
    Piece[][] board = new Piece[8][8];    //null pieces

    public boolean hasPiece(int x, int y) {
        return board[x][y] != null;
    }

    public boolean hasPieceSameColour(int x, int y, Piece piece) {
        return board[x][y].getColour().equals(piece.getColour());
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setPiece(int x, int y, Piece piece) {
        board[x][y] = piece;
        piece.setPosition(x,y);
    }

    public void removePiece(int x, int y) {
        board[x][y] = null;
    }

    public boolean positionOutBorders(int x, int y) {
        return  x > 7 || x < 0 || y > 7 || y < 0;
    }

    public ChessBoard() {
        board[0][7] = new Rook(0,7, "white");
        board[1][7] = new Knight(1,7, "white");
        board[2][7] = new Bishop(2,7, "white");
        board[3][7] = new King(3,7,"white");
        board[4][7] = new Queen(4, 7, "white");
        board[5][7] = new Bishop(5, 7, "white");
        board[6][7] = new Knight(6, 7, "white");
        board[7][7] = new Rook(7, 7, "white");


        board[0][0] = new Rook(0,0, "black");
        board[1][0] = new Knight(1,0, "black");
        board[2][0] = new Bishop(2,0, "black");
        board[3][0] = new King(3,0,"black");
        board[4][0] = new Queen(4, 0, "black");
        board[5][0] = new Bishop(5, 0, "black");
        board[6][0] = new Knight(6, 0, "black");
        board[7][0] = new Rook(7, 0, "black");

        for (int x = 0; x <8; x++) {
            board[x][1] = new Pawn(x,1, "black");
            board[x][6] = new Pawn(x,6, "white");
        }
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }


}
