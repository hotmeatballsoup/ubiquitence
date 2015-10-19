package io.hotmeatballsoup.ubiquitence.utils.seqgen;

/**
 * Used for generating sequences at the application layer. Seed the generator with a base value
 * and then call its {@link SequenceGenerator#next()} method as many times as needed to generate
 * new values. The values generated depend on the implementation.
 */
public interface SequenceGenerator<TYPE> {
	/**
	 * Gets the seed value passed to the generator at creation.
	 * 
	 * @return	The generator's seeded value
	 */
	TYPE getSeed();

	/**
	 * Generates the next value in the sequence. Implementation specific.
	 * 
	 * @return	The next value in the sequence
	 */
	TYPE next();
	
	/**
	 * Resets the generator back to the seed, such that calling {@link SequenceGenerator#next}
	 * will give you the first value in the sequence again.
	 */
	void reset();
}
