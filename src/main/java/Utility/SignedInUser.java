package Utility;

import Entities.User;

public class SignedInUser {
    private static SignedInUser signedInUser = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    private SignedInUser(){
    }

    public static SignedInUser getInstance(){
        if(signedInUser ==  null){
            signedInUser = new SignedInUser();
        }
        return signedInUser;
    }


}
