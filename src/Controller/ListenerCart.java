package Controller;

import Model.Bdd;
import View.App;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Louis on 23/12/2014.
 */
//Classe permettant de voir le panier
public class ListenerCart implements ActionListener {
    App app = new App();
    Bdd bdd = new Bdd();

    JMenuItem voirPanier = new JMenuItem();

    private int nbarticle = app.getNbarticle();
    private ArrayList<Integer> phoneCart = app.getPhoneCart();
    //private Integer nbarticle;

    public ListenerCart(App window, JMenuItem voirPanier, int nbarticle){
        this.app=window;
        this.voirPanier=voirPanier;
        this.nbarticle = nbarticle;
    }

    public void actionPerformed(ActionEvent arg0)
    {
        if(nbarticle!=0){
            JFrame window = new JFrame();
            JPanel tablePanel = new JPanel();
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JScrollPane scrollPane= new JScrollPane(tablePanel);

            window.setTitle("Votre panier");
            window.setSize(800, 600);
            window.setLayout(new BorderLayout());

            for(int i = 0;i<nbarticle;i++)
            {
                JPanel leftTablePanel = new JPanel();
                JPanel rightTablePanel = new JPanel();
                JLabel phoneName= new JLabel("Nom : "+bdd.getPhoneName(phoneCart.get(i)));
                JLabel phonePrice = new JLabel("Prix : "+bdd.getPhonePrice(phoneCart.get(i))+" euros");
                leftTablePanel.add(phoneName);
                leftTablePanel.add(phonePrice);
                leftTablePanel.setBorder(border);
                leftTablePanel.setLayout(new BoxLayout(leftTablePanel, BoxLayout.PAGE_AXIS));

                ImageIcon phonePicture= new ImageIcon(new ImageIcon("img/"+bdd.getPhonePicture(phoneCart.get(i))).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
                JLabel phonePictureLabel = new JLabel(phonePicture);
                rightTablePanel.add(phonePictureLabel);
                rightTablePanel.setBorder(border);

                tablePanel.add(leftTablePanel);
                tablePanel.add(rightTablePanel);

                tablePanel.setBorder(border);
                tablePanel.setLayout(new GridLayout(0,2));

                window.add(scrollPane);
                window.setVisible(true);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Le panier est vide !");
        }
    }
}
