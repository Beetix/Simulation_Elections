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
public class BulletinElectronique extends AbstractVote implements CheckDateBulletin{

    public BulletinElectronique(HommePolitique hommePolitique, int dateBulletin, int dateScrutin) {
        super(hommePolitique, dateBulletin, dateScrutin);
    }
    
    
    @Override
    public boolean estInvalide(){
        return checkDate();
    }

    @Override
    public boolean checkDate() {
        return (dateScrutin - 2) >= dateBulletin;
    }
    
}
