package com.pl.MYCRAFTisbest.CraftMe;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftMe extends JavaPlugin implements Listener {

	public void onEnable(){
		loadRecipes();
		try{
			File file = new File(getDataFolder(), File.separator + "config.yml");
			if (!file.exists()){
				this.getConfig().addDefault("Cobweb", true);
				this.getConfig().addDefault("Glowstone", true);
				this.getConfig().addDefault("Mossy_Cobblestone", true);
				this.getConfig().addDefault("PureWater", true);
				this.getConfig().addDefault("PureLava", true);
				this.getConfig().options().copyDefaults(true);
				this.saveConfig();
			}
			}
			catch (ClassCastException e)
			{
				
				
			}
	}
	
	
	private void loadRecipes() {
	
		if (this.getConfig().getBoolean("Cobweb", true)){
    	ItemStack cobwebItem = new ItemStack(Material.WEB, 1);
    
    	ShapedRecipe cobweb = new ShapedRecipe(cobwebItem);
    

    	cobweb.shape(
    			"SSS",
    			"SWS",
    			"SSS");
    	cobweb.setIngredient('S', Material.STRING);  
    	cobweb.setIngredient('W', Material.WOOL);
    	Bukkit.addRecipe(cobweb);

		}
		if (this.getConfig().getBoolean("Glowstone", true)){
	    	ItemStack glowstoneItem = new ItemStack(Material.GLOWSTONE, 1);
	    
	    	ShapedRecipe glowstone = new ShapedRecipe(glowstoneItem);
	    

	    	glowstone.shape(
	    			"GGG",
	    			"GTG",
	    			"GGG");
	    	glowstone.setIngredient('G', Material.GLASS);  
	    	glowstone.setIngredient('T', Material.TORCH);
	    	Bukkit.addRecipe(glowstone);

			}
		if (this.getConfig().getBoolean("Mossy_Cobblestone", true)){
	    	ItemStack mCobbleItem = new ItemStack(Material.MOSSY_COBBLESTONE, 1);
	    
	    	ShapedRecipe mCobble = new ShapedRecipe(mCobbleItem);
	    

	    	mCobble.shape(
	    			"V",
	    			"C",
	    			"V");
	    	mCobble.setIngredient('V', Material.VINE);  
	    	mCobble.setIngredient('C', Material.COBBLESTONE);
	    	Bukkit.addRecipe(mCobble);

			}
		if (this.getConfig().getBoolean("PureWater", true)){
	    	ItemStack waterItem = new ItemStack(Material.WATER, 1);
	    
	    	ShapedRecipe water = new ShapedRecipe(waterItem);
	    

	    	water.shape(
	    			"B");
	    	water.setIngredient('B', Material.WATER_BUCKET);  
	    	Bukkit.addRecipe(water);

			}
		if (this.getConfig().getBoolean("PureLava", true)){
	    	ItemStack lavaItem = new ItemStack(Material.LAVA, 1);
	    
	    	ShapedRecipe lava = new ShapedRecipe(lavaItem);
	    

	    	lava.shape(
	    			"L");
	    	lava.setIngredient('L', Material.LAVA_BUCKET);  
	    	Bukkit.addRecipe(lava);

			}
		if (this.getConfig().getBoolean("PureWater", true)){
	    	ItemStack fireItem = new ItemStack(Material.FIRE, 64);
	    
	    	ShapedRecipe fire = new ShapedRecipe(fireItem);
	    

	    	fire.shape(
	    			"F");
	    	fire.setIngredient('F', Material.FLINT_AND_STEEL);  
	    	Bukkit.addRecipe(fire);

			}
}
}

