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
		for(int i=0; i< worlds.size(); i++) {
			if (killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.ZOMBIE)) {
				String world = killer.getWorld().getName();
				if(worlds.get(i).equals(world)) {
					isWorldAtList = true;
					break;
				}else {
					isWorldAtList = false;
				}
			}
		}
		if(isWorldAtList && killer != null && killer.getType().equals(EntityType.PLAYER)) {
			switch(entity) {
			case ZOMBIE: 
				onKill(e, "zombies");
			case SKELETON:
				onKill(e, "skeletons");
			case SPIDER:
				onKill(e, "spiders");
			case CAVE_SPIDER:
				onKill(e, "cave_spider");
			case BLAZE:
				onKill(e, "blazes");
			case CREEPER:
				onKill(e, "creepers");
			case ENDER_DRAGON:
				onKill(e, "ender_dragons");
			case ENDERMAN:
				onKill(e, "endermans");
			case ENDERMITE:
				onKill(e, "endermites");
			case BAT:
				onKill(e, "bats");
			case CHICKEN:
				onKill(e, "chickens");
			case COW:
				onKill(e, "cows");
			case GHAST:
				onKill(e, "ghasts");
			case GUARDIAN:
				onKill(e, "guardians");
			case HORSE:
				onKill(e, "horses");
			case IRON_GOLEM:
				onKill(e, "iron_golems");
			case MAGMA_CUBE:
				onKill(e, "magma_cubes");
			case MUSHROOM_COW:
				onKill(e, "mushroom_cows");
			case OCELOT:
				onKill(e, "ocelots");
			case PIG:
				onKill(e, "pigs");
			case PIG_ZOMBIE:
				onKill(e, "pig_zombies");
			case PLAYER:
				onKill(e, "players");
			case RABBIT:
				onKill(e, "rabbits");
			case SHEEP:
				onKill(e, "sheeps");
			case SILVERFISH:
				onKill(e, "silverfishs");
			case SLIME:
				onKill(e, "slimes");
			case SNOWMAN:
				onKill(e, "snowmans");
			case SQUID:
				onKill(e, "squids");
			case VILLAGER:
				onKill(e, "villagers");
			case WITCH:
				onKill(e, "witchs");
			case WITHER:
				onKill(e, "withers");
			case WOLF:
				onKill(e, "wolfs");
				default:
					return;
			}
		}
	}

	public void onKill(EntityDeathEvent e, String mob) {
		Player killer = e.getEntity().getKiller();
		FileConfiguration players = plugin.getPlayers();
		FileConfiguration config = plugin.getConfig();
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		// System to add mobkills to players & rewards system.
		if (players.contains("Players. " + killer.getUniqueId() + " . "+mob)) {
			int counter = Integer
					.valueOf(players.getString("Players. " + killer.getUniqueId() + " . "+mob));
			players.set("Players. " + killer.getUniqueId() + " . "+mob, counter + 1);
			plugin.savePlayers();
			String rewardsPath = config.getString("Rewards."+mob+"." + (counter + 1));
			if (config.contains(rewardsPath)) {
				if (config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
					if (rewardsPath.startsWith("msg %player%")) {
						killer.sendMessage(ChatColor.translateAlternateColorCodes('&',
								rewardsPath.replaceAll("msg %player%", "")).trim());
					} else if (rewardsPath.startsWith("tell %player%")) {
						killer.sendMessage(ChatColor.translateAlternateColorCodes('&',
								rewardsPath.replaceAll("tell %player%", "")).trim());
					} else {
						Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&',
								rewardsPath.replaceAll("%player%", killer.getName())));
					}
				} else {
					Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&',
							rewardsPath.replaceAll("%player%", killer.getName())));
				}
			}
		}else {
			players.set("Players. " + killer.getUniqueId() + " . "+mob, 1);
			int counter = Integer
					.valueOf(players.getString("Players. " + killer.getUniqueId() + " . "+mob));
			String rewardsPath = config.getString("Rewards."+mob+"." + counter);
			plugin.savePlayers();
			if (config.contains(rewardsPath)) {
				if (config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
					if (rewardsPath.startsWith("msg %player%")) {
						killer.sendMessage(ChatColor.translateAlternateColorCodes('&',
								rewardsPath.replaceAll("msg %player%", "")).trim());
					} else if (rewardsPath.startsWith("tell %player%")) {
						killer.sendMessage(ChatColor.translateAlternateColorCodes('&',
								rewardsPath.replaceAll("tell %player%", "")).trim());
					} else {
						Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&',
								rewardsPath.replaceAll("%player%", killer.getName())));
					}
				} else {
					Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&',
							rewardsPath.replaceAll("%player%", killer.getName())));
				}
			}
		}
	}
}