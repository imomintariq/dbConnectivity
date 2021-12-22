package Controllers;

import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegisterComplaint {

    @FXML
    private TextArea complaint;

    @FXML
    private TextField kametiCode;

    @FXML
    private TextField offendersUsername;

    @FXML
    private Button submitButton;

    @FXML
    private TextField username;

    @FXML
    void submitButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/DashBoard.fxml");
        } catch (Exception e) {
            System.out.println("Dashboard Page not Loaded");
        }
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/DashBoard.fxml");
        } catch (Exception e) {
            System.out.println("Dashboard Page not Loaded");
        }
    }

}
