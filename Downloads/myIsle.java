package com.webs.mycraftisbest.evilmidget38._Husky_.MYCRAFTisbest.MyIsle;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.struct.Role;


public class myIsle extends JavaPlugin {
	public boolean voteMsg;
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		voteMsg = votifierInstalled();
	}
	
    private boolean votifierInstalled(){
    	if(getServer().getPluginManager().getPlugin("votifier") != null) {
			return true;
		} else {
			return false;
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

