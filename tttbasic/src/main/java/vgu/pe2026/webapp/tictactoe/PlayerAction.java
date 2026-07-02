package vgu.pe2026.webapp.tictactoe;

public class PlayerAction {
    private String quockhanhBoard;
    private int quockhanhMove;

    public PlayerAction(String boardState, int actionIndex) {
        this.quockhanhBoard = boardState;
        this.quockhanhMove = actionIndex;
    }

    public String getBoardState() {
        return quockhanhBoard;
    }

    public int getActionIndex() {
        return quockhanhMove;
    }
}
