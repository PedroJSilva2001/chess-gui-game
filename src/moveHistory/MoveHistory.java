package moveHistory;

/**
 * Keeps a register of all moves in a match in a doubly-linked list
 */
public class MoveHistory {

        /**
         * The first move in a match
         */
        private Move firstMove;

        /**
         * The last move in a match
         */
        private Move lastMove;

        /**
         * The selected move (the one the player is currently on)
         */
        private Move current;

        /**
         * The number of moves in a match
         */
        private int moveNumber;

        public static int i = 0;

        /**
         *  The constructor of the move history
         */
        public MoveHistory() {
                firstMove = null;
                lastMove = null;
                current  = null;
                moveNumber = 0;
        }

        /**
         * @return Returns the current move the player is on
         */
        public Move getCurrent() {
                return current;
        }

        /**
         *  Sets the current to the one before or after
         *
         * @param boolean backwards True if the player is traversing backwards, False otherwise
         *
         * @return Returns True if they traverse the history, False otherwise
         */
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



        public void print() {
            Move curr = firstMove;
            while(curr != null) {
                System.out.println(i);
                curr = curr.getNextMove();
                i++;
            }
        }

        /**
         *  Appends to the end of the history a new move
         *
         * @param Move move The new move to append
         */
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

        /**
         * @return Returns True if the player can go backwards (if he has not reached the beginning), False otherwise
         */
        private boolean isNotFirstMove() {
                return current.getPreviousMove() != null;
        }

        /**
         *
         * @return Returns True if the player can go forwards (if he has not reached the end), False otherwise
         */
        private boolean isNotLastMove() {
                return current.getNextMove() != null;
        }

        /**
         * Deletes all moves after the current selected one
         *
         * @return Returns True if any moves were deleted, False otherwise
         */
        public boolean clearForwardMoves() {
                Move temp = current.getNextMove();
                boolean willClear = temp != null;

                while (temp != null) {
                    moveNumber--;
                    temp = temp.getNextMove();
                }

                current.setNextMove(null);
                return willClear;
        }

}
