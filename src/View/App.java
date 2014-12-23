package View;

import Controller.ListenerCart;
import Controller.ListenerQuitter;
import Controller.ListenerSearch;
import Model.Bdd;

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

    Bdd bdd=new Bdd();

    ArrayList<Integer> phonesList = bdd.getNumberOfPhones();

    //Creation des panels
    private JPanel mainPan;
    private JPanel panelHeader;
    private JPanel tablePanel;
    private JPanel rightTablePanel;
    private JPanel leftTablePanel;
    private JPanel addToCartPanel;

    //Creation de la barre de menu
    private JMenuBar barreMenu;

    //Creation du menu
    private JMenu fichier;
    private JMenu panier;

    //Création des items de menu
    private JMenuItem quitter;
    private JMenuItem voirPanier;

    //Creation des labels
    private JLabel phoneName;
    private JLabel phonePrice;
    private JLabel phonePictureLabel;

    //Creation des images
    private ImageIcon phonePicture;

    //Creation des boutons
    private JButton rechercher;
    private JButton showMoreDetails;

    //Creation des JTextField
    private JTextField rechercheTextField;

    //Creation des bordures
    private Border border;

    //Creation de la scollbar
    private JScrollPane scrollPanel;

    //Création d'un tableau comprenant les telephone du panier
    private ArrayList<Integer> phoneCart = new ArrayList<Integer>();
    private int nbarticle = phoneCart.size();

    public void init(){
        System.out.println(phoneCart.size()+" / "+nbarticle);

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


        //Création de tous les elements du menu
        barreMenu=new JMenuBar();
        fichier=new JMenu("Fichier");
        panier=new JMenu("Panier");
        voirPanier=new JMenuItem("Voir panier");
        quitter= new JMenuItem("Quitter");

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

        //Creation du panel principal on lui associe un BorderLayout et on l'insert dans la fenetre
        mainPan = new JPanel();
        mainPan.setLayout(new BorderLayout());
        this.add(mainPan);

        //Creation des elements de recherche
        panelHeader = new JPanel();
        rechercher= new JButton("Rechercher");
        rechercheTextField= new JTextField("Tapez le nom du produit voulu",20);

        //On ajoute le panel recherche au panel principal
        mainPan.add(panelHeader, BorderLayout.NORTH);

        //On ajoute les champs de recherche au panel Header
        panelHeader.add(rechercher);
        panelHeader.add(rechercheTextField);

        //On crée les bordures
        border = BorderFactory.createLineBorder(Color.BLACK);

        //On crée un panel qui contiendra les produits, on lui associe une bordure puis on defini le type de Layout
        tablePanel = new JPanel();
        tablePanel.setBorder(border);
        tablePanel.setLayout(new GridLayout(0,2));

        //On crée une boucle qui retournera autant de table qu'il y a de produit dans la base de données

        for(int i=1; i<=phonesList.size(); i++){

            //On crée le panel de gauche
            leftTablePanel = new JPanel();

            //On defini le panel de gauche avec le nom et le prix de l'article en définissant sa taille, type de layout etc...
            leftTablePanel.setPreferredSize(new Dimension(360, 300 ));
            leftTablePanel.setLayout(new BoxLayout(leftTablePanel, BoxLayout.PAGE_AXIS));
            leftTablePanel.setBorder(border);

            //Creation des champs du tableau de gauche
            phoneName=new JLabel("Nom :"+bdd.getPhoneName(i));
            phonePrice= new JLabel("Prix :"+bdd.getPhonePrice(i)+" euros");

            //On crée le panel de droite
            rightTablePanel = new JPanel();

            //On defini le panel de droite avec la photo, la checkbox et les details de l'article en définissant, type de layout etc...
            rightTablePanel.setPreferredSize(new Dimension(360, 300));
            rightTablePanel.setLayout(new BorderLayout());
            rightTablePanel.setBorder(border);

            //On ajoute le panel de la photo et celui de l'ajout au panier dans le panel de droite
            phonePicture= new ImageIcon(new ImageIcon("img/"+bdd.getPhonePicture(i)).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
            phonePictureLabel = new JLabel(phonePicture);

            addToCartPanel = new JPanel();
            //On ajoute les différents champs ajout au panier dans le label correspondant
            //Creation des champs du tableau de droite
            final JCheckBox addToCartCheckBox = new JCheckBox("Ajouter au panier");
            JButton showMoreDetails = new JButton("Details");
            addToCartPanel.add(addToCartCheckBox);
            addToCartPanel.add(showMoreDetails);

            leftTablePanel.add(phoneName);
            leftTablePanel.add(phonePrice);

            rightTablePanel.add(phonePictureLabel, BorderLayout.CENTER);
            rightTablePanel.add(addToCartPanel, BorderLayout.SOUTH);

            tablePanel.add(leftTablePanel);
            tablePanel.add(rightTablePanel);

            //On ajoute le panel des produits au panel principal
            mainPan.add(tablePanel, BorderLayout.CENTER);

            //Bouton detail avec une ecoute sur le bouton :
            final int finalI = i;
            showMoreDetails.addActionListener(new ActionListener() {
                                                  public void actionPerformed(ActionEvent e) {

                                                      JFrame detailWindow = new JFrame();
                                                      String message = "Details du telephone :\n - nom : "+bdd.getPhoneName(finalI)+" \n- prix : "+bdd.getPhonePrice(finalI)+" euros \n -taille de l'ecran : "+bdd.getPhoneScreenSize(finalI)+" pouces \n- marque commerciale : "+bdd.getPhoneBrand(finalI);
                                                      JOptionPane.showMessageDialog(detailWindow, message);
                                                  }
                                              }
            );

            //Checkbox ajout du téléphone avec une ecoute sur la JCheckBox
            addToCartCheckBox.addActionListener(new ActionListener() {
                                                    public void actionPerformed(ActionEvent e) {
                                                        if (addToCartCheckBox.isSelected()) {
                                                            int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous ajouter mettre cet article dans votre panier ?", "Ajouter un telephone au panier", JOptionPane.YES_NO_OPTION);
                                                            if (rep == 0) {
                                                                phoneCart.add(finalI);
                                                                nbarticle++;
                                                                System.out.println(phoneCart.size()+" / "+nbarticle);
                                                            } else {
                                                                addToCartCheckBox.setSelected(false);
                                                            }
                                                        }
                                                    }
                                                }
            );
        }



        //Creation de la scrollbar
        scrollPanel = new JScrollPane(mainPan);
        //On rend la fenetre scrollable
        this.add(scrollPanel);

        //On ajoute un écouteur sur le JMenuItem Panier
        ListenerCart listenerCart = new ListenerCart();
        voirPanier.addActionListener(listenerCart);

    }

    //Classe interne permettant d'afficher le panier
    public class ListenerCart implements ActionListener
    {
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
                    tablePanel.setLayout(new GridLayout(0,2,10,10));

                    window.add(scrollPane);
                    window.setVisible(true);
                }
            }else {
                JOptionPane.showMessageDialog(null,"Le panier est vide !");
            }
        }
    }


    //Création des getters et setters
    public JMenuItem getQuitter() {
        return quitter;
    }

    public JMenuItem getVoirPanier() {
        return voirPanier;
    }

    public JTextField getRechercheTextField() {
        return rechercheTextField;
    }

    public JButton getRechercher() {
        return rechercher;
    }

    public ArrayList<Integer> getPhoneCart() {
        return phoneCart;
    }

    public int getNbarticle() {
        return nbarticle;
    }





}
