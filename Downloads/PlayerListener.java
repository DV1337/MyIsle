import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.ChatColor;
 
public class PlayerListener implements Listener {
      
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
    }
