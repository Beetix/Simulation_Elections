package travail.tp2;

/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */


import correction.tp1.Candidat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import correction.tp1.Civilite;
import correction.tp1.HommePolitique;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;



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
                
                List<Candidat> lc1 = scrutin.getResultatScrutin();
                System.out.println("Sans Tri");
                afficheListe(lc1);
                Collections.sort(lc1);
                System.out.println("Tri alphabétique (ordre naturel)");
                afficheListe(lc1);
                System.out.println("Tri par pourcentage décroissant");
                //lc1.sort(new ComparateurCandidat());
                Collections.sort(lc1,new ComparateurCandidat());
                afficheListe(lc1);
                System.out.println("Tri par pourcentage croissant méthode 1 ");
                Collections.sort(lc1,Collections.reverseOrder(new ComparateurCandidat()));
                afficheListe(lc1);
                System.out.println("Tri par pourcentage croissant méthode 2 ");
                Collections.sort(lc1,new ComparateurCandidat());
                Collections.reverse(lc1);
                afficheListe(lc1);
                // Récupération du meilleur candidat :
                Collections.reverse(lc1);
                System.out.println("Meileur candidat way 1 : " + lc1.get(0));
                System.out.println("Meileur candidat way 2 : " + Collections.min(lc1, new ComparateurCandidat()) );
                
                System.out.println("Deuxième candidat way 1 : " + lc1.get(1));
                System.out.println("Index du meilleur candidat via List : " +lc1.indexOf(Collections.max(lc1, new ComparateurCandidat())));
                //List lc2=(ArrayList)((ArrayList)lc1).clone();
                List<Candidat> lc2=new ArrayList<>(lc1);
                System.out.println("Copie  ");
                afficheListe(lc2);
                
                for( Candidat candidat : lc1 )
                {
                    if(candidat.getPourCentVoix()<20)
                    { 
                        lc2.remove(candidat);
                    }
                }
                System.out.println("Après remove boucle for  ");
                afficheListe(lc2);
                
                List<Candidat> lc3=new ArrayList<>(lc1);
                for (ListIterator<Candidat> ite = lc1.listIterator(); ite.hasNext(); )
                {
                    Candidat c = ite.next();
                    if(c.getPourCentVoix() <20)
                    {
                        lc3.remove(c);
                    }
                }
                
                System.out.println("Après remove iterator  ");
                afficheListe(lc3);
                
                // 2,5
                System.out.println("lc1  ");
                afficheListe(lc1);
                System.out.println("lc1 sans lc3  ");
                lc1.retainAll(lc3);
                afficheListe(lc1);
                
                
                // 2,6
                System.out.println("listes identiques equals: " + lc1.equals(lc3));
                System.out.println("listes identiques contains : " + (lc1.containsAll(lc3) && lc3.containsAll(lc1)  ) );
               
                System.out.println("Clear & Affichage de lc3 : ");
                lc3.clear();
                afficheListe(lc3);
                System.out.println("lc3 is empty ? : " + lc3.isEmpty());
                System.out.println("lc3 size ? : " + lc3.size());

                
                
                //Exercie 3
                List<Candidat> lc4 = scrutin.getResultatScrutin();
                Map<Civilite,List<String>> map1 = new TreeMap<>();
                
                List<String> lh = new ArrayList<String>();
                List<String> lf = new ArrayList<String>();
                
                map1.put(Civilite.HOMME, lh);
                map1.put(Civilite.FEMME, lf);
                
                int nbhomme=0;
                for (ListIterator<Candidat> ite = lc4.listIterator(); ite.hasNext(); )
                {
                    Candidat c = ite.next();
                    if(c.getCivilite() == Civilite.HOMME )
                    {
                        lh.add(c.getNom());
                        nbhomme++;
                    }
                    else
                    {
                        lf.add(c.getNom());
                    }
                }
                
                System.out.println(map1);
                
                Set< Map.Entry<Civilite, List<String> > > set1 = map1.entrySet();
                
                for (Map.Entry<Civilite, List<String> > e : set1)
                {
                    System.out.println("Liste des "+e.getKey() + " \n " );
                    for (String s : e.getValue())
                    {
                        System.out.println(s+"\n");
                    }
                }
                
                System.out.println(set1);
                
                
                System.out.println("Nombre d'hommes :" + nbhomme );
                
                Set<Civilite> set2 = map1.keySet();
                System.out.println(set2);
                
                map1.remove(Civilite.FEMME);
                System.out.println(map1);
                System.out.println(set1); // Set aussi modifié car c'est une "vue" de la map.
                System.out.println(set2);
                
                
                Set<Civilite> monSet = new TreeSet(set2);
                monSet.add(Civilite.FEMME);
                monSet.add(Civilite.HOMME);
                System.out.println(monSet);
                
                
	}

        private static void afficheListe(List<Candidat> liste)
        {
             for (ListIterator ite = liste.listIterator(); ite.hasNext(); )
                    System.out.println(ite.next());
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