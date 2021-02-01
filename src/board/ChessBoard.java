package board;

import pieces.*;

public class ChessBoard {

        Piece[][] board = new Piece[8][8];    //null pieces

        public boolean hasPiece(int x, int y) {
                return !board[x][y].getColour().equals("blank");
        }

        public boolean hasPieceSameColour(int x, int y, String colour) {
                return board[x][y].getColour().equals(colour);
        }

        public Piece[][] getBoard() {
                return board;
        }

        public void setPiece(int x, int y, Piece piece) {
                board[x][y] = piece;
                piece.setPosition(x, y);
        }

        public void removePiece(int x, int y) {
                board[x][y] = new Pawn(x, y, "empty");
        }

        public void setPiece(Position pos, Piece piece) {
                board[pos.getX()][pos.getY()] = piece;
                piece.setPosition(pos.getX(), pos.getY());
        }

        public void removePiece(Position pos) {
                board[pos.getX()][pos.getY()] =
                        new Pawn(pos.getX(), pos.getY(), "empty");
        }

        public boolean positionOutBorders(int x, int y) {
                return  x > 7 || x < 0 || y > 7 || y < 0;
        }

        public ChessBoard() {
                for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                                board[i][j] = new Pawn(i, j, "empty");
                        }
                }

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

                for (int x = 0; x < 8; x++) {
                    board[x][1] = new Pawn(x,1, "black");
                    board[x][6] = new Pawn(x,6, "white");
                }
        }

        public Piece getPiece(int x, int y) {
                return board[x][y];
        }

        public Piece getPiece(Position pos) {
                return board[pos.getX()][pos.getY()];
        }


}
