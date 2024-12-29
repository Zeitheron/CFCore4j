import org.zeith.cfcore4j.CFCore4j;
import org.zeith.cfcore4j.CFCoreBuilder;
import org.zeith.cfcore4j.base.HTTPCache;
import org.zeith.cfcore4j.guava.RateLimiter;
import org.zeith.cfcore4j.schemas.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestCFCore4j
{
	public static void main(String[] args)
	{
		String apiKey = "your API key";
		
		CFCore4j api = new CFCoreBuilder()
				.authorize(apiKey) // Authorize our API with a key
				.cache(HTTPCache.cacheInRAMFor(TimeUnit.HOURS, 2L).cacheSizeLimit(4)) // Set cache lifetime to 2 hours in RAM
				.rateLimit(RateLimiter.create(5)) // Create force a ratelimit to CF API servers to be 5 calls per second
				.build(); // Create our API
		
		System.out.println(api.mods().getMods(310637L));
		
		// Test cache with multiple similar requests:
		System.out.println(api.minecraft().getVersions());
		System.out.println(api.minecraft().getVersions());
		System.out.println(api.minecraft().getVersions());
		System.out.println(api.minecraft().getVersions());
		
		System.out.println(api.minecraft().getSpecificVersion("1.21.4"));
		for(MinecraftModLoaderIndex datum : api.minecraft().getModLoaders("1.20.1", true).data.stream().limit(10L).collect(Collectors.toList()))
		{
			System.out.println(datum);
			System.out.println(" - " + api.minecraft().getSpecificModLoader(datum).data);
			System.out.println();
		}
		
		Game minecraft = api.games().getGame(432L);
		System.out.println(minecraft.name + " (" + minecraft.slug + ")");
		
		// Test cache
		minecraft = api.games().getGame(432L);
		System.out.println(minecraft.name + " (" + minecraft.slug + ")");
		
		long modId = 247401;
		Mod hammerLib = api.mods().getMod(modId);
		System.out.println(hammerLib.name + " (" + hammerLib.slug + ")");
		
		long fileId = 3541718;
		File file = api.files().getFiles(fileId).get(0);
		System.out.println(file.displayName + " {" + file.fileName + "}");
	}
}