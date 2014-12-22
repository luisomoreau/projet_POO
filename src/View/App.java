package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    JMenuItem voirPanier=new JMenuItem("Voir panier");
    JMenuItem quitter= new JMenuItem("Quitter");

    //Creation des champs de recherche
    JButton rechercher= new JButton("Rechercher");
    JTextField rechercheTextField= new JTextField("Tapez le nom du produit recherché",20);

    //Création d'un tableau comprenant les telephone du panier
    public ArrayList<Integer> phoneCart = new ArrayList<Integer>();
    int nbarticle = phoneCart.size();

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
        //this.setContentPane(mainPan);
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

        //Creation des champs du tableau de gauche
        JLabel phoneName=new JLabel("Nom :");
        JLabel phonePrice= new JLabel("Prix :");
        leftTablePanel.add(phoneName);
        leftTablePanel.add(phonePrice);

        //On ajoute le panel de droite avec la photo, l'ajout au panier et les détails
        rightTablePanel.setPreferredSize(new Dimension(360, 300));
        rightTablePanel.setLayout(new BorderLayout());
        rightTablePanel.setBorder(border);
        tablePanel.add(rightTablePanel);

        //On ajoute le panel de la photo et celui de l'ajout au panier dans le panel de droite
        ImageIcon phonePicture= new ImageIcon(new ImageIcon("img/iphone6.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        JLabel phonePictureLabel = new JLabel(phonePicture);
        rightTablePanel.add(phonePictureLabel, BorderLayout.CENTER);
        rightTablePanel.add(addToCartPanel, BorderLayout.SOUTH);

        //On ajoute les différents champs ajout au panier dans le label correspondant
        //Creation des champs du tableau de droite
        JCheckBox addToCartCheckBox = new JCheckBox("Ajouter au panier");
        JButton showMoreDetails = new JButton("Détails");
        addToCartPanel.add(addToCartCheckBox);
        addToCartPanel.add(showMoreDetails);

        //On ajoute un écouteur sur le JMenuItem Quitter
        ListenerQuitter listenerQuitter = new ListenerQuitter();
        quitter.addActionListener(listenerQuitter);

        //On ajoute un écouteur sur le JMenuItem Panier
        ListenerCart listenerCart = new ListenerCart();
        voirPanier.addActionListener(listenerCart);

        //On ajoute un écouteur sur le JTextFlied Rechercher
        ListenerSearch listenerSearch = new ListenerSearch();
        rechercheTextField.addActionListener(listenerSearch);
    }

    //Classe interne permettant de quitter l'application
    public class ListenerQuitter implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            {
                if(nbarticle==0)
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

    //Classe interne permettant d'afficher le panier
    public class ListenerCart implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            if(nbarticle!=0){
                JFrame window = new JFrame();
                JPanel panProduit = new JPanel();
                Border borderProduit = BorderFactory.createLineBorder(Color.BLACK);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JScrollPane scrollPane= new JScrollPane(panProduit);

                window.setTitle("Votre panier");
                window.setSize(800, 600);
                window.setLayout(new BorderLayout());
            }else
            {
                JOptionPane.showMessageDialog(null,"Le panier est vide !");
            }
        }
    }

    //Classe interne permettant d'afficher la recherche
    public class ListenerSearch implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null,"Test recherche");
        }
    }
}
