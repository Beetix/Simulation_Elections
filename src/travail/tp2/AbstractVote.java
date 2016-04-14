/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travail.tp2;

import correction.tp1.HommePolitique;

/**
 *
 * @author user
 */
public abstract class AbstractVote implements Vote {

    protected int dateBulletin;
    protected int dateScrutin;
    
    protected HommePolitique hommePolitique;

    public AbstractVote(HommePolitique hommePolitique, int dateBulletin, int dateScrutin) {
        this.dateBulletin = dateBulletin;
        this.dateScrutin = dateScrutin;
        this.hommePolitique = hommePolitique;
    }
    
    @Override
    public int getDate() {
        return dateBulletin;
    }

    public HommePolitique getHommePolitique() {
        return hommePolitique;
    }
    
    @Override
    public String toString()
    {
         String validite;
         if (estInvalide())
         {
             validite = "invalide";
         }
         else
         {
             validite = "valide";
         }
         return "Vote par : "+ getClass().getSimpleName() +" pour [ civilite= " + getHommePolitique().getCivilite() +" ; nom =" + getHommePolitique().getNom() + " ; parti= " + getHommePolitique().getParti() +" ] -> " + validite + "\n";
     }
     
    public abstract boolean estInvalide();
     
}
