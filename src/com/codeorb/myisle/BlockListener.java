package com.codeorb.myisle;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {

    public void onBlockBreak (BlockBreakEvent event) {
        Player p = event.getPlayer();
    }
}
