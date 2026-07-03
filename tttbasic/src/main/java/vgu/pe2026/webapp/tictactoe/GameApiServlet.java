package vgu.pe2026.webapp.tictactoe;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "GameApiServlet", value = "/api/quockhanh/play")
public class GameApiServlet extends HttpServlet {
    private static final Gson GSON_MAPPER = new Gson();
    private static final AIPlayer BOT = new AIPlayer();

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        applyCors(resp);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        applyCors(resp);
        String payload = new String(req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        PlayerAction action = GSON_MAPPER.fromJson(payload, PlayerAction.class);
        
        ActionResult result = processPlayerAction(action);
        
        String jsonOut = GSON_MAPPER.toJson(result);
        byte[] outBytes = jsonOut.getBytes(StandardCharsets.UTF_8);
        
        resp.setContentType("application/json; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentLength(outBytes.length);
        resp.getOutputStream().write(outBytes);
    }

    private void applyCors(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }

    private ActionResult processPlayerAction(PlayerAction action) {
        PlayingField field;
        try {
            field = PlayingField.parseState(action.getBoardState());
        } catch (IllegalArgumentException e) {
            return new ActionResult("invalid", "000000000");
        }

        if (!field.checkMoveValidity(action.getActionIndex())) {
            return new ActionResult("invalid", field.exportState());
        }

        field.markCell(action.getActionIndex(), PlayingField.HUMAN_MARK);
        if (field.checkWinCondition(PlayingField.HUMAN_MARK)) return new ActionResult("win", field.exportState());
        if (field.checkDrawCondition()) return new ActionResult("draw", field.exportState());

        int botChoice = BOT.decideMove(field);
        if (botChoice != -1) {
            field.markCell(botChoice, PlayingField.BOT_MARK);
        }

        if (field.checkWinCondition(PlayingField.BOT_MARK)) return new ActionResult("lose", field.exportState());
        if (field.checkDrawCondition()) return new ActionResult("draw", field.exportState());

        return new ActionResult("ongoing", field.exportState());
    }
}
