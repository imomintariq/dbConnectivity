package Controllers;
import Entities.User;
import Main.KametiManagementSystem;
import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Statement;
import java.util.List;

public class LogIn {

    @FXML
    private TextField password;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField username;

    @FXML
    void SignInButtonClicked(MouseEvent event) {

        Main main = new Main();
        KametiManagementSystem kms = new KametiManagementSystem();

        if(kms.LogIn(username.getText(),password.getText())) {
            System.out.println("Log In Successful");
            try {
                main.changeScene("DashBoard.fxml");
            } catch (Exception e) {
                System.out.println("Log In Page not Loaded");
            }
        }
        else{System.out.println("Log In Failed");}
    }

    @FXML
    void signUpButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("SignUp.fxml");
        }
        catch(Exception e){
            System.out.println("Sign Up Page not Loaded");
        }
    }


}
