package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

import static java.awt.Color.green;

public class Controller implements Initializable {

    public final static String SOUND1_URL = "file:///C:/Users/danie/OneDrive/Skrivbord/tictac02/assets/s1.wav";
    public final static String SOUND2_URL = "asssets/s2.wav";

    protected MediaPlayer mediaPlayer;
    protected Media sound;

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
    private Text winnerText;

    private int playerTurn = 0;

    ArrayList<Button> buttons;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void restartGame() {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tic-Tac-Toe");
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);


            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0){

            button.setText("X");
            playerTurn = 1;
        } else{
            button.setText("O");
            playerTurn = 0;
        }
    }

    public void checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {
                winnerText.setText("X won!");

        noAction();

            }

            //O winner
            else if (line.equals("OOO")) {
                winnerText.setText("O won!");
                noAction();
            }
            }
    }

    void noAction() {
        buttons.forEach(this::preventClick);

    }
    public void preventClick(Button button){
        button.setDisable(true);
        //button.setText("");
    }

    public void playAgainstComputer(ActionEvent actionEvent) {

       // Media media = new Media(new File(SOUND1_URL).toURI().toString());
        //mediaPlayer = new MediaPlayer(media);
        //mediaPlayer.play();
        computerMove();
    }


    public void computerMove(){


       int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
       while(!buttons.get(randomNum).getText().equals("")){
           randomNum = ThreadLocalRandom.current().nextInt(0, 9);

       }
        buttons.get(randomNum).setText("0");
    }
}
