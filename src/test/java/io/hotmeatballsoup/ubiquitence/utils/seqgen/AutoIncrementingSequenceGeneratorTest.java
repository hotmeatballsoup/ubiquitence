package io.hotmeatballsoup.ubiquitence.utils.seqgen;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link AutoIncrementingSequenceGenerator}.
 */
public class AutoIncrementingSequenceGeneratorTest {
	@Test
	public void defaultConstructorSeedsToOne() {
		// Given
		AutoIncrementingSequenceGenerator aisg;
		
		// When
		aisg = new AutoIncrementingSequenceGenerator();
		
		// Then:
		Assert.assertTrue(aisg.getSeed() == 1L);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantSeedNegativeValue() {
		// Given
		@SuppressWarnings("unused")
		AutoIncrementingSequenceGenerator aisg;
		
		// Expect exception
		aisg = new AutoIncrementingSequenceGenerator(-1L);
	}
	
	@Test
	public void nextIncrementsByOneEachTime() {
		// Given
		AutoIncrementingSequenceGenerator aisg = new AutoIncrementingSequenceGenerator();
		
		// When
		Long id1 = aisg.next();
		Long id2 = aisg.next();
		Long id3 = aisg.next();
		
		// Then:
		Assert.assertTrue(id1 == 1L);
		Assert.assertTrue(id2 == 2L);
		Assert.assertTrue(id3 == 3L);
	}
	
	@Test
	public void resetSendsNextMethodBackToSeedValue() {
		// Given
		AutoIncrementingSequenceGenerator aisg = new AutoIncrementingSequenceGenerator();
		aisg.next();
		aisg.next();
		aisg.next();
		aisg.next();
		Long id = aisg.next();
		
		// When
		aisg.reset();
		
		// Then:
		Assert.assertTrue(id == 5L);
		Assert.assertTrue(aisg.next() == 1L);
	}
}
