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
        //SETTING VALUES TO BE PASSED TO KAMETI MANAGEMENT SYSTEM FOR INSERTION INTO DATAABSE
        //-----//
        String Rule1 = "";
        String Rule2 = "";
        String  Rule3 = "";
        String Rule4 = "";
        String Rule5 = "";
        String isPrivate = "Public";
        if (rule1Check.isSelected() == true) {
            System.out.println("Rule no 1 Checked");
            Rule1 = "The payment of share needs to be made by the 15th of every month.";
        }
        if (rule2Check.isSelected() == true) {
            System.out.println("Rule no 2 Checked");
            Rule2 = "Kameti head has the right to accept or reject user(s) from joining the Kameti.";
        }
        if (rule3Check.isSelected() ==  true) {
            System.out.println("Rule no 3 Checked");
            Rule3 = "Kameti Head has the right to accept or reject request of the Kameti members to make payments.";
        }
        if (rule4Check.isSelected() == true) {
            System.out.println("Rule no 4 Checked");
            Rule4 = "Payments slots and order will be decided upon the descrition of the Kameti Head.";
        }
        if (rule5Check.isSelected() == true) {
            System.out.println("Rule no 5 Checked");
            Rule5 = "All and any disputes will be managed by the Kameti Head.";
        }
        if(isPrivateCheck.isSelected())
        {
            isPrivate = "Private";
        }
        String KametiName = kametiNameField.getText();
        int KametiDuration = Integer.valueOf(kametiDurationField.getText());
        //String KametiPaymentFrequency = kametiFrquencyField.getText();
        LocalDate LC = DatePickerNote.getValue();
        int Payout = Integer.valueOf(kametiPayoutField.getText());
        KametiManagementSystem kms = new KametiManagementSystem();
        kms.AddAKameti(KametiName/*KametiPaymentFrequency*/,Rule1,Rule2,Rule3,Rule4,Rule5,isPrivate,Payout,LC,KametiDuration);
    }

    public void onDatePicked(ActionEvent actionEvent) {
    }
}
