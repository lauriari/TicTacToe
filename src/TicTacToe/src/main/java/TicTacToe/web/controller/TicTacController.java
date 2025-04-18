package TicTacToe.web.controller;


import TicTacToe.domain.model.GameBoard;
import TicTacToe.domain.service.PlayGame;
import TicTacToe.web.mapper.Adapter;
import TicTacToe.web.model.Button;
import TicTacToe.web.model.Button2;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class TicTacController {

    private Button[] button = new Button[9];
    private Button2 yourMove;

  @Autowired
  private PlayGame playGame;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        for (int i = 0; i < 9; i++){
            button[i] = new Button();
        }

        UUID uuid = playGame.createNewGame();
        model.addAttribute("curUUID", uuid.toString());
        session.setAttribute("curUUID", uuid.toString());

        System.out.println("uuid - " + uuid);
        Adapter.boardToButton(new GameBoard(), button);
        yourMove = new Button2("your move first", true);
        model.addAttribute("yourMove", yourMove);
        for (int i = 0; i < 9; i++) {
            model.addAttribute("button" + i, button[i]);
        }
        return "TicTac4";
    }

    @PostMapping("/click")
    public String handleClick(
            @RequestParam("buttonNumber") String buttonNumber,
            @RequestParam("uuid") UUID uuid,
            HttpSession session,
            Model model) {


            yourMove.setText(" ");
            yourMove.setEnabled(false);

            GameBoard newMoveGameBoard;

      if (buttonNumber.equals("9")) {
          newMoveGameBoard = playGame.comp1stMove(uuid);
          Adapter.boardToButton(newMoveGameBoard, button);
      }
      else {
          newMoveGameBoard = playGame.myMoveAndCompMove(uuid, Integer.parseInt(buttonNumber));
          Adapter.boardToButton(newMoveGameBoard, button);
          if (playGame.getStatus() != 0){
              for (int i = 0; i < 9; i++){
                  button[i].setEnabled(false);
              }
              if (playGame.getStatus() == 1){
                  yourMove.setText("You WIN");
              } else {
                  yourMove.setText("You LOOSE");
              }
              yourMove.setEnabled(false);
          }
      }

        model.addAttribute("curUUID", uuid);
        model.addAttribute("yourMove", yourMove);
        for (int i = 0; i < 9; i++) {
            model.addAttribute("button" + i, button[i]);
        }
        return "TicTac4";
    }

}