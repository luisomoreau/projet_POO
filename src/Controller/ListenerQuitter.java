package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.App;

/**
 * Created by Louis on 23/12/2014.
 */
//Classe interne permettant de quitter l'application
public class ListenerQuitter implements ActionListener {

    App app = new App();
    JMenuItem quitter = new JMenuItem();

    public ListenerQuitter(App window,JMenuItem quitter){
        this.app=window;
        this.quitter=quitter;
    }
    public void actionPerformed(ActionEvent arg0){
        {
            if(app.getNbarticle()==0)
            {
                System.exit(0);
            }
            else
            {
                int i = JOptionPane.showConfirmDialog(null, " Il y a des articles présents dans votre panier. \nSouhaitez vous quitter l'application ?", "Quitter", JOptionPane.YES_NO_OPTION);
                if( i == 0)
                {
                    System.exit(0);
                }
            }
        }
    }
}
