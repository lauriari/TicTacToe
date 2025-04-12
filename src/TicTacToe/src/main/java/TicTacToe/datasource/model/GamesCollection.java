package TicTacToe.datasource.model;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GamesCollection extends ConcurrentHashMap<UUID, GameField> {
}
