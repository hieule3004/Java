public class Grid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Piece[][] grid = new Piece[HEIGHT][WIDTH];

    private int numShips = 0;

    public Grid() {
        // TODO: Question 2a.
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = Piece.WATER;
            }
        }
    }

    public boolean canPlace(Coordinate c, int size, boolean isDown) {
        //return false; // TODO: delete this line for Question 2b.
        int x = c.getRow();
        int y = c.getColumn();
        if (isDown) {
            for (int i = 0; i < size; i++) {
                if (x + i >= HEIGHT || grid[x + i][y] != Piece.WATER) {
                    return false;
                }
            }
        } else {
            for (int j = 0; j < size; j++) {
                if (y + j >= WIDTH || grid[x][y + j] != Piece.WATER) {
                    return false;
                }
            }
        }
        return true;
    }

    public void placeShip(Coordinate c, int size, boolean isDown) {
        // TODO: Question 2c.
        if (canPlace(c, size, isDown)) {
            int x = c.getRow();
            int y = c.getColumn();
            if (isDown) {
                for (int i = 0; i < size; i++) {
                    grid[x + i][y] = Piece.SHIP;
                }
            } else {
                for (int j = 0; j < size; j++) {
                    grid[x][y + j] = Piece.SHIP;
                }
            }
        }
        numShips++;
    }

    public boolean wouldAttackSucceed(Coordinate c) {
        //return false; // TODO: delete this line for Question 3a.
        return grid[c.getRow()][c.getColumn()] == Piece.SHIP;
    }

    public void attackCell(Coordinate c) {
        // TODO: Question 3b.
        if (wouldAttackSucceed(c)) {
            grid[c.getRow()][c.getColumn()] = Piece.DAMAGED_SHIP;
            numShips--;
            Main.printHitMessage();
        } else {
            grid[c.getRow()][c.getColumn()] = Piece.MISS;
        }
    }

    public boolean areAllSunk() {
        //return false; // TODO: delete this line for Question 3c.
        return numShips == 0;
    }

    public static boolean isShipPiece(Piece piece) {
        return piece == Piece.SHIP || piece == Piece.DAMAGED_SHIP;
    }

    public String toPlayerString() {
        //return null; // TODO: delete this line for Question 4.
        boolean isDown, isDamaged;
        isDown = false; isDamaged = false;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (isShipPiece(grid[i][j])) {
                    if (isShipPiece(grid[i + 1][j])) {
                        isDown = true;
                    }
                    if (isDown) {
                        for (int c = i; isShipPiece(grid[c][j]); c++) {
                            if (grid[c][j] == Piece.DAMAGED_SHIP) {
                                isDamaged = true;
                            }
                        }
                        if (isDamaged) {
                            for (int c = i; isShipPiece(grid[c][j]); c++) {
                                grid[c][j] = Piece.DAMAGED_SHIP;
                            }
                        }
                    } else {
                        for (int c = j; isShipPiece(grid[i][c]); c++) {
                            if (grid[i][c] == Piece.DAMAGED_SHIP) {
                                isDamaged = true;
                            }
                        }
                        if (isDamaged) {
                            for (int c = j; isShipPiece(grid[i][c]); c++) {
                                grid[i][c] = Piece.DAMAGED_SHIP;
                            }
                        }
                    }
                }
            }
        }
        Piece[][] newGrid = Util.deepClone(grid);
        Util.hideShips(newGrid);
        return newGrid.toString();
    }

    @Override
    public String toString() {
        return renderGrid(grid);
    }

    private static String renderGrid(Piece[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 0123456789\n");
        for (int i = 0; i < grid.length; i++) {
            sb.append((char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    return "!";
                }
                switch (grid[i][j]) {
                case SHIP:
                    sb.append('#');
                    break;
                case DAMAGED_SHIP:
                    sb.append('*');
                    break;
                case MISS:
                    sb.append('o');
                    break;
                case WATER:
                    sb.append('.');
                    break;
                }

            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
