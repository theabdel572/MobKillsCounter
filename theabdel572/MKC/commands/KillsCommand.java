package theabdel572.MKC.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import theabdel572.MKC.MKC;
import theabdel572.MKC.MobKillsList;

public class KillsCommand implements CommandExecutor {
	private MKC plugin;

	public KillsCommand(MKC plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		FileConfiguration config = plugin.getConfig();
		if (!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(
					plugin.getPluginName() + ChatColor.RED + " This command only can be executed by players.");
			return false;
		} else {
			Player player = (Player) sender;
			if (player.hasPermission("mkc.mobs")) {
				if (args.length == 0) {
					MobKillsList.sendMobKillsList(plugin, player, player.getUniqueId());
				} else if (args.length == 1) {
					String user = args[0];
					UUID uid = Bukkit.getOfflinePlayer(user).getUniqueId();
					MobKillsList.sendMobKillsList(plugin, player, uid);
				}
			} else {
				player.sendMessage(plugin.getPluginName() + " "
						+ ChatColor.translateAlternateColorCodes('&', config.getString("Config.NoPermission-Message")));
			}
		}
		return true;
	}
}