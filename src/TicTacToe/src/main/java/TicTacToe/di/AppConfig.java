package TicTacToe.di;

import TicTacToe.datasource.mapper.DefaultGameMapper;
import TicTacToe.datasource.mapper.GameMapper;
import TicTacToe.datasource.repository.DataRepository;
import TicTacToe.datasource.repository.DataService;
import TicTacToe.datasource.repository.IDataService;
import TicTacToe.domain.service.DefaultGameService;
import TicTacToe.domain.service.GameService;
import TicTacToe.domain.service.PlayGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class AppConfig {
//
//
//    @Bean
//    public DataRepository repository(){
//        return new DataRepository();
//    }
//
//    @Bean
//    public DataService service(DataRepository repository){
//        return new DataService(repository);
//    }
//
//    @Bean
//    public DefaultGameMapper gameMapper(){
//        return new DefaultGameMapper();
//    }
//
//    @Bean
//    public DefaultGameService gameService(IDataService dataService, GameMapper gameMapper){
//        return new DefaultGameService(dataService, gameMapper);
//    }
//
//    @Bean
//    public PlayGame playGame(GameService gameService){
//        return new PlayGame(gameService);
//    }
//
//
//}
