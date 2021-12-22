package Controllers;

import Entities.Kameti;
import Entities.User;
import Exceptions.EmptyComplaintException;
import Main.Main;
import Main.KametiManagementSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class RegisterComplaint {

    @FXML
    private TextArea complaint;
    boolean Warning = false;
    @FXML
    private TextField kametiCode;

    @FXML
    private TextField offender;

    @FXML
    private Button submitButton;

    @FXML
    private TextField reporter;
    @FXML
    private Label backButtonWarningLabel;

    @FXML
    void submitButtonClicked(MouseEvent event) {
    try {
        CheckEmptyComplaint();
    }
    catch(Exception e)
    {
        backButtonWarningLabel.setText("You cannot submit an empty report!");
        backButtonWarningLabel.setVisible(true);

    }


    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        try
        {
            CheckComplaint(Warning);
        }
        catch(Exception e)
        {
            Warning = true;
        }

    }
   public void CheckComplaint(boolean Warning) throws EmptyComplaintException {
       if (Warning == false) {
           backButtonWarningLabel.setText("Going back will make you lose all of your progress!");
           throw new EmptyComplaintException("Please Enter Details");
       } else if (Warning == true) {
           try {
               Main main = new Main();
               main.changeScene("StandardUserPages/DashBoard.fxml");
           } catch (Exception e) {
               System.out.println("Dashboard Page not Loaded");
           }
       }
   }
   public boolean CheckEmptyComplaint() throws EmptyComplaintException
   {
       KametiManagementSystem kms = new KametiManagementSystem();
       Kameti kameti = kms.getKametiWithId(kametiCode.getText());
       if(kameti != null) {
           User user = kms.retrieveUserWithId(reporter.getText());
           if (user != null) {
               User _offender = kms.retrieveUserWithId(offender.getText());
               if(_offender != null){
                   kms.addComplaintToDb(kameti, user, _offender,complaint.getText());
                   Main main = new Main();
                   try {
                       main.changeScene("StandardUserPages/DashBoard.fxml");
                   } catch (Exception e) {
                       System.out.println("Dashboard Page not Loaded");
                   }
               }

           }
       }

       throw new EmptyComplaintException("Empty Report");
   }

}
