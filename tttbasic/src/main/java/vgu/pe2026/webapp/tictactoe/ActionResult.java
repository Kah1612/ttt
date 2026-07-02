package vgu.pe2026.webapp.tictactoe;

public class ActionResult {
    private String quockhanhStatus;
    private String quockhanhBoard;

    public ActionResult(String gameStatus, String boardState) {
        this.quockhanhStatus = gameStatus;
        this.quockhanhBoard = boardState;
    }

    public String getStatus() {
        return quockhanhStatus;
    }

    public String getBoardState() {
        return quockhanhBoard;
    }
}
