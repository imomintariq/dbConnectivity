package Controllers;

import Entities.Kameti;
import Exceptions.KametiNotSelectedException;
import Main.KametiDatabaseHandler;
import Main.Main;
import Utility.SignedInUser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class PublicKametis implements Initializable { //for standard user
    @FXML
    private Label NoKametiSelectedLabel;

    @FXML
    private ListView<String> kametiList = new ListView<String>();

    @FXML
    private Button joinButton;

    private String selectedRow;
    private ArrayList<String> selectedKameti;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectedKameti = new ArrayList<>();
        KametiDatabaseHandler kms = new KametiDatabaseHandler();
        ArrayList<String> k = kms.retrievePublicKametis();
        kametiList.getItems().addAll(k);
        kametiList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selectedRow = kametiList.getSelectionModel().getSelectedItem();//getting current selection

                selectedKameti.clear();
                StringTokenizer st = new StringTokenizer(selectedRow, " ");
                while (st.hasMoreTokens()) {
                    selectedKameti.add(st.nextToken());
                }
                System.out.println("Selected kameti Id = " + selectedKameti.get(0) + ".");
                //System.out.println();

                //System.out.println(currentCandidate);

            }
        });
    }

    @FXML
    public void backButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/DashBoard.fxml");
        }
        catch(Exception e){
            System.out.println("Sign Up Page not Loaded");
        }
    }


    @FXML
    public void joinButtonClicked(javafx.scene.input.MouseEvent mouseEvent) {
        KametiDatabaseHandler kms = new KametiDatabaseHandler();

        try {
            if(selectedKameti.size() != 0) {
                Kameti kametiToBeJoined = kms.getKametiWithId(selectedKameti.get(0));
                checkKametiSelection(kametiToBeJoined);
            }
            else {
                checkKametiSelection(null);
            }
        } catch (Exception e) {
            System.out.println("Exception has been throws for not selecting Kameti" + e);
        }
    }

    public boolean checkKametiSelection(Kameti KametiToCheck)throws KametiNotSelectedException {
        if (KametiToCheck == null)
        {
            NoKametiSelectedLabel.setText("Please select a Kameti!");
            NoKametiSelectedLabel.setVisible(true);
            throw new KametiNotSelectedException("Kameti has not been selected");
        }
        else
        {
            KametiDatabaseHandler kms = new KametiDatabaseHandler();
            SignedInUser signedInUser = SignedInUser.getInstance();
            kms.addMemberToKameti(signedInUser.getUser(), KametiToCheck);
        }
        return false;
    }
}

