package MainPrg;

import Model.Bdd;
import View.App;

import java.util.ArrayList;

/**
 * Created by Louis on 18/12/2014.
 */
public class Main {
    public static void main(String[] args) {
       // App app=new App();
        Bdd bdd=new Bdd();

        ArrayList<String > phones = bdd.getPhones();

        for(String elem: phones)
        {
            System.out.println (elem);
        }

    }
}
