package com.codeorb.myisle;

import org.bukkit.Location;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import com.codeorb.myisle.exp.ExpManager;
import com.codeorb.myisle.listeners.BlockListener;
import com.codeorb.myisle.listeners.OtherListener;
import com.codeorb.myisle.listeners.PlayerListener;
import com.codeorb.myisle.worldgenerator.MyIsleChunkGenerator;
import com.comphenix.protocol.events.ConnectionSide;
import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.struct.Role;

//for crafting cobwebs
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;


public class MyIsle extends JavaPlugin {

    public static MyIsle i;

    public boolean voteMsg;

    private ExpManager expManager = new ExpManager();

    public void onEnable(){
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
        getServer().getPluginManager().registerEvents(new OtherListener(this, ConnectionSide.SERVER_SIDE, 0x2B), this);
        loadRecipes();
        voteMsg = votifierInstalled();
        i = this;
    }

    public void onDisable(){
        i = null;
    }

    private boolean votifierInstalled(){
        if(getServer().getPluginManager().getPlugin("votifier") != null) {
            return true;
        } else {
            return false;
        }
    }

    // possibly move to otherListner.class   OR create new class (if more recipies added)
    private void loadRecipes() {
        ItemStack cobwebItem = new ItemStack(Material.WEB);

        ShapedRecipe cobweb = new ShapedRecipe(cobwebItem);

        // This is where the cobweb craft structure could be overriden
        cobweb.shape(
                "SSS",
                "SWS",
                "SSS");
        cobweb.setIngredient('S', Material.STRING);  
        cobweb.setIngredient('W', Material.WOOL);
        Bukkit.addRecipe(cobweb);


    }
    /**
     * 
     * @param worldName
     * The name of the world the generator is being applied to
     * @param GenId
     * The id (if any) specified by the user. It can be used if the plugin
     * wants to have multiple generators in one plugin. More on this later.
     * @return
     * The ChunkGenerator that this plugin provides
     */
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String GenId) {
        return new MyIsleChunkGenerator();
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

    public ExpManager getExpManager(){
        return expManager;
    }


}

