package moveHistory;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest  {


    @Test
    void appendMove() {
        Move move1 = new Move(null, null,null );

        Move move2 = new Move(null, null,null );

        Move move3 = new Move(null, null,null );

        Move move4 = new Move(null, null,null );

        MoveHistory m = new MoveHistory();
        m.appendMove(move1);
        m.appendMove(move2);
        m.appendMove(move3);
        m.appendMove(move4);
        m.print();

    }


}