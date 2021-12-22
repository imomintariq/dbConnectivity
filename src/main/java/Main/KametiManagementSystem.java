package Main;

import Entities.Kameti;
import Entities.Member;
import Entities.User;
import Utility.SignedInUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KametiManagementSystem {

    private boolean admin; //0 for admin; 1 for standard user.

    public ArrayList<String> retrieveKametis() {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Kameti.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<Kameti> kametiList = session.createQuery("FROM Kameti").getResultList();
        ArrayList<String> kametiStringList = new ArrayList<>();

        for(int i=0;i<kametiList.size();i++)
        {
            System.out.println(kametiList.get(i).getKametiName());
            System.out.println(kametiList.get(i).getKametiDuration());
            System.out.println(kametiList.get(i).getTotalPayout());
            //System.out.printf("%2d. %-20s $%.2f%n",  kametiList.get(i).getKametiName(), kametiList.get(i).getKametiDuration(), kametiList.get(i).getTotalPayout());
            kametiStringList.add(kametiList.get(i).getId() + "          "+kametiList.get(i).getKametiName() + "          " +kametiList.get(i).getKametiDuration() + "          " + kametiList.get(i).getTotalPayout());

        }
        return kametiStringList;

    }

    public void registerAUser(String username, String password, String email, String cnic, String firstName, String lastName, String phoneNumber, String confirmedPassword, boolean checkAdmin) {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(User.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();

        User user= new User();
        //member.setId();
        //member.
        user.setId(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setCnic(cnic);
        user.setPhoneNumber(phoneNumber);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAdminCheck(checkAdmin);
        session.save(user);


        trans.commit();

    }

    public String LogIn(String Username, String Password) {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(User.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<User> UserList = session.createQuery("FROM User").getResultList();

            for(int i=0;i<UserList.size();i++)
            {
                System.out.println(UserList.get(i).getId());
                System.out.println(UserList.get(i).getPassword());
                if(Username.equals(UserList.get(i).getId()) && Password.equals(UserList.get(i).getPassword())) {
                    if(UserList.get(i).getAdminCheck() == true){
                        return "admin";
                    }
                    else{
                        return "standard user";
                    }
                }
            }
            return "not found";
    }

    public void AddAKameti(String KametiName, String frequency, String Rule1, String Rule2, String Rule3, String Rule4, String Rule5, String isPrivate, int KametiPayout, LocalDate LC,int kametiDuration) {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Kameti.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();
        Kameti K = new Kameti();
        //SETTING VALUES
        K.setKametiName(KametiName);
        K.setKametiDuration(kametiDuration);
        K.setFrequency(frequency);
        K.setRule1(Rule1);
        K.setRule2(Rule2);
        K.setRule3(Rule3);
        K.setRule4(Rule4);
        K.setRule5(Rule5);
        K.setIsPrivate(isPrivate);
        K.setTotalPayout(KametiPayout);
        K.setStartDate(LC);
        K.setIndividualShare(0);
        if(frequency.equals("After 15 Days")){
            System.out.println("Freq is fortnightly");


            K.setTotalMembers(kametiDuration*2);
            K.setIndividualShare(KametiPayout/K.getTotalMembers());
            System.out.println("Total Payout " + KametiPayout);
            System.out.println("Total Members " + kametiDuration*2);
            System.out.println("Individual Share " + K.getIndividualShare());
        }
        else if (frequency.equals("Monthly")){
            System.out.println("Freq is monthly");
            K.setTotalMembers(kametiDuration);
            K.setIndividualShare(KametiPayout/K.getTotalMembers());

            System.out.println("Total Payout " + KametiPayout);
            System.out.println("Total Members " + kametiDuration);
            System.out.println("Individual Share " + K.getIndividualShare());
        }


        //K.setId(5);
        SignedInUser signedInUser = SignedInUser.getInstance();
        K.setKametiHead(signedInUser.getUser());
        session.save(K);
        trans.commit();
        System.out.println(Rule1 + Rule2 + Rule3 + Rule4 + Rule5);

    }

    /*public boolean checkUser(String username) {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Kameti.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<User> UserList = session.createQuery("FROM User", User).getResultList();

        boolean found = false;

        for(int i=0;i<UserList.size();i++) {
           if(UserList.get(i).getId().equals(username)){
               return true;
           }
        }

        return false;

    }*/

    public User retrieveUser(String username, String password) {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(User.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<User> UserList = session.createQuery("FROM User").getResultList();

        for(int i=0;i<UserList.size();i++)
        {
            System.out.println(UserList.get(i).getId());
            System.out.println(UserList.get(i).getPassword());
            if(username.equals(UserList.get(i).getId()) && password.equals(UserList.get(i).getPassword()))
            {
                return UserList.get(i);
            }
        }
        return null;
    }

    public Kameti getKametiWithId(String selectedKametiId) {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Kameti.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<Kameti> kametiList = session.createQuery("FROM Kameti").getResultList();
        ArrayList<String> kametiStringList = new ArrayList<>();

        for(int i=0;i<kametiList.size();i++)
        {
            if(kametiList.get(i).getId() == Integer.parseInt(selectedKametiId)){
                return kametiList.get(i);
            }
        }
        return null;
    }

    public void addMemberToKameti(User user, Kameti kametiToBeJoined) {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Member.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();


        Member member= new Member();

        member.setKametiId(kametiToBeJoined);
        member.setUsername(user);
        member.setTurnNumber(-1);
        member.setIsHead("false");
        member.setHasPaid("false");
        session.save(member);


        trans.commit();

    }

    public ArrayList<String> retrieveJoinedKametis() {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Member.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<Member> memberList = session.createQuery("FROM Member").getResultList();
        ArrayList<String> kametiStringList = new ArrayList<>();

        SignedInUser signedInUser = SignedInUser.getInstance();
        String username = signedInUser.getUser().getId();


        for(int i=0;i<memberList.size();i++)
        {
            if(memberList.get(i).getUsername().getId().equals(username)){
                kametiStringList.add(memberList.get(i).getKametiId().getId() + "          "+memberList.get(i).getKametiId().getKametiName() + "          " +memberList.get(i).getKametiId().getKametiDuration() + "          " + memberList.get(i).getKametiId().getTotalPayout());
                System.out.println(memberList.get(i).getKametiId().getId() + "          "+memberList.get(i).getKametiId().getKametiName() + "          " +memberList.get(i).getKametiId().getKametiDuration() + "          " + memberList.get(i).getKametiId().getTotalPayout());
            }


        }
        return kametiStringList;
    }


    public ArrayList<String> retrieveOwnedKametis() {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Member.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<Kameti> kametiList = session.createQuery("FROM Kameti").getResultList();
        ArrayList<String> kametiStringList = new ArrayList<>();

        SignedInUser signedInUser = SignedInUser.getInstance();
        String username = signedInUser.getUser().getId();


        for(int i=0;i<kametiList.size();i++)
        {
            if(kametiList.get(i).getKametiHead().getId().equals(username)){
                kametiStringList.add(kametiList.get(i).getId() + "          "+kametiList.get(i).getKametiName() + "          " +kametiList.get(i).getKametiDuration() + "          " + kametiList.get(i).getTotalPayout());
                //System.out.println(memberList.get(i).getKametiId().getId() + "          "+memberList.get(i).getKametiId().getKametiName() + "          " +memberList.get(i).getKametiId().getKametiDuration() + "          " + memberList.get(i).getKametiId().getTotalPayout());
            }


        }
        return kametiStringList;
    }
}
