package io.hotmeatballsoup.ubiquitence.utils.seqgen;

import com.google.common.base.Preconditions;

/**
 * Auto-incrementing sequence generator for <code>Long</code> types. Values in the sequence
 * are incremented (by 1) on each subsequent invocation of
 * {@link AutoIncrementingSequenceGenerator#next}.
 */
public class AutoIncrementingSequenceGenerator implements SequenceGenerator<Long> {
	private Long originalSeed;
	private Long seed;
	
	public AutoIncrementingSequenceGenerator() {
		this(1L);
	}
	
	/**
	 * Creates an {@link AutoIncrementingSequenceGenerator}/
	 * 
	 * @param seed	The initial "seed" value to start from; typically <code>1L</code>.
	 */
	public AutoIncrementingSequenceGenerator(Long seed) {
		super();
		
		Preconditions.checkArgument(seed >= 0L);
		
		this.originalSeed = seed;
		this.seed = seed;
	}
	
	@Override
	public Long getSeed() {
		return seed;
	}

	@Override
	public Long next() {
		return seed++;
	}

	@Override
	public void reset() {
		seed = originalSeed;
	}
}
