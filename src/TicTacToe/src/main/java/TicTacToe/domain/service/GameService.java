package TicTacToe.domain.service;

import TicTacToe.domain.model.GameBoard;

import java.util.UUID;

public interface GameService {
    UUID createNewGame();

    void saveGame(UUID uuid, GameBoard gameBoard);
    GameBoard nextMove(UUID uuid);
    void validGame(UUID uuid, GameBoard newMove);
    boolean finishGame(GameBoard game);
}
