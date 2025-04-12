package TicTacToe.datasource.repository;

import TicTacToe.datasource.model.GameField;
import TicTacToe.datasource.model.GamesCollection;

import java.util.UUID;

public class DataRepository {
    private final GamesCollection games;

    public DataRepository() {
        this.games = new GamesCollection();
    }
    public void saveGameRepository(UUID uuid, GameField field){
        games.put(uuid, field);
    }
    public GameField loadGameRepository(UUID uuid){
        return games.get(uuid);
    }
}
