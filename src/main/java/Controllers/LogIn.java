package Controllers;
import Main.KametiManagementSystem;
import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
        kms.LogIn(username.getText(),password.getText());
        try {
            main.changeScene("DashBoard.fxml");
        }
        catch(Exception e){
            System.out.println("Log In Page not Loaded");
        }
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
