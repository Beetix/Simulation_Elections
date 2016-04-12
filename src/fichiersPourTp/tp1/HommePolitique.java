package fichiersPourTp.tp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author beetix
 */
public class HommePolitique {
    
    private Civilite civilite;
    
    private String nom;
    private String nomParti;

    public HommePolitique(Civilite civilite, String nom, String nomParti) {
        this.civilite = civilite;
        this.nom = nom;
        this.nomParti = nomParti;
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

    public String getNomParti() {
        return nomParti;
    }

    public void setNomParti(String nomParti) {
        this.nomParti = nomParti;
    }

    @Override
    public String toString() {
        return "HommePolitique{" + "civilite=" + civilite + ", nom=" + nom + ", nomParti=" + nomParti + '}';
    }
    
    
    public static void main(String args[])
    {
        HommePolitique h1, h2, h3;
        h1 = new HommePolitique(Civilite.FEMME,"nom1","parti1");
        h3 =new HommePolitique(Civilite.HOMME,"nom3","parti3");
        System.out.println("h1: " + h1);
        
        System.out.println("Est ce que civilite est correcte ? " + h1.getCivilite());
        h1.setCivilite(Civilite.HOMME);
        System.out.println("Est ce que civilite a changé ? " + h1.getCivilite());
    }
    
    
}
