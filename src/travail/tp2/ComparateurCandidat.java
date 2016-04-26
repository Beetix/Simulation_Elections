/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travail.tp2;

import correction.tp1.Candidat;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class ComparateurCandidat implements Comparator<Candidat>{

    @Override
    public int compare(Candidat c1, Candidat c2) {
        Double p1,p2;
        
        p1 = c1.getPourCentVoix();
        p2 = c2.getPourCentVoix();
        
        return p2.compareTo(p1);
    }
    
    
    
    
}
