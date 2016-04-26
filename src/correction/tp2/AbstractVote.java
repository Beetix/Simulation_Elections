package correction.tp2;

import correction.tp1.HommePolitique;
/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */

/**
 * Hi�rarchie de classes pour repr�senter un vote
 */
 
public abstract class AbstractVote implements Vote {
 
    private HommePolitique hommePolitique;
    // un jour entre 1 et 31
    private int dateVote;    
    // un jour entre 1 et 31
    private int dateScrutin;
 
    
    public AbstractVote(HommePolitique hommePolitique, int dateVote, int dateScrutin) {
    	this.hommePolitique = hommePolitique;
        this.dateVote = dateVote;
        this.dateScrutin = dateScrutin;
    }
 
    /**
     * @return vrai si le vote est invalide 
     * 		m�thode impl�ment�e concr�tement par les sous-classes
     */
    public abstract boolean estInvalide();
 
    /**
     * @return l'homme politique en faveur de qui est le vote
     */
    public HommePolitique getHommePolitique() {
        return hommePolitique;
    }
 
    public int getDate() {
        return dateVote;
    }
 
   	public int getDateScrutin() {
		return dateScrutin;
	}

	public String toString() {
        String result = "Vote par " + this.getClass().getSimpleName()+ " pour le candidat " + getHommePolitique();
        if (this.estInvalide()) {
            result += " -> invalide";
        } else {
            result += " -> valide";
        }
        return result;
    }
 
    public static void main(String[] args) {

    }
}
 