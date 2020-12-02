package moveHistory;

public class MoveHistory {
    private Move firstMove;
    private Move lastMove;
    private Move current;
    private int moveNumber;
    public static int i = 0;

    public MoveHistory() {
        firstMove = null;
        lastMove = null;
        current  = null;
        moveNumber = 0;
    }

    public Move getCurrent() {
        return current;
    }

    public void print() {
        Move curr = firstMove;
        while(curr != null) {
            System.out.println(i);
            curr = curr.getNextMove();
            i++;
        }
    }

    public void appendMove(Move move) {
        switch (moveNumber) {
            case 0: {
                firstMove = move;
                lastMove = firstMove;
                break;
            }
            case 1: {
                firstMove.setNextMove(move);
                move.setPreviousMove(firstMove);
                lastMove = move;
                break;
            }
            default: {
                lastMove.setNextMove(move);
                move.setPreviousMove(lastMove);
                lastMove = move;
            }
        }
        current = lastMove;
        moveNumber++;
    }

    public boolean setCurrent(boolean backwards){
        if (backwards && isNotFirstMove()) {
            current = current.getPreviousMove();
            return true;
        }
        else if(!backwards && isNotLastMove()) {
            current = current.getNextMove();
            return true;
        }
        return false;
    }

    private boolean isNotFirstMove() {
        return current.getPreviousMove() != null;
    }


    private boolean isNotLastMove() {
        return current.getNextMove() != null;
    }

}
