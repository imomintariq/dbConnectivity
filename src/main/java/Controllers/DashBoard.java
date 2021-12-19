package Controllers;

import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class DashBoard {

    @FXML
    private Button dashBoardBackButton;
    @FXML
    private Button createKametiButton;

    @FXML
    private Button joinKametiButton;

    @FXML
    private Button viewKametisButton;

    @FXML
    void createKametiButtonClicked(MouseEvent event)
    {

    }

    @FXML
    void joinKametiButtonClicked(MouseEvent event)
    {
        Main main = new Main();
        try {
            main.changeScene("KametiTypes.fxml");
        }
        catch(Exception e){
            System.out.println("Sign Up Page not Loaded");
        }
    }

    @FXML
    void viewKametisButtonClicked(MouseEvent event) {

    }
    @FXML
    void dashBoardBackButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("LogIn.fxml");
        }
        catch(Exception e){
            System.out.println("Log In Page not Loaded");
        }
    }

}
