package Controllers;

import Entities.Kameti;
import Main.KametiManagementSystem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PublicKametis implements Initializable {

    @FXML
    private ListView<String> kametiList = new ListView<String>();

    @Override
    public void initialize(URL url, ResourceBundle rb){

        KametiManagementSystem kms = new KametiManagementSystem();
        ArrayList<String> k = kms.retrieveKametis();
        kametiList.getItems().add(String.valueOf(k));
    }

}
