/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travail.tp2;

import correction.tp1.CandidatScrutin;
import correction.tp1.HommePolitique;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author user
 */
public class Scrutin {
    private int dateScrutin;
    private List<Vote> votes;
    private List<CandidatScrutin> candidats;
    private int population;
    private int nbVotesValides;

    public Scrutin(int population, int dateScrutin) {
        this.dateScrutin = dateScrutin;
        this.population = population;

        this.votes = new LinkedList<Vote>();
        this.candidats = new LinkedList<CandidatScrutin>();
    }

    public Scrutin(List<HommePolitique> hommesPolitiques, int population, int dateScrutin) {
        this(population, dateScrutin);
        initListCandidatScrutins(hommesPolitiques);
    }

    public void addCandidat(HommePolitique hommePolitique)
    {
        CandidatScrutin candidat = new CandidatScrutin(hommePolitique, dateScrutin);
        candidats.add(candidat);
    }
    
    public void addBulletin(Vote vote){
        votes.add(vote);
    }

    @Override
    public String toString() {
        return "Scrutin\n--------\n\n" + "dateScrutin=" + dateScrutin + "\nvotes=" + votes + "\ncandidats=" + candidats + "\npopulation=" + population + "\nnbVotesValides=" + nbVotesValides + "\n\n";
    }

    public int getPopulation() {
        return population;
    }

    public int getNbVotesValides() {
        return nbVotesValides;
    }

    public int getDateScrutin() {
        return dateScrutin;
    }
    
    public void countTheVotes() {
        for (Vote vote : votes)
        {
            if (!vote.estInvalide())
            {
                for (CandidatScrutin candidatScrutin : candidats)
                {
                    if (candidatScrutin.containsHommePolitique(vote.getHommePolitique()))
                    {
                        candidatScrutin.addVoix();
                        nbVotesValides++;
                        break;
                    }
                }
                            
            }
        }
    }
    
    public double tauxParticipation()
    {
        return (double) nbVotesValides / population;
    }
    
    private void initListCandidatScrutins(List<HommePolitique> hommesPolitiques) {
        if (hommesPolitiques != null){
            for (HommePolitique hommePolitique : hommesPolitiques ) { 
                CandidatScrutin candidatScrutin = null;
                candidatScrutin = new CandidatScrutin(hommePolitique, this.getDateScrutin());
                this.candidats.add(candidatScrutin);
            }
        }
    }
}
