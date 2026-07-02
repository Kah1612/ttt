package vgu.pe2026.webapp.tictactoe;

public class AIPlayer {
    public int decideMove(PlayingField field) {
        return field.findNextAvailable();
    }
}
