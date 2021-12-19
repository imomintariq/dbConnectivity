package Controllers;

import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class KametiTypes {

    @FXML
    private Text kametiTypeText;

    @FXML
    private Button privateKametiButton;

    @FXML
    private Button publicKametiButton;

    @FXML
    void privateKametiButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("PrivateKametiList.fxml");
        }
        catch(Exception e){
            System.out.println("Sign Up Page not Loaded");
        }
    }

    @FXML
    void publicKametiButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("PublicKametiList.fxml");
        }
        catch(Exception e){
            System.out.println("Sign Up Page not Loaded");
        }
    }

}
