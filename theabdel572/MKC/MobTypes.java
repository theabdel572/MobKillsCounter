package theabdel572.MKC;

import org.bukkit.entity.EntityType;

public class MobTypes{
	//Enum to manage mobtypes and their respective config paths.
	enum MobType{
		
		ZOMBIE("zombies"), SKELETON("skeletons"), SPIDER("spiders"), CAVE_SPIDER("cave_spiders"), BLAZE("blazes"),
		CREEPER("creepers"), ENDER_DRAGON("ender_dragons"), ENDERMAN("endermans"), ENDERMITE("endermites"),
		BAT("bats"), CHICKEN("chickens"), COW("cows"), GHAST("ghasts"), GUARDIAN("guardians"), HORSE("horses"),
		IRON_GOLEM("iron_golems"), MAGMA_CUBE("magma_cubes"), MUSHROOM_COW("mushroom_cows"), OCELOT("ocelots"),
		PIG("pigs"), PIG_ZOMBIE("pig_zombies"), PLAYER("players"), RABBIT("rabbits"), SHEEP("sheeps"), SILVERFISH("silverfishs"),
		SLIME("slimes"), SNOWMAN("snowmans"), SQUID("squids"), VILLAGER("villagers"), WITCH("witchs"), WITHER("withers"), WOLF("wolfs");

		private MobType(String path) {
				this.path = path;
		}
		
		public String getPath() {
			return this.path;
		}
		
		//Getting the MobType (this enum) from the name of the EntityType (bukkit enum).
		public MobType getFromEntityType(EntityType entity) {
			@SuppressWarnings("deprecation")
			String name = entity.getName();
			
			return MobType.valueOf(name.toUpperCase());
		}
		
		
		private String path;
	}
}
