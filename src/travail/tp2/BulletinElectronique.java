/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travail.tp2;

/**
 *
 * @author user
 */
public class BulletinElectronique extends AbstractVote implements CheckDateBulletin{
    
    
        
    
    @Override
    public boolean estInvalide(){
        return false;
    }

    @Override
    public boolean checkDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
