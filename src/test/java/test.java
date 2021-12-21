import Main.KametiManagementSystem;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class test {

    static KametiManagementSystem kms;
    static ArrayList<String> kametiStringList;

    @BeforeClass
    public static void setUp(){
        kms = new KametiManagementSystem();
        kametiStringList = kms.retrieveKametis();
        kms.registerAUser("sampleUser1","password","sampleuser@email.com","13123 3123123 12","Sample","User","0300 0000000","password");
    }

    @Test
    public void logInCheck(){
        Assertions.assertEquals(kms.LogIn("No User","User"),false);
    }

    @Test
    public void checkKametiInsertion(){
        kms.AddAKameti("Sample Kameti","Monthly","true","true","false","false","false","Private Kameti",1000, LocalDate.ofEpochDay(2021-12-22),4);

        String check = "Sample Kameti"+ "          " +"4" + "          " + "1000";

        boolean found = false;

        for(int i=0; i<kametiStringList.size(); i++) {
            if(kametiStringList.get(i).equals(check)){
                found = true;
                break;
            }
        }

        Assertions.assertEquals(found,true);
    }

   /* @Test
    public void checkUserInsertion(){
        Assertions.assertEquals(kms.checkUser("No User"),true);
    }*/

}