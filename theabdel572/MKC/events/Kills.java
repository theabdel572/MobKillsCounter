package theabdel572.MKC.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import theabdel572.MKC.MKC;

public class Kills implements Listener {
	private MKC plugin;
	private boolean isWorldAtList;

	public Kills(MKC plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void killEvent(EntityDeathEvent e) {
		Player killer = e.getEntity().getKiller();
		EntityType entity = e.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for (int i = 0; i < worlds.size(); i++) {
			if (killer != null && killer.getType().equals(EntityType.PLAYER)) {
				String world = killer.getWorld().getName();
				if (worlds.get(i).equals(world)) {
					isWorldAtList = true;
					break;
				} else {
					isWorldAtList = false;
				}
			}
		}
		if (isWorldAtList && killer != null && killer.getType().equals(EntityType.PLAYER)) {
			switch (entity) {
			case ZOMBIE:
				onKill(e, "zombies");
				break;
			case SKELETON:
				onKill(e, "skeletons");
				break;
			case SPIDER:
				onKill(e, "spiders");
				break;
			case CAVE_SPIDER:
				onKill(e, "cave_spiders");
				break;
			case BLAZE:
				onKill(e, "blazes");
				break;
			case CREEPER:
				onKill(e, "creepers");
				break;
			case ENDER_DRAGON:
				onKill(e, "ender_dragons");
				break;
			case ENDERMAN:
				onKill(e, "endermans");
				break;
			case ENDERMITE:
				onKill(e, "endermites");
				break;
			case BAT:
				onKill(e, "bats");
				break;
			case CHICKEN:
				onKill(e, "chickens");
				break;
			case COW:
				onKill(e, "cows");
				break;
			case GHAST:
				onKill(e, "ghasts");
				break;
			case GUARDIAN:
				onKill(e, "guardians");
				break;
			case HORSE:
				onKill(e, "horses");
				break;
			case IRON_GOLEM:
				onKill(e, "iron_golems");
				break;
			case MAGMA_CUBE:
				onKill(e, "magma_cubes");
				break;
			case MUSHROOM_COW:
				onKill(e, "mushroom_cows");
				break;
			case OCELOT:
				onKill(e, "ocelots");
				break;
			case PIG:
				onKill(e, "pigs");
				break;
			case PIG_ZOMBIE:
				onKill(e, "pig_zombies");
				break;
			case PLAYER:
				onKill(e, "players");
				break;
			case RABBIT:
				onKill(e, "rabbits");
				break;
			case SHEEP:
				onKill(e, "sheeps");
				break;
			case SILVERFISH:
				onKill(e, "silverfishs");
				break;
			case SLIME:
				onKill(e, "slimes");
				break;
			case SNOWMAN:
				onKill(e, "snowmans");
				break;
			case SQUID:
				onKill(e, "squids");
				break;
			case VILLAGER:
				onKill(e, "villagers");
				break;
			case WITCH:
				onKill(e, "witchs");
				break;
			case WITHER:
				onKill(e, "withers");
				break;
			case WOLF:
				onKill(e, "wolfs");
				break;
			default:
				break;
			}
		}
	}

	public void onKill(EntityDeathEvent e, String mob) {
		Player killer = e.getEntity().getKiller();
		FileConfiguration players = plugin.getPlayers();
		FileConfiguration config = plugin.getConfig();
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		// System to add mobkills to players & rewards system.
		if (players.contains("Players." + killer.getUniqueId() + "." + mob)) {
			int counter = Integer.valueOf(players.getString("Players." + killer.getUniqueId() + "." + mob));
			players.set("Players." + killer.getUniqueId() + "." + mob, counter + 1);
			plugin.savePlayers();
			List<String> rewardPath = config.getStringList("Rewards." + mob + "." + (counter + 1));
			if (config.contains("Rewards." + mob + "." + (counter + 1))) {
					for(int i = 0; i < rewardPath.size(); i++) {
						String command = rewardPath.get(i);
						if (config.getBoolean("Config.Send-Message-insteadof-Command")) {
							if (command.startsWith("msg %player%")) {
								killer.sendMessage(ChatColor
										.translateAlternateColorCodes('&', command.replaceAll("msg %player%", "")).trim());
							} else if (command.startsWith("tell %player%")) {
								killer.sendMessage(ChatColor
										.translateAlternateColorCodes('&', command.replaceAll("tell %player%", "")).trim());
							} else {
								Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&',
										command.replaceAll("%player%", killer.getName())));
							}
						} else {
							Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&',
									command.replaceAll("%player%", killer.getName())));
						}
					}
			}
		} else {
			players.set("Players." + killer.getUniqueId() + ".name", killer.getName());
			players.set("Players." + killer.getUniqueId() + "." + mob, 1);
			int counter = Integer.valueOf(players.getString("Players." + killer.getUniqueId() + "." + mob));
			List<String> rewardPath = config.getStringList("Rewards." + mob + "." + counter);
			plugin.savePlayers();
			if (config.contains("Rewards." + mob + "." + counter)) {
				for(int i = 0; i < rewardPath.size(); i++) {
					String command = rewardPath.get(i);
					if (config.getBoolean("Config.Send-Message-insteadof-Command")) {
						if (command.startsWith("msg %player%")) {
							killer.sendMessage(ChatColor
									.translateAlternateColorCodes('&', command.replaceAll("msg %player%", "")).trim());
						} else if (command.startsWith("tell %player%")) {
							killer.sendMessage(ChatColor
									.translateAlternateColorCodes('&', command.replaceAll("tell %player%", "")).trim());
						} else {
							Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&',
									command.replaceAll("%player%", killer.getName())));
						}
					} else {
						Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&',
								command.replaceAll("%player%", killer.getName())));
					}
				}
			}
		}
	}
}