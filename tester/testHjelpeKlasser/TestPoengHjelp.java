package testHjelpeKlasser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entiteter.Stemme;
import hjelpeKlasser.PoengHjelp;

public class TestPoengHjelp {
	
	private final int MAX_STEMME_VERDI = 5;
	private final double FEILTOLERANSE = 0.01;
	private final static int NULLPUNKT_FOR_VEKTETSCORE = 3;
	private final static double STANDARDVEKTETSCORE = 1.00;

	private List<Stemme> statiskStemmer;
	private List<Stemme> dynamiskStemmer;
	private int poengFasit;
	private double fasitGjPoeng;
	private int antallNullStemmer;
	private double fasitVektetScore;
	
	@Before
	public void oppsett() {
		//Statisk test
		statiskStemmer = new ArrayList<Stemme>();
		int antallStemmer = 5;
		
		for(int i = 0; i < antallStemmer; i++) {
			statiskStemmer.add(new Stemme(0, 0, i));
		}
		
		//Dynamisk test
		dynamiskStemmer = new ArrayList<Stemme>();
		Random rand = new Random();
		int dynamiskAntallStemmer = 1000;
		double positivScore = 0.0;
		double negativScore = 0.0;
		
		for(int i = 0; i < dynamiskAntallStemmer; i++) {
			int stemme = rand.nextInt(MAX_STEMME_VERDI);
			poengFasit += stemme;
			
			dynamiskStemmer.add(new Stemme(0, 0, stemme));
			
			if(stemme == 0) {
				antallNullStemmer++;
			}else{
				if(stemme > NULLPUNKT_FOR_VEKTETSCORE) {
					positivScore += (stemme - NULLPUNKT_FOR_VEKTETSCORE);
				}else {
					negativScore += (stemme - NULLPUNKT_FOR_VEKTETSCORE);
				}
			}
			
			
		}
		
		fasitGjPoeng = (double)poengFasit / (dynamiskStemmer.size() - antallNullStemmer);
	
		fasitVektetScore = STANDARDVEKTETSCORE 
				+ (positivScore / 100.0) + (negativScore / 100.0);
	}
	
	//Statisk liste
	@Test
	public void testStatiskGyldigeStemmer() {
		int antallStemmer = 4;
		
		Assert.assertEquals(antallStemmer,
				PoengHjelp.gyldigeStemmer(statiskStemmer));
	}
	
	@Test
	public void testStatiskTellPoengTilProsjekt() {
		int poengFasit = 10;
		
		Assert.assertEquals(poengFasit,
				PoengHjelp.tellPoengTilProsjekt(statiskStemmer));
	}
	
	@Test
	public void testStatiskRegnUtGjScore() {
		double GjPoeng = 2.50;
		
		Assert.assertEquals(GjPoeng,
				PoengHjelp.regnUtGjScore(statiskStemmer), FEILTOLERANSE);
	}
	
	@Test
	public void testStatiskRegnUtVektetScore() {
		double vektetScore = 0.98;
		
		Assert.assertEquals(vektetScore,
				PoengHjelp.regnUtVektetScore(statiskStemmer), FEILTOLERANSE);
	}
	
	@Test
	public void testStatiskRegnUtScore() {
		double score = 9.8;
		
		Assert.assertEquals(score, 
				PoengHjelp.regnUtScore(statiskStemmer), FEILTOLERANSE);
	}
	
	//Dynamisk liste
	
	@Test
	public void testDynamiskTellPoengTilProsjekt() {
		Assert.assertEquals(poengFasit,
				PoengHjelp.tellPoengTilProsjekt(dynamiskStemmer));
	}
	
	@Test
	public void testDynamiskRegnUtGjScore() {
		Assert.assertEquals(fasitGjPoeng,
				PoengHjelp.regnUtGjScore(dynamiskStemmer), FEILTOLERANSE);
	}
	
	@Test
	public void testDynamiskRegnUtVektetScore() {
		Assert.assertEquals(fasitVektetScore,
				PoengHjelp.regnUtVektetScore(dynamiskStemmer), FEILTOLERANSE);
	}
	
	@Test
	public void testDynamiskRegnUtScore() {
		int antallStemmer = PoengHjelp.gyldigeStemmer(dynamiskStemmer);
		double gjScore = PoengHjelp.regnUtGjScore(dynamiskStemmer);
		double vektetScore = PoengHjelp.regnUtVektetScore(dynamiskStemmer);
		
		double score = gjScore * antallStemmer * vektetScore;
		
		Assert.assertEquals(score, 
				PoengHjelp.regnUtScore(dynamiskStemmer), FEILTOLERANSE);
	}
	
	@Test
	public void testDynamiskGyldigeStemmer() {
		Assert.assertEquals(dynamiskStemmer.size() - antallNullStemmer,
				PoengHjelp.gyldigeStemmer(dynamiskStemmer));
	}
	
	
	
	
}
