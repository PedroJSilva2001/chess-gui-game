package pieces;

import board.ChessBoard;
import java.util.ArrayList;

import moveHistory.EnPassant;
import moveHistory.Move;
import moveHistory.MoveType;
import moveHistory.Promotion;

public class Pawn extends Piece {

        private boolean hasMoved;

        private boolean passing;

        public Pawn(int x, int y, String colour) {
                super(x, y, colour);
                hasMoved = false;
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
                int step = !hasMoved? 2:1;
                int dir = colour.equals("black")? 1:-1;
                ArrayList<Position> unfilteredMoves = new ArrayList<>();

                if (canCapture(x, isBlack()? y+1 : y-1, board) == -1)
                        unfilteredMoves.add(new Position(x, isBlack()? y+1 : y-1));

                if (!hasMoved && canCapture(x, isBlack()? y+2 : y-2, board) == -1)
                        unfilteredMoves.add(new Position(x, isBlack()? y+2 : y-2));

                hasMoved = true;
                return unfilteredMoves;
        }

        public void setState(boolean state) {
                hasMoved = state;
        }

        /*private Move getEnPassant(ChessBoard board) {
                int newX = -1;

                if (canCaptureEnPassant(true, board)) newX = x-1;

                else if (canCaptureEnPassant(false, board)) newX = x+1;

                if (newX == -1) return null;

                Position startPosition = new Position(x, y);
                Position endPosition = new Position(newX, isBlack()? y+1 : y-1);
                Position capturedStartPosition = new Position(newX, isBlack()? y-2 : y+2);
                Position capturedEndPosition = new Position(newX, y);
                Displacement path = new Displacement(startPosition,endPosition);
                Displacement capturedPath = new Displacement(capturedStartPosition, capturedEndPosition);
                Piece captured = board.getPiece(capturedEndPosition);

                return new EnPassant(path, capturedPath, this, captured);

        }*/
        private Move getEnPassant(boolean left, ChessBoard board) {
                int newX = left? x-1: x+1;
                Position startPosition = new Position(x, y);
                Position endPosition = new Position(newX, isBlack()? y+1 : y-1);
                Position capturedStartPosition = new Position(newX, isBlack()? y-2 : y+2);
                Position capturedEndPosition = new Position(newX, y);
                Displacement path = new Displacement(startPosition,endPosition);
                Displacement capturedPath = new Displacement(capturedStartPosition, capturedEndPosition);
                Piece captured = board.getPiece(capturedEndPosition);
                return new EnPassant(path, capturedPath, this, captured);
        }


        private boolean inFifthRank() {
                return (colour.equals("white") && y == 3) ||
                        (colour.equals("black") && y == 4);
        }

        private boolean canCaptureEnPassant(boolean left, ChessBoard board) {
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

        @Override
        public ArrayList<Move> getValidMoves(ChessBoard board) {
                ArrayList<Move> validMoves = new ArrayList<>();
//nao esquecer do rei: se anda para a frente e podera ficar em check
                //Move enPassant = getEnPassant(board);
                //if (enPassant != null) validMoves.add(enPassant);
                if (canCaptureEnPassant(true, board))
                        validMoves.add(getEnPassant(true, board));

                else if (canCaptureEnPassant(false, board))
                        validMoves.add(getEnPassant(false, board));

                return validMoves;
        }

        @Override
        protected ArrayList<Move> filterMoves(ChessBoard board) {
                ArrayList<Move> filteredMoves = new ArrayList<>();
                return filteredMoves;
        }

        private Move getPromotion(ChessBoard board) {
                Position startPosition = new Position(x, y);
                Position endPosition = new Position(x, isBlack()? 7 : 0);
                Displacement path = new Displacement(startPosition, endPosition);
                Piece promoted = promote("queen");
                if (canPromote(board)) return new Promotion(path, this, promoted);
                return null;
        }

        private boolean canPromote(ChessBoard board) {
                return (colour.equals("white") && y == 1 && canCapture(x,0, board) == -1)
                        || (colour.equals("black") && y == 6 && canCapture(x, 7, board) == -1) ;
        }


}