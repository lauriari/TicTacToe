package TicTacToe.datasource.repository;

import TicTacToe.datasource.model.GameField;
import TicTacToe.datasource.model.GamesCollection;
import org.springframework.stereotype.Component;

import java.util.UUID;


public class DataRepository {
    private final GamesCollection games;

    public DataRepository(GamesCollection gamesCollection) {
        this.games = gamesCollection;
    }
    public void saveGameRepository(UUID uuid, GameField field){
        games.put(uuid, field);
    }
    public GameField loadGameRepository(UUID uuid){
        return games.get(uuid);
    }
}
