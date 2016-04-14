package travail.tp1;

public class CandidatScrutin{
        private HommePolitique hpolitique;
        private int nvoix;
        private int dscrutin;
        
        public CandidatScrutin(HommePolitique h,int date){
                this.hpolitique=new HommePolitique(h.getCivilite(),h.getNom(),h.getParti());
                this.nvoix=0;
                this.dscrutin=date;
        }
        
        /**
         * @return the hpolitique
         */
        public HommePolitique getHpolitique() {
                return hpolitique;
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
         * @param nvoix the nvoix to set
         */
        public void setNvoix(int nvoix) {
                this.nvoix = nvoix;
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
                
}
