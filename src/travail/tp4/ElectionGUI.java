/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travail.tp4;

import com.sun.java.swing.plaf.motif.MotifBorders;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.WEST;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.WEST;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author beetix
 */
public class ElectionGUI extends JFrame {
    
    public ElectionGUI()
    {
        super("Résultat des élections");
        lancer();
    }
    
    
    
    private void lancer()
    {
        // Barre de menus
        JMenuBar barreMenu = new JMenuBar();
        
        // Sous menu Résultats élection
        JMenu menuResultats = new JMenu("Résultats élection");
        JMenuItem itemApresSimu = new JMenuItem("Après simulation");
        JMenuItem itemApresGestionScrutin = new JMenuItem("Après gestion d'un scrutin");
        JMenuItem itemExit = new JMenuItem(new AbstractAction("Exit"){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        itemApresSimu.addActionListener(new ElectionActionListener());
        
        menuResultats.add(itemApresSimu);
        menuResultats.add(itemApresGestionScrutin);
        menuResultats.add(itemExit);
        
        barreMenu.add(menuResultats);
        // Sous menu Préférences
        JMenu menuPreferences = new JMenu("Préférences");
        
        // Sous sous menu Ordre d'affichage des résultats
        JMenu menuOrdreAffichage = new JMenu("Ordre d'affichage des résultats");        
        JMenuItem itemOrdreAlphabetique = new JMenuItem("Par ordre alphabétique");
        JMenuItem itemOrdreResultat = new JMenuItem("Par ordre décroissant des résultats");
        
        menuOrdreAffichage.add(itemOrdreAlphabetique);
        menuOrdreAffichage.add(itemOrdreResultat);
        
        menuPreferences.add(menuOrdreAffichage);
        
        // Sous sous menu Couleur des libellés
        JMenu menuCouleurLibelles = new JMenu("Couleur des libellés");
        
        menuPreferences.add(menuCouleurLibelles);
        
        // Sous sous menu Taille police de libellés
        JMenu menuTailleLibelles = new JMenu("Taille police de libellés");
        
        menuPreferences.add(menuTailleLibelles);
        
        barreMenu.add(menuPreferences);
        
        setJMenuBar(barreMenu);
        
        JPanel panel = (JPanel) getContentPane();
        
        // Fond rouge
        panel.setBackground(Color.red);
        
        // Felix le chat
        JLabel imageAccueil = new JLabel(new ImageIcon("ressources/gif/felixCat.gif"), CENTER);
        panel.add(imageAccueil, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        ElectionGUI testElectionGUI = new ElectionGUI();
    }
    
    class ElectionActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            afficheResultats();
        }
    }
    
    private void afficheResultats()
    {
        JPanel panneauPrincipal = (JPanel) getContentPane();
        
        // On enlève tout
        panneauPrincipal.removeAll();
        panneauPrincipal.setBackground(null);
        
        // Panneau Ouest
        JPanel panneauOuest = new JPanel();
        panneauOuest.setBackground(Color.yellow);
        panneauOuest.setBorder(new LineBorder(Color.cyan));
        
        // Label panneau Ouest
        JLabel labelOuest = new JLabel("Ouest");
        panneauOuest.add(labelOuest);

        // Panneau Central
        JPanel panneauCentral = new JPanel(new GridLayout(2,2));
        panneauCentral.setBackground(Color.red);
        panneauCentral.setBorder(new LineBorder(Color.white));
        
        // Labels panneau Central
        JLabel labelCentral1 = new JLabel("Centre 1");
        JLabel labelCentral2 = new JLabel("Centre 2");
        JLabel labelCentral3 = new JLabel("Centre 3");
        JLabel labelCentral4 = new JLabel("Centre 4");
        
        panneauCentral.add(labelCentral1);
        panneauCentral.add(labelCentral2);     
        panneauCentral.add(labelCentral3);
        panneauCentral.add(labelCentral4);
        
        // Ajout dans le panneau principal
        panneauPrincipal.setLayout(new BorderLayout());
        panneauPrincipal.add(panneauOuest, BorderLayout.WEST);
        panneauPrincipal.add(panneauCentral, BorderLayout.CENTER);
        
        setContentPane(panneauPrincipal);
        
    }

    
}

