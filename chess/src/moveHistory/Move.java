package moveHistory;

import pieces.Piece;
import pieces.Position;

import java.util.Iterator;
import java.util.LinkedList;

public class Move {
    private Position startPosition;
    private Position endPosition;
    private Piece taken;
    private Move previous;
    private Move next;

    Move(Position startPosition, Position endPosition, Piece taken) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.taken = taken;
        previous = null;
        next = null;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public Piece getTaken() {
        return taken;
    }

    public Move getPreviousMove() {
        return previous;
    }

    public  Move getNextMove() {
        return next;

    }

    public void setNextMove(Move next) {
        this.next = next;
    }

    public void setPreviousMove(Move previous) {
        this.previous = previous;
    }
}
