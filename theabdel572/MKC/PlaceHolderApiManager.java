package theabdel572.MKC;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class PlaceHolderApiManager extends PlaceholderExpansion {
	// We get an instance of the plugin later.
	private MKC plugin;

	public PlaceHolderApiManager(MKC plugin) {
		this.plugin = plugin;
	}

	/**
	 * Because this is an internal class, you must override this method to let
	 * PlaceholderAPI know to not unregister your expansion class when
	 * PlaceholderAPI is reloaded
	 *
	 * @return true to persist through reloads
	 */
	@Override
	public boolean persist() {
		return true;
	}

	/**
	 * Since this expansion requires api access to the plugin "SomePlugin" we must
	 * check if said plugin is on the server or not.
	 *
	 * @return true or false depending on if the required plugin is installed.
	 */
	@Override
	public boolean canRegister() {
		return true;
	}

	/**
	 * The name of the person who created this expansion should go here.
	 * 
	 * @return The name of the author as a String.
	 */
	@Override
	public String getAuthor() {
		return "theabdel572";
	}

	/**
	 * The placeholder identifier should go here.<br>
	 * This is what tells PlaceholderAPI to call our onRequest method to obtain a
	 * value if a placeholder starts with our identifier.<br>
	 * This must be unique and can not contain % or _
	 *
	 * @return The identifier in {@code %<identifier>_<value>%} as String.
	 */
	@Override
	public String getIdentifier() {
		return "mkc";
	}

	/**
	 * This is the version of this expansion.<br>
	 * You don't have to use numbers, since it is set as a String.
	 *
	 * @return The version as a String.
	 */
	@Override
	public String getVersion() {
		return plugin.getDescription().getVersion();
	}

	/**
	 * This is the method called when a placeholder with our identifier is found and
	 * needs a value.<br>
	 * We specify the value identifier in this method.<br>
	 * Since version 2.9.1 can you use OfflinePlayers in your requests.
	 *
	 * @param player     A {@link org.bukkit.Player Player}.
	 * @param identifier A String containing the identifier/value.
	 *
	 * @return possibly-null String of the requested identifier.
	 */

	@Override
	public String onPlaceholderRequest(Player player, String identifier) {
		FileConfiguration players = plugin.getPlayers();
		if (player == null) {
			return "";
		}

		if (identifier.equals("zombies")) {
			if (players.contains("Players." + player.getUniqueId() + ".zombies")) {
				return players.getString("Players." + player.getUniqueId() + ".zombies");
			} else {
				return "0";
			}
		}
		if (identifier.equals("skeletons")) {
			if (players.contains("Players." + player.getUniqueId() + ".skeletons")) {
				return players.getString("Players." + player.getUniqueId() + ".skeletons");
			} else {
				return "0";
			}
		}
		if (identifier.equals("spiders")) {
			if (players.contains("Players." + player.getUniqueId() + ".spiders")) {
				return players.getString("Players." + player.getUniqueId() + ".spiders");
			} else {
				return "0";
			}
		}
		if (identifier.equals("cave_spiders")) {
			if (players.contains("Players." + player.getUniqueId() + ".cave_spiders")) {
				return players.getString("Players." + player.getUniqueId() + ".cave_spiders");
			} else {
				return "0";
			}
		}
		if (identifier.equals("blazes")) {
			if (players.contains("Players." + player.getUniqueId() + ".blazes")) {
				return players.getString("Players." + player.getUniqueId() + ".blazes");
			} else {
				return "0";
			}
		}
		if (identifier.equals("creepers")) {
			if (players.contains("Players." + player.getUniqueId() + ".creepers")) {
				return players.getString("Players." + player.getUniqueId() + ".creepers");
			} else {
				return "0";
			}
		}
		if (identifier.equals("ender_dragons")) {
			if (players.contains("Players." + player.getUniqueId() + ".ender_dragons")) {
				return players.getString("Players." + player.getUniqueId() + ".ender_dragons");
			} else {
				return "0";
			}
		}
		if (identifier.equals("endermans")) {
			if (players.contains("Players." + player.getUniqueId() + ".endermans")) {
				return players.getString("Players." + player.getUniqueId() + ".endermans");
			} else {
				return "0";
			}
		}
		if (identifier.equals("endermites")) {
			if (players.contains("Players." + player.getUniqueId() + ".endermites")) {
				return players.getString("Players." + player.getUniqueId() + ".endermites");
			} else {
				return "0";
			}
		}
		if (identifier.equals("bats")) {
			if (players.contains("Players." + player.getUniqueId() + ".bats")) {
				return players.getString("Players." + player.getUniqueId() + ".bats");
			} else {
				return "0";
			}
		}
		if (identifier.equals("chickens")) {
			if (players.contains("Players." + player.getUniqueId() + ".chickens")) {
				return players.getString("Players." + player.getUniqueId() + ".chickens");
			} else {
				return "0";
			}
		}
		if (identifier.equals("cows")) {
			if (players.contains("Players." + player.getUniqueId() + ".cows")) {
				return players.getString("Players." + player.getUniqueId() + ".cows");
			} else {
				return "0";
			}
		}
		if (identifier.equals("ghasts")) {
			if (players.contains("Players." + player.getUniqueId() + ".ghasts")) {
				return players.getString("Players." + player.getUniqueId() + ".ghasts");
			} else {
				return "0";
			}
		}
		if (identifier.equals("guardians")) {
			if (players.contains("Players." + player.getUniqueId() + ".guardians")) {
				return players.getString("Players." + player.getUniqueId() + ".guardians");
			} else {
				return "0";
			}
		}
		if (identifier.equals("horses")) {
			if (players.contains("Players." + player.getUniqueId() + ".horses")) {
				return players.getString("Players." + player.getUniqueId() + ".horses");
			} else {
				return "0";
			}
		}
		if (identifier.equals("iron_golems")) {
			if (players.contains("Players." + player.getUniqueId() + ".iron_golems")) {
				return players.getString("Players." + player.getUniqueId() + ".iron_golems");
			} else {
				return "0";
			}
		}
		if (identifier.equals("magma_cubes")) {
			if (players.contains("Players." + player.getUniqueId() + ".magma_cubes")) {
				return players.getString("Players." + player.getUniqueId() + ".magma_cubes");
			} else {
				return "0";
			}
		}
		if (identifier.equals("mushroom_cows")) {
			if (players.contains("Players." + player.getUniqueId() + ".mushroom_cows")) {
				return players.getString("Players." + player.getUniqueId() + ".mushroom_cows");
			} else {
				return "0";
			}
		}
		if (identifier.equals("ocelots")) {
			if (players.contains("Players." + player.getUniqueId() + ".ocelots")) {
				return players.getString("Players." + player.getUniqueId() + ".ocelots");
			} else {
				return "0";
			}
		}
		if (identifier.equals("pigs")) {
			if (players.contains("Players." + player.getUniqueId() + ".pigs")) {
				return players.getString("Players." + player.getUniqueId() + ".pigs");
			} else {
				return "0";
			}
		}
		if (identifier.equals("pig_zombies")) {
			if (players.contains("Players." + player.getUniqueId() + ".pig_zombies")) {
				return players.getString("Players." + player.getUniqueId() + ".pig_zombies");
			} else {
				return "0";
			}
		}
		if (identifier.equals("players")) {
			if (players.contains("Players." + player.getUniqueId() + ".players")) {
				return players.getString("Players." + player.getUniqueId() + ".players");
			} else {
				return "0";
			}
		}
		if (identifier.equals("rabbits")) {
			if (players.contains("Players." + player.getUniqueId() + ".rabbits")) {
				return players.getString("Players." + player.getUniqueId() + ".rabbits");
			} else {
				return "0";
			}
		}
		if (identifier.equals("sheeps")) {
			if (players.contains("Players." + player.getUniqueId() + ".sheeps")) {
				return players.getString("Players." + player.getUniqueId() + ".sheeps");
			} else {
				return "0";
			}
		}
		if (identifier.equals("silverfishs")) {
			if (players.contains("Players." + player.getUniqueId() + ".silverfishs")) {
				return players.getString("Players." + player.getUniqueId() + ".silverfishs");
			} else {
				return "0";
			}
		}
		if (identifier.equals("slimes")) {
			if (players.contains("Players." + player.getUniqueId() + ".slimes")) {
				return players.getString("Players." + player.getUniqueId() + ".slimes");
			} else {
				return "0";
			}
		}
		if (identifier.equals("snowmans")) {
			if (players.contains("Players." + player.getUniqueId() + ".snowmans")) {
				return players.getString("Players." + player.getUniqueId() + ".snowmans");
			} else {
				return "0";
			}
		}
		if (identifier.equals("squids")) {
			if (players.contains("Players." + player.getUniqueId() + ".squids")) {
				return players.getString("Players." + player.getUniqueId() + ".squids");
			} else {
				return "0";
			}
		}
		if (identifier.equals("villagers")) {
			if (players.contains("Players." + player.getUniqueId() + ".villagers")) {
				return players.getString("Players." + player.getUniqueId() + ".villagers");
			} else {
				return "0";
			}
		}
		if (identifier.equals("witchs")) {
			if (players.contains("Players." + player.getUniqueId() + ".witchs")) {
				return players.getString("Players." + player.getUniqueId() + ".witchs");
			} else {
				return "0";
			}
		}
		if (identifier.equals("withers")) {
			if (players.contains("Players." + player.getUniqueId() + ".withers")) {
				return players.getString("Players." + player.getUniqueId() + ".withers");
			} else {
				return "0";
			}
		}
		if (identifier.equals("wolfs")) {
			if (players.contains("Players." + player.getUniqueId() + ".wolfs")) {
				return players.getString("Players." + player.getUniqueId() + ".wolfs");
			} else {
				return "0";
			}
		}
		// We return null if an invalid placeholder (f.e.%someplugin_placeholder3%)
		// was provided
		return null;
	}
}