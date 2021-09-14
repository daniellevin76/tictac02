package sample;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerVsEnvironment {

    public PlayerVsEnvironment( ArrayList<Button> buttons, Text titleText) {

        gamePlay(buttons, titleText);
    }


    private void gamePlay(ArrayList<Button> buttons, Text titleText) {
        titleText.setText("PvE");

        buttons.forEach(button ->{
            button.setDisable(false);

            button.setOnMouseClicked(event ->{



                setSymbol(button);
                computerSetSymbol(buttons);
                button.setDisable(true);

                GameOver gameOver = new GameOver(buttons, titleText);
                gameOver.checkGameOver(buttons, titleText);


            });
            button.setFocusTraversable(false);
        });
    }

    private void computerSetSymbol(ArrayList<Button> buttons) {


        int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
        System.out.println(randomNum);
        while(!buttons.get(randomNum).getText().equals(" ")){

            randomNum = ThreadLocalRandom.current().nextInt(0, 9);
    }
        buttons.get(randomNum).setText("O");
        buttons.get(randomNum).setTextFill(Color.BLUE);
}
    private void setSymbol(Button button) {

            button.setText("X");
            button.setTextFill(Color.RED);
    }
}