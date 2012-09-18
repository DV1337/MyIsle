import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
 
public class OtherListener implements Listener {
 
      @EventHandler(priority = EventPriority.HIGHEST)
        public void onCreatureSpawn(CreatureSpawnEvent event) {
           System.out.println("MOB SPAWNED!!!");
        }
      
      @EventHandler(priority = EventPriority.HIGHEST)
        public void onEnchant(EnchantItemEvent event) {
           event.setCancelled(true);
           event.getPlayer().sendMessage(ChatColor.BLUE + "Enchanting is not allowed!")
        }
    }
