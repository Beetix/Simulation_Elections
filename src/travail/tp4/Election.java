/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travail.tp4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

import correction.tp1.Candidat;
import correction.tp1.Civilite;
import correction.tp1.HommePolitique;
import travail.tp2.BulletinCourrier;
import travail.tp2.BulletinElectronique;
import travail.tp2.BulletinPapier;
import travail.tp2.Vote;
import travail.tp2.CandidatComparator;
import travail.tp2.Scrutin;


/**
 *
 * @author beetix & loupiotte93
 */
public class Election {
	private Scrutin scrutin;
	private int dateSrutin;	
	private int population;
	private int votants;
	private int dateBulletin;
	private List< HommePolitique> hommePolitiques;
	private List<String> imageHommePolitique;
	private List<Candidat> candidats;
	private Map<HommePolitique, String>  mapHommePolitique_Image;

	public Election() {
		super();
		scrutin = null;
		dateSrutin = 0;		
		population = 0;
		votants = 0;
		dateBulletin = 0;	
	}


	/**
	 * @return the dateSrutin
	 */
	public int getDateSrutin() {
		return dateSrutin;
	}

	/**
	 * @return the liste de candidats
	 */
	public List<Candidat> getCandidats() {
		return candidats;
	}

	/**
	 *  
	 * Simulation d'un scrutin
	 * @return the liste de candidats
	 */
	public List<Candidat>  simulation(DisplayOrder displayOrder) {

		initSimulation();

		candidats = resultScrutin();		

		candidats = sortCandidats(displayOrder);		

		return candidats;
	}

	/**
	 *  
	 * initialise la simulation
	 */
	private void initSimulation() {

		imageHommePolitique = new ArrayList<String>();
		hommePolitiques = new ArrayList< HommePolitique>();
		mapHommePolitique_Image = new TreeMap<HommePolitique, String>();

		hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Tarek Oxlama", "Parti1"));
		hommePolitiques.add(new HommePolitique(Civilite.HOMME,"Nicolai Tarcozi", "Parti2"));
		hommePolitiques.add(new HommePolitique(Civilite.HOMME,"Vlad Imirboutine", "Parti1"));
		hommePolitiques.add(new HommePolitique(Civilite.FEMME,"Angel Anerckjel", "Parti4"));
		hommePolitiques.add(new HommePolitique(Civilite.FEMME,"Anne SanSoossi", "Parti5"));

		String[] tab = {"bunny.gif", "fantome.gif", "schtroumpfs.gif","sorciere.gif", "cricket.gif"};
		File g=new File("");
		String imagePath = "ressources/gif/";
		for (int i = 0; i< tab.length; i++){
			String imageName = imagePath + tab[i];
			imageHommePolitique.add(imageName);
		}

		scrutin = null;
		dateSrutin = 15;		
		population = 30;
		votants = 20;
		dateBulletin = 13;


		/**
		 * Association des hommes politiques et de leur image
		 */
		if (hommePolitiques.size()!=0 && imageHommePolitique.size()!=0){
			for (int i = 0; i< hommePolitiques.size(); i++) {  	
				mapHommePolitique_Image.put(hommePolitiques.get(i), imageHommePolitique.get(i));
			}
		}
	}
	/** 
	 * Lance une simulation
	 * d�pouille les votes
	 * retourne le r�sultat
	 */
	private List<Candidat> resultScrutin(){

		/**
		 * simulation votes
		 */
		scrutin = simulerVotes(hommePolitiques, votants, dateSrutin, dateBulletin, population);

		/**
		 * Traitement aprs vote
		 */
		scrutin.countTheVotes();

		/**
		 * R�cup�ration r�sultat sous forme de liste de Candidat
		 */
		candidats = scrutin.getResultatScrutin();

		return candidats;
	}


	/**
	 * 		Simulation d'un scrutin 
	 *  	tous les votes sont envoy�s � la m�me date
	 *  	Tous passent le check de date 
	 *  	1 bulletins papier sur 2 passe le check de signature
	 */	
	private static Scrutin simulerVotes(List< HommePolitique> hommePolitiques, int votants,
			int dateSrutin, int dateBulletin, int population) {

		Scrutin scrutin = new Scrutin(hommePolitiques, population, dateSrutin);
		Vote vote = null;
		//System.out.println(scrutin);		// pour v�rif

		if (hommePolitiques!=null){
			for (int i = 0; i < votants; ++i) {

				int candNum = Utils.randomInt(hommePolitiques.size());

				// bulletins papiers impairs sont sign�s, pairs sont non sign�s
				boolean signature = true;
				if ((i % 2) == 0) {
					signature = false;
				}

				// simulation cr�ation bulletins de vote
				switch (i % 3) {
				case 0:{
					vote = new BulletinElectronique(hommePolitiques.get(candNum), dateBulletin, dateSrutin);			
					break;
				}			
				case 1:{
					vote = new BulletinPapier(hommePolitiques.get(candNum), dateBulletin, dateSrutin, signature);
					break;
				}
				case 2:{
					vote = new BulletinCourrier(hommePolitiques.get(candNum), dateBulletin, dateSrutin, signature);
				}
				default: // nothing			
				}
				//System.out.println(vote);		// pour v�rif
				scrutin.addBulletin( vote);				
			}
		}
		return scrutin;
	}


