package TicTacToe.datasource.repository;

import TicTacToe.datasource.mapper.GameMapper;
import TicTacToe.datasource.model.GameField;
import TicTacToe.domain.model.GameBoard;

import java.util.UUID;


public class DataService implements IDataService {

    private DataRepository repository;

    public DataService(DataRepository repository) {

        this.repository = repository;

    }

    @Override
    public void saveGame(UUID uuid, GameField field){
        repository.saveGameRepository(uuid, field);
    }

    @Override
    public GameField loadGame(UUID uuid){
        return repository.loadGameRepository(uuid);
    }
}
