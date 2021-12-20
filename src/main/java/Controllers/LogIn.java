package Controllers;
import Exceptions.LogInException;
import Main.KametiManagementSystem;
import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.w3c.dom.Text;

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
    private Label incorrectTextLabel;
    @FXML
    void SignInButtonClicked(MouseEvent event) {
        KametiManagementSystem kms = new KametiManagementSystem();
        boolean logIn = kms.LogIn(username.getText(), password.getText());
        try {
            checkLogin(logIn);
        } catch (Exception e) {
            System.out.println("Oh No! You do not seemed to be signed up" + e);
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
        @FXML
     void checkLogin(boolean flag) throws LogInException
        {
            if (flag == true) {
                Main main = new Main();
                try {
                    main.changeScene("DashBoard.fxml");
                } catch (Exception e) {
                    System.out.println("Log In Page not Loaded");
                }
            } else {
                System.out.println("Incorrect Username or Password");
                incorrectTextLabel.setText("Incorrect Username or Password");
                incorrectTextLabel.setVisible(true);
            }

        }
}
