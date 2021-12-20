package Controllers;

import Main.KametiManagementSystem;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;

public class CreateAKameti {

    @FXML
    private TextField YetToDecide;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox isPrivateCheck;

    @FXML
    private TextField kametiDurationField;

    @FXML
    private TextField kametiFrquencyField;

    @FXML
    private TextField kametiNameField;

    @FXML
    private TextField kametiPayoutField;

    @FXML
    private TextField kametiStartDateField;

    @FXML
    private CheckBox rule1Check;

    @FXML
    private CheckBox rule2Check;
    @FXML
    private DatePicker DatePickerNote;

    @FXML
    private CheckBox rule3Check;

    @FXML
    private CheckBox rule4Check;

    @FXML
    private CheckBox rule5Check;

    @FXML
    private Button submitButton;

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
    void submitButtonClicked(MouseEvent event) {

    }
    public void onDatePicked(ActionEvent actionEvent) {
    }
}
