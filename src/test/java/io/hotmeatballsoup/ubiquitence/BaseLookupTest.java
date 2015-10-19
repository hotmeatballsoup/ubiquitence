package io.hotmeatballsoup.ubiquitence;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class showing typical usage of {@link BaseLookup}.
 */
public class BaseLookupTest {
	@Test
	public void createAndUseCrayonColor() {
		// Given:
		CrayonColor crayonColor = new CrayonColor(1L, "001", "my_db_user", new Date(),
			"Midnight Blue", "MIDNIGHT_BLUE", "A very dark blue.");
		
		// Expect:
		Assert.assertTrue(!"VIOLET".equals(crayonColor.getAlias()));
	}

	/**
	 * Dummy class for showcasing purposes.
	 */
	private class CrayonColor extends BaseLookup {
		public CrayonColor(Long id, String version, String createdBy, Date createdOn, String name, String alias,
				String description) {
			super(id, version, createdBy, createdOn, name, alias, description);
		}		
	}
}
