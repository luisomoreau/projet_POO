package Model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Louis on 22/12/2014.
 */
public class Bdd {

    private String url = "jdbc:mysql://localhost/projetPOO";
    private String login ="root";
    private String passwd = "mysql";
    private Connection connexion=null;
    private Statement stmt;
    private ResultSet resultset;

    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection(url, login, passwd);
        }catch (ClassNotFoundException e) {
        e.printStackTrace();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    //On libère les ressources
    public void clear(){
        try {
            resultset.close();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Ici, on compte le nombre de telephone dans la base de données et on enregistre les id dans une liste
    public ArrayList<Integer> getNumberOfPhones(){
        String requeteNumberOfPhones = "SELECT phoneID from telephone GROUP BY phoneID";
        ArrayList<Integer> numberOfPhones = new ArrayList<Integer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection(url, login, passwd);
            Statement stmt = connexion.createStatement();
            ResultSet resultset = stmt.executeQuery(requeteNumberOfPhones);

            while (resultset.next()) {
                numberOfPhones.add(resultset.getInt(1));
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numberOfPhones;
    }

    public ArrayList<String> getPhonePropreties(Integer idPhone){
        String requetePhone = "SELECT * FROM telephone WHERE phoneID="+idPhone;
        ArrayList<String> phonePropreties = new ArrayList();
        try {
            Statement stmt = connexion.createStatement();
            ResultSet resultset = stmt.executeQuery(requetePhone);
            while (resultset.next()){

                phonePropreties.add(resultset.getString(1));
                phonePropreties.add(resultset.getString(2));
                phonePropreties.add(resultset.getString(3));
                phonePropreties.add(resultset.getString(4));
                phonePropreties.add(resultset.getString(5));
                phonePropreties.add(resultset.getString(6));
            }
            return phonePropreties;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phonePropreties;
    }

    public String getPhoneName(Integer idPhone){
        String requetePhoneName = "SELECT phoneName FROM telephone WHERE phoneID="+idPhone;
        String phoneName = "";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet resultset = stmt.executeQuery(requetePhoneName);
            while (resultset.next()){
            phoneName = resultset.getString(1);
            return phoneName;}

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneName;
    }

    public String getPhonePrice(Integer idPhone){
        String requetePhonePrice = "SELECT phonePrice FROM telephone WHERE phoneID="+idPhone;
        String phonePrice = "";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet resultset = stmt.executeQuery(requetePhonePrice);
            while (resultset.next()){
                phonePrice = resultset.getString(1);
                return phonePrice;}

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return phonePrice;
    }

    public String getPhonePicture(Integer idPhone){
        String requetePhonePicture = "SELECT phonePicturePath FROM telephone WHERE phoneID="+idPhone;
        String phonePicture = "";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet resultset = stmt.executeQuery(requetePhonePicture);
            while (resultset.next()){
                phonePicture = resultset.getString(1);
                return phonePicture;}

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return phonePicture;
    }

    public String getPhoneScreenSize(Integer idPhone){
        String requetePhoneScreenSize = "SELECT phoneScreenSize FROM telephone WHERE phoneID="+idPhone;
        String phoneScreenSize = "";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet resultset = stmt.executeQuery(requetePhoneScreenSize);
            while (resultset.next()){
                phoneScreenSize = resultset.getString(1);
                return phoneScreenSize;}

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneScreenSize;
    }

    public String getPhoneBrand(Integer idPhone){
        String requetePhoneBrand = "SELECT phoneBrand FROM telephone WHERE phoneID="+idPhone;
        String phoneBrand = "";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet resultset = stmt.executeQuery(requetePhoneBrand);
            while (resultset.next()){
                phoneBrand = resultset.getString(1);
                return phoneBrand;}

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneBrand;
    }

    public ArrayList<Integer> search(String searchfield){
        String requeteSearch = "SELECT phoneID FROM telephone WHERE phoneName LIKE '%"+searchfield+"%' GROUP BY phoneID";
        ArrayList<Integer> phoneID= new ArrayList<Integer>();
        try {
            Statement stmt = connexion.createStatement();
            ResultSet resultset = stmt.executeQuery(requeteSearch);
            while (resultset.next()){
                phoneID.add(resultset.getInt(1));
                return phoneID;}

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneID;
    }
}
