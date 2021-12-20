package Utility;

public class PrivateKametiDetails {
    public String getKametiName() {
        return kametiName;
    }

    public void setKametiName(String kametiName) {
        this.kametiName = kametiName;
    }

    public String getKametiCode() {
        return kametiCode;
    }

    public void setKametiCode(String kametiCode) {
        this.kametiCode = kametiCode;
    }

    public String kametiName;
   public String kametiCode;
    private static PrivateKametiDetails single_instance = null;


    private PrivateKametiDetails()
    {
        kametiName = "";
        kametiCode = "";
    }

    public static PrivateKametiDetails getInstance()
    {
        if (single_instance == null) {
            single_instance = new PrivateKametiDetails();
        }
        return single_instance;
    }
}
