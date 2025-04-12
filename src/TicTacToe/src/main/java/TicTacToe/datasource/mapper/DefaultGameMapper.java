package TicTacToe.datasource.mapper;

import TicTacToe.datasource.model.GameField;
import TicTacToe.domain.model.GameBoard;

public class DefaultGameMapper implements GameMapper{
    @Override
    public GameBoard fieldToBoard (GameField field){
        GameBoard board = new GameBoard();
        for (int i = 0; i < 9; i++){
            board.setBoard(i / 3, i % 3, field.getData(i));
        }
        return board;
    }
    @Override
    public GameField boardToField (GameBoard board){
        GameField field = new GameField();
        for (int i = 0; i < 9; i++){
            field.setData(i, board.getBoard(i / 3, i % 3));
        }
        return field;
    }
}
