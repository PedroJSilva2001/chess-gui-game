package pieces;

public class Position {

        private int x;

        private int y;

        /**
         * The constructor of the position
         *
         * @param int x value of position
         * @param int y value of position
         */
        public Position(int x, int y) {
                setPosition(x,y);
        }

        /**
         * @return Returns x value of position
         */
        public int getX() {
                return x;
        }

        /**
         * @return Returns y value of position
         */
        public int getY() {
                return y;
        }

        /**
         *  Sets the new position
         *
         * @param int x value of position
         * @param int y value of position
         */
        public void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
        }

        public String getString() {
                //StringBuilder s = new StringBuilder().append((char)('a' + x)).append((char)(8 - y));
                //return s.toString();
                return String.valueOf((char) ('a' + x)) + (char) (8 - y);
        }

        public void setX(int x) {
                this.x = x;
        }

        public void setY(int y) {
                this.y = y;
        }
}
