package Controllers;

import Main.KametiManagementSystem;
import Main.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateAKameti implements Initializable {

    @FXML
    private DatePicker DatePickerNote;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox isPrivateCheck;

    @FXML
    private TextField kametiDurationField;

    @FXML
    private ChoiceBox<String> kametiFrquency;

    @FXML
    private TextField kametiNameField;

    @FXML
    private TextField kametiPayoutField;

    @FXML
    private CheckBox rule1Check;

    @FXML
    private CheckBox rule2Check;

    @FXML
    private CheckBox rule3Check;

    @FXML
    private CheckBox rule4Check;

    @FXML
    private CheckBox rule5Check;

    @FXML
    private Button submitButton;

    String frequency;

    @FXML
    void backButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/DashBoard.fxml");
        }
        catch(Exception e){
            System.out.println("Dash Board Page not Loaded");
        }
    }

    @FXML
    void onDatePicked(ActionEvent event) {

    }

    @FXML
    void submitButtonClicked(MouseEvent event) throws IOException {
        KametiManagementSystem kms = new KametiManagementSystem();
        System.out.println("Name = " + kametiNameField.getText());
        System.out.println("frequency = " + frequency);
        System.out.println("rule 1 = " + rule1Check.isSelected());
        System.out.println("Rule 2  = " + rule2Check.isSelected());
        System.out.println("isPrivate = " + isPrivateCheck.isSelected());
        System.out.println("payOut = " + Integer.parseInt(kametiPayoutField.getText()));
        System.out.println("Data = " + DatePickerNote.getValue());
        System.out.println("Duration = " + Integer.parseInt(kametiDurationField.getText()));
        kms.AddAKameti(kametiNameField.getText(),
                frequency,
                String.valueOf(rule1Check.isSelected()),
                String.valueOf(rule2Check.isSelected()),
                String.valueOf(rule3Check.isSelected()),
                String.valueOf(rule4Check.isSelected()),
                String.valueOf(rule5Check.isSelected()),
                String.valueOf(isPrivateCheck.isSelected()),
                Integer.parseInt(kametiPayoutField.getText()), DatePickerNote.getValue(),Integer.parseInt(kametiDurationField.getText()));
        //WRITING INTO FILE
        FileWriter Fr = new FileWriter("Kametis.txt",true );
        BufferedWriter br = new BufferedWriter(Fr);
        String toWrite ="";
        toWrite += kametiNameField.getText();
        toWrite += "  -  ";
        toWrite += kametiPayoutField.getText();
        toWrite += "  -  ";
        toWrite +=  String.valueOf(rule1Check.isSelected());
        toWrite += "  -  ";
        toWrite += String.valueOf(rule2Check.isSelected());
        toWrite += "  -  ";
        toWrite += String.valueOf(rule3Check.isSelected());
        toWrite += "  -  ";
        toWrite += String.valueOf(rule4Check.isSelected());
        toWrite += "  -  ";
        toWrite += String.valueOf(rule5Check.isSelected());
        toWrite += "  -  ";
        toWrite += frequency;
        toWrite += "  -  ";
        toWrite+= isPrivateCheck.getText();
        toWrite += "  -  ";
        toWrite += kametiDurationField.getText();
        toWrite += "  -  ";
        toWrite+= isPrivateCheck.getText();
        toWrite += "  -  ";
        toWrite += String.valueOf((DatePickerNote.getValue()));
        toWrite += "  -  ";
        ////
        br.write(toWrite);
        br.newLine();
        br.close();

        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/DashBoard.fxml");
        }
        catch(Exception e){
            System.out.println("Dash Board Page not Loaded");
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<String> freqList = new ArrayList<>();
        freqList.add("Monthly");
        freqList.add("After 15 Days");
        ObservableList<String> observableList = FXCollections.observableArrayList(freqList);

        kametiFrquency.setItems(observableList);

        kametiFrquency.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                frequency=kametiFrquency.getSelectionModel().getSelectedItem();//getting current selection

                System.out.println(frequency);

            }
        });

    }
}
