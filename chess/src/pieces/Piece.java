package pieces;
import board.ChessBoard;
import pieceBehaviour.PieceBehaviour;

import java.util.Arrays;
import java.util.Vector;

public abstract class Piece implements PieceBehaviour {
    protected String colour;
    protected int x;
    protected int y;
    protected String name;

    public String getColour() {
        return colour;
    }

    public abstract Vector<Vector<Integer>>getMoves(ChessBoard board);

    Piece(int x, int y, String colour, String name) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.name = name;
    }
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
    public String getName() {
        return name;
    }



}
