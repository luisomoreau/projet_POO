package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Louis on 18/12/2014.
 */

public class App extends JFrame{

    private JMenuBar barreMenu;
    private JMenu fichier;
    private JMenu panier;
    private JMenuItem voirPanier;
    private JMenuItem quitter;
    private JPanel mainPan;
    private JPanel panelHeader;
    private JButton rechercher;
    private JTextField rechercheTextField;

    public App(){
        this.setTitle("Convertisseur de monnaie");
        this.setSize(800, 500);

        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(this, "Commencer mes achats");

        // On appelle la méthode qui retournera toute notre vue.
        this.setContentPane(initialise());

        //On ajoute un menu à la fenêtre principale
        //Ici est initialisée la barre de menu
        barreMenu=new JMenuBar();

        //On ajoute les deux onglets "fichier" et "panier"
        fichier=new JMenu("Fichier");
        panier=new JMenu("Panier");
        barreMenu.add(fichier);
        barreMenu.add(panier);

        //On ajoute les champs "Quitter" à l'onglet "Fichier" et "Voir le panier" à "Panier"
        quitter=new JMenuItem("Quitter");
        voirPanier= new JMenuItem("Voir panier");
        fichier.add(quitter);
        panier.add(voirPanier);

        this.setJMenuBar(barreMenu);
    }
    private JPanel initialise(){
        //On initialise le panel principal
        mainPan = new JPanel();
        //On initialise le premier JPanel qui contiendra le header, à savoir le bouton "rechercher" et le champs de recherche
        panelHeader = new JPanel();
        rechercher= new JButton("Rechercher");
        rechercheTextField= new JTextField("Tapez le nom du produit recherché",20);

        //On ajoute les deux champs au panel Header
        panelHeader.add(rechercher);
        panelHeader.add(rechercheTextField);

        //On ajoute le panel Header au panel principal
        mainPan.add(panelHeader, BorderLayout.NORTH);

        return mainPan;

    }
}
