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
public class BulletinCourrier extends AbstractVote implements CheckDateBulletin,CheckSigneBulletin{
    
    private boolean signature;
    
   
    
    public boolean estInvalide(Scrutin scrutin){
        return scrutin.getDateScrutin() < dateBulletin;
    }
    
    public static void main(String[] args) {
        BulletinCourrier b1, b2;
        b1=new BulletinCourrier();
        
    }

    @Override
    public boolean estInvalide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkSigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
