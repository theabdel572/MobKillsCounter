package theabdel572.MKC.events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import theabdel572.MKC.MobKillsList;
import theabdel572.MKC.MobTypes.MobType;

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
		
		
		if (killer == null || killer.getType() != EntityType.PLAYER) {
			return;
		}

		//Checking if the world is in the enabled worlds list.
		for (int i = 0; i < worlds.size(); i++) {
			String world = killer.getWorld().getName();

			if (worlds.get(i).equals(world)) {
				isWorldAtList = true;
				break;
			}
			isWorldAtList = false;
		}

		if (!isWorldAtList) {
			return;
		}
		
		Map<EntityType, KillAction> entityActions = new HashMap<EntityType, KillAction>();
		
		entityActions.put(entity, new KillAction() {

			@Override
			public void onKill(EntityDeathEvent e, MobType mob) {
				Player killer = e.getEntity().getKiller();
				FileConfiguration players = plugin.getPlayers();
				FileConfiguration config = plugin.getConfig();
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				String path = "Players." + killer.getUniqueId() + "." + mob.getPath();
				
				// System to add mobkills to players & rewards system.
				
				if(MobKillsList.hasMobKill(plugin, killer, mob)) {
					
					//Adding 1 kill to the counter.
					int counter = players.getInt(path);
					players.set(path, counter + 1);
					
					plugin.savePlayers();
					
					executeRewards(killer, mob);
					return;
				}
				players.set("Players." + killer.getUniqueId() + ".name", killer.getName());
				players.set("Players." + killer.getUniqueId() + "." + mob.getPath(), 1);
				plugin.savePlayers();
				
				executeRewards(killer, mob);
			}
			
		});
		
		entityActions.get(entity).onKill(e, MobType.getFromEntityType(entity));
	}
	
	//Checking if the command is /tell or /msg.
	public boolean isMsgCommand(String command) {
		return command.startsWith("msg %player%") || command.startsWith("tell %player%");
	}
	
	// Method to send messages instead of and msg or tell command.
	public void sendCommandMessage(Player player, String command) {		
		player.sendMessage(ChatColor
				.translateAlternateColorCodes('&', command.replaceAll("msg %player%", "").replaceAll("tell %player%", "")).trim());
	}
	
	// Method to give rewards to players.
	public void executeRewards(Player player, MobType mob) {
		
		FileConfiguration config = plugin.getConfig();
		FileConfiguration players = plugin.getPlayers();
		String path = "Players." + player.getUniqueId() + "." + mob.getPath();
		
		int counter = players.getInt(path);
		
		List<String> rewardPath = config.getStringList("Rewards." + mob.getPath() + "." + counter);
		//Checking if that kill number has a reward established.
		if (!config.contains("Rewards." + mob.getPath() + "." + counter)) {
			return;
		}
		
		for (int i = 0; i < rewardPath.size(); i++) {
			
			String command = rewardPath.get(i);
			//Checking if the command is /tell or /msg.
			if (config.getBoolean("Config.Send-Message-insteadof-Command") && isMsgCommand(command)) {
				sendCommandMessage(player, command);
				
			}else {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), ChatColor.translateAlternateColorCodes('&',
						command.replaceAll("%player%", player.getName())));
			}
		}
		return;
	}
}