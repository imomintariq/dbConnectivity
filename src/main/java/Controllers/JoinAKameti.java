package Controllers;

import Main.Main;
import Utility.PrivateKametiDetails;
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
        PrivateKametiDetails pvk = PrivateKametiDetails.getInstance();
        pvk.setKametiCode(kametiCode.getText());
        pvk.setKametiName(kametiName.getText());
        Main main = new Main();
        try {
            main.changeScene("PrivateKameti.fxml");
        }
        catch(Exception e){
            System.out.println("Private Kameti Page not Loaded");
        }
    }

    @FXML
    void publicKametiButtonClicked(MouseEvent event) {

        System.out.println("Public Kameti Button Clicked !!!");

        System.out.println("Private Kameti Button Clicked !!!");
    }

}
