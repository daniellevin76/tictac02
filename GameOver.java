package sample;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class GameOver {


    public boolean gameOver;

    public GameOver(ArrayList<Button> buttons, Text titleText) {
        checkGameOver(buttons, titleText);
    }


    public void checkGameOver(ArrayList<Button> buttons, Text titleText){


        for (int comb = 0; comb < 8; comb++) {
            String line = switch (comb) {


                case 0 -> buttons.get(0).getText() + buttons.get(1).getText() + buttons.get(2).getText();
                case 1 -> buttons.get(3).getText() + buttons.get(4).getText() + buttons.get(5).getText();
                case 2 -> buttons.get(6).getText() + buttons.get(7).getText() + buttons.get(8).getText();
                case 3 -> buttons.get(0).getText() + buttons.get(4).getText() + buttons.get(8).getText();
                case 4 -> buttons.get(2).getText() + buttons.get(4).getText() + buttons.get(6).getText();
                case 5 -> buttons.get(0).getText() + buttons.get(3).getText() + buttons.get(6).getText();
                case 6 -> buttons.get(1).getText() + buttons.get(4).getText() + buttons.get(7).getText();
                case 7 -> buttons.get(2).getText() + buttons.get(5).getText() + buttons.get(8).getText();
                default -> null;
            };

            //X wins
            if (line.equals("XXX")) {
                titleText.setText("Game over: X won!");
                gameOver = true;
                noAction(buttons);

            }

            //O wins
            else if (line.equals("OOO")) {
                titleText.setText("Game over: O won!");
                gameOver = true;
                noAction(buttons);
            }
        }
   }

    public void noAction(ArrayList<Button> buttons) {
        buttons.forEach(this::preventClick);
    }

    private void preventClick(Button button) {
        button.setDisable(true);
    }
}