package Model;

/**
 * Created by Louis on 22/12/2014.
 */

//Dans cette classe on crée un objet telephone dont on se servira par la suite dans la vue
public class Phone {
    private int phoneID ;
    private String phoneName;
    private String phonePrice;
    private String phonePicturePath;
    private String phoneScreenSize;
    private String phoneBrand;

    //Constructeur de la classe
    public Phone(int phoneID, String phoneName, String phonePrice, String phonePicturePath, String phoneScreenSize, String phoneBrand){
        this.phoneID = phoneID;
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
        this.phonePicturePath = phonePicturePath;
        this.phoneScreenSize = phoneScreenSize;
        this.phoneBrand = phoneBrand;
    }

    //Getters et Setters générés
    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(String phonePrice) {
        this.phonePrice = phonePrice;
    }

    public String getPhonePicturePath() {
        return phonePicturePath;
    }

    public void setPhonePicturePath(String phonePicturePath) {
        this.phonePicturePath = phonePicturePath;
    }

    public String getPhoneScreenSize() {
        return phoneScreenSize;
    }

    public void setPhoneScreenSize(String phoneScreenSize) {
        this.phoneScreenSize = phoneScreenSize;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }
}
