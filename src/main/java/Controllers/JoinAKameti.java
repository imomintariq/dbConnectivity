package Controllers;

import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class JoinAKameti {

    @FXML
    private TextField kametiCode;

    @FXML
    private TextField kametiDuration;

    @FXML
    private TextField kametiName;

    @FXML
    private TextField kametiPayout;

    @FXML
    private Button privateKametiButton;

    @FXML
    private Button publicKametiButton;

    @FXML
    void backButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("DashBoard.fxml");
        }
        catch(Exception e){
            System.out.println("Dash Board Page not Loaded");
        }
    }

    @FXML
    void privateKametiButtonClicked(MouseEvent event) {

    }

    @FXML
    void publicKametiButtonClicked(MouseEvent event) {

    }

}
