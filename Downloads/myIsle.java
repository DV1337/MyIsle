package com.webs.mycraftisbest.evilmidget38._Husky_.MYCRAFTisbest.MyIsle;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.struct.Role;


public class myIsle extends JavaPlugin implements Listener {
	public boolean voteMsg;
	
	public void onEnable(){
		voteMsg = votifierInstalled();
	}
	
    private boolean votifierInstalled(){
    	if(getServer().getPluginManager().getPlugin("votifier") != null) {
			return true;
		} else {
			return false;
		}
    }
	@EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerJoin(final PlayerJoinEvent event) {
        Player p = event.getPlayer();
    	if (p.getName().equals("MYCRAFTisbest")) {
    	      Bukkit.broadcastMessage(ChatColor.BLUE + "[MyIsle]" + ChatColor.GOLD + "MYCRAFTisbest made MyIsle");
    	}
    	      else if (p.getName().equals("evilmidget38")) {
    	    	  Bukkit.broadcastMessage(ChatColor.BLUE + "[MyIsle] " + ChatColor.GOLD + "evilmidget38 made MyIsle");
    	      }
    	      else if (p.getName().equals("Husky")){
    	    	  Bukkit.broadcastMessage(ChatColor.BLUE + "[MyIsle] " + ChatColor.GOLD + "Husky made MyIsle");
    	      } else if (p.getName().equals("ludo0777")) {
    	    	  Bukkit.broadcastMessage(ChatColor.BLUE + "[MyIsle] " + ChatColor.GOLD + "ludo0777 made MyIsle");
    	      }
    	      else{
    	    	  Bukkit.broadcastMessage(ChatColor.BLUE + "[MyIsle]" + ChatColor.GREEN + p.getName() + "has joined as level <var>");
    	    	 ((Player) p).sendMessage(ChatColor.BLUE + "[MyIsle]" + ChatColor.GREEN + "This is a Isle server");
    	      }
    	if (voteMsg) return;{
    		((Player) p).sendMessage(ChatColor.BLUE + "[MyIsle]" + ChatColor.GREEN + "Vote for the server and get a larger isle");
    	}
	}

public static void createNewFaction(String name, String creator, Location home){
    Faction f = Factions.i.create(name);
    f.setHome(home);
    FPlayer player = FPlayers.i.get(name);
    player.setFaction(f);
    player.setRole(Role.ADMIN);
}
public static  void claimLand(Faction f, Location center, int radius){
   for (int x = center.getBlockX()-radius; x <= center.getBlockX()+radius; x+=16)
       for(int z = center.getBlockZ()-radius; z <= center.getBlockZ()+radius; z+=16)
           Board.setFactionAt(f, new FLocation(center.getWorld().getName(), x, z));
}


}

