package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Louis on 18/12/2014.
 */

public class App extends JFrame{

    //Creation des panels
    private JPanel mainPan = new JPanel();
    private JPanel panelHeader = new JPanel();
    private JPanel tablePanel = new JPanel();
    private JPanel leftTablePanel = new JPanel();
    private JPanel rightTablePanel = new JPanel();
    private JPanel addToCartPanel = new JPanel();

    //Creation de la scrollbar
    private JScrollPane scrollPanel= new JScrollPane();

    //Création du menu
    private JMenuBar barreMenu=new JMenuBar();
    private JMenu fichier=new JMenu("Fichier");
    private JMenu panier=new JMenu("Panier");
    private JMenuItem voirPanier=new JMenuItem("Quitter");
    private JMenuItem quitter= new JMenuItem("Voir panier");

    //Creation des champs de recherche
    private JButton rechercher= new JButton("Rechercher");
    private JTextField rechercheTextField= new JTextField("Tapez le nom du produit recherché",20);

    //Creation des champs du tableau de gauche
    private JLabel phoneName=new JLabel("Nom :");
    private JLabel phonePrice= new JLabel("Prix :");

    //Creation des champs du tableau de droite
    private JLabel phonePictureLabel = new JLabel();
    private ImageIcon phonePicture= new ImageIcon(new ImageIcon("img/iphone6.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
    private JCheckBox addToCartCheckBox = new JCheckBox("Ajouter au panier");
    private JButton showMoreDetails = new JButton("Détails");


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
        this.setContentPane(mainPan);

        //On ajoute le panel recherche au panel principal
        mainPan.add(panelHeader, BorderLayout.NORTH);

        //On ajoute les champs de recherche au panel Header
        panelHeader.add(rechercher);
        panelHeader.add(rechercheTextField);

        //On crée les bordures
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        //On crée un panel qui contiendra les produits
        tablePanel.setBorder(border);
        tablePanel.setLayout(new GridLayout(0,2,10,10));

        //On ajoute le panel de gauche avec le nom et le prix de l'article en définissant sa taille et sa position
        leftTablePanel.setPreferredSize(new Dimension(300, 300 ));
        leftTablePanel.setLayout(new BoxLayout(leftTablePanel, BoxLayout.PAGE_AXIS));
        leftTablePanel.setBorder(border);
        tablePanel.add(leftTablePanel);

        //On ajoute les champs nom et prix au panel de gauche
        leftTablePanel.add(phoneName);
        leftTablePanel.add(phonePrice);

        //On ajoute le panel de droite avec la photo, l'ajout au panier et les détails
        rightTablePanel.setPreferredSize(new Dimension(300, 300));
        rightTablePanel.setLayout(new BoxLayout(rightTablePanel, BoxLayout.PAGE_AXIS));
        rightTablePanel.setBorder(border);
        tablePanel.add(rightTablePanel);

        //On ajoute le panel de la photo et celui de l'ajout au panier dans le panel de droite
        rightTablePanel.add(phonePictureLabel);
        rightTablePanel.add(addToCartPanel);

        //On ajoute les différents champs ajout au panier dans le label correspondant
        addToCartPanel.add(addToCartCheckBox);
        addToCartPanel.add(showMoreDetails);

    }
    /*
    private JPanel initialise(){

        //On initialise le tableau qui contiendra le nom de l'article et le prix ainsi que la photo du téléphone, l'ajout au panier + le bouton de détail
        tablePanel = new JPanel();
        tablePanel.setPreferredSize( new Dimension( 800, 280 ) );
        tablePanel.setLayout(new BorderLayout());
        //tableau de gauche
        leftTablePanel = new JPanel();
        phoneName = new JLabel("Nom :");
        phonePrice = new JLabel("Prix :");
        leftTablePanel.add(phoneName);
        leftTablePanel.add(phonePrice);
        tablePanel.add(leftTablePanel, BorderLayout.CENTER);

        //Tableau de droite
        rightTablePanel = new JPanel();
        phonePicture = new ImageIcon(new ImageIcon("img/iphone6.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        phonePictureLabel = new JLabel(phonePicture);
        addToCartPanel = new JPanel();
        addToCartCheckBox = new JCheckBox();
        showMoreDetails = new JButton("Details");
        addToCartPanel.add(addToCartCheckBox);
        addToCartPanel.add(showMoreDetails);
        rightTablePanel.setLayout(new BorderLayout());
        rightTablePanel.add(addToCartPanel, BorderLayout.SOUTH);
        rightTablePanel.add(phonePictureLabel, BorderLayout.CENTER);
        tablePanel.add(rightTablePanel, BorderLayout.EAST);


        //On associe les bordures aux différents panel
        tablePanel.setBorder(border);
        rightTablePanel.setBorder(border);
        leftTablePanel.setBorder(border);


        //On ajoute les panels au panel principal
        mainPan.setLayout(new BorderLayout());
        mainPan.add(panelHeader, BorderLayout.NORTH);
        mainPan.add(tablePanel, BorderLayout.CENTER);

        return mainPan;

    }
    */
}
