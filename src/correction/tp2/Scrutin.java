package correction.tp2;

/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */


import java.util.LinkedList;
import java.util.List;

import correction.tp1.CandidatScrutin;
import correction.tp1.HommePolitique;


/**
 * Scrutin : mise en oeuvre d'une �lection pour un certain nombre de candidatScrutins, 
 * les votes se font par bulletin papier ou �lectronique ou courrier
 */

public class Scrutin {

	private List<CandidatScrutin> candidatScrutins;

	private List<Vote> votes;	

	private int dateScrutin;
	private int population;
	private int nbVotesValides;

	/**
	 * Cr�e un scrutin
	 *
	 * @param population
	 *            Nombre maximal de personnes pouvant voter
	 * @param dateScrutin
	 *            date scrutin simul�e par un int
	 */
	public Scrutin(int population, int dateScrutin) {
		this(null, population, dateScrutin);
	}

	/**
	 * Cr�e un scrutin
	 *
	 * @param hommesPolitiques
	 *            l'ensemble des hommes politiques candidatScrutins � l'�lection
	 * @param population
	 *            Nombre maximal de personnes pouvant voter
	 * @param dateScrutin
	 *            date scrutin simul�e par un int
	 */
	public Scrutin(List<HommePolitique> hommesPolitiques, int population, int dateScrutin) {
		super();
		this.nbVotesValides = 0;
		this.population = population;      
		this.dateScrutin = dateScrutin;
		this.votes = new LinkedList<Vote>();
		this.candidatScrutins = new LinkedList<CandidatScrutin>();
		this.initListCandidatScrutins(hommesPolitiques);
	}

	/**
	 * @param hommesPolitiques
	 * 		cr�e les diff�rents candidatScrutins � partir de la liste des HommesPolitiques, 
	 * 		(initialise leur nb de voix � 0) et les ajoute dans la liste
	 */
	private void initListCandidatScrutins(List<HommePolitique> hommesPolitiques) {
		if (hommesPolitiques != null){
			for (HommePolitique hommePolitique : hommesPolitiques ) {
				addCandidatScrutin(hommePolitique);
			}
		}
	}

	/**
	 * @param hommesPolitique
	 * 		cr�e 1 candidatScrutin � partir d'1 HommePolitique, 
	 * 		et l' ajoute dans la liste
	 */
	public void addCandidatScrutin(HommePolitique hommePolitique) {
		CandidatScrutin candidatScrutin = null;
		candidatScrutin = new CandidatScrutin(hommePolitique, this.getDateScrutin());
		this.candidatScrutins.add(candidatScrutin);
	}


	/**
	 * @param vote
	 * 		ajoute le vote � la liste
	 */
	public void addBulletin(Vote vote) {
		if (votes!=null)
			votes.add(vote);
	}

	/**
	 * D�pouille chaque vote et si le vote est valide
	 * met � jour nb voix du candidatScrutin concern�
	 * et incr�mente compteur de votes valides.
	 */
	public void countTheVotes() {
		HommePolitique hommePolitique = null;		
		for (Vote vote : votes) {
			if (!vote.estInvalide()) {
				hommePolitique = vote.getHommePolitique();
				for (CandidatScrutin candidatScrutin : candidatScrutins){
					if (candidatScrutin.containsHommePolitique(hommePolitique) && candidatScrutin.getDateScrutin() == this.getDateScrutin() ) {
						candidatScrutin.addVoix();
					}
				}				
				nbVotesValides++;
			}
		}
	}

	public double tauxParticipation() {
		double ret = 0;
		ret = nbVotesValides * 100.0 / getPopulation();
		return ret;
	}

	public int getDateScrutin() {
		return dateScrutin;
	}

	public void setDateScrutin(int dateScrutin) {
		this.dateScrutin = dateScrutin;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		double taux = this.tauxParticipation();
		String ret = "Scrutin [dateScrutin=" + dateScrutin + ", " +
		"population=" + population + ", " +
		"totalVotants="	+ nbVotesValides + "," +
		String.format("Taux de participation avec vote valide=%2.1f", taux)+ "%" +
		"\ncandidatScrutins =" + candidatScrutins +"]";
		return ret;
	}	
	
	
}