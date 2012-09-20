package com.codeorb.myisle;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.ChatColor;

public class OtherListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        //System.out.println("MOB SPAWNED!!!");  For the sake of sanity.
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEnchant(EnchantItemEvent event) {
        event.setCancelled(true);
        event.getEnchanter().sendMessage(ChatColor.BLUE + "Enchanting is not allowed!");
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDeath(EntityDeathEvent event){
        Entity e = event.getEntity();
        int dropAmount = 3;
        if (e instanceof Creeper)
            dropAmount = 5;
        event.setDroppedExp(dropAmount);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerExpChange(PlayerExpChangeEvent e){
        myIsle.i.getExpManager().grantExp(e.getPlayer().getName(), e.getAmount());
    }
}
