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
public class ListenerSearch implements ActionListener {
    App app = new App();
    Bdd bdd = new Bdd();

    JTextField rechercherTextField = app.getRechercheTextField();

    public ListenerSearch(App window, JTextField rechercherTextField){
        this.app = window;
        this.rechercherTextField = rechercherTextField;
    }

    public void actionPerformed(ActionEvent arg0) {
        String searchText = rechercherTextField.getText();
        ArrayList<Integer> resultatRecherche;
        //On se connecte à la base données
        bdd.connect();
        resultatRecherche = bdd.search(searchText);
        if(resultatRecherche.isEmpty()){
            JOptionPane.showMessageDialog(null, "Aucun produit ne correspond !");
        }else {
            JFrame window = new JFrame();
            JPanel tablePanel = new JPanel();
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JScrollPane scrollPane= new JScrollPane(tablePanel);

            window.setTitle("Resultat de recherche :"+searchText);
            window.setSize(800, 600);
            window.setLayout(new BorderLayout());

            for(int i = 0;i<resultatRecherche.size();i++)
            {
                JPanel leftTablePanel = new JPanel();
                JPanel rightTablePanel = new JPanel();
                JLabel phoneName= new JLabel("Nom : "+bdd.getPhoneName(resultatRecherche.get(i)));
                JLabel phonePrice = new JLabel("Prix : "+bdd.getPhonePrice(resultatRecherche.get(i))+" euros");
                leftTablePanel.add(phoneName);
                leftTablePanel.add(phonePrice);
                leftTablePanel.setBorder(border);
                leftTablePanel.setLayout(new BoxLayout(leftTablePanel, BoxLayout.PAGE_AXIS));

                ImageIcon phonePicture= new ImageIcon(new ImageIcon("img/"+bdd.getPhonePicture(resultatRecherche.get(i))).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
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
        }
    }
}
