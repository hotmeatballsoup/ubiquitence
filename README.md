# Ubiquitence
Model once, persist anywhere.

### What is it?
Ubiquitence is a "commons" style library targeting JVM apps that have general persistence needs. We've worked with *many* different databases over the years (relational, document, big data, kv-stores, graphs, etc.) and have noticed a worrisome amount of [DRY](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself) violations going on w.r.t. various persistence libraries.

Any time you persist entities, you need usually need some base classes that are properly annotated (JPA annotations, perhaps Jackson/JSON or protobuff annotations, bean validation annotations). Ubiquitence offers such a type hierarchy as well as the necessary annotations and dependencies. Where applicable, we also make these configurable, although as an opinionated library, we're following a more *convention over configuration* attitude.

### Goals
* Develop your domain entities once and then allow them to map to 1+ persistence stores without having to make changes *to them*
* To make persistence as easy and reusable as possible.

### Requirements
Ubiquitence is compiled using Java 8 but doesn't make use of any JRE7/8 features, so this *should* work with JRE5+. But if you're still using Java 5 or 6, you may want to revisit your architecture. Java 7 is already EOL!

### How to use it

#### Type Hierarchy
Currently there's no right/wrong way to "use" Ubiquitence. You just make sure your entity classes extend the appropriate Ubiquitence classes and everything "*should just work*."

Check out the [test classes](src/test/java) for usage ideas or check out our [Javadocs]() for full descriptions of each class and when/where to use it. If all else fails create an [issue]() and we'll get it addressed within a day or two.

**Ubiquitence will always strive to be on the latest *stable* versions of all dependencies (so no release candidates or betas, etc.).**

For example, if you have a standard entity class, you just need to extend `BaseEntity` like so:

    @Entity											// Optional, Mongo only
    @JsonIgnoreProperties(ignoreUnknown=true)		// Optional, configure as needed
    @JsonInclude(JsonInclude.Include.NON_NULL)		// Optional, configure as needed
    public class Hotmeatballsoup extends BaseEntity {
    	@JsonProperty("fizz")
    	@NotEmpty
        public String fizz;
        
        @JsonProperty("buzz")
        public boolean buzz;
        
        Hotmeatballsoup(Long id, String version, String fizz, boolean buzz) {
            super(id, version, "my_db_user");
            
            setFizz(fizz);
            setBuzz(buzz);
        }
        
        // Getters and setters down here, etc.
    }
    
You will have to have a basic working knowledge of these underlying libraries, although the end goal of this project is to abstract these details out into generic configurations/annotations that will map to any persistence store.

#### Sequence Generators
Some persistence stores (such as Mongo) require you to use their own, non-`Long` unique IDs to generate unique sequences on them. Since the fundamental pillar of Ubiquitence is to be common/generic, we didn't want to force our base classes to use proprietary/custom data types (e.g., in the case of Mongo/Morphia there is the `org.bson.types.ObjectId`). The implication here, however, is that for those data stores, we then need to generate the sequences ourselves. Ubiquitence provides such sequence generators for this type of scenario.

Currently we have `AutoIncrementingSequenceGenerator` which can be used auto-increment your `BaseEntity` instances as you create them like so:

    AutoIncrementingSequenceGenerator aisg = new AutoIncrementingSequenceGenerator(1L); // seed value
    
    // When we call 'aisg.next()' the first time, it gives us back 1L. Then 2L, 3L, etc...
    Hotmeatbalsoup hms = new Hotmeatballsoup(aisg.next(), UUID.randomUUID.toString(),
	    "Widget fizz", false);

### Current capabilities
* Jackson/JSON serialization
* Mongo annotations via [Morphia]()
* JSR-303 (Bean Validation)

### Next release
* Google Protobuff support
* XStream/XML serialization
* JPA/Hibernate

### Road map
* Large-scale NoSQL support (Cassandra, BigTable, Neo4j, Redis, Riak, CouchDB)
* Abstracted annotations/configurations so that you don't need to know the intricate details in working with these underlying frameworks

### What if I need something that isn't supported?
[Contribute!](CONTRIBUTING.md), or file an [issue]() and label it as an **enhancement**.

### What if something isn't working as expected?
File an [issue]() and label it as a **bug**.

### Contributing
[Please see our Contributing page.](CONTRIBUTING.md)


