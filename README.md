# CFCore4j

A simple yet effective wrapper library around CF Core API.

Check their official docs to have a better time understanding what each method [here](https://docs.curseforge.com/) does.

## Example Usage

This example fetches

```java
import org.zeith.cfcore4j.CFCore4j;
import org.zeith.cfcore4j.CFCoreBuilder;
import org.zeith.cfcore4j.schemas.File;
import org.zeith.cfcore4j.schemas.Game;
import org.zeith.cfcore4j.schemas.Mod;

public class TestCFCore4j
{
	public static void main(String[] args)
	{
		String apiKey = "your API key";

		CFCore4j api = new CFCoreBuilder().authorize(apiKey).build();

		Game minecraft = api.games().getGame(432);

		System.out.println(minecraft.name + " (" + minecraft.slug + ")");

		int modId = 247401;
		Mod musicLayer = api.mods().getMod(modId);
		System.out.println(musicLayer.name + " (" + musicLayer.slug + ")");

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
    implementation 'org.zeith:CFCore4j:1.0.1'
}
```

### Maven:

```xml

<dependencies>
    <dependency>
        <groupId>org.zeith</groupId>
        <artifactId>CFCore4j</artifactId>
        <version>1.0.1</version>
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

### Jar library

Download from [here](https://github.com/Zeitheron/CFCore4j/releases).
