package MainPrg;

import Model.Bdd;
import View.App;

import java.util.ArrayList;

/**
 * Created by Louis on 18/12/2014.
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");

        App app=new App();
        //Bdd bdd=new Bdd();
/*
        ArrayList<Integer> phonesList = bdd.getNumberOfPhones();

        for(int i=0; i<phonesList.size(); i++){
            System.out.println(bdd.getPhoneName(i));
            System.out.println(bdd.getPhonePrice(i));
            System.out.println(bdd.getPhonePicture(i));
            System.out.println(bdd.getPhoneScreenSize(i));
            System.out.println(bdd.getPhoneBrand(i));
            System.out.println("");
        }*/
    }
}
