package pieces;
import board.ChessBoard;
import moveHistory.Move;
import pieceBehaviour.PieceBehaviour;
import java.util.ArrayList;

public abstract class Piece implements PieceBehaviour {

        protected String colour;

        protected int x;

        protected int y;

        private boolean selected;

        private ArrayList<Position> positionHistory;


        Piece(int x, int y, String colour) {
                setPosition(x,y);
                this.colour = colour;
                this.selected = false;
        }

        public String getColour() {
                return colour;
        }

        public abstract ArrayList<Position> getUnfilteredMoves(ChessBoard board);
        //public abstract ArrayList<Position> getMoves(ChessBoard board);



        public int getX() {
                return x;
        }

        public int getY() {
                return y;
        }

        public void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
        }

        public boolean isSelected() {
                return selected;
        }

        public void setSelectState(boolean selected) {
                this.selected = selected;
        }

        public void updatePositionHistory() {
                positionHistory.add(new Position(x,y));
        }

        public ArrayList<Position> getPositionHistory() {
                return positionHistory;
        }

        protected int canCapture(int x, int y, ChessBoard board) {
                //return !board.hasPieceSameColour(x, y, colour);
                if (!board.hasPiece(x, y)) return -1;
                if (board.hasPieceSameColour(x, y, colour)) return 0;
                return 1;

        }

        public ArrayList<Position> getLine(int dir1, int dir2, ChessBoard board, int step) {
                ArrayList<Position> possibleMoves = new ArrayList<>();

                for (int i = 1; i < step; ++i) {
                        int newX = x + i*dir1;
                        int newY = y + i*dir2;

                        if (board.positionOutBorders(newX, newY)) break;

                        /*if (board.hasPiece(newX, newY)) {
                                //ser bloqueado por uma peça da mesma cor
                                if (!canCapture(newX, newY, board)) break;
                        }*/
                        if (canCapture(newX, newY, board) == 0) break;

                        possibleMoves.add(new Position(newX, newY));

                        /*if (board.hasPiece(newX, newY)) {
                                //o movimento é bloqueado quando se encontra uma peça que se consegue capturar
                                if (canCapture(newX, newY, board)) break;
                        }*/

                        if (canCapture(newX, newY, board) == 1) break;
                }

                return possibleMoves;
        }

        public boolean isBlack() {
                return colour.equals("black");
        }

        public abstract ArrayList<Move> getValidMoves(ChessBoard board);

        protected abstract ArrayList<Move> filterMoves(ChessBoard board);


}
