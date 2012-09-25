package com.codeorb.myisle.listeners;

import net.minecraft.server.Packet43SetExperience;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.ChatColor;

import com.codeorb.myisle.MyIsle;
import com.comphenix.protocol.events.ConnectionSide;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class OtherListener extends PacketAdapter implements Listener{

    public OtherListener(Plugin plugin, ConnectionSide connectionSide, int packets) {
		super(plugin, connectionSide, packets);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
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
        if (e instanceof Creeper) {
            dropAmount = 5;
        }
        event.setDroppedExp(dropAmount);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerExpChange(PlayerExpChangeEvent e){
        MyIsle.i.getExpManager().grantExp(e.getPlayer().getName(), e.getAmount());
    }
    
    @Override
    public void onPacketSending(PacketEvent event){
    	//This is using ProtocolLib
    	MyIsle.i.getExpManager().modifyPacket(((Packet43SetExperience)event.getPacket().getHandle()), event.getPlayer().getName());
    }
}
