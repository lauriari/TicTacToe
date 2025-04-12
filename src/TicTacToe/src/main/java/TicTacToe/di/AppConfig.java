//package TicTacToe.di;
//
//import TicTacToe.datasource.mapper.DefaultGameMapper;
//import TicTacToe.datasource.mapper.GameMapper;
//import TicTacToe.domain.service.DefaultGameService;
//import TicTacToe.domain.service.GameService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public GameMapper gameMapper() {
//        return new DefaultGameMapper();
//    }
//
//    @Bean
//    public GameService gameService(GameMapper mapper){
//        return new DefaultGameService(mapper);
//    }
//}
