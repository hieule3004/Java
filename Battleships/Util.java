import java.util.Arrays;

public class Util {

    public static final char FIRST_LETTER = 'A';
    public static final char LAST_LETTER = 'Z';
    public static final char FIRST_DIGIT = '0';
    public static final char LAST_DIGIT = '9';

    private static boolean isLetter(char letter) {
        return letter >= FIRST_LETTER && letter <= LAST_LETTER;
    }

    private static int letterToIndex(char letter) {
        //return -1; // TODO delete this line for Question 1a.
        assert isLetter(letter): "Capital alphabetic letter";
        return letter - FIRST_LETTER;
    }

    private static boolean isDigit(char number) {
        return number >= FIRST_DIGIT && number <= LAST_DIGIT;
    }

    private static int numberToIndex(char number) {
        //return -1; // TODO: delete this line for Question 1b.
        assert isDigit(number): "Digit character";
        return number - FIRST_DIGIT;
    }

    public static Coordinate parseCoordinate(String s) {
        //return null; // TODO: delete this line for Question 1c.
        assert s.length() == 2: "Wrong input format";
        return new Coordinate(letterToIndex(s.charAt(0)), numberToIndex(s.charAt(1)));
    }

    public static Piece hideShip(Piece piece) {
        //return null; // TODO: delete this line for Question 1d.
        return piece.equals(Piece.SHIP) ? Piece.WATER : piece;
    }

    public static void hideShips(Piece[][] grid) {
        // TODO: Question 1e.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = hideShip(grid[i][j]);
            }
        }
    }

    public static Piece[][] deepClone(Piece[][] input) {
        Piece[][] output = new Piece[input.length][];
        for (int i = 0; i < input.length; i++) {
            output[i] = Arrays.copyOf(input[i], input[i].length);
        }
        return output;
    }
}
