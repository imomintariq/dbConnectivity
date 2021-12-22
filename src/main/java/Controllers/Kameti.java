package Controllers;

import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class Kameti {

    @FXML
    private ListView<?> TurnStatus;

    @FXML
    private Button backButton;

    @FXML
    private Label kametiID;

    @FXML
    private Label kametiName;

    @FXML
    private ListView<?> membersList;

    @FXML
    private Button payShareBtn;

    @FXML
    private Button withdrawPaymentBtn;

    @FXML
    void backButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/ViewKametis.fxml");
        } catch (Exception e) {
            System.out.println("Dashboard Page not Loaded");
        }
    }

    @FXML
    void payShareBtnClicked(MouseEvent event) {

    }

    @FXML
    void withdrawPaymentBtnClicked(MouseEvent event) {

    }

}