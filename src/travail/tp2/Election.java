package travail.tp2;

/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import correction.tp1.Civilite;
import correction.tp1.HommePolitique;



/**
 * Classe pour tester la simulation
 */

public class Election {

	public static void main(String args[]) {

		Scrutin scrutin;
		int dateSrutin;	
		int population;
		int votants;
		int dateBulletin;
		List< HommePolitique> hommePolitiques;
		
		hommePolitiques = new ArrayList< HommePolitique>();
		hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Tarek Oxlama", "parti1"));
		hommePolitiques.add(new HommePolitique(Civilite.HOMME,"Nicolai Tarcozi", "parti2"));
		hommePolitiques.add(new HommePolitique(Civilite.HOMME,"Vlad Imirboutine", "parti3"));
		hommePolitiques.add(new HommePolitique(Civilite.FEMME,"Angel Anerckjel", "parti4"));
		
		scrutin = null;
		dateSrutin = 15;		
		population = 30;
		votants = 20;

		/**
		 * simulation de votes 
		 * - tous sont envoy�s � la m�me date 
		 * - Tous passent le check de date
		 * - 1 bulletins papier sur 2 passe check signature
		 */				
		System.out.println("\n\t1�re simulation \n" );
		dateBulletin = 13;	
		// simulation votes
		scrutin = simulerVotes(hommePolitiques, votants, dateSrutin, dateBulletin, population);
		// Traitement apr�s vote
		scrutin.countTheVotes();
		// Affichage r�sultat brut du scrutin
		System.out.println(scrutin);


		/**
		 * simulation de votes 
		 * - tous sont envoy�s � la m�me date invalide
		 * - Seuls les bulletins papier passent le check
		 * - 1 bulletins papier sur 2 passe check signature
		 */		
		System.out.println("\n\t2�me simulation \n" );
		dateBulletin = 16;		
		// simulation votes
		scrutin = simulerVotes(hommePolitiques, votants, dateSrutin, dateBulletin, population);	
		// Traitement apr�s vote
		scrutin.countTheVotes();
		// Affichage r�sultat brut du scrutin
		System.out.println(scrutin);
	}


	private static Scrutin simulerVotes(List< HommePolitique> hommePolitiques, int votants,
			int dateSrutin, int dateBulletin, int population) {

		Scrutin scrutin = new Scrutin(hommePolitiques, population, dateSrutin);

		// ou bien
		//		scrutin = new Scrutin(population, dateSrutin);
		//		for (HommePolitique hommePolitique : hommePolitiques )
		//			scrutin.addCandidat(hommePolitique);

		//System.out.println(scrutin);

		if (hommePolitiques!=null){
			for (int i = 0; i < votants; ++i) {

				int candNum = Utils.randomInt(hommePolitiques.size());
				Vote vote = null;

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
			//	System.out.println(vote);		// pour v�rif ToString() des classes qui impl�mentent Vote
				scrutin.addBulletin(vote);				
			}
		}
		return scrutin;
	}
}


/**
 * Classe utilitaire
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