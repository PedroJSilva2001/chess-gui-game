package pieces;
import board.ChessBoard;
import pieceBehaviour.PieceBehaviour;
import pieceMovement.PieceMovement;

import java.util.Arrays;
import java.util.Vector;
import java.util.ArrayList;

public abstract class Piece implements PieceBehaviour {
    protected String colour;
    protected int x;
    protected int y;
    protected String name;
    protected boolean selected;
    protected ArrayList<Position> positionHistory;

    public String getColour() {
        return colour;
    }

    public abstract ArrayList<Position> getUnfilteredMoves(ChessBoard board);

    Piece(int x, int y, String colour, String name) {
        setPosition(x,y);
        this.colour = colour;
        this.name = name;
        this.selected = false;
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

    public boolean isSelected() {
        return selected;
    }

    public void updatePositionHistory() {
        positionHistory.add(new Position(x,y));
    }

    public ArrayList<Position> getPositionHistory() {
        return positionHistory;
    }


}
