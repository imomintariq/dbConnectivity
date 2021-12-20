package Controllers;

import Entities.Kameti;
import Main.KametiManagementSystem;
import Utility.PrivateKametiDetails;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrivateKameti implements Initializable {

    @FXML
    private ListView<String> KametiList;

    @FXML
    private Text KametiText;

    String selectedKametiId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
