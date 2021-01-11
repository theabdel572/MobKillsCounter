package theabdel572.MKC.events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import theabdel572.MKC.MKC;

public class Join implements Listener{
	private MKC plugin;
	public Join(MKC plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		FileConfiguration players = plugin.getPlayers();
		FileConfiguration config = plugin.getConfig();
		String MKCEnter = "Config.SendMobkills-On-Join";
		if(config.getString(MKCEnter).equals("true")) {
			if(player.hasPermission("mkc.mobs")) {
			if(!players.contains("Players")) {
				player.sendMessage(ChatColor.RED+"---------"+plugin.name+"---------");
				player.sendMessage(ChatColor.BLUE+"Zombies killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Skeletons killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Spiders killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Cave_Spiders killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Blazes killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Creepers killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Ender_Dragons killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Endermans killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Endermites killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Bats killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Chickens killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Cows killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Ghasts killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Guardians killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Horses killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Iron_Golems killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Magma_Cubes killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Mushroom_Cows killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Ocelots killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Pigs killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Pig_Zombies killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Players killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Rabbits killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Sheeps killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Silverfishs killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Slimes killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Snowmans killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Squids killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Villagers killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Witchs killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Withers killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.BLUE+"Wolfs killed: "+ChatColor.RED+"0");
				player.sendMessage(ChatColor.RED+"---------"+plugin.name+"---------");
				return;
			}else {
				if(players.contains("Players. "+player.getUniqueId()+" .zombies")) {
					int zombiescounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .zombies"));
					player.sendMessage(ChatColor.RED+"---------"+plugin.name+"---------");
					player.sendMessage(ChatColor.BLUE+"Zombies killed: "+ChatColor.GREEN+zombiescounter);
				}else {
					player.sendMessage(ChatColor.RED+"---------"+plugin.name+"---------");
					player.sendMessage(ChatColor.BLUE+"Zombies killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .skeletons")) {
					int skeletonscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .skeletons"));
					player.sendMessage(ChatColor.BLUE+"Skeletons killed: "+ChatColor.GREEN+skeletonscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Skeletons killed: "+ChatColor.RED+"0");
			}
				if(players.contains("Players. "+player.getUniqueId()+" .spiders")) {
					int spiderscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .spiders"));
					player.sendMessage(ChatColor.BLUE+"Spiders killed: "+ChatColor.GREEN+spiderscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Spiders killed: "+ChatColor.RED+"0");
		}
				if(players.contains("Players. "+player.getUniqueId()+" .cave_spiders")) {
					int cave_spiderscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .cave_spiders"));
					player.sendMessage(ChatColor.BLUE+"Cave_Spiders killed: "+ChatColor.GREEN+cave_spiderscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Cave_Spiders killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .blazes")) {
					int blazescounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .blazes"));
					player.sendMessage(ChatColor.BLUE+"Blazes killed: "+ChatColor.GREEN+blazescounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Blazes killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .creepers")) {
					int creeperscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .creepers"));
					player.sendMessage(ChatColor.BLUE+"Creepers killed: "+ChatColor.GREEN+creeperscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Creepers killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .ender_dragons")) {
					int ender_dragonscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .ender_dragons"));
					player.sendMessage(ChatColor.BLUE+"Ender_Dragons killed: "+ChatColor.GREEN+ender_dragonscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Ender_Dragons killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .endermans")) {
					int endermanscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .endermans"));
					player.sendMessage(ChatColor.BLUE+"Endermans killed: "+ChatColor.GREEN+endermanscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Endermans killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .endermites")) {
					int endermitescounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .endermites"));
					player.sendMessage(ChatColor.BLUE+"Endermites killed: "+ChatColor.GREEN+endermitescounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Endermites killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .bats")) {
					int batscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .bats"));
					player.sendMessage(ChatColor.BLUE+"Bats killed: "+ChatColor.GREEN+batscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Bats killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .chickens")) {
					int chickenscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .chickens"));
					player.sendMessage(ChatColor.BLUE+"Chickens killed: "+ChatColor.GREEN+chickenscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Chickens killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .cows")) {
					int cowscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .cows"));
					player.sendMessage(ChatColor.BLUE+"Cows killed: "+ChatColor.GREEN+cowscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Cows killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .ghasts")) {
					int ghastscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .ghasts"));
					player.sendMessage(ChatColor.BLUE+"Ghasts killed: "+ChatColor.GREEN+ghastscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Ghasts killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .guardians")) {
					int guardianscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .guardians"));
					player.sendMessage(ChatColor.BLUE+"Guardians killed: "+ChatColor.GREEN+guardianscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Guardians killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .horses")) {
					int horsescounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .horses"));
					player.sendMessage(ChatColor.BLUE+"Horses killed: "+ChatColor.GREEN+horsescounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Horses killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .iron_golems")) {
					int iron_golemscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .iron_golems"));
					player.sendMessage(ChatColor.BLUE+"Iron_Golems killed: "+ChatColor.GREEN+iron_golemscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Iron_Golems killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .magma_cubes")) {
					int magma_cubescounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .magma_cubes"));
					player.sendMessage(ChatColor.BLUE+"Magma_Cubes killed: "+ChatColor.GREEN+magma_cubescounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Magma_Cubes killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .mushroom_cows")) {
					int mushroom_cowscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .mushroom_cows"));
					player.sendMessage(ChatColor.BLUE+"Mushroom_Cows killed: "+ChatColor.GREEN+mushroom_cowscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Mushroom_Cows killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .ocelots")) {
					int ocelotscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .ocelots"));
					player.sendMessage(ChatColor.BLUE+"Ocelots killed: "+ChatColor.GREEN+ocelotscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Ocelots killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .pigs")) {
					int pigscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .pigs"));
					player.sendMessage(ChatColor.BLUE+"Pigs killed: "+ChatColor.GREEN+pigscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Pigs killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .pig_zombies")) {
					int pig_zombiescounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .pig_zombies"));
					player.sendMessage(ChatColor.BLUE+"Pig_Zombies killed: "+ChatColor.GREEN+pig_zombiescounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Pig_Zombies killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .players")) {
					int playerscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .players"));
					player.sendMessage(ChatColor.BLUE+"Players killed: "+ChatColor.GREEN+playerscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Players killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .rabbits")) {
					int rabbitscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .rabbits"));
					player.sendMessage(ChatColor.BLUE+"Rabbits killed: "+ChatColor.GREEN+rabbitscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Rabbits killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .sheeps")) {
					int sheepscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .sheeps"));
					player.sendMessage(ChatColor.BLUE+"Sheeps killed: "+ChatColor.GREEN+sheepscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Sheeps killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .silverfish")) {
					int silverfishcounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .silverfish"));
					player.sendMessage(ChatColor.BLUE+"Silverfishs killed: "+ChatColor.GREEN+silverfishcounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Silverfishs killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .cows")) {
					int cowscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .cows"));
					player.sendMessage(ChatColor.BLUE+"Cows killed: "+ChatColor.GREEN+cowscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Cows killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .slimes")) {
					int slimescounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .slimes"));
					player.sendMessage(ChatColor.BLUE+"Slimes killed: "+ChatColor.GREEN+slimescounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Slimes killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .snowmans")) {
					int snowmanscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .snowmans"));
					player.sendMessage(ChatColor.BLUE+"Snowmans killed: "+ChatColor.GREEN+snowmanscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Snowmans killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .squids")) {
					int squidscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .squids"));
					player.sendMessage(ChatColor.BLUE+"Squids killed: "+ChatColor.GREEN+squidscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Squids killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .villagers")) {
					int villagerscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .villagers"));
					player.sendMessage(ChatColor.BLUE+"Villagers killed: "+ChatColor.GREEN+villagerscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Villagers killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .witchs")) {
					int witchscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .witchs"));
					player.sendMessage(ChatColor.BLUE+"Witchs killed: "+ChatColor.GREEN+witchscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Witchs killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .withers")) {
					int witherscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .withers"));
					player.sendMessage(ChatColor.BLUE+"Withers killed: "+ChatColor.GREEN+witherscounter);
				}else {
					player.sendMessage(ChatColor.BLUE+"Withers killed: "+ChatColor.RED+"0");
				}
				if(players.contains("Players. "+player.getUniqueId()+" .wolfs")) {
					int wolfscounter = Integer.valueOf(players.getString("Players. "+player.getUniqueId()+" .wolfs"));
					player.sendMessage(ChatColor.BLUE+"Wolfs killed: "+ChatColor.GREEN+wolfscounter);
					player.sendMessage(ChatColor.RED+"---------"+plugin.name+"---------");
				}else {
					player.sendMessage(ChatColor.BLUE+"Wolfs killed: "+ChatColor.RED+"0");
					player.sendMessage(ChatColor.RED+"---------"+plugin.name+"---------");
					return;
				}
	}
		}
		}
		if(player.hasPermission("mkc.updatecheck") && !(plugin.getVersion().equals(plugin.getLatestVersion()))) {
			player.sendMessage(plugin.name+ChatColor.RED +" There is a new version available. "+ChatColor.YELLOW+
  				  "("+ChatColor.GRAY+plugin.latestversion+ChatColor.YELLOW+")");
  		  player.sendMessage(ChatColor.RED+"You can download it at: "+ChatColor.WHITE+"https://www.spigotmc.org/resources/mobkillscounter-compatible-with-30-mobs-1-7-1-16-perfect-for-survival-servers.82876/");
		}
	}
}
