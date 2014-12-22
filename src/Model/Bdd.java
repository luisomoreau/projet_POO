package Model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Louis on 22/12/2014.
 */
public class Bdd {

    String url = "jdbc:mysql://localhost/projetPOO";
    String login ="root";
    String passwd = "mysql";
    Connection connexion=null;

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
    //Ici, on compte le nombre de telephone dans la base de données et on enregistre les id dans une liste
    public ArrayList<Integer> getNumberOfPhones(){
        String requeteNumberOfPhones = "SELECT phoneID from telephone GROUP BY phoneID";
        connect();
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
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection(url, login, passwd);
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

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phonePropreties;
    }
}
