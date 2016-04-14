package travail.tp1;

public class CandidatScrutin implements Comparable<CandidatScrutin>{
        private HommePolitique hpolitique;
        private int nvoix;
        private int dscrutin;
        
        public CandidatScrutin(HommePolitique h,int date){
                this.hpolitique=(HommePolitique)h.clone();
                this.nvoix=0;
                this.dscrutin=date;
        }
        
        /**
         * @return civilite
         */
        public Civilite getCivilite() {
                return hpolitique.getCivilite();
        }
        
        public String getNom() {
            return hpolitique.getNom();
        }

        public String getParti() {
            return hpolitique.getParti();
        }

        /**
         * @param hpolitique the hpolitique to set
         */
        public void setHpolitique(HommePolitique hpolitique) {
                this.hpolitique = hpolitique;
        }
        /**
         * @return the nvoix
         */
        public int getNvoix() {
                return nvoix;
        }
       
        /**
         * @return the dscrutin
         */
        public int getDscrutin() {
                return dscrutin;
        }
        /**
         * @param dscrutin the dscrutin to set
         */
        public void setDscrutin(int dscrutin) {
                this.dscrutin = dscrutin;
        }
        
        
        public boolean checkAttributsHommePolitique(HommePolitique h){
            if (h.getCivilite()!=this.getCivilite()){
                return false;
            }
            if (h.getNom()!=this.getNom()){
                return false;
            }
            if (h.getParti()!=this.getParti()){
                return false;
            }
            return true;
        }
        
       
        
        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
                return "CandidatScrutin [hpolitique=" + hpolitique + ", nvoix=" + nvoix
                                + ", dscrutin=" + dscrutin + "]";
        }
        
        /* (non-Javadoc)
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + dscrutin;
                result = prime * result
                                + ((hpolitique == null) ? 0 : hpolitique.hashCode());
                result = prime * result + nvoix;
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
                if (!(obj instanceof CandidatScrutin))
                        return false;
                CandidatScrutin other = (CandidatScrutin) obj;
                if (dscrutin != other.dscrutin)
                        return false;
                if (hpolitique == null) {
                        if (other.hpolitique != null)
                                return false;
                } else if (!hpolitique.equals(other.hpolitique))
                        return false;
                if (nvoix != other.nvoix)
                        return false;
                return true;
        }
                
        
        public static void main(String[] args) {
        
             HommePolitique h1, h2, h3;
        h1 = new HommePolitique(Civilite.FEMME,"nom1","parti1");
        h3 = new HommePolitique(Civilite.HOMME,"nom3","parti3");
        
        CandidatScrutin cs1, cs2;
        cs1 = new CandidatScrutin(h1, 212016);
        cs2 = new CandidatScrutin(h3, 212016);    
           
            System.out.println(cs1);
            
        System.out.println("cs1 et hp3 sont les mêmes : "+cs1.checkAttributsHommePolitique(h3));
        
        
    }

    @Override
    public int compareTo(CandidatScrutin o) {
        
        return hpolitique.compareTo(new HommePolitique(o.getCivilite(),o.getNom(),o.getParti()));
        
    }
                
                
                
                
}
