package theabdel572.MKC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.entity.EntityType;

/* Class containing an enum to manage all the mobs compatible with the plugin
 * and their respective paths in the config files.
 */
public class MobTypes {
  // Enum to manage mobtypes and their respective config paths.
  public enum MobType {
    ZOMBIE("zombies"),
    SKELETON("skeletons"),
    SPIDER("spiders"),
    CAVE_SPIDER("cave_spiders"),
    BLAZE("blazes"),
    CREEPER("creepers"),
    ENDER_DRAGON("ender_dragons"),
    ENDERMAN("endermans"),
    ENDERMITE("endermites"),
    BAT("bats"),
    CHICKEN("chickens"),
    COW("cows"),
    GHAST("ghasts"),
    GUARDIAN("guardians"),
    HORSE("horses"),
    IRON_GOLEM("iron_golems"),
    MAGMA_CUBE("magma_cubes"),
    MUSHROOM_COW("mushroom_cows"),
    OCELOT("ocelots"),
    PIG("pigs"),
    PIG_ZOMBIE("pig_zombies"),
    PLAYER("players"),
    RABBIT("rabbits"),
    SHEEP("sheeps"),
    SILVERFISH("silverfishs"),
    SLIME("slimes"),
    SNOWMAN("snowmans"),
    SQUID("squids"),
    VILLAGER("villagers"),
    WITCH("witchs"),
    WITHER("withers"),
    WOLF("wolfs"),
    WARDEN("wardens"),
    ALLAY("allays"),
    AXOLOTL("axolotles"),
    BEE("bees"),
    PIGLIN("piglins"),
    PIGLIN_BRUTE("brute_piglins"),
    ZOMBIFIED_PIGLIN("zombified_piglins");

    // Creates a MobType instance with the given path, which is gonna be used in config files.
    private MobType(String path) {
      this.path = path;
    }

    public String getPath() {
      return this.path;
    }

    // Getting the MobType (this enum) from the name of the EntityType (bukkit enum).
    public static MobType getFromEntityType(EntityType entity) {
      @SuppressWarnings("deprecation")
      String name = entity.getName();

      return MobType.valueOf(name.toUpperCase());
    }

    // Get an array with all the paths of the MobType enum.
    public static String[] getEveryPath() {

      String[] paths = {};
      List<String> pathList = new ArrayList<String>(Arrays.asList(paths));

      for (int i = 0; i < MobType.values().length; i++) {

        String path = MobType.values()[i].getPath();
        pathList.add(path);
      }

      paths = pathList.toArray(paths);

      return paths;
    }

    // Method to check if the given String is the path of some of the enum's elements.
    public static boolean isPath(String s) {

      for (String path : MobType.getEveryPath()) {
        if (path.equalsIgnoreCase(s)) {
          return true;
        }
      }

      return false;
    }

    private final String path;
  }
}
