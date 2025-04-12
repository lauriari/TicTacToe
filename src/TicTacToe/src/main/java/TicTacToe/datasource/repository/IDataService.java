package TicTacToe.datasource.repository;

import TicTacToe.datasource.model.GameField;
import TicTacToe.domain.model.GameBoard;

import java.util.UUID;

public interface IDataService {
    void saveGame(UUID uuid, GameField field);
    GameField loadGame(UUID uuid);
}
