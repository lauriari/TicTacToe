package TicTacToe.domain.service;

import TicTacToe.domain.model.GameBoard;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.lang.Math.random;


public class PlayGame {
    GameService service;
    private int status = 0;

    public int getStatus() {
        return status;
    }

    public PlayGame(GameService service) { this.service = service;}

    public UUID createNewGame (){
        return service.createNewGame();
    }

    public GameBoard myMoveAndCompMove(UUID uuid, int curMove){
        status = 0;
        try {
            service.validGame(uuid, curMove);
            if (service.finishGame(service.loadGame(uuid))){
                status = 1;

            }

            GameBoard newGame = service.nextMove(uuid);

            if (service.finishGame(newGame)){
                status = 2;

            }
            service.saveGame(uuid, newGame);
            return newGame;
        }
        catch (Exception e){
            System.out.println("err - " + e);
            return service.loadGame(uuid);
        }
    }
    public GameBoard comp1stMove (UUID uuid){
        GameBoard game = service.loadGame(uuid);
        int randomNumber = (int)(random() * 3);
        if (randomNumber == 2){
            game.setBoard(1,1,2);
        } else {
            game.setBoard(randomNumber, 0, 2);
        }
        service.saveGame(uuid, game);
        return game;
    }
}
