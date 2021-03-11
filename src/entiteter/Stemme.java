package entiteter;

import javax.persistence.*;

public class Stemme {

	@Entity
	@Table(schema="exposystem",name="stemme")
	public class Vote {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int stemmeId;
		
		private int stemmeVerdi;
		
		@ManyToOne
		@JoinColumn(name="standId")
		private Stand stand;
		
		@ManyToOne
		@JoinColumn(name="tilskuerId")
		private Tilskuer tilskuer;
		
		
		/**
		 * Oppretter en ny stemme
		 * @param String verdi vekten paa stemmen
		 * @param Stand stand hvilket stand stemmen er for
		 * @param Tilskuer tilskuer hvilken tilskuer stemmen tilhører
		 */
		public Stemme(String verdi, Stand stand, Tilskuer tilskuer) {
			this.stand = stand;
			this.tilskuer= tilskuer;
			this.stemmeVerdi = Integer.parseInt(verdi);
		}
		
		public Vote() {}
		
		public int hentStemmeId() {
			return stemmeId;
		}

		public void setStemmeId(int stemmeId) {
			this.stemmeId = stemmeId;
		}

		public int hentStemmeVerdi() {
			return stemmeVerdi;
		}

		public void setStemmeVerdi(int stemmeVerdi) {
			this.stemmeVerdi = stemmeVerdi;
		}

		public Stand hentStand() {
			return stand;
		}

		public void setStand(Stand stand) {
			this.stand = stand;
		}	
		
		public Tilskuer hentTilskuer() {
			return tilskuer;
		}
		
	}
}