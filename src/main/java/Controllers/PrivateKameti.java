package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
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
