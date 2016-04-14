package tp1;


/**
 * @author francoise.perrin
 * Inspiration MOOC sur Coursera "Introduction à la POO (en Java)"
 * by Jamila Sam, Jean-Cédric Chappelier - EPFL 
 */

public class HommePolitique implements Comparable<HommePolitique>, Cloneable {
 
	private Civilite civilite;
	private String nom;
    private String parti;
    
	/**
	 * @param civilite
	 * @param nom
	 * @param parti
	 */
	public HommePolitique(Civilite civilite, String nom, String parti) {
		super();
		this.setNom(nom);
		this.setParti(parti) ;
		this.setCivilite(civilite);
	}
	public HommePolitique(HommePolitique hommePolitique) {
		super();
		this.setNom(hommePolitique.nom);
		this.setParti(hommePolitique.parti) ;
		this.setCivilite(hommePolitique.civilite);
	}
	/**
	 * @param civilite
	 */
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	
	/**
	 * @return
	 */
	public Civilite getCivilite() {
		return civilite;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		if (nom == null) {
			throw new IllegalArgumentException("la propriété nom ne peut pas être null");
		}
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public String getParti() {
		return parti;
	}

	/**
	 * @param parti
	 */
	public void setParti(String parti) {
		this.parti = parti;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((civilite == null) ? 0 : civilite.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((parti == null) ? 0 : parti.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HommePolitique other = (HommePolitique) obj;
		if (civilite == null) {
			if (other.civilite != null)
				return false;
		} else if (!civilite.equals(other.civilite))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (parti == null) {
			if (other.parti != null)
				return false;
		} else if (!parti.equals(other.parti))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(HommePolitique o) {
		int comp = 0;
		if ((o != null)) {
			// algo riqué : reprendre celui de equals serait prudent
			comp = this.civilite.compareTo(o.civilite) + this.nom.compareTo(o.nom) + this.parti.compareTo(o.parti);
		}
		else
			throw new NullPointerException();
		return comp;
	}

	@Override
	public String toString() {
		//return "HommePolitique [nom=" + nom + ", parti=" + parti + "]";
		return "[civilité = " + civilite + ", nom = " + nom + ", parti = " + parti + "]";
	}
 
    @Override
    public Object clone()  {
		return new HommePolitique(this.civilite,this.nom, this.parti) ;
	}
    
    public static void main(String[] args){
        	  org.junit.runner.JUnitCore.main("tp1.unitTest.HommePolitiqueTest");
    }
   
}

 