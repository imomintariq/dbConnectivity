package Controllers;

import Entities.Kameti;
import Main.KametiManagementSystem;
import Utility.PrivateKametiDetails;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PrivateKameti implements Initializable {

    @FXML
    private ListView<?> KametiList;

    @FXML
    private Text KametiText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PrivateKametiDetails pkd = PrivateKametiDetails.getInstance();
        System.out.println(pkd.getKametiCode() + pkd.getKametiName());
        KametiManagementSystem kms = new KametiManagementSystem();
        Kameti K = kms.retrievePrivateKametis(pkd.getKametiName(), pkd.getKametiCode());
        System.out.println(K.getId());
        System.out.println(K.getKametiName());
        System.out.println(K.getKametiDuration());
    }
}
