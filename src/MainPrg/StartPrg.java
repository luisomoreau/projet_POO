package MainPrg;

import Controller.ListenerQuitter;
import Controller.ListenerSearch;
import View.App;

import java.util.ArrayList;

/**
 * Created by Louis on 18/12/2014.
 */
public class StartPrg {
    public static void main(String[] args) {
        //On démarre la vue
        App app=new App();
        app.init();

        ListenerQuitter listenerQuitter = new ListenerQuitter(app, app.getQuitter());
        app.getQuitter().addActionListener(listenerQuitter);

        ListenerSearch listenerSearch = new ListenerSearch(app, app.getRechercheTextField());
        app.getRechercher().addActionListener(listenerSearch);
    }
}
