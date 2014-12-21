package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Louis on 18/12/2014.
 */

public class App extends JFrame{

    //Creation des panels
    JPanel mainPan = new JPanel();
    JPanel panelHeader = new JPanel();
    JPanel tablePanel = new JPanel();
    JPanel leftTablePanel = new JPanel();
    JPanel rightTablePanel = new JPanel();
    JPanel addToCartPanel = new JPanel();

    //Creation de la scrollbar
    JScrollPane scrollPanel= new JScrollPane(mainPan);

    //Création du menu
    JMenuBar barreMenu=new JMenuBar();
    JMenu fichier=new JMenu("Fichier");
    JMenu panier=new JMenu("Panier");
    JMenuItem voirPanier=new JMenuItem("Quitter");
    JMenuItem quitter= new JMenuItem("Voir panier");

    //Creation des champs de recherche
    JButton rechercher= new JButton("Rechercher");
    JTextField rechercheTextField= new JTextField("Tapez le nom du produit recherché",20);

    //Creation des champs du tableau de gauche
    JLabel phoneName=new JLabel("Nom :");
    JLabel phonePrice= new JLabel("Prix :");

    //Creation des champs du tableau de droite
    JCheckBox addToCartCheckBox = new JCheckBox("Ajouter au panier");
    JButton showMoreDetails = new JButton("Détails");


    public App(){

        //Déclaration du titre
        this.setTitle("Projet POO : e-Commerce");

        //Déclaration des paramètres de la fenetre JFrame
        this.setSize(800, 600);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        //JOptionPane.showMessageDialog(this, "Commencer mes achats");

        //On rend la fenetre scrollable
        this.add(scrollPanel);

        //On ajoute un menu à la fenêtre principale
        this.setJMenuBar(barreMenu);
        //On ajoute les deux onglets "fichier" et "panier"
        barreMenu.add(fichier);
        barreMenu.add(panier);

        //On crée les Mnémoniques
        fichier.setMnemonic('F');
        panier.setMnemonic('P');

        //On ajoute les champs "Quitter" à l'onglet "Fichier" et "Voir le panier" à "Panier"
        fichier.add(quitter);
        panier.add(voirPanier);

        // On appelle la méthode qui retournera toute notre vue.
        this.add(mainPan);

        //On ajoute le panel recherche au panel principal
        mainPan.add(panelHeader, BorderLayout.NORTH);

        //On ajoute les champs de recherche au panel Header
        panelHeader.add(rechercher);
        panelHeader.add(rechercheTextField);

        //On crée les bordures
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        //On crée un panel qui contiendra les produits
        tablePanel.setBorder(border);
        tablePanel.setLayout(new GridLayout(0,2));

        //On ajoute le panel des produits au panel principal
        mainPan.add(tablePanel, BorderLayout.CENTER);

        //On ajoute le panel de gauche avec le nom et le prix de l'article en définissant sa taille et sa position
        leftTablePanel.setPreferredSize(new Dimension(360, 300 ));
        leftTablePanel.setLayout(new BoxLayout(leftTablePanel, BoxLayout.PAGE_AXIS));
        leftTablePanel.setBorder(border);
        tablePanel.add(leftTablePanel);

        //On ajoute les champs nom et prix au panel de gauche
        leftTablePanel.add(phoneName);
        leftTablePanel.add(phonePrice);

        //On ajoute le panel de droite avec la photo, l'ajout au panier et les détails
        rightTablePanel.setPreferredSize(new Dimension(360, 300));
        rightTablePanel.setLayout(new BoxLayout(rightTablePanel, BoxLayout.PAGE_AXIS));
        rightTablePanel.setBorder(border);
        tablePanel.add(rightTablePanel);

        //On ajoute le panel de la photo et celui de l'ajout au panier dans le panel de droite
        ImageIcon phonePicture= new ImageIcon(new ImageIcon("img/iphone6.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        JLabel phonePictureLabel = new JLabel(phonePicture);
        rightTablePanel.add(phonePictureLabel);
        rightTablePanel.add(addToCartPanel);

        //On ajoute les différents champs ajout au panier dans le label correspondant
        addToCartPanel.add(addToCartCheckBox);
        addToCartPanel.add(showMoreDetails);

    }
}
