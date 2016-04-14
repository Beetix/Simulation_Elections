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
public class BulletinPapier extends AbstractVote implements CheckSigneBulletin {

    private boolean signature;
    
    public BulletinPapier(HommePolitique hommePolitique, int dateBulletin, int dateScrutin, boolean signature) {
        super(hommePolitique, dateBulletin, dateScrutin);
        this.signature = signature;
    }
    

    @Override
    public boolean estInvalide() {
        return !checkSigne();
    }

    @Override
    public boolean checkSigne() {
        return signature;
    }
}
