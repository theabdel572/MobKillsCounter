package theabdel572.MKC;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import theabdel572.MKC.MobTypes.MobType;

public interface MobKillsList {
	// Method to send the MobKillsList with /mobkills commands.
	public static void sendMobKillsList(MKC plugin, Player player, UUID uuid) {
		FileConfiguration config = plugin.getConfig();
		FileConfiguration players = plugin.getPlayers();
		
		
	}
	
	public static void sendMobKillsListToPlayer(MKC plugin, Player player, FileConfiguration players,
			FileConfiguration config) {
		if (!players.contains("Players." + player.getUniqueId())) {
			sendListWithoutKills(plugin, player, config);
		} else {
			if (players.contains("Players." + player.getUniqueId() + ".zombies")) {
				int zombiescounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".zombies"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
						+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Zombies killed: " + config.getString("Colors.Number-Color") + zombiescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
						+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Zombies killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".skeletons")) {
				int skeletonscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".skeletons"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Skeletons killed: " + config.getString("Colors.Number-Color") + skeletonscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Skeletons killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".spiders")) {
				int spiderscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".spiders"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Spiders killed: " + config.getString("Colors.Number-Color") + spiderscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Spiders killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".cave_spiders")) {
				int cave_spiderscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".cave_spiders"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Cave Spiders killed: " + config.getString("Colors.Number-Color") + cave_spiderscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Cave Spiders killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".blazes")) {
				int blazescounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".blazes"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Blazes killed: " + config.getString("Colors.Number-Color") + blazescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Blazes killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".creepers")) {
				int creeperscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".creepers"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Creepers killed: " + config.getString("Colors.Number-Color") + creeperscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Creepers killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".ender_dragons")) {
				int ender_dragonscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".ender_dragons"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ender Dragons killed: " + config.getString("Colors.Number-Color") + ender_dragonscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ender Dragons killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".endermans")) {
				int endermanscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".endermans"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Endermens killed: " + config.getString("Colors.Number-Color") + endermanscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Endermens killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".endermites")) {
				int endermitescounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".endermites"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Endermites killed: " + config.getString("Colors.Number-Color") + endermitescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Endermites killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".bats")) {
				int batscounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".bats"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Bats killed: " + config.getString("Colors.Number-Color") + batscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Bats killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".chickens")) {
				int chickenscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".chickens"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Chickens killed: " + config.getString("Colors.Number-Color") + chickenscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Chickens killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".cows")) {
				int cowscounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".cows"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Cows killed: " + config.getString("Colors.Number-Color") + cowscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Cows killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".ghasts")) {
				int ghastscounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".ghasts"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ghasts killed: " + config.getString("Colors.Number-Color") + ghastscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ghasts killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".guardians")) {
				int guardianscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".guardians"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Guardians killed: " + config.getString("Colors.Number-Color") + guardianscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Guardians killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".horses")) {
				int horsescounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".horses"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Horses killed: " + config.getString("Colors.Number-Color") + horsescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Horses killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".iron_golems")) {
				int iron_golemscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".iron_golems"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Iron Golems killed: " + config.getString("Colors.Number-Color") + iron_golemscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Iron Golems killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".magma_cubes")) {
				int magma_cubescounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".magma_cubes"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Magma Cubes killed: " + config.getString("Colors.Number-Color") + magma_cubescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Magma Cubes killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".mushroom_cows")) {
				int mushroom_cowscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".mushroom_cows"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "MushRoom Cows killed: " + config.getString("Colors.Number-Color") + mushroom_cowscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "MushRoom Cows killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".ocelots")) {
				int ocelotscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".ocelots"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ocelots killed: " + config.getString("Colors.Number-Color") + ocelotscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ocelots killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".pigs")) {
				int pigscounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".pigs"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Pigs killed: " + config.getString("Colors.Number-Color") + pigscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Pigs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".pig_zombies")) {
				int pig_zombiescounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".pig_zombies"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Pig Zombies killed: " + config.getString("Colors.Number-Color") + pig_zombiescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Pig Zombies killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".players")) {
				int playerscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".players"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Players killed: " + config.getString("Colors.Number-Color") + playerscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Players killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".rabbits")) {
				int rabbitscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".rabbits"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Rabbits killed: " + config.getString("Colors.Number-Color") + rabbitscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Rabbits killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".sheeps")) {
				int sheepscounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".sheeps"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Sheeps killed: " + config.getString("Colors.Number-Color") + sheepscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Sheeps killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".silverfish")) {
				int silverfishcounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".silverfish"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Silverfishs killed: " + config.getString("Colors.Number-Color") + silverfishcounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Silverfishs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".slimes")) {
				int slimescounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".slimes"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Slimes killed: " + config.getString("Colors.Number-Color") + slimescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Slimes killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".snowmans")) {
				int snowmanscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".snowmans"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Snowmans killed: " + config.getString("Colors.Number-Color") + snowmanscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Snowmans killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".squids")) {
				int squidscounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".squids"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Squids killed: " + config.getString("Colors.Number-Color") + squidscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Squids killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".villagers")) {
				int villagerscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".villagers"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Villagers killed: " + config.getString("Colors.Number-Color") + villagerscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Villagers killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".witchs")) {
				int witchscounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".witchs"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Witchs killed: " + config.getString("Colors.Number-Color") + witchscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Witchs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".withers")) {
				int witherscounter = Integer
						.valueOf(players.getString("Players." + player.getUniqueId() + ".withers"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Withers killed: " + config.getString("Colors.Number-Color") + witherscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Withers killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + player.getUniqueId() + ".wolfs")) {
				int wolfscounter = Integer.valueOf(players.getString("Players." + player.getUniqueId() + ".wolfs"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Wolfs killed: " + config.getString("Colors.Number-Color") + wolfscounter));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
						+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Wolfs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
						+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
			}
		}
	}

	// Method to send MobKillsList from a UUID, in the command /mobkills <player>.
	public static void sendMobKillsListFromUUID(MKC plugin, Player player, UUID uid, FileConfiguration players,
			FileConfiguration config) {
		if (!players.contains("Players")) {
			sendListWithoutKills(plugin, player, config);
		} else {
			if (players.contains("Players." + uid + ".zombies")) {
				int zombiescounter = Integer.valueOf(players.getString("Players." + uid + ".zombies"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
						+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Zombies killed: " + config.getString("Colors.Number-Color") + zombiescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
						+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Zombies killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".skeletons")) {
				int skeletonscounter = Integer.valueOf(players.getString("Players." + uid + ".skeletons"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Skeletons killed: " + config.getString("Colors.Number-Color") + skeletonscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Skeletons killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".spiders")) {
				int spiderscounter = Integer.valueOf(players.getString("Players." + uid + ".spiders"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Spiders killed: " + config.getString("Colors.Number-Color") + spiderscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Spiders killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".cave_spiders")) {
				int cave_spiderscounter = Integer.valueOf(players.getString("Players." + uid + ".cave_spiders"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Cave Spiders killed: " + config.getString("Colors.Number-Color") + cave_spiderscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Cave Spiders killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".blazes")) {
				int blazescounter = Integer.valueOf(players.getString("Players." + uid + ".blazes"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Blazes killed: " + config.getString("Colors.Number-Color") + blazescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Blazes killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".creepers")) {
				int creeperscounter = Integer.valueOf(players.getString("Players." + uid + ".creepers"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Creepers killed: " + config.getString("Colors.Number-Color") + creeperscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Creepers killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".ender_dragons")) {
				int ender_dragonscounter = Integer.valueOf(players.getString("Players." + uid + ".ender_dragons"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ender Dragons killed: " + config.getString("Colors.Number-Color") + ender_dragonscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ender Dragons killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".endermans")) {
				int endermanscounter = Integer.valueOf(players.getString("Players." + uid + ".endermans"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Endermens killed: " + config.getString("Colors.Number-Color") + endermanscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Endermens killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".endermites")) {
				int endermitescounter = Integer.valueOf(players.getString("Players." + uid + ".endermites"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Endermites killed: " + config.getString("Colors.Number-Color") + endermitescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Endermites killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".bats")) {
				int batscounter = Integer.valueOf(players.getString("Players." + uid + ".bats"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Bats killed: " + config.getString("Colors.Number-Color") + batscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Bats killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".chickens")) {
				int chickenscounter = Integer.valueOf(players.getString("Players." + uid + ".chickens"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Chickens killed: " + config.getString("Colors.Number-Color") + chickenscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Chickens killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".cows")) {
				int cowscounter = Integer.valueOf(players.getString("Players." + uid + ".cows"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Cows killed: " + config.getString("Colors.Number-Color") + cowscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Cows killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".ghasts")) {
				int ghastscounter = Integer.valueOf(players.getString("Players." + uid + ".ghasts"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ghasts killed: " + config.getString("Colors.Number-Color") + ghastscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ghasts killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".guardians")) {
				int guardianscounter = Integer.valueOf(players.getString("Players." + uid + ".guardians"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Guardians killed: " + config.getString("Colors.Number-Color") + guardianscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Guardians killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".horses")) {
				int horsescounter = Integer.valueOf(players.getString("Players." + uid + ".horses"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Horses killed: " + config.getString("Colors.Number-Color") + horsescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Horses killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".iron_golems")) {
				int iron_golemscounter = Integer.valueOf(players.getString("Players." + uid + ".iron_golems"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Iron Golems killed: " + config.getString("Colors.Number-Color") + iron_golemscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Iron Golems killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".magma_cubes")) {
				int magma_cubescounter = Integer.valueOf(players.getString("Players." + uid + ".magma_cubes"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Magma Cubes killed: " + config.getString("Colors.Number-Color") + magma_cubescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Magma Cubes killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".mushroom_cows")) {
				int mushroom_cowscounter = Integer.valueOf(players.getString("Players." + uid + ".mushroom_cows"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "MushRoom Cows killed: " + config.getString("Colors.Number-Color") + mushroom_cowscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "MushRoom Cows killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".ocelots")) {
				int ocelotscounter = Integer.valueOf(players.getString("Players." + uid + ".ocelots"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ocelots killed: " + config.getString("Colors.Number-Color") + ocelotscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Ocelots killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".pigs")) {
				int pigscounter = Integer.valueOf(players.getString("Players." + uid + ".pigs"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Pigs killed: " + config.getString("Colors.Number-Color") + pigscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Pigs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".pig_zombies")) {
				int pig_zombiescounter = Integer.valueOf(players.getString("Players." + uid + ".pig_zombies"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Pig Zombies killed: " + config.getString("Colors.Number-Color") + pig_zombiescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Pig Zombies killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".players")) {
				int playerscounter = Integer.valueOf(players.getString("Players." + uid + ".players"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Players killed: " + config.getString("Colors.Number-Color") + playerscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Players killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".rabbits")) {
				int rabbitscounter = Integer.valueOf(players.getString("Players." + uid + ".rabbits"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Rabbits killed: " + config.getString("Colors.Number-Color") + rabbitscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Rabbits killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".sheeps")) {
				int sheepscounter = Integer.valueOf(players.getString("Players." + uid + ".sheeps"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Sheeps killed: " + config.getString("Colors.Number-Color") + sheepscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Sheeps killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".silverfish")) {
				int silverfishcounter = Integer.valueOf(players.getString("Players." + uid + ".silverfish"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Silverfishs killed: " + config.getString("Colors.Number-Color") + silverfishcounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Silverfishs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".slimes")) {
				int slimescounter = Integer.valueOf(players.getString("Players." + uid + ".slimes"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Slimes killed: " + config.getString("Colors.Number-Color") + slimescounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Slimes killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".snowmans")) {
				int snowmanscounter = Integer.valueOf(players.getString("Players." + uid + ".snowmans"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Snowmans killed: " + config.getString("Colors.Number-Color") + snowmanscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Snowmans killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".squids")) {
				int squidscounter = Integer.valueOf(players.getString("Players." + uid + ".squids"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Squids killed: " + config.getString("Colors.Number-Color") + squidscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Squids killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".villagers")) {
				int villagerscounter = Integer.valueOf(players.getString("Players." + uid + ".villagers"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Villagers killed: " + config.getString("Colors.Number-Color") + villagerscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Villagers killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".witchs")) {
				int witchscounter = Integer.valueOf(players.getString("Players." + uid + ".witchs"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Witchs killed: " + config.getString("Colors.Number-Color") + witchscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Witchs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".withers")) {
				int witherscounter = Integer.valueOf(players.getString("Players." + uid + ".withers"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Withers killed: " + config.getString("Colors.Number-Color") + witherscounter));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Withers killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
			if (players.contains("Players." + uid + ".wolfs")) {
				int wolfscounter = Integer.valueOf(players.getString("Players." + uid + ".wolfs"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Wolfs killed: " + config.getString("Colors.Number-Color") + wolfscounter));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
						+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ "Wolfs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
						+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
			}
		}
	}

	// Method to send the list if the player have no kills.
	static void sendListWithoutKills(MKC plugin, Player player, FileConfiguration config) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
				+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Zombies killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Skeletons killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Spiders killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Cave Spiders killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Blazes killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Creepers killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Ender Dragons killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Endermens killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Endermites killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Bats killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Chickens killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Cows killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Ghasts killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Guardians killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Horses killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Iron Golems killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Magma Cubes killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "MushRoom Cows killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Ocelots killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Pigs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Pig Zombies killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Players killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Rabbits killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Sheeps killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Silverfishs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Slimes killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Snowmans killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Squids killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Villagers killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Witchs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Withers killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
				+ "Wolfs killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
				+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
	}
}
