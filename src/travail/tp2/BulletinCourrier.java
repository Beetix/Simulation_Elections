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
public class BulletinCourrier extends AbstractVote implements CheckDateBulletin,CheckSigneBulletin{
    
    private boolean signature;

    public BulletinCourrier(HommePolitique hommePolitique, int dateBulletin, int dateScrutin, boolean signature) {
        super(hommePolitique, dateBulletin, dateScrutin);
        this.signature = signature;
    }

    @Override
    public boolean estInvalide() {
        return !(checkDate() && checkSigne());
    }

    @Override
    public boolean checkDate() {
        return dateScrutin >= dateBulletin;
    }

    @Override
    public boolean checkSigne() {
        return signature;
    }
}
