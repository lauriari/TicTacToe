package TicTacToe.datasource.mapper;

import TicTacToe.datasource.model.GameField;
import TicTacToe.domain.model.GameBoard;

public interface GameMapper {
    GameBoard fieldToBoard (GameField field);
    GameField boardToField (GameBoard board);
}
