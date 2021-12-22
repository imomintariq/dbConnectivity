package Controllers;

import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class DashBoard {

    @FXML
    private Button createKametiButton;

    @FXML
    private Button dashBoardBackButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button joinKametiButton;

    @FXML
    private Button viewKametisButton;

    @FXML
    void createKametiButtonClicked(MouseEvent event)
    {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/CreateAKameti.fxml");
        }
        catch(Exception e){
            System.out.println("Create A Kameti Page not Loaded");
        }

    }

    @FXML
    void joinKametiButtonClicked(MouseEvent event)
    {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/JoinAKameti.fxml");
        }
        catch(Exception e){
            System.out.println("Join A Kameti Page not Loaded");
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

    @FXML
    void helpButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("Help.fxml");
        }
        catch(Exception e){
            System.out.println("Help Page not Loaded");
        }
    }

    public void reportButtonClicked(MouseEvent mouseEvent) {
    }
}
