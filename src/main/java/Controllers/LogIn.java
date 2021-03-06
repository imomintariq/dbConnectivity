package Controllers;
import Exceptions.LogInException;
import Main.KametiDatabaseHandler;
import Main.Main;
import Utility.SignedInUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Label incorrectTextLabel;

    @FXML
    void SignInButtonClicked(MouseEvent event) {
        KametiDatabaseHandler kms = new KametiDatabaseHandler();
        String logIn = kms.LogIn(username.getText(), password.getText());
        try {
            checkLogin(logIn);

        } catch (Exception e) {
            System.out.println("Oh No! You do not seemed to be signed up" + e);
            incorrectTextLabel.setText("Incorrect Username or Password");
            incorrectTextLabel.setVisible(true);
        }

    }

    @FXML
    void signUpButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("StandardUserPages/SignUp.fxml");
        }
        catch(Exception e){
            System.out.println("Sign Up Page not Loaded");
        }
    }
        @FXML
     void checkLogin(String flag) throws LogInException
        {
            if (flag.equals("standard user") == true) {
                Main main = new Main();
                try {
                    KametiDatabaseHandler kms = new KametiDatabaseHandler();
                    SignedInUser signedInUser = SignedInUser.getInstance();
                    signedInUser.setUser(kms.retrieveUser(username.getText(),password.getText()));
                    //main.changeScene("DashBoard.fxml");
                    main.changeScene("StandardUserPages/DashBoard.fxml");
                } catch (Exception e) {
                    System.out.println("Dashboard Page not Loaded");
                }
            }
            else if(flag.equals("admin")){
                Main main = new Main();
                try {
                    main.changeScene("AdminPages/AdminDashBoard.fxml");
                } catch (Exception e) {
                    System.out.println("Admin Dashboard Page not Loaded");
                }
            }
            else {
                System.out.println("Incorrect Username or Password");
                throw new LogInException("Incorrect Username or Password");
            }

        }
}
