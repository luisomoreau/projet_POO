package MainPrg;

import Model.Bdd;
import View.App;

import java.util.ArrayList;

/**
 * Created by Louis on 18/12/2014.
 */
public class Testing {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");

        //App app=new App();
        Bdd bdd=new Bdd();
        bdd.connect();

        //ArrayList<Integer> list = bdd.search("a");

        ArrayList<Integer> list = bdd.getNumberOfPhones();

        for(int i=0; i<list.size(); i++){
            //System.out.println(list.size());

            //System.out.println(list.get(i));
            System.out.println(bdd.getPhoneName(list.get(i)));
            System.out.println(bdd.getPhonePrice(list.get(i)));
            System.out.println(bdd.getPhonePicture(list.get(i)));
            System.out.println(bdd.getPhoneScreenSize(list.get(i)));
            System.out.println(bdd.getPhoneBrand(list.get(i)));
            System.out.println("");
        }
    }
}
