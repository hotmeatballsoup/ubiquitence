package io.hotmeatballsoup.ubiquitence;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base lookup entity for <a href="https://en.wikipedia.org/wiki/Reference_table">reference data</a>.
 * Essentially an <b>enum</b> but at the database level.
 * 
 * <p>Lookups are expected to have 3 fields in persistence:
 * <ul>
 * 	<li><b>name:</b> an <i>external</i>, public/customer facing, pretty-print name</li>
 * 	<li><b>alias:</b> an <i>internal</i> alias, or tag, to be used in your code</li>
 * 	<li><b>description:</b> a simple description of what the enumerate value represents</li>
 * </ul>
 * 
 * For instance, say you have a table called <code>crayon_colors</code> and wanted to model it at
 * the application layer as a lookup. You'd simple do:
 * 
 * <pre><code>public class CrayonColor extends BaseLookup { }</code></pre>
 * 
 * <p>If your lookups have other attributes/properties beyond just these three (name, alias and
 * description) then you would add them. But for most lookups these three fields should suffice
 * so your lookup class would either be empty (well, with a constructor, of course).
 * 
 * <p>Then at the data layer you might have the following table/collection/record:
 * 
 * <pre><code>crayon_colors
 * crayon_color_name	crayon_color_alias	  crayon_color_description
 * -------------------------------------------------------------------
 * 'Fire Engine Red'	FIRE_ENGINE_RED		  The color of a Fire Engine.
 * 'Midnight Blue'        MIDNIGHT_BLUE	  	  A very dark blue.</code></pre>
 * 
 * The idea here is that you display the <i>name</i> to end users, and use the <i>alias</i> as
 * an internal tag that can be read and processed by your app code.
 */
public abstract class BaseLookup extends BaseEntity {
	@JsonProperty("name")
	@NotEmpty
	private String name;
	
	@JsonProperty("alias")
	@NotEmpty
	private String alias;
	
	@JsonProperty("description")
	@NotEmpty
	private String description;

	public BaseLookup() {
		super();
	}
	
	public BaseLookup(String createdBy, String name, String alias, String description) {
		super(createdBy);
		
		setName(name);
		setAlias(alias);
		setDescription(description);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
