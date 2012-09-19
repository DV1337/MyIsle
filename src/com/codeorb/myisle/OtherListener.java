package com.codeorb.myisle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.ChatColor;

public class OtherListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        //System.out.println("MOB SPAWNED!!!");  For the sake of sanity.
        // I added that for a reason you know... lol
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEnchant(EnchantItemEvent event) {
        event.setCancelled(true);
        event.getEnchanter().sendMessage(ChatColor.BLUE +"[MyIsle]" + ChatColor.GREEN + "Enchanting is not allowed, Buy the item");
    }
    
}
