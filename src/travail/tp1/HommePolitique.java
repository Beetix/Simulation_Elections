package travail.tp1;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author beetix & lm
 */
public class HommePolitique implements Comparable<HommePolitique>, Cloneable {
    
    private Civilite civilite;
    
    private String nom;
    private String parti;

    public HommePolitique(Civilite civilite, String nom, String nomParti) {
        this.civilite = civilite;
        this.nom = nom;
        this.parti = nomParti;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getParti() {
        return parti;
    }

    public void setParti(String nomParti) {
        this.parti = nomParti;
    }

    @Override
    public String toString() {
        return "HommePolitique{" + "civilite=" + civilite + ", nom=" + nom + ", nomParti=" + parti + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.civilite);
        hash = 13 * hash + Objects.hashCode(this.nom);
        hash = 13 * hash + Objects.hashCode(this.parti);
        return hash;
    }
    
    


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HommePolitique other = (HommePolitique) obj;
        if (this.civilite != other.civilite) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.parti, other.parti)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(HommePolitique o) {
        return this.civilite.compareTo(o.getCivilite()) + this.nom.compareTo(o.nom) + this.parti.compareTo(o.getParti());
    }
    
    public Object clone()
    {
        return new HommePolitique(this.civilite, this.nom, this.parti);
    }
    
    
    public static void main(String args[])
    {
        HommePolitique h1, h2, h3;
        h1 = new HommePolitique(Civilite.FEMME,"nom1","parti1");
        h3 = new HommePolitique(Civilite.HOMME,"nom3","parti3");
        System.out.println("h1: " + h1);
        
        System.out.println("Est ce que civilite est correcte ? " + h1.getCivilite());
        h1.setCivilite(Civilite.HOMME);
        System.out.println("Est ce que civilite a changé ? " + h1.getCivilite());
        
        System.out.println("h1 == h3 ? " + (h1 == h3));
        System.out.println("Opération --> h1 = h3");
        h1 = h3;
        System.out.println("h1 = h3 ? " + (h1 == h3));
        System.out.println("h1.equals(h3) ? " + h1.equals(h3));
        System.out.println("Changement civilité h1 en FEMME");
        h1.setCivilite(Civilite.FEMME);
        System.out.println("La civilité de h3 a-t-elle changé ? " + h3.getCivilite());
        
        h2 = new HommePolitique(h1.getCivilite(), h1.getNom(), h1.getParti());
        System.out.println("h1 == h2 ? " + (h1 == h2));
        System.out.println("h1.equals(h2) ? " + h1.equals(h2));
        System.out.println("h1.compareTo(h2) = " + h1.compareTo(h2));
        System.out.println("Changement civilité h1 en HOMME");
        h1.setCivilite(Civilite.HOMME);
        System.out.println("h1.equals(h2) ? " + h1.equals(h2));
        System.out.println("h1.compareTo(h2) = " + h1.compareTo(h2));
        
        h2 = (HommePolitique) h1.clone();
        System.out.println("h1 == h2 ? " + (h1 == h2));
        System.out.println("h1.equals(h2) ? " + h1.equals(h2));
        System.out.println("h1.compareTo(h2) = " + h1.compareTo(h2));
        System.out.println("Changement parti de h1 en unAutreParti");
        h1.setParti("unAutreParti");
        System.out.println(h2);
        
        
    }


    
    
}
