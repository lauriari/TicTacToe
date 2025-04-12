package TicTacToe.domain.service;

import TicTacToe.domain.model.GameBoard;

import java.util.UUID;

public class PlayGame {
    GameService service;

    public PlayGame(GameService service) {
        this.service = service;
    }

    public UUID createNewGame (){
        return service.createNewGame();
    }

    public GameBoard myMoveAndCompMove(UUID uuid, GameBoard game){
        try {
            service.validGame(uuid, game);
            if (service.finishGame(game)){
                System.out.println("Win");
            }
            service.saveGame(uuid, game);

            GameBoard newGame = service.nextMove(uuid);

            if (service.finishGame(newGame)){
                System.out.println("Loose");
            }
            service.saveGame(uuid, newGame);
            return newGame;
        }
        catch (Exception e){
            System.out.println("err - " + e);
            return game;
        }
    }
}
