package vgu.pe2026.webapp.tictactoe;

public class PlayingField {
    public static final int EMPTY_CELL = 0;
    public static final int HUMAN_MARK = 1;
    public static final int BOT_MARK = 2;

    private int[] grid;

    public PlayingField() {
        grid = new int[9];
        for (int i = 0; i < 9; i++) {
            grid[i] = EMPTY_CELL;
        }
    }

    public static PlayingField parseState(String stateString) {
        if (stateString == null || stateString.length() != 9) {
            throw new IllegalArgumentException("Invalid state string length.");
        }
        PlayingField field = new PlayingField();
        for (int i = 0; i < 9; i++) {
            char c = stateString.charAt(i);
            if (c >= '0' && c <= '2') {
                field.grid[i] = c - '0';
            } else {
                throw new IllegalArgumentException("Invalid character in state string.");
            }
        }
        return field;
    }

    public String exportState() {
        StringBuilder sb = new StringBuilder(9);
        for (int i = 0; i < 9; i++) {
            sb.append(grid[i]);
        }
        return sb.toString();
    }

    public boolean checkMoveValidity(int position) {
        if (position < 1 || position > 9) return false;
        return grid[position - 1] == EMPTY_CELL;
    }

    public void markCell(int position, int playerType) {
        if (checkMoveValidity(position)) {
            grid[position - 1] = playerType;
        }
    }

    public boolean checkWinCondition(int playerType) {
        int[][] winLines = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };
        for (int[] line : winLines) {
            if (grid[line[0]] == playerType &&
                grid[line[1]] == playerType &&
                grid[line[2]] == playerType) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDrawCondition() {
        for (int cell : grid) {
            if (cell == EMPTY_CELL) return false;
        }
        return true;
    }

    public int findNextAvailable() {
        for (int i = 0; i < 9; i++) {
            if (grid[i] == EMPTY_CELL) {
                return i + 1;
            }
        }
        return -1;
    }
}
