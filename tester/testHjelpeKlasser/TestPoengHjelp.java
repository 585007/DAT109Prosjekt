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

	private List<Stemme> stemmer;
	private int poengFasit;
	private double fasitGjPoeng;
	private int antallNullStemmer;
	private double fasitVektetScore;
	
	@Before
	public void oppsett() {
		stemmer = new ArrayList<Stemme>();
		Random rand = new Random();
		
		int antallStemmer = 5;
		for(int i = 0; i < antallStemmer; i++) {
			int stemme = rand.nextInt(MAX_STEMME_VERDI);
			poengFasit += stemme;
			
			stemmer.add(new Stemme(0, 0, stemme));
			
			if(stemme == 0) {
				antallNullStemmer++;
			}else {
				fasitVektetScore += (stemme - NULLPUNKT_FOR_VEKTETSCORE);
			}
		}
		
		fasitGjPoeng = poengFasit / (stemmer.size() - antallNullStemmer);
		
		
	}
	
	
	@Test
	public void testTellPoengTilProsjekt() {
		Assert.assertEquals(poengFasit,
				PoengHjelp.tellPoengTilProsjekt(stemmer));
	}
	
	@Test
	public void testRegnUtGjScore() {
		Assert.assertEquals(fasitGjPoeng,
				PoengHjelp.regnUtGjScore(stemmer), FEILTOLERANSE);
	}
	
	//TODO - endret utregningsmetode
	@Test
	public void testregnUtVektetScore() {
		Assert.assertEquals(fasitVektetScore,
				PoengHjelp.regnUtVektetScore(stemmer), FEILTOLERANSE);
	}
	
	//TODO - endret utregningsmetode
	@Test
	public void testRegnUtScore() {
		
		int antallStemmer = PoengHjelp.gyldigeStemmer(stemmer);
		int totalScore = PoengHjelp.tellPoengTilProsjekt(stemmer);
		double gjScore = PoengHjelp.regnUtGjScore(stemmer);
		double vektetScore = PoengHjelp.regnUtVektetScore(stemmer);
		
		double score;
		
		if(vektetScore != 0) {
			score = antallStemmer / (totalScore + gjScore * vektetScore);
		}else {
			score = antallStemmer / (totalScore + gjScore) ;
		}
		
		
		Assert.assertEquals(score, 
				PoengHjelp.regnUtScore(stemmer), FEILTOLERANSE);
	}
	
	public void testGyldigeStemmer() {
		Assert.assertEquals(antallNullStemmer,
				PoengHjelp.gyldigeStemmer(stemmer));
	}
	
	
	
	
}
