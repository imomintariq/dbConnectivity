package Controllers;

import Main.KametiManagementSystem;
import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignUp {

    @FXML
    private Button backButton;

    @FXML
    private TextField cnic;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button registerButton;

    @FXML
    private TextField username;


    @FXML
    void backButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("LogIn.fxml");
        } catch (Exception e) {
            System.out.println("Log In Page not Loaded");
        }
    }

    @FXML
    void registerButtonClicked(MouseEvent event) {
        String _username = username.getText();
        String _password = password.getText();
        String _email = email.getText();
        String _cnic = cnic.getText();
        String _firstName = firstName.getText();
        String _lastName = lastName.getText();
        String _phoneNumber = phoneNumber.getText();
        String _confirmedPassword = confirmPassword.getText();

        if (_password.equals(_confirmedPassword)) {
            KametiManagementSystem kms = new KametiManagementSystem();
            kms.registerAUser(_username, _password, _email, _cnic, _firstName, _lastName, _phoneNumber, _confirmedPassword);
        }

        Main main = new Main();
        try {
            main.changeScene("LogIn.fxml");
        } catch (Exception e) {
            System.out.println("Log In Page not Loaded");
        }

    }


}
