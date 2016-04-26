package correction.tp2;

import correction.tp1.HommePolitique;


/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */

public class BulletinCourrier extends AbstractVotePapier implements CheckDateBulletin, Vote {
	 
    public BulletinCourrier(HommePolitique hommePolitique, int dateVote, int dateScrutin, boolean signature) {
        super(hommePolitique, dateVote, dateScrutin, signature);
    }
 
    public boolean checkDate() {
        return getDate() <= getDateScrutin();
    }
 
    @Override
    public boolean estInvalide() {
        // un bulletin courrier est invalide s'il n'est
        // pas sign� ou que la date limite est d�pass�e
        return (super.estInvalide() || !checkDate());
 
    }
 
 
}