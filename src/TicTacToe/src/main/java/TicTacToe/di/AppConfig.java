package TicTacToe.di;

import TicTacToe.datasource.mapper.DefaultGameMapper;
import TicTacToe.datasource.model.GamesCollection;
import TicTacToe.datasource.repository.DataRepository;
import TicTacToe.datasource.repository.DataService;
import TicTacToe.domain.service.DefaultGameService;
import TicTacToe.domain.service.PlayGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GamesCollection gamesCollection() {return new GamesCollection();}
    @Bean
    public DataRepository repository(){
        return new DataRepository(gamesCollection());
    }

    @Bean
    public DataService service(){
        return new DataService(repository());
    }

    @Bean
    public DefaultGameMapper gameMapper(){
        return new DefaultGameMapper();
    }

    @Bean
    public DefaultGameService gameService(){
        return new DefaultGameService(service(), gameMapper());
    }

    @Bean
    public PlayGame playGame(){
        return new PlayGame(gameService());
    }


}
