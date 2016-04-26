package travail.tp1;

import java.util.Objects;

public class Candidat implements Comparable<Candidat>{

    private CandidatScrutin cScrutin;
    private double pVoix;

    public Candidat(CandidatScrutin cScrutin, int nbVotesValides) {
        this.cScrutin = cScrutin;
        this.pVoix = (nbVotesValides/(double)cScrutin.getNvoix());
    }
    
    @Override
    public String toString() {
        return cScrutin + " a eu "+ pVoix * 100 + " % des voix";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cScrutin);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.pVoix) ^ (Double.doubleToLongBits(this.pVoix) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Candidat other = (Candidat) obj;
        if (Double.doubleToLongBits(this.pVoix) != Double.doubleToLongBits(other.pVoix)) {
            return false;
        }
        if (!Objects.equals(this.cScrutin, other.cScrutin)) {
            return false;
        }
        return true;
    }

    public double getpVoix() {
        return pVoix;
    }
    
    public Civilite getCivilite() {
        return cScrutin.getCivilite();
    }

    public String getNom() {
        return cScrutin.getNom();
    }

    public String getParti() {
        return cScrutin.getParti();
    }
    
     /**
     * @return the nvoix
     */
    public int getNvoix() {
            return cScrutin.getNvoix();
    }

    /**
     * @return the dscrutin
     */
    public int getDscrutin() {
            return cScrutin.getDscrutin();
    }
    
    public static void main(String[] args) {
         
        HommePolitique h1, h2, h3;
        h1 = new HommePolitique(Civilite.FEMME,"nom1","parti1");
        h3 = new HommePolitique(Civilite.HOMME,"nom3","parti3");
        
        CandidatScrutin cs1, cs2;
        cs1 = new CandidatScrutin(h1, 212016);
        cs2 = new CandidatScrutin(h3, 212016);    
        
        Candidat c1,c2;
        c1 = new Candidat(cs2, 12);
        c2 = new Candidat(cs1, 15);
        
        
        
        
        System.out.println(c1);
            
        System.out.println("cs1 et hp3 sont les mêmes : "+cs1.checkAttributsHommePolitique(h3));
        
        System.out.println("c1 et c2 sont les mêmes : "+c1.compareTo(c2));
        
    }

    @Override
    public int compareTo(Candidat o) {
        return this.cScrutin.compareTo(new CandidatScrutin(new HommePolitique(this.getCivilite(),this.getNom(),this.getParti()),this.getNvoix()));
    }

    
    
    
}