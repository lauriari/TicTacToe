package TicTacToe.datasource.model;

import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GamesCollection extends ConcurrentHashMap<UUID, GameField> {
}
