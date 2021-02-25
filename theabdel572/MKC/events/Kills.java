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

public class Kills implements Listener{
	private MKC plugin;
	public Kills(MKC plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void killZombies(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.ZOMBIE)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
					FileConfiguration players = plugin.getPlayers();
					ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
					players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
					if(players.contains("Players. "+killer.getUniqueId()+" .zombies")) { 
						int zombiescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .zombies"));
						String path = config.getString("Rewards.zombies."+(zombiescounter+1));
						players.set("Players. "+killer.getUniqueId()+" .zombies", zombiescounter+1);
						plugin.savePlayers();
						if(config.contains("Rewards.zombies."+(zombiescounter+1))) {
							if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
								if(path.startsWith("msg %player%")) {
									killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
								}else if(path.startsWith("tell %player%")) {
									killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}else {
								Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
							}
						}
					}else {
						players.set("Players. "+killer.getUniqueId()+" .zombies", 1);
						int zombiescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .zombies"));
						String path = config.getString("Rewards.zombies."+zombiescounter);
						plugin.savePlayers();
						if(config.contains("Rewards.zombies."+zombiescounter)) {
							if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
								if(path.startsWith("msg %player%")) {
									killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
								}else if(path.startsWith("tell %player%")) {
									killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}else {
								Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
							}
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void killSkeletons(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.SKELETON)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .skeletons")) { 
							int skeletonscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .skeletons"));
							String path = config.getString("Rewards.skeletons."+(skeletonscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .skeletons", skeletonscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.skeletons."+(skeletonscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .skeletons", 1);
							int skeletonscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .skeletons"));
							String path = config.getString("Rewards.skeletons."+skeletonscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.skeletons."+skeletonscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
	}
	@EventHandler
	public void killSpiders(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.SPIDER)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .spiders")) { 
							int spiderscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .spiders"));
							String path = config.getString("Rewards.spiders."+(spiderscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .spiders", spiderscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.spiders."+(spiderscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .spiders", 1);
							int spiderscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .spiders"));
							String path = config.getString("Rewards.spiders."+spiderscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.spiders."+spiderscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killCave_Spiders(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.CAVE_SPIDER)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .cave_spiders")) { 
							int cave_spiderscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .cave_spiders"));
							String path = config.getString("Rewards.cave_spiders."+(cave_spiderscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .cave_spiders", cave_spiderscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.cave_spiders."+(cave_spiderscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .cave_spiders", 1);
							int cave_spiderscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .cave_spiders"));
							String path = config.getString("Rewards.cave_spiders."+cave_spiderscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.cave_spiders."+cave_spiderscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killBlazes(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.BLAZE)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .blazes")) { 
							int blazescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .blazes"));
							String path = config.getString("Rewards.blazes."+(blazescounter+1));
							players.set("Players. "+killer.getUniqueId()+" .blazes", blazescounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.blazes."+(blazescounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .blazes", 1);
							int blazescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .blazes"));
							String path = config.getString("Rewards.blazes."+blazescounter);
							plugin.savePlayers();
							if(config.contains("Rewards.blazes."+blazescounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killCreepers(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.CREEPER)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .creepers")) { 
							int creeperscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .creepers"));
							String path = config.getString("Rewards.creepers."+(creeperscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .creepers", creeperscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.creepers."+(creeperscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .creepers", 1);
							int creeperscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .creepers"));
							String path = config.getString("Rewards.creepers."+creeperscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.creepers."+creeperscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killEnder_Dragons(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.ENDER_DRAGON)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .ender_dragons")) { 
							int ender_dragonscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .ender_dragons"));
							String path = config.getString("Rewards.ender_dragons."+(ender_dragonscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .ender_dragons", ender_dragonscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.ender_dragons."+(ender_dragonscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .ender_dragons", 1);
							int ender_dragonscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .ender_dragons"));
							String path = config.getString("Rewards.ender_dragons."+ender_dragonscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.ender_dragons."+ender_dragonscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killEndermans(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.ENDERMAN)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .endermans")) { 
							int endermanscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .endermans"));
							String path = config.getString("Rewards.endermans."+(endermanscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .endermans", endermanscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.endermans."+(endermanscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .endermans", 1);
							int endermanscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .endermans"));
							String path = config.getString("Rewards.endermans."+endermanscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.endermans."+endermanscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killEndermites(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.ENDERMITE)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .endermites")) { 
							int endermitescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .endermites"));
							String path = config.getString("Rewards.endermites."+(endermitescounter+1));
							players.set("Players. "+killer.getUniqueId()+" .endermites", endermitescounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.endermites."+(endermitescounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .endermites", 1);
							int endermitescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .endermites"));
							String path = config.getString("Rewards.endermites."+endermitescounter);
							plugin.savePlayers();
							if(config.contains("Rewards.endermites."+endermitescounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killBats(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.BAT)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .bats")) { 
							int batscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .bats"));
							String path = config.getString("Rewards.bats."+(batscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .bats", batscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.bats."+(batscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .bats", 1);
							int batscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .bats"));
							String path = config.getString("Rewards.bats."+batscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.bats."+batscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killChickens(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.CHICKEN)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .chickens")) { 
							int chickenscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .chickens"));
							String path = config.getString("Rewards.chickens."+(chickenscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .chickens", chickenscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.chickens."+(chickenscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .chickens", 1);
							int chickenscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .chickens"));
							String path = config.getString("Rewards.chickens."+chickenscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.chickens."+chickenscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killCows(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.COW)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .cows")) { 
							int cowscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .cows"));
							String path = config.getString("Rewards.cows."+(cowscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .cows", cowscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.cows."+(cowscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .cows", 1);
							int cowscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .cows"));
							String path = config.getString("Rewards.cows."+cowscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.cows."+cowscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killGhasts(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.GHAST)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .ghasts")) { 
							int ghastscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .ghasts"));
							String path = config.getString("Rewards.ghasts."+(ghastscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .ghasts", ghastscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.ghasts."+(ghastscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .ghasts", 1);
							int ghastscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .ghasts"));
							String path = config.getString("Rewards.ghasts."+ghastscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.ghasts."+ghastscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killGuardians(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.GUARDIAN)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .guardians")) { 
							int guardianscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .guardians"));
							String path = config.getString("Rewards.guardians."+(guardianscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .guardians", guardianscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.guardians."+(guardianscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .guardians", 1);
							int guardianscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .guardians"));
							String path = config.getString("Rewards.guardians."+guardianscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.guardians."+guardianscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killHorses(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.HORSE)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .horses")) { 
							int horsescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .horses"));
							String path = config.getString("Rewards.horses."+(horsescounter+1));
							players.set("Players. "+killer.getUniqueId()+" .horses", horsescounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.horses."+(horsescounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .horses", 1);
							int horsescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .horses"));
							String path = config.getString("Rewards.horses."+horsescounter);
							plugin.savePlayers();
							if(config.contains("Rewards.horses."+horsescounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killIron_Golems(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.IRON_GOLEM)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .iron_golems")) { 
							int iron_golemscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .iron_golems"));
							String path = config.getString("Rewards.iron_golems."+(iron_golemscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .iron_golems", iron_golemscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.iron_golems."+(iron_golemscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .iron_golems", 1);
							int iron_golemscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .iron_golems"));
							String path = config.getString("Rewards.iron_golems."+iron_golemscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.iron_golems."+iron_golemscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killMagma_Cubes(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.MAGMA_CUBE)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .magma_cubes")) { 
							int magma_cubescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .magma_cubes"));
							String path = config.getString("Rewards.magma_cubes."+(magma_cubescounter+1));
							players.set("Players. "+killer.getUniqueId()+" .magma_cubes", magma_cubescounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.magma_cubes."+(magma_cubescounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .magma_cubes", 1);
							int magma_cubescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .magma_cubes"));
							String path = config.getString("Rewards.magma_cubes."+magma_cubescounter);
							plugin.savePlayers();
							if(config.contains("Rewards.magma_cubes."+magma_cubescounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killMushroom_Cows(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.MUSHROOM_COW)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .mushroom_cows")) { 
							int mushroom_cowscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .mushroom_cows"));
							String path = config.getString("Rewards.mushroom_cows."+(mushroom_cowscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .mushroom_cows", mushroom_cowscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.mushroom_cows."+(mushroom_cowscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .mushroom_cows", 1);
							int mushroom_cowscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .mushroom_cows"));
							String path = config.getString("Rewards.mushroom_cows."+mushroom_cowscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.mushroom_cows."+mushroom_cowscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killOcelots(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.OCELOT)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .ocelots")) { 
							int ocelotscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .ocelots"));
							String path = config.getString("Rewards.ocelots."+(ocelotscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .ocelots", ocelotscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.ocelots."+(ocelotscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .ocelots", 1);
							int ocelotscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .ocelots"));
							String path = config.getString("Rewards.ocelots."+ocelotscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.ocelots."+ocelotscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killPigs(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.PIG)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .pigs")) { 
							int pigscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .pigs"));
							String path = config.getString("Rewards.pigs."+(pigscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .pigs", pigscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.pigs."+(pigscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .pigs", 1);
							int pigscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .pigs"));
							String path = config.getString("Rewards.pigs."+pigscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.pigs."+pigscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
	}
	@EventHandler
	public void killPig_pig_zombies(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.PIG_ZOMBIE)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .pig_zombies")) { 
							int pig_zombiescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .pig_zombies"));
							String path = config.getString("Rewards.pig_zombies."+(pig_zombiescounter+1));
							players.set("Players. "+killer.getUniqueId()+" .pig_zombies", pig_zombiescounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.pig_zombies."+(pig_zombiescounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .pig_zombies", 1);
							int pig_zombiescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .pig_zombies"));
							String path = config.getString("Rewards.pig_zombies."+pig_zombiescounter);
							plugin.savePlayers();
							if(config.contains("Rewards.pig_zombies."+pig_zombiescounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killPlayers(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.PLAYER)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .players")) { 
							int playerscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .players"));
							String path = config.getString("Rewards.players."+(playerscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .players", playerscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.players."+(playerscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .players", 1);
							int playerscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .players"));
							String path = config.getString("Rewards.players."+playerscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.players."+playerscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killRabbits(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.RABBIT)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .rabbits")) { 
							int rabbitscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .rabbits"));
							String path = config.getString("Rewards.rabbits."+(rabbitscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .rabbits", rabbitscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.rabbits."+(rabbitscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .rabbits", 1);
							int rabbitscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .rabbits"));
							String path = config.getString("Rewards.rabbits."+rabbitscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.rabbits."+rabbitscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killSheeps(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.SHEEP)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .sheeps")) { 
							int sheepscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .sheeps"));
							String path = config.getString("Rewards.sheeps."+(sheepscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .sheeps", sheepscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.sheeps."+(sheepscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .sheeps", 1);
							int sheepscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .sheeps"));
							String path = config.getString("Rewards.sheeps."+sheepscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.sheeps."+sheepscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killSilverfishs(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.SILVERFISH)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .silverfishs")) { 
							int silverfishscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .silverfishs"));
							String path = config.getString("Rewards.silverfishs."+(silverfishscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .silverfishs", silverfishscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.silverfishs."+(silverfishscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .silverfishs", 1);
							int silverfishscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .silverfishs"));
							String path = config.getString("Rewards.silverfishs."+silverfishscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.silverfishs."+silverfishscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killSlimes(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.SLIME)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .slimes")) { 
							int slimescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .slimes"));
							String path = config.getString("Rewards.slimes."+(slimescounter+1));
							players.set("Players. "+killer.getUniqueId()+" .slimes", slimescounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.slimes."+(slimescounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .slimes", 1);
							int slimescounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .slimes"));
							String path = config.getString("Rewards.slimes."+slimescounter);
							plugin.savePlayers();
							if(config.contains("Rewards.slimes."+slimescounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killSnowmans(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.SNOWMAN)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .snowmans")) { 
							int snowmanscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .snowmans"));
							String path = config.getString("Rewards.snowmans."+(snowmanscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .snowmans", snowmanscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.snowmans."+(snowmanscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .snowmans", 1);
							int snowmanscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .snowmans"));
							String path = config.getString("Rewards.snowmans."+snowmanscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.snowmans."+snowmanscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killSquids(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.SQUID)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .squids")) { 
							int squidscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .squids"));
							String path = config.getString("Rewards.squids."+(squidscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .squids", squidscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.squids."+(squidscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .squids", 1);
							int squidscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .squids"));
							String path = config.getString("Rewards.squids."+squidscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.squids."+squidscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killVillagers(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.VILLAGER)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .villagers")) { 
							int villagerscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .villagers"));
							String path = config.getString("Rewards.villagers."+(villagerscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .villagers", villagerscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.villagers."+(villagerscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .villagers", 1);
							int villagerscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .villagers"));
							String path = config.getString("Rewards.villagers."+villagerscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.villagers."+villagerscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killWitchs(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.WITCH)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .witchs")) { 
							int witchscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .witchs"));
							String path = config.getString("Rewards.witchs."+(witchscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .witchs", witchscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.witchs."+(witchscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .witchs", 1);
							int witchscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .witchs"));
							String path = config.getString("Rewards.witchs."+witchscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.witchs."+witchscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killWithers(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.WITHER)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .withers")) { 
							int witherscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .withers"));
							String path = config.getString("Rewards.withers."+(witherscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .withers", witherscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.withers."+(witherscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .withers", 1);
							int witherscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .withers"));
							String path = config.getString("Rewards.withers."+witherscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.withers."+witherscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
	@EventHandler
	public void killWolfs(EntityDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		EntityType entity = event.getEntityType();
		FileConfiguration config = plugin.getConfig();
		List<String> worlds = config.getStringList("Worlds.enabled-worlds");
		for(int i=0;i<worlds.size();i++) {
				if(killer != null && killer.getType().equals(EntityType.PLAYER) && entity.equals(EntityType.WOLF)) {
					String world = killer.getWorld().getName();
					if(worlds.get(i).equals(world)) {
						FileConfiguration players = plugin.getPlayers();
						ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
						players.set("Players. "+killer.getUniqueId()+" .name", killer.getName());
						if(players.contains("Players. "+killer.getUniqueId()+" .wolfs")) { 
							int wolfscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .wolfs"));
							String path = config.getString("Rewards.wolfs."+(wolfscounter+1));
							players.set("Players. "+killer.getUniqueId()+" .wolfs", wolfscounter+1);
							plugin.savePlayers();
							if(config.contains("Rewards.wolfs."+(wolfscounter+1))) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}else {
							players.set("Players. "+killer.getUniqueId()+" .wolfs", 1);
							int wolfscounter = Integer.valueOf(players.getString("Players. "+killer.getUniqueId()+" .wolfs"));
							String path = config.getString("Rewards.wolfs."+wolfscounter);
							plugin.savePlayers();
							if(config.contains("Rewards.wolfs."+wolfscounter)) {
								if(config.getBoolean("Config.Send-Message-insteadof-Command") == true) {
									if(path.startsWith("msg %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("msg %player%", "")));
									}else if(path.startsWith("tell %player%")) {
										killer.sendMessage(ChatColor.translateAlternateColorCodes('&', path.replaceAll("tell %player%", "")));
									}else {
										Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
									}
								}else {
									Bukkit.dispatchCommand(console, ChatColor.translateAlternateColorCodes('&', path.replaceAll("%player%", killer.getName())));
								}
							}
						}
				}
			}
		}
		
	}
}