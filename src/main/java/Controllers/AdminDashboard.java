package Controllers;

import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AdminDashboard {

    @FXML
    private Button SignOutButton;

    @FXML
    private Button newAdminButton;

    @FXML
    private Button viewComplaintsBtn;

    @FXML
    private Button viewPrivKametisBtn;

    @FXML
    private Button viewPubKametisBtn;

    @FXML
    void SignOutButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/LogIn.fxml");
        }
        catch(Exception e){
            System.out.println("Log In Page not Loaded");
        }
    }

    @FXML
    void viewComplaintsButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("AdminPages/AllComplaints.fxml");
        }
        catch(Exception e){
            System.out.println("Complaints List Page not Loaded");
        }
    }

    @FXML
    void viewPrivateKametisButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("AdminPages/PrivateKametisList.fxml");
        }
        catch(Exception e){
            System.out.println("Private Kametis List Page not Loaded");
        }
    }

    @FXML
    void viewPublicKametisButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("AdminPages/PublicKametisList.fxml");
        }
        catch(Exception e){
            System.out.println("Public Kametis List Page not Loaded");
        }
    }

    public void registerAdminButtonClicked(MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("AdminPages/RegisterNewAdmin.fxml");
        }
        catch(Exception e){
            System.out.println("Admin Sign Up Page not Loaded");
        }
    }
}
