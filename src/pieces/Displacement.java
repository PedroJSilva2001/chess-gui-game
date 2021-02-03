package pieces;

public class Displacement {
        private Position startPosition;
        private Position endPosition;


        public Displacement(Position start, Position end) {
                this.startPosition = start;
                this.endPosition = end;
        }

        public Position getStart() {
                return startPosition;
        }

        public Position getEnd() {
                return endPosition;
        }
}