	/**
	 * @param displayOrder 
	 * Tri candidats selon displayOrder
	 * @return 
	 */
	public List<Candidat> sortCandidats(DisplayOrder displayOrder) {
		if (candidats != null) {
			if (displayOrder != null){
				if (displayOrder.equals(DisplayOrder.ALPHA)){
					Collections.sort(candidats);
				}
				if (displayOrder.equals(DisplayOrder.POURCENT)){
					Collections.sort(candidats, CandidatComparator.POURCENTVOIX);
				}
				if (displayOrder.equals(DisplayOrder.PARTI)){
					Collections.sort(candidats, CandidatComparator.POURCENTVOIX);
				}
			}
		}	
		return candidats;
	}

	/**
	 * @return the mapImage qui associe les candidats et l'image
	 * de l'homme politique correspondant
	 */
	public Map<Candidat, String> newMapCandidatImage() {

		Map<Candidat, String> map = new HashMap<Candidat, String>();

		for (Entry<HommePolitique, String> e : mapHommePolitique_Image.entrySet()){

			HommePolitique hommePolitique = e.getKey();
			String imageName = e.getValue();

			for (Candidat candidat : candidats) {  	
				if (candidat.containsHommePolitique(hommePolitique)){
					map.put(candidat, imageName);
				}
			}
		}		
		return map;
	}

	/**
	 * @return map qui associe � chaque civilit�
	 * la liste des candidats correspondants
	 */
	public Map<Civilite, List<Candidat>> newMapCiviliteCandidats() {

		Map<Civilite, List<Candidat>> map  = 
			new TreeMap<Civilite, List<Candidat>>();
		List<Candidat> candidatsInMap = null;

		for (Candidat candidat : candidats) {  				
			candidatsInMap = map.get(candidat.getCivilite());
			//si cette cle n'existe pas dans la Map, on cree un nouvel element
			if(candidatsInMap == null){
				candidatsInMap = new LinkedList<Candidat>();
			}
			//et on inclut l'HommePolitique envelopp� dans le Candidat dans la liste 
			candidatsInMap.add(candidat);
			//puis l'element dans la Map
			map.put(candidat.getCivilite(), candidatsInMap);
		}
		return map;
	}




	/**
	 * @return map qui associe � chaque parti
	 * le pourcentage de voix obtenu
	 */
	public Map<String, Double> newMapPartiPourcent() {

		Map<String, Double> map  = 	new TreeMap<String, Double>();			 
		Double pourcentCandidat = null;
		double pourcent = 0;

		for (Candidat candidat : candidats) {  

			pourcentCandidat = map.get(candidat.getParti());
			//si cette cle n'existe pas dans la Map, on initialise le cumul
			if (pourcentCandidat == null){
				pourcent = 0;
			}
			else {
				pourcent = pourcentCandidat.doubleValue() ;
			}			
			pourcent +=  candidat.getPourCentVoix();
			map.put(candidat.getParti(), pourcent);
		}
		return map;
	}

	/**
	 * @return map qui associe � chaque parti
	 * la liste des candidats correspondants
	 */
	public Map<String, List<Candidat>> newMapPartiCandidats() {

		Map<String, List<Candidat>> map  = 
			new TreeMap<String, List<Candidat>>();
		List<Candidat> candidatsInMap = null;

		for (Candidat candidat : candidats) {  				
			candidatsInMap = map.get(candidat.getParti());
			//si cette cle n'existe pas dans la Map, on cree un nouvel element
			if(candidatsInMap == null){
				candidatsInMap = new LinkedList<Candidat>();
			}
			//et on inclut l'HommePolitique envelopp� dans le Candidat dans la liste 
			candidatsInMap.add(candidat);
			//puis l'element dans la Map
			map.put(candidat.getParti(), candidatsInMap);
		}
		return map;
	}

}

/**
 * Classe utilitaire de g�n�ration de nb al�atoire
 *
 */
class Utils {

	private static final Random RANDOM = new Random();

	// initialise le g�n�rateur de nombres al�atoires
	public static void setSeed(long seed) {
		RANDOM.setSeed(seed);
	}

	// g�n�re un entier entre 0 et max (max non compris)
	public static int randomInt(int max) {
		return RANDOM.nextInt(max);
	}
}
    

