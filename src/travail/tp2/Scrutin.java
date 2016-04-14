/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travail.tp2;

import correction.tp1.HommePolitique;
import java.util.List;

/**
 *
 * @author user
 */
public class Scrutin {
    protected int dateScrutin;
    protected List< Vote > votes;
    protected List< HommePolitique > candidats;
    protected int population;

    public int getDateScrutin() {
        return dateScrutin;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public List<HommePolitique> getCandidats() {
        return candidats;
    }
    
    
    
    
    
    public void addBulletin(Vote vote){
        votes.add(vote);
    }



}
