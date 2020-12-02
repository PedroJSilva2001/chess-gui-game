package pieces;

import board.ChessBoard;
import pieceBehaviour.PieceBehaviour;

import java.util.ArrayList;
import java.util.Vector;

public class Pawn extends Piece {

    private boolean hasntMoved;

    public Pawn(int x, int y, String colour) {
        super(x,y,colour, "pawn");
        hasntMoved = true;
    }

    public Piece promote(String promotion) {
        return switch (promotion) {
            case "rook" -> new Rook(this.getX(), this.getY(), this.getColour());
            case "bishop" -> new Bishop(this.getX(), this.getY(), this.getColour());
            case "queen" -> new Queen(this.getX(), this.getY(), this.getColour());
            case "knight" -> new Knight(this.getX(), this.getY(), this.getColour());
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
}
