
package Controllers;

import Entities.User;
import Exceptions.LogInException;
import Exceptions.SignUpException;
import Main.KametiManagementSystem;
import Main.Main;
import Utility.SignedInUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;

public class SignUp {

    @FXML
    private Label ExceptionText;
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
            main.changeScene("StandardUserPages/LogIn.fxml");
        } catch (Exception e) {
            System.out.println("Log In Page not Loaded");
        }
    }

    @FXML
    void registerButtonClicked(MouseEvent event) throws IOException, LogInException {
        String _username = username.getText();
        String _passWord = password.getText();
        User user = new User();
        User user2 = new User();
        KametiManagementSystem kms = new KametiManagementSystem();
        user = kms.retrieveUser(_username, _passWord);
        boolean flag = false;

        try {
            flag = checkSingUp(user, user2);
        } catch (Exception e) {
            System.out.println("Sign Up Unsuccesful");
        }
        if (flag == false) {


        }
    }

    boolean checkSingUp(User U1, User U2) throws LogInException, IOException, SignUpException {
        boolean returnFlag = false;
        if(U1 != null)
        {
            System.out.println("A person with the same username has already been registered");
            returnFlag = true;
            ExceptionText.setText("A person with the same username already exists");
        }
        if(cnic.getText().length() < 13)
        {
            ExceptionText.setText("CNIC Must be valid (13 characters long)");
            System.out.println("CNIC Must be valid (13 characters long)");
            returnFlag = true;
        }
        if(password.getText().equals(confirmPassword.getText())!= true)
        {
            ExceptionText.setText("Passowrd and Confirmed password do not Match!");
            ExceptionText.setVisible(true);
            throw new SignUpException("Same Username already exists");
        }
        if(returnFlag == false) {
            ExceptionText.setText("Sign Up Successful");
            ExceptionText.setVisible(true);
            SignedInUser signedInUser = SignedInUser.getInstance();
            signedInUser.setUser(U2);
            //
            U2.setCnic(cnic.getText());
            U2.setFirstName(firstName.getText());
            U2.setLastName(lastName.getText());
            U2.setEmail(email.getText());
            U2.setId(username.getText());
            U2.setPhoneNumber(phoneNumber.getText());
            U2.setPassword(password.getText());
            //
            String _password = password.getText();
            String _email = email.getText();
            String _cnic = cnic.getText();
            String _firstName = firstName.getText();
            String _lastName = lastName.getText();
            String _phoneNumber = phoneNumber.getText();
            String _confirmedPassword = confirmPassword.getText();
            String _username = username.getText();
            KametiManagementSystem kms = new KametiManagementSystem();
            kms.registerAUser(_username, _password, _email, _cnic, _firstName, _lastName, _phoneNumber, _confirmedPassword,false);
            FileWriter Fr = new FileWriter("Users.txt", true);
            BufferedWriter br = new BufferedWriter(Fr);
            String toWrite = "";
            toWrite += _username;
            toWrite += "  -  ";
            toWrite += _password;
            toWrite += "  -  ";
            toWrite += _email;
            toWrite += "  -  ";
            toWrite += _cnic;
            toWrite += "  -  ";
            toWrite += _firstName;
            toWrite += "  -  ";
            toWrite += _lastName;
            toWrite += "  -  ";
            toWrite += _phoneNumber;
            toWrite += "  -  ";
            toWrite += _confirmedPassword;
            toWrite += "  -  ";
            br.write(toWrite);
            br.newLine();
            br.close();

            Main main = new Main();
            try {
                main.changeScene("StandardUserPages/DashBoard.fxml");
            } catch (Exception e) {
                System.out.println("Log In Page not Loaded");
            }
        }
        return false;
    }
}



