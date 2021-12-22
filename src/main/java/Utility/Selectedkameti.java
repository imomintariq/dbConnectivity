package Utility;

import Entities.Kameti;
import Entities.User;

public class Selectedkameti {
    private static Selectedkameti selectedkameti = null;


    private Kameti kameti;

    private Selectedkameti(){
    }

    public static Selectedkameti getInstance(){
        if(selectedkameti ==  null){
            selectedkameti = new Selectedkameti();
        }
        return selectedkameti;
    }

    public Kameti getKameti() {
        return kameti;
    }

    public void setKameti(Kameti kameti) {
        this.kameti = kameti;
    }
}
