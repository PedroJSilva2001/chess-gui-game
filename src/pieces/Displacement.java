package pieces;

public class Displacement {
        private Position startPosition;
        private Position endPosition;


        public Displacement(Position start, Position end) {
                this.startPosition = start;
                this.endPosition = end;
        }

        Position getStart() {
                return startPosition;
        }

        Position getEnd() {
                return endPosition;
        }
}
