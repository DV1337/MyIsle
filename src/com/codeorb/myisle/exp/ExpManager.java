/**
 * 
 */
package com.codeorb.myisle.exp;

import java.util.TreeMap;

import net.minecraft.server.Packet43SetExperience;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ExpManager {
    TreeMap<String, PlayerLevel> experience = new TreeMap<String, PlayerLevel>();
    
    
    public void updatePlayers() {
        for (String name : experience.keySet()) 
            updatePlayer(name);
    }
    
    public void updatePlayer(String name){
        containsCheck(name);
        Player player = Bukkit.getPlayer(name);
        PlayerLevel exp = experience.get(name);
        ((CraftPlayer)player).getHandle().netServerHandler.sendPacket(new Packet43SetExperience(exp.getXp(), exp.getExpForLevel(exp.level), exp.getLevel()));
    }
    
    public void grantExp(String name, int amount) {
        containsCheck(name);
        PlayerLevel level = experience.get(name);
        level.addXp(amount);
        updatePlayer(name);
    }
    
    private void containsCheck(String name){
        if (!experience.containsKey(name))
            experience.put(name, new PlayerLevel(0, 0));
    }

}
