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

    public ArrayList<String> getPhones(){
        String requetePhone = "SELECT * FROM telephone";
        ArrayList<String> ensemblePhone = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection(url, login, passwd);
            Statement stmt = connexion.createStatement();
            ResultSet resultset = stmt.executeQuery(requetePhone);

            //ArrayList ensemblePhone = new ArrayList();

            while (resultset.next()){
                ensemblePhone.add(resultset.getString(0));
                ensemblePhone.add(resultset.getString(1));
                ensemblePhone.add(resultset.getString(2));
                ensemblePhone.add(resultset.getString(3));
                ensemblePhone.add(resultset.getString(4));
                ensemblePhone.add(resultset.getString(5));
            }
            return ensemblePhone;

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("et merde");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ensemblePhone;
    }
}
