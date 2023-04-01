package theabdel572.MKC.events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import theabdel572.MKC.MKC;
import theabdel572.MKC.MobKillsList;

// Class to manage player joining events.
public class Join implements Listener {
  private MKC plugin;

  public Join(MKC plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  // Method to handle the player join listener.
  public void onPlayerJoin(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    FileConfiguration config = plugin.getConfig();
    if (config.getBoolean("Config.SendMobkills-On-Join")) {
      if (player.hasPermission("mkc.mobs")) {
        MobKillsList.sendMobKillsList(plugin, player, player.getUniqueId());
      }
    }
    if (player.hasPermission("mkc.updatecheck")
        && !(plugin.getVersion().equals(plugin.getLatestVersion()))) {
      player.sendMessage(
          plugin.getPluginName()
              + ChatColor.RED
              + " There is a new version available. "
              + ChatColor.YELLOW
              + "("
              + ChatColor.GRAY
              + plugin.getLatestVersion()
              + ChatColor.YELLOW
              + ")");
      player.sendMessage(
          ChatColor.RED
              + "You can download it at: "
              + ChatColor.WHITE
              + "https://www.spigotmc.org/resources/mobkillscounter-compatible-with-30-mobs-1-7-1-16-perfect-for-survival-servers.82876/");
    }
  }
}
