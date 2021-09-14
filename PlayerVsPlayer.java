package sample;


import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerVsPlayer {

    public int turn;

    public PlayerVsPlayer(ArrayList<Button> buttons, Text titleText){


        gamePlay(buttons, titleText);

    }

    private void gamePlay(ArrayList<Button> buttons, Text titleText) {

        buttons.forEach(button ->{
            button.setDisable(false);
            button.setOnMouseClicked(event ->{

                setSymbol(button);
                button.setDisable(true);
                GameOver gameOver = new GameOver(buttons, titleText);
                gameOver.checkGameOver(buttons, titleText);
            });
            button.setFocusTraversable(false);
        });
    }

    private void setSymbol(Button button) {

        turn +=1;
        if(turn % 2 == 0){

            button.setText("X");
            button.setTextFill(Color.RED);
        }
        else{
            button.setText("O");
            button.setTextFill(Color.BLUE);
        }

    }
}
