package Controllers;

import Main.Main;
import Utility.SignedInUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoard implements Initializable {

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
    private Label signedInUserLabel;

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
        Main main = new Main();
        try {
            System.out.println("View Kametis button clicked!!");
            main.changeScene("StandardUserPages/ViewKametis.fxml");
        }
        catch(Exception e){
            System.out.println("View Kametis Page not Loaded");
        }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SignedInUser signedInUser = SignedInUser.getInstance();

        System.out.println("Signed In User = " + signedInUser.getUser().getFirstName() + " " + signedInUser.getUser().getLastName());
        //signedInUserLabel = new Label(signedInUser.getUser().getFirstName());
        //signedInUserLabel.setVisible(true);
        signedInUserLabel.setText("Welcome " + signedInUser.getUser().getFirstName() + " " + signedInUser.getUser().getLastName());
        signedInUserLabel.setVisible(true);
    }
    public void reportButtonClicked(MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/FileComplaintPage.fxml");
        }
        catch(Exception e){
            System.out.println("Complaint Page not Loaded");
        }
    }
}
