package correction.tp2;

import correction.tp1.HommePolitique;


/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */


/**
 * Vote par bulletin papier
 */
public class BulletinPapier extends AbstractVotePapier implements Vote {
 
    public BulletinPapier(HommePolitique hommePolitique, int dateVote, int dateScrutin, boolean signature) {
        super(hommePolitique, dateVote, dateScrutin, signature);
    }
 
   
 
}
 