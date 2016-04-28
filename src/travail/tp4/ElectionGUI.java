/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travail.tp4;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;

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
        
        itemApresSimu.addActionListener(null);
        
        menuResultats.add(itemApresSimu);
        menuResultats.add(itemApresGestionScrutin);
        
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
    
}

class
