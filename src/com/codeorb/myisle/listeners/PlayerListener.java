package com.codeorb.myisle.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.codeorb.myisle.MyIsle;

public class PlayerListener implements Listener {


	@EventHandler
	public void PlayerJoin(final PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (MyIsle.i.getDescription().getAuthors().contains(p.getName()))
			Bukkit.broadcastMessage(p.getName()+ " is part of the MyIsle dev team!");
		Bukkit.broadcastMessage(ChatColor.BLUE + "[MyIsle]" + ChatColor.GREEN + p.getName() + "has joined as level <var>");
		p.sendMessage(ChatColor.BLUE + "[MyIsle]" + ChatColor.GREEN + "This is a Isle server");
		if (MyIsle.i.voteMsg) return;{
			p.sendMessage(ChatColor.BLUE + "[MyIsle]" + ChatColor.GREEN + "Vote for the server and get a larger isle");
		}
	}



}
