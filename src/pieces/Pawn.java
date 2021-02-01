package pieces;

import board.ChessBoard;
import java.util.ArrayList;

import moveHistory.EnPassant;
import moveHistory.Move;
import moveHistory.MoveType;

public class Pawn extends Piece {

        private boolean hasntMoved;

        private boolean passing;

        public Pawn(int x, int y, String colour) {
                super(x, y, colour);
                hasntMoved = true;
                passing = false;
        }

        public Piece promote(String promotion) {
                return switch (promotion) {
                    case "rook" -> new Rook(x, y, colour);
                    case "bishop" -> new Bishop(x, y, colour);
                    case "queen" -> new Queen(x, y, colour);
                    case "knight" -> new Knight(x, y, colour);
                    default -> throw new IllegalStateException("Unexpected value: " + promotion);
                };
        }

        @Override
        public ArrayList<Position> getUnfilteredMoves(ChessBoard board) {
                int step = hasntMoved? 2:1;
                int dir = colour.equals("black")? 1:-1;
                ArrayList<Position> unfilteredMoves = new ArrayList<>();

                return unfilteredMoves;
        }

        public void setState(boolean state) {
                hasntMoved = state;
        }

        private ArrayList<Move> enPassant(ChessBoard board) {
                ArrayList<Move> moves = new ArrayList<>();
                Position startPosition = new Position(x, y);
                Position endPositionLeft = new Position(x-1, isBlack()? y-1 : y+1);
                Position endPositionRight = new Position(x+1, isBlack()? y-1 : y+1);
                Position pawnPositionLeft = new Position(x-1, y);
                Position pawnPositionRight = new Position(x+1, y);

                if (captureEnPassant(true, board))
                        moves.add(new EnPassant(startPosition, endPositionLeft,
                                this, board.getPiece(pawnPositionLeft)));
                if (captureEnPassant(false, board))
                        moves.add(new EnPassant(startPosition, endPositionRight,
                                this, board.getPiece(pawnPositionRight)));
                return moves;
        }

        private boolean inFifthRank() {
                return (colour.equals("white") && y == 3) ||
                        (colour.equals("black") && y == 4);
        }

        private boolean captureEnPassant(boolean left, ChessBoard board) {
                if (!inFifthRank()) return false;

                int newX = left ? x-1: x+1;

                if (board.positionOutBorders(newX, y)) return false;

                if (canCapture(newX, y, board) == 1 &&
                        (board.getPiece(newX, y) instanceof Pawn))
                        return ((Pawn) board.getPiece(newX, y)).isPassing();

                return false;
        }

        public boolean isPassing() {
                return passing;
        }

        public void setPassingState(boolean passing) {
                this.passing = passing;
        }

}