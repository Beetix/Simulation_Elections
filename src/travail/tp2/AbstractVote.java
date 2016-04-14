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
    protected HommePolitique hommePolitique;
    
    public int getDateBulletin() {
        return dateBulletin;
    }


    public HommePolitique getHommePolitique() {
        return hommePolitique;
    }


    
    public abstract boolean estInvalide();


   
    
    
    
     public String toString(){
         String validite;
         if (estInvalide())
         {
             validite = "invalide";
         }
         else
         {
             validite = "valide";
         }
         return "Vote par : "+ getClass().getSimpleName() +" pour [ civilite= " + getHommePolitique().getCivilite() +" ; nom =" + getHommePolitique().getNom() + " ; parti= " + getHommePolitique().getParti() +" ] -> " + validite;
     }
     
     
     
     public static void main(String[] args) {
        BulletinCourrier b1,b2;
    }
}
