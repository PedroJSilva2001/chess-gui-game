package pieces;

import board.ChessBoard;
import pieceBehaviour.PieceBehaviour;

import java.util.Vector;

public class Pawn extends Piece implements PieceBehaviour {
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
    public Vector<Vector<Integer>> getMoves(ChessBoard board) {

        Vector<Vector<Integer>> possibleMoves = new Vector<Vector<Integer>>();
        Vector<Integer> move = getShortLine(x,y,)

        return possibleMoves;
    }
}
