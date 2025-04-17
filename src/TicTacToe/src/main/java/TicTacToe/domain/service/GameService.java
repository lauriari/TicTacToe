package TicTacToe.domain.service;

import TicTacToe.domain.model.GameBoard;

import java.util.UUID;

public interface GameService {
    UUID createNewGame();

    void saveGame(UUID uuid, GameBoard gameBoard);
    GameBoard loadGame(UUID uuid);
    GameBoard nextMove(UUID uuid);
    void validGame(UUID uuid, int curMove);
    boolean finishGame(GameBoard game);
}
