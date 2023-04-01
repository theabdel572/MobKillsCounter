package theabdel572.MKC;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import theabdel572.MKC.commands.Comands;
import theabdel572.MKC.commands.KillsCommand;
import theabdel572.MKC.events.Join;
import theabdel572.MKC.events.Kills;

// Main plugin class.
public class MKC extends JavaPlugin {
  private FileConfiguration players = null;
  private File playersFile = null;
  private String configPath;
  private final PluginDescriptionFile pdffile = getDescription();
  private final String version = pdffile.getVersion();
  private final String name =
      ChatColor.AQUA + "[" + ChatColor.GOLD + "MobKillsCounter" + ChatColor.AQUA + "]";
  private String latestversion;

  // Method called when the plugin enables.
  public void onEnable() {
    registerCommands();
    registerEvents();
    registerConfig();
    registerPlayers();
    updateChecker();
    checkConfig();
    if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
      new PlaceHolderApiManager(this).register();
    }
  }

  public String getVersion() {
    return this.version;
  }

  public String getLatestVersion() {
    return this.latestversion;
  }

  public String getPluginName() {
    return this.name;
  }

  // Method to register the command classes to the plugin.
  public void registerCommands() {
    this.getCommand("mkc").setExecutor(new Comands(this));
    this.getCommand("mobkills").setExecutor(new KillsCommand(this));
  }

  // Method to register the config.yml file and create it if it doesn't exist.
  public void registerConfig() {
    File config = new File(this.getDataFolder(), ("config.yml"));
    configPath = config.getPath();
    if (!config.exists()) {
      this.getConfig().options().copyDefaults(true);
      saveConfig();
    }
  }

  // Method to register the listeners for the plugin.
  public void registerEvents() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new Kills(this), this);
    pm.registerEvents(new Join(this), this);
  }

  public FileConfiguration getPlayers() {
    if (players == null) {
      reloadPlayers();
    }
    return players;
  }

  // Method to reload players.yml file.
  public void reloadPlayers() {
    if (players == null) {
      playersFile = new File(getDataFolder(), "players.yml");
    }
    players = YamlConfiguration.loadConfiguration(playersFile);
    Reader defConfigStream;
    try {
      defConfigStream = new InputStreamReader(this.getResource("players.yml"), "UTF8");
      if (defConfigStream != null) {
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        players.setDefaults(defConfig);
      }
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  // Method to save the players.yml file.
  public void savePlayers() {
    try {
      players.save(playersFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Method to register the players.yml file and create it if it doesn't exist.
  public void registerPlayers() {
    playersFile = new File(this.getDataFolder(), "players.yml");
    if (!playersFile.exists()) {
      this.getPlayers().options().copyDefaults(true);
      savePlayers();
    }
  }

  // Method to check if the config is up-to-date and if not, create the new paths.
  public void checkConfig() {
    FileConfiguration config = getConfig();
    Path file = Paths.get(configPath);
    List<String> worlds = config.getStringList("Worlds.enabled-worlds");
    try {
      String text = new String(Files.readAllBytes(file));
      if (!text.contains("SendMobkills-On-Join:")) {
        getConfig().set("Config.SendMobkills-On-Join", true);
        saveConfig();
      }
      if (!text.contains("Worlds:")) {
        getConfig().set("Worlds.enabled-worlds", worlds);
        saveConfig();
      }
      if (!text.contains("Colors:")) {
        getConfig().set("Colors.Lines-Color", "&c");
        getConfig().set("Colors.MobsName-Color", "&1");
        getConfig().set("Colors.Number-Color", "&a");
        getConfig().set("Colors.Number-Color-if-0", "&c");
        saveConfig();
      }
      if (!text.contains("Send-Message-insteadof-Command:")) {
        getConfig().set("Config.Send-Message-insteadof-Command", true);
        saveConfig();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Method to check for updates at the spigot's plugin page.
  public void updateChecker() {
    try {
      HttpURLConnection con =
          (HttpURLConnection)
              new URL("https://api.spigotmc.org/legacy/update.php?resource=82876").openConnection();
      int timed_out = 1250;
      con.setConnectTimeout(timed_out);
      con.setReadTimeout(timed_out);
      latestversion = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
      if (latestversion.length() <= 7) {
        if (!version.equals(latestversion)) {
          Bukkit.getConsoleSender()
              .sendMessage(
                  name
                      + ChatColor.RED
                      + " There is a new version available. "
                      + ChatColor.YELLOW
                      + "("
                      + ChatColor.GRAY
                      + latestversion
                      + ChatColor.YELLOW
                      + ")");
          Bukkit.getConsoleSender()
              .sendMessage(
                  ChatColor.RED
                      + "You can download it at: "
                      + ChatColor.WHITE
                      + "https://www.spigotmc.org/resources/mobkillscounter-compatible-with-30-mobs-1-7-1-16-perfect-for-survival-servers.82876/");
        }
      }
    } catch (Exception ex) {
      Bukkit.getConsoleSender().sendMessage(name + ChatColor.RED + " Error while checking update.");
    }
  }
}
