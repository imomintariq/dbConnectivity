package Controllers;

import Main.Main;
import Main.KametiDatabaseHandler;
import Utility.Selectedkameti;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Kameti implements Initializable {

    @FXML
    private ListView<String> TurnStatus;

    @FXML
    private Button backButton;

    @FXML
    private Label kametiID;

    @FXML
    private Label kametiName;

    @FXML
    private ListView<String> membersList;

    @FXML
    private Button payShareBtn;

    @FXML
    private Button withdrawPaymentBtn;

    private String selectedRow;


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

        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/Kameti.fxml");
        }
        catch(Exception e){
            System.out.println("KametiDesc Page not Loaded");
        }
    }

    @FXML
    void withdrawPaymentBtnClicked(MouseEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Selectedkameti sc = Selectedkameti.getInstance();
        kametiID.setText(sc.getKameti().getId().toString());
        kametiID.setVisible(true);
        kametiName.setText(sc.getKameti().getKametiName());
        kametiID.setVisible(true);

        KametiDatabaseHandler kms = new KametiDatabaseHandler();
        ArrayList<String> k = kms.retrieveKametiMembers();
        membersList.getItems().addAll(k);
        membersList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selectedRow = membersList.getSelectionModel().getSelectedItem();//getting current selection

            }
        });



    }


}