import org.bukkit.event.Listener;
 
public class BlockListener implements Listener {
      @Override
    public void onBlockBreak (BlockBreakEvent event) {
        Player p = event.getPlayer();
    }
    }
