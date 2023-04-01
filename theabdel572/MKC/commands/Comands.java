package theabdel572.MKC.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import theabdel572.MKC.MKC;
import theabdel572.MKC.MobTypes.MobType;

// Class to manage the main /mkc commands.
public class Comands implements CommandExecutor {
  private MKC plugin;

  public Comands(MKC plugin) {
    this.plugin = plugin;
  }

  // Well i'm lazy to refactor this class, i'm making just some changes.
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (args.length > 0) {
      FileConfiguration config = plugin.getConfig();

      if (args[0].equalsIgnoreCase("version")) {

        if (sender.hasPermission("mkc.version")) {
          sender.sendMessage(
              plugin.getPluginName()
                  + ChatColor.GREEN
                  + " The plugin version is: "
                  + ChatColor.BLUE
                  + plugin.getVersion());
          return true;
        }

        sender.sendMessage(
            plugin.getPluginName()
                + " "
                + ChatColor.translateAlternateColorCodes(
                    '&', config.getString("Config.NoPermission-Message")));

      } else if (args[0].equalsIgnoreCase("setreward")) {

        if (sender.hasPermission("mkc.setrewards")) {

          if (args.length > 2) {

            if (MobType.isPath(args[1])) {
              try {
                int kills4reward = Integer.parseInt(args[2]);
                List<String> rewards = new ArrayList<>();
                rewards.add("tell %player% You killed " + kills4reward + " " + args[1] + ".");
                config.set("Rewards." + args[1] + "." + kills4reward, rewards);
                plugin.saveConfig();
                sender.sendMessage(
                    plugin.getPluginName()
                        + " Reward set correctly! Go to config.yml to configure the command"
                        + " reward.");
              } catch (Exception exc) {
                sender.sendMessage(
                    plugin.getPluginName() + " Please, use a number for kill rewards.");
              }
            } else {
              sender.sendMessage(
                  "Please, use a correct parametre for" + ChatColor.AQUA + " [name of the mob]:");
              sender.sendMessage(
                  "zombies, skeletons, spiders, cave_spiders, blazes, creepers, ender_dragons,"
                      + " endermans, endermites,");
              sender.sendMessage(
                  "bats, chickens, cows, ghasts, guardians, horses, iron_golems, magma_cubes,"
                      + " mushroom_cows,");
              sender.sendMessage(
                  "ocelots, pigs, pig_zombies, sheeps, silverfishs, slimes, snowmans, squids,"
                      + " villagers, witchs, withers or wolfs.");
            }
          } else {
            sender.sendMessage(
                plugin.getPluginName()
                    + " Correctly usage: /mkc setreward [name of the mob] [kills for reward]");
          }
        } else {
          sender.sendMessage(
              plugin.getPluginName()
                  + " "
                  + ChatColor.translateAlternateColorCodes(
                      '&', config.getString("Config.NoPermission-Message")));
        }
      } else if (args[0].equalsIgnoreCase("reload")) {

        if (sender.hasPermission("mkc.reload")) {
          plugin.reloadConfig();
          sender.sendMessage(
              plugin.getPluginName() + ChatColor.GREEN + " The config has been reloaded.");

        } else {
          sender.sendMessage(
              plugin.getPluginName()
                  + " "
                  + ChatColor.translateAlternateColorCodes(
                      '&', config.getString("Config.NoPermission-Message")));
        }
      } else if (args[0].equalsIgnoreCase("permissions")) {
        sender.sendMessage(
            ChatColor.BLUE
                + "mkc.placeholders "
                + ChatColor.BLACK
                + "-"
                + ChatColor.GREEN
                + " /mkc placeholders");
        sender.sendMessage(
            ChatColor.BLUE
                + "mkc.version "
                + ChatColor.BLACK
                + "-"
                + ChatColor.GREEN
                + " /mkc version");
        sender.sendMessage(
            ChatColor.BLUE
                + "mkc.reload "
                + ChatColor.BLACK
                + "-"
                + ChatColor.GREEN
                + " /mkc reload");
        sender.sendMessage(
            ChatColor.BLUE
                + "mkc.mobs "
                + ChatColor.BLACK
                + "-"
                + ChatColor.GREEN
                + " /mobkills & /mobkills <player>");
        sender.sendMessage(
            ChatColor.BLUE
                + "mkc.updatecheck "
                + ChatColor.BLACK
                + "-"
                + ChatColor.GREEN
                + " See if a plugin has a new version (send message to it on join).");
        sender.sendMessage(
            ChatColor.BLUE
                + "mkc.setrewards "
                + ChatColor.BLACK
                + "-"
                + ChatColor.GREEN
                + " /mkc setreward <name of the mob> <kills for reward>");

      } else if (args[0].equalsIgnoreCase("help")) {
        sendMKCHelp(sender);

      } else if (args[0].equalsIgnoreCase("page")) {
        sender.sendMessage(plugin.getPluginName() + ChatColor.BLUE + " The plugin page is:");
        sender.sendMessage(
            ChatColor.GREEN
                + "https://www.spigotmc.org/resources/mobkillscounter-rewards-compatible-with-30-mobs-1-7-1-16-perfect-for-survival-servers.82876/");

      } else if (args[0].equalsIgnoreCase("placeholders")) {
        if (sender.hasPermission("mkc.placeholders")) {
          sender.sendMessage(
              plugin.getPluginName()
                  + ChatColor.GREEN
                  + " All placeholders have the same syntax: "
                  + ChatColor.BLUE
                  + "%mkc_<MobName>%");
          sender.sendMessage(
              ChatColor.GREEN + "All possible arguments to " + ChatColor.BLUE + "<MobName>:");
          sender.sendMessage(
              "zombies, skeletons, spiders, cave_spiders, blazes, creepers, ender_dragons,"
                  + " endermans, endermites,");
          sender.sendMessage(
              "bats, chickens, cows, ghasts, guardians, horses, iron_golems, magma_cubes,"
                  + " mushroom_cows,");
          sender.sendMessage(
              "ocelots, pigs, pig_zombies, sheeps, silverfishs, slimes, snowmans, squids,"
                  + " villagers, witchs, withers or wolfs.");
        } else {
          sender.sendMessage(
              plugin.getPluginName()
                  + " "
                  + ChatColor.translateAlternateColorCodes(
                      '&', config.getString("Config.NoPermission-Message")));
        }
      } else {
        sender.sendMessage(plugin.getPluginName() + ChatColor.RED + " This command doesn't exists");
      }

    } else {
      sendMKCHelp(sender);
    }
    return true;
  }

  // Method to send the help message of the plugin.
  public void sendMKCHelp(CommandSender sender) {
    sender.sendMessage(plugin.getPluginName() + ChatColor.BLUE + " Commands:");
    sender.sendMessage(
        ChatColor.DARK_BLUE
            + "/mkc page "
            + ChatColor.GREEN
            + " Use it to see the plugin page and see detailed info about the plugin.");
    sender.sendMessage(
        ChatColor.DARK_BLUE
            + "/mkc placeholders "
            + ChatColor.GREEN
            + " Use it to see the available placeholders.");
    sender.sendMessage(
        ChatColor.DARK_BLUE
            + "/mkc version "
            + ChatColor.GREEN
            + " Use it to see the plugin version.");
    sender.sendMessage(
        ChatColor.DARK_BLUE + "/mkc reload " + ChatColor.GREEN + " Use it to reload the config.");
    sender.sendMessage(
        ChatColor.DARK_BLUE
            + "/mkc permissions "
            + ChatColor.GREEN
            + " Use it to see the plugin permissions.");
    sender.sendMessage(
        ChatColor.DARK_BLUE
            + "/mobkills "
            + ChatColor.GREEN
            + " Use it to see all mobs you killed.");
    sender.sendMessage(
        ChatColor.DARK_BLUE
            + "/mobkills <player>"
            + ChatColor.GREEN
            + " Use it to see all mobs a specific player killed.");
    sender.sendMessage(
        ChatColor.DARK_BLUE
            + "/mkc setreward <name of the mob> <kills for reward>"
            + ChatColor.GREEN
            + " Use it to set a reward for a specific number of kills to one mob.");
  }
}
