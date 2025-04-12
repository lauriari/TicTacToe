package TicTacToe.web.mapper;

import TicTacToe.domain.model.GameBoard;
import TicTacToe.web.model.Button;

import java.util.UUID;

public class Adapter {
    private Adapter() {
    }
    public enum BoardCondition {
        EMPTY(" "),
        PLAYER_X("X"),
        PLAYER_O("O");
        private final String symbol;
        BoardCondition(String symbol) {
            this.symbol = symbol;
        }
        public String getSymbol() {
            return symbol;
        }
    }
    public static void boardToButton(GameBoard gameBoard, Button[] button) {
        for (int i = 0; i < 9; i++) {
            button[i].setText(BoardCondition.values()[gameBoard.getBoard(i % 3, i / 3)].getSymbol());
        }
    }
    public static void buttonToBoard(Button[] button, GameBoard gameBoard) {
        for (int i = 0; i < 9; i++){
            for (int j = 0; j <= 2; j++){
                if (button[i].getText().equals(BoardCondition.values()[j].getSymbol())) {
                    gameBoard.setBoard(i % 3, i / 3, j);
                }
            }
        }
    }
}
