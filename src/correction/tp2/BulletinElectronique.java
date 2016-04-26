package correction.tp2;

import correction.tp1.HommePolitique;



/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction � la POO (en Java)"
 * by Jamila Sam, Jean-C�dric Chappelier - EPFL 
 */


/**
 * Vote par bulletin �lectronique
 */
public class BulletinElectronique extends AbstractVote implements CheckDateBulletin, Vote {
 
    public BulletinElectronique(HommePolitique hommePolitique, int dateVote, int dateScrutin) {
        super(hommePolitique, dateVote, dateScrutin);
    }
 
    public boolean checkDate() {
        return getDate() <= getDateScrutin() - 2;
    }
 
    @Override
    public boolean estInvalide() {
        return !checkDate();
    }
 
}
 