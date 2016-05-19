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
import java.util.List;
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
import correction.tp1.Candidat;
import correction.tp1.Civilite;
import java.awt.Font;
import java.util.Iterator;
import java.util.Map;
import javax.swing.Box;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.renderer.category.BarRenderer;
import java.awt.GradientPaint;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 *
 * @author beetix
 */
public class ElectionGUI extends JFrame {
    
    private List<Candidat> listcandidats;
    private Election election;	
    private String imageAccueil;

    public ElectionGUI(String titreElections, Election election, String imageAccueil) {
        super("Résultat des élections");
        this.election=election;
        this.imageAccueil=imageAccueil;
        
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
        
        itemOrdreAlphabetique.addActionListener(new DisplayAlphaOrderListener());
        itemOrdreResultat.addActionListener(new DisplayResultatOrderListener());
        
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
        if(!this.imageAccueil.equals(""))
        {
            JLabel imageAccueilLabel = new JLabel(new ImageIcon(this.imageAccueil), CENTER);
            panel.add(imageAccueilLabel, BorderLayout.CENTER);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel remplirPourcentagePannel(List<Candidat> listcandidats , int dateScrutin) {
        
        String libelle = "Répartition des candidats du scrutin du "+dateScrutin;
        
        JPanel chart = new ChartPanel( createPieChart(createDataset(listcandidats),libelle));
        
        
        return chart;
    }
    
    private static JFreeChart createPieChart(PieDataset dataset, String libelle) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            libelle,  // chart title
            dataset,             // data
            false,               // exclude legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }
    
        /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createBarChart(final CategoryDataset dataset, String libelle) {
        
        final JFreeChart chart = ChartFactory.createBarChart(
            libelle,         // chart title
            "",               // domain axis label
            "Pourcentage",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
    
    private static PieDataset createDataset(List<Candidat> listecandidats) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(Candidat candidat : listecandidats)
        {
            dataset.setValue(String.format("%s ( %.2f %%)",candidat.getNom(),candidat.getPourCentVoix()),candidat.getPourCentVoix());
        }
        return dataset;        
    }
    
    private static PieDataset createDataset(Map<String, List<Candidat>> mapParti) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Iterator<Map.Entry<String, List<Candidat>>> iterator = mapParti.entrySet().iterator();
        while ( iterator.hasNext()) {
            
            Map.Entry<String, List<Candidat>> entree = iterator.next();
            List<Candidat> listeCandidats = entree.getValue();
            
            double pourcentageParti = 0;
            
            for (Candidat candidat : listeCandidats)
            {
                pourcentageParti += candidat.getPourCentVoix();
            }
            
            dataset.setValue(String.format("%s ( %.2f %%)", entree.getKey() , pourcentageParti ), pourcentageParti);
        }
        
        return dataset;        
    }
    
    private CategoryDataset createSexeCandidatDataset(Map<Civilite, List<Candidat>> mapCiviliteCandidats) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Iterator<Map.Entry<Civilite, List<Candidat>>> iterator = mapCiviliteCandidats.entrySet().iterator();
        while ( iterator.hasNext()) {
            Map.Entry<Civilite, List<Candidat>> entree = iterator.next();
            List<Candidat> listeCandidats = entree.getValue();
            for (Candidat candidat : listeCandidats)
            {
                dataset.setValue(candidat.getPourCentVoix(),candidat.getCivilite() ,candidat.getNom());
            }
         }
        return dataset;       
    }
    
        private CategoryDataset createCandidatSexeDataset(Map<Civilite, List<Candidat>> mapCiviliteCandidats) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Iterator<Map.Entry<Civilite, List<Candidat>>> iterator = mapCiviliteCandidats.entrySet().iterator();
        while ( iterator.hasNext()) {
            Map.Entry<Civilite, List<Candidat>> entree = iterator.next();
            List<Candidat> listeCandidats = entree.getValue();
            for (Candidat candidat : listeCandidats)
            {
                dataset.setValue(candidat.getPourCentVoix(),candidat.getNom(),candidat.getCivilite());
            }
         }
        return dataset;       
    }


    private JPanel remplirPartiPannel(List<Candidat> listcandidats, Map<String, List<Candidat>> newMapPartiCandidats, int dateScrutin) {
        String libelle = "Répartition des candidats du scrutin du "+dateScrutin+" par parti.";
        
        JPanel chart = new ChartPanel( createPieChart(createDataset(newMapPartiCandidats),libelle));
        
        
        return chart;   
    }


