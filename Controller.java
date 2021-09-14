package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class Controller implements Initializable {


    @FXML
    private Button pvpButton;

    @FXML
    private Button pveButton;

    @FXML
    private Button restartButton;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text titleText;

    ArrayList<Button>  buttons;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

        gameSetup(buttons, titleText, pveButton, pvpButton);

        restartButton.setOnMouseClicked(event -> {
            gameSetup(buttons, titleText, pveButton, pvpButton);
        });

    }

    private void gameSetup(ArrayList<Button> buttons, Text titleText, Button pveButton, Button pvpButton) {


        resetButtons(buttons, titleText, pveButton, pvpButton);

        playAgainstAnotherPlayer(buttons, titleText);

        playAgainstComputer(buttons, titleText);

  }

    private void playAgainstComputer(ArrayList<Button> buttons, Text titleText) {
        pveButton.setOnMouseClicked(event ->{
            new PlayerVsEnvironment(buttons, titleText);
            pveButton.setDisable(true);
            pvpButton.setDisable(true);
        });
    }

    private void playAgainstAnotherPlayer(ArrayList<Button> buttons, Text titleText) {
        pvpButton.setOnMouseClicked(event ->{
            new PlayerVsPlayer(buttons, titleText);
            pveButton.setDisable(true);
            pvpButton.setDisable(true);

        });
    }

    private void resetButtons(ArrayList<Button> buttons, Text titleText, Button pveButton, Button pvpButton) {

        buttons.forEach(btn ->{
            btn.setDisable(true);
            btn.setText(" ");
        btn.setDisable(true);});
        titleText.setText("Tic Tac Toe");
        pvpButton.setDisable(false);
        pveButton.setDisable(false);

    }



}











