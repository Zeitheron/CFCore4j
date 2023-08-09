# CFCore4j

A simple yet effective wrapper library around CF Core API.

Check their official docs to have a better time understanding what each method [here](https://docs.curseforge.com/) does.

## Example Usage

This example fetches Minecraft by it's game id, HammerLib by it's id, and a file by the file id.
There are way more functions to see here and there, these are just a few.

```java
import org.zeith.cfcore4j.CFCore4j;
import org.zeith.cfcore4j.CFCoreBuilder;
import org.zeith.cfcore4j.base.HTTPCache;
import org.zeith.cfcore4j.guava.RateLimiter;
import org.zeith.cfcore4j.schemas.File;
import org.zeith.cfcore4j.schemas.Game;
import org.zeith.cfcore4j.schemas.Mod;

import java.util.concurrent.TimeUnit;

public class TestCFCore4j
{
	public static void main(String[] args)
	{
		String apiKey = "your API key";
		
		CFCore4j api = new CFCoreBuilder()
				.authorize(apiKey) // Authorize our API with a key
				.cache(HTTPCache.cacheInRAMFor(TimeUnit.HOURS, 2L)) // Set cache lifetime to 2 hours in RAM
				.rateLimit(RateLimiter.create(5)) // Create force a ratelimit to CF API servers to be 5 calls per second
				.build(); // Create our API
		
		Game minecraft = api.games().getGame(432);
		System.out.println(minecraft.name + " (" + minecraft.slug + ")");
		
		// Test cache
		minecraft = api.games().getGame(432);
		System.out.println(minecraft.name + " (" + minecraft.slug + ")");
		
		int modId = 247401;
		Mod hammerLib = api.mods().getMod(modId);
		System.out.println(hammerLib.name + " (" + hammerLib.slug + ")");
		
		int fileId = 3541718;
		File file = api.files().getFiles(fileId).get(0);
		System.out.println(file.displayName + " {" + file.fileName + "}");
	}
}
```

## It's cool and all, but where do I get API keys?

**[Here](https://console.curseforge.com/?#/api-keys)**

## CFCore4j Dependency

### Gradle:

```groovy
repositories {
    mavenCentral()
    maven { url = "https://maven.zeith.org" }
}

dependencies {
    implementation 'org.zeith:CFCore4j:1.1.7'
}
```

### Maven:

```xml

<dependencies>
    <dependency>
        <groupId>org.zeith</groupId>
        <artifactId>CFCore4j</artifactId>
        <version>1.1.7</version>
    </dependency>
</dependencies>
```

```xml

<repositories>
    <repository>
        <id>zeith.org</id>
        <name>Zeith's Repository</name>
        <url>https://maven.zeith.org</url>
    </repository>
</repositories>
```

### Jar library:

Download from [here](https://github.com/Zeitheron/CFCore4j/releases).