    private JPanel remplirSexeCandidatPannel(List<Candidat> listcandidats, Map<Civilite, List<Candidat>> newMapCiviliteCandidats, int dateScrutin) {
         String libelle = "Répartition des candidats du scrutin du "+dateScrutin+" par Sexe/Candidat.";
        
        JPanel chart = new ChartPanel( createBarChart(createSexeCandidatDataset(newMapCiviliteCandidats),libelle));
        
        
        return chart; 
    }

    private JPanel remplirCandidatSexePannel(List<Candidat> listcandidats, Map<Civilite, List<Candidat>> newMapCiviliteCandidats, int dateScrutin) {
        String libelle = "Répartition des candidats du scrutin du "+dateScrutin+" par Candidat/Sexe.";
        
        JPanel chart = new ChartPanel( createBarChart(createCandidatSexeDataset(newMapCiviliteCandidats),libelle));
        
        
        return chart; 
    }


    

    class DisplayAlphaOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listcandidats = election.sortCandidats(DisplayOrder.ALPHA);
            
            afficheResultats(listcandidats);
        }
    }
    
    class DisplayResultatOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listcandidats = election.sortCandidats(DisplayOrder.POURCENT);
            
            afficheResultats(listcandidats);
        }
    }
    
    class ElectionActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            listcandidats = election.simulation(DisplayOrder.PARTI);
            
            afficheResultats(listcandidats);
        }
    }
    
    private JPanel remplirWestPannel(List<Candidat> listecandidats, Map<Candidat, String> candidatimage, int datescrutin )
    {
        // Panneau Ouest
        JPanel panneauOuest = new JPanel(new BorderLayout());
        panneauOuest.setBackground(Color.white);
        panneauOuest.setBorder(new LineBorder(Color.cyan));
        
        // Label panneau Ouest
        JLabel labelOuest = new JLabel("Resultat du scrutin du "+datescrutin);
        panneauOuest.add(labelOuest, BorderLayout.NORTH);
        Box boxcandidats = Box.createVerticalBox();
        for(Candidat candidat : listecandidats)
        {
            Box item = Box.createHorizontalBox();
            JLabel imageItem = new JLabel(new ImageIcon(candidatimage.get(candidat)), CENTER);
            item.add(imageItem);
            Box infos = Box.createVerticalBox();
            JLabel civ = new JLabel(candidat.getCivilite() + "");
            JLabel nom = new JLabel(candidat.getNom());
            JLabel parti = new JLabel(candidat.getParti());
            JLabel voix = new JLabel(String.format("%.2f %% des voix",candidat.getPourCentVoix()));
            infos.add(civ);
            infos.add(nom);
            infos.add(parti);
            infos.add(voix);
            item.add(infos);
            boxcandidats.add(item);
        }
        panneauOuest.add(boxcandidats, BorderLayout.CENTER);
        return panneauOuest;
    }
    
    
    
    private void afficheResultats(List<Candidat> listcandidats)
    {
        JPanel panneauPrincipal = (JPanel) getContentPane();
        
        // On enlève tout
        panneauPrincipal.removeAll();
        panneauPrincipal.setBackground(null);
        
        JPanel panneauOuest=remplirWestPannel(listcandidats, election.newMapCandidatImage(), election.getDateSrutin());

        // Panneau Central
        JPanel panneauCentral = new JPanel(new GridLayout(2,2));
        panneauCentral.setBackground(Color.red);
        panneauCentral.setBorder(new LineBorder(Color.white));
        
        // Répartition des candidats du scrutin
        JPanel pieparpourcentage =remplirPourcentagePannel(listcandidats, election.getDateSrutin());
                
        // Répartition des candidats du scrutin par parti 
        JPanel pieparparti =remplirPartiPannel(listcandidats,election.newMapPartiCandidats(), election.getDateSrutin());
        
        // Répartition des candidats du scrutin par parti 
        JPanel barreparcandidat =remplirSexeCandidatPannel(listcandidats,election.newMapCiviliteCandidats(), election.getDateSrutin());
        
        // Répartition des candidats du scrutin par parti 
        JPanel barreparcivilite =remplirCandidatSexePannel(listcandidats,election.newMapCiviliteCandidats(), election.getDateSrutin());
                
        // Panneau Central
        
        panneauCentral.add(pieparpourcentage);
        panneauCentral.add(pieparparti);     
        panneauCentral.add(barreparcandidat);
        panneauCentral.add(barreparcivilite);
        
        // Ajout dans le panneau principal
        panneauPrincipal.setLayout(new BorderLayout());
        panneauPrincipal.add(panneauOuest, BorderLayout.WEST);
        panneauPrincipal.add(panneauCentral, BorderLayout.CENTER);
        
        setContentPane(panneauPrincipal);
        
    }

    
}

