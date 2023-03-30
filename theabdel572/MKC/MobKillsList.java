package theabdel572.MKC;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import theabdel572.MKC.MobTypes.MobType;

public interface MobKillsList {
	
	// Method to send the MobKillsList with /mobkills commands.
	public static void sendMobKillsList(MKC plugin, UUID uuid) {
		
		FileConfiguration config = plugin.getConfig();
		FileConfiguration players = plugin.getPlayers();
		
		Player player = Bukkit.getPlayer(uuid);
		
		String path = "Players." + uuid + ".";
		String[] mobTypePaths = MobType.getEveryPath();
		
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
				+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
		
		for(int i=0; i < mobTypePaths.length; i++) {
			
			// Formatting mobname taking the path of the item in the enum, and then replacing _ for " " and capitalizing the first char.
			String formattedMobName = mobTypePaths[i].replaceAll("_", " ");
			formattedMobName = formattedMobName.substring(0, 1).toUpperCase() + formattedMobName.substring(1);
			
			if(players.contains(path + mobTypePaths[i])) {
				
				int counter = players.getInt(path + mobTypePaths[i]);
				
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ formattedMobName + " killed: " + config.getString("Colors.Number-Color") + counter));
				
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.MobsName-Color")
						+ formattedMobName + " killed: " + config.getString("Colors.Number-Color-if-0") + "0"));
			}
		}
		
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Colors.Lines-Color")
				+ "---------" + plugin.getPluginName() + config.getString("Colors.Lines-Color") + "---------"));
	}
	
	public static boolean hasMobKill(MKC plugin, Player player, MobType mob) {
		
		FileConfiguration players = plugin.getPlayers();
		return players.contains("Players." + player.getUniqueId() + "." + mob.getPath());
	}
}
