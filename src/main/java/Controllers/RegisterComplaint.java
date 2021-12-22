package Controllers;

import Entities.Kameti;
import Entities.User;
import Main.Main;
import Main.KametiManagementSystem;
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

        KametiManagementSystem kms = new KametiManagementSystem();
        Kameti kameti = kms.getKametiWithId(kametiCode.getText());
        if(kameti != null) {
            User user = kms.retrieveUserWithId(username.getText());
            if (user != null) {
                User offender = kms.retrieveUserWithId(offendersUsername.getText());
                if(offender != null){
                    kms.addComplaintToDb(kameti, user, offender,complaint.getText());
                }

            }
        }
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
