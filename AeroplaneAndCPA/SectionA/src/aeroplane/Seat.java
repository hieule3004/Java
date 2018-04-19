package aeroplane;

import java.util.NoSuchElementException;

public class Seat {

	// TODO: Section A, Tasks 1 and 3

    private final int row;
    private final char letter;

    public static final int FIRST_ROW = 1;
    public static final int LAST_ROW = 50;
    public static final char FIRST_LETTER = 'A';
    public static final char LAST_LETTER = 'F';
    public static final Seat FIRST_SEAT = new Seat(1, 'A');
    public static final Seat LAST_SEAT = new Seat(50, 'F');

    public Seat(int row, char letter) {
        assert row >= FIRST_ROW && row <= LAST_ROW: "Row: 1-50";
        assert letter >= FIRST_LETTER && letter <= LAST_LETTER: "Letter: A-F";
        this.row = row;
        this.letter = letter;
    }

    public int getRow() {
        return row;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return Integer.toString(row) + Character.toString(letter);
    }

    public boolean isEmergencyExit() {
        return row == 1 || row == 10 || row == 30;
    }

    public boolean hasNext() {
        return !equals(LAST_SEAT);
    }

    public Seat next() {
        if (letter == LAST_LETTER) {
            if (row == LAST_ROW) {
                throw new NoSuchElementException("Last seat has no next");
            }
            return new Seat(row + 1, FIRST_LETTER);
        }
        return new Seat(row, (char) (letter + 1));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) obj;
        return row == other.getRow() && letter == other.getLetter();
    }

    @Override
    public int hashCode() {
        return letter * 100 + row;
    }
}
