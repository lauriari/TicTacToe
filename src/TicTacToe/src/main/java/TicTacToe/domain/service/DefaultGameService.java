package TicTacToe.domain.service;

import TicTacToe.datasource.mapper.GameMapper;
import TicTacToe.datasource.repository.IDataService;
import TicTacToe.domain.model.GameBoard;
import org.springframework.stereotype.Component;

import java.util.UUID;


public class DefaultGameService implements GameService {

    private IDataService service;
    private GameMapper mapper;

    public DefaultGameService(IDataService service, GameMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    private void save(UUID uuid, GameBoard gameBoard){
        service.saveGame(uuid, mapper.boardToField(gameBoard));
    }
    private GameBoard load(UUID uuid){
        return mapper.fieldToBoard(service.loadGame(uuid));
    }

    @Override
    public UUID createNewGame (){
        UUID uuid = UUID.randomUUID();
        service.saveGame(uuid, mapper.boardToField(new GameBoard()));
        return uuid;
    }

    @Override
    public void saveGame(UUID uuid, GameBoard gameBoard) {
        this.save(uuid, gameBoard);
    }

    @Override
    public GameBoard loadGame(UUID uuid) {
        return this.load(uuid);
    }



    private int recurs(GameBoard game, int player, int depth){
        int sign = player == 1 ? 1 : -1;
        if (this.finishGame(game)){
            return sign*depth;
        } else {
            player = player + sign;
            int best = 0;
            boolean start = false;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (game.getBoard(i,j) == 0){
                        GameBoard newGame = new GameBoard(game);
                        newGame.setBoard(i,j,player);
                        int res = recurs(newGame, player, depth-1);
                        if (!start){
                            start = true;
                            best = res;
                        }
                        if (player == 1){
                            if (best < res) best = res;
                        }
                        else {
                            if (best > res) best = res;
                        }

                    }
                }
            }
            return best;
        }
    }

    @Override
    public GameBoard nextMove(UUID uuid) {
        GameBoard currentGame = this.load(uuid);


        int best = 0;
        boolean start = false;
        GameBoard next = currentGame;
        GameBoard newMove;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentGame.getBoard(i, j) == 0) {
                    newMove = new GameBoard(currentGame);
                    newMove.setBoard(i, j, 2);

                    int res = 0;
                    res = recurs(newMove, 2, 10);
                    if (!start){
                        start = true;
                        best = res;
                        next = newMove;
                    }
                    if (best > res) {
                        best = res;
                        next = newMove;
                    }
                }
            }
        }
        return next;
    }


    @Override
    public void validGame(UUID uuid, int curMove) throws IllegalAccessError {
        GameBoard oldGame = this.load(uuid);
        if (oldGame.getBoard(curMove % 3, curMove / 3) != 0) {
            throw new IllegalAccessError("bad game");
        } else {
            oldGame.setBoard(curMove % 3, curMove / 3, 1);
        }
        this.save(uuid, oldGame);
    }

    @Override
    public boolean finishGame(GameBoard game) {
        for (int i = 0; i < 3; i++) {
            if (game.getBoard(i, 0) == game.getBoard(i, 1) &&
                    game.getBoard(i, 1) == game.getBoard(i, 2) &&
                    game.getBoard(i, 0) != 0) {
                return true;
            }
            if (game.getBoard(0, i) == game.getBoard(1, i) &&
                    game.getBoard(1, i) == game.getBoard(2, i) &&
                    game.getBoard(0, i) != 0) {
                return true;
            }
        }
        if (game.getBoard(0,0) == game.getBoard(1,1) &&
                game.getBoard(2,2) == game.getBoard(1,1) &&
        game.getBoard(0,0) != 0){
            return true;
        }
        if (game.getBoard(0,2) == game.getBoard(1,1) &&
                game.getBoard(2,0) == game.getBoard(1,1) &&
                game.getBoard(1,1) != 0){
            return true;
        }

        return false;
    }
}
