package TicTacToe.web.controller;

import TicTacToe.datasource.mapper.DefaultGameMapper;
import TicTacToe.datasource.repository.DataService;
import TicTacToe.datasource.repository.DataRepository;
import TicTacToe.domain.model.GameBoard;
import TicTacToe.domain.service.DefaultGameService;
import TicTacToe.domain.service.PlayGame;
import TicTacToe.web.mapper.Adapter;
import TicTacToe.web.model.Button;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class TicTacController {

    private Button[] button = new Button[9];

    private PlayGame playGame = new PlayGame(new DefaultGameService(new DataService(new DataRepository()), new DefaultGameMapper()));
    UUID uuid;

    @GetMapping("/")
    public String index(Model model) {
        for (int i = 0; i < 9; i++){
            button[i] = new Button();
        }
        uuid = playGame.createNewGame();
        System.out.println("uuid - " + uuid);
        Adapter.boardToButton(new GameBoard(), button);
        for (int i = 0; i < 9; i++) {
            model.addAttribute("button" + i, button[i]);
        }
        return "TicTac4";
    }

    @PostMapping("/click")
    public String handleClick(
            @RequestParam("buttonNumber") String buttonNumber,
            Model model) {

        button[Integer.parseInt(buttonNumber)].setText("X");

        GameBoard newMoveGameBoard = new GameBoard();

        Adapter.buttonToBoard(button, newMoveGameBoard);


        newMoveGameBoard = playGame.myMoveAndCompMove(uuid, newMoveGameBoard);

        Adapter.boardToButton(newMoveGameBoard, button);

        for (int i = 0; i < 9; i++) {
            model.addAttribute("button" + i, button[i]);
        }
        return "TicTac4";
    }

}