package io.hotmeatballsoup.ubiquitence;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class showing typical usage of {@link BaseLookup}.
 */
public class BaseLookupTest {
	@Test
	public void createAndUseCrayonColor() {
		// Given:
		CrayonColor crayonColor = new CrayonColor("my_db_user", "Midnight Blue",
			"MIDNIGHT_BLUE", "A very dark blue.");
		
		// Expect:
		Assert.assertTrue(!"VIOLET".equals(crayonColor.getAlias()));
	}

	/**
	 * Dummy class for showcasing purposes.
	 */
	private class CrayonColor extends BaseLookup {
		public CrayonColor(String createdBy, String name, String alias, String description) {
			super(createdBy, name, alias, description);
		}		
	}
}
