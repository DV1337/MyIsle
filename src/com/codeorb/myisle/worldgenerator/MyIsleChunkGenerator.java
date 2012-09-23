/**
 * 
 */
package com.codeorb.myisle.worldgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class MyIsleChunkGenerator extends ChunkGenerator{

    /**
     * 
     * @param x
     * X co-ordinate of the block to be set in the array
     * @param y
     * Y co-ordinate of the block to be set in the array
     * @param z
     * Z co-ordinate of the block to be set in the array
     * @param chunk
     * An array containing the Block id's of all the blocks in the chunk. The first offset
     * is the block section number. There are 16 block sections, stacked vertically, each of which
     * 16 by 16 by 16 blocks.
     * @param material
     * The material to set the block to.
     */
    void setBlock(int x, int y, int z, byte[][] chunk, Material material) {
        if (chunk[y >> 4] == null)
            chunk[y >> 4] = new byte[16 * 16 * 16];
        if (!(y <= 256 && y >= 0 && x <= 16 && x >= 0 && z <= 16 && z >= 0))
            return;
        try {
            chunk[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = (byte) material.getId();
        } catch (Exception e) {
            // do nothing
        }
    }
    @Override
    /**
     * @param world
     * The world the chunk belongs to
     * @param rand
     * Don't use this, make a new random object using the world seed (world.getSeed())
     * @param biome
     * Use this to set/get the current biome
     * @param ChunkX and ChunkZ
     * The x and z co-ordinates of the current chunk.
     */
    public byte[][] generateBlockSections(World world, Random rand, int ChunkX, int ChunkZ, BiomeGrid biome) {
        //50 blocks of water.  Islands will be added via a BlockPopulator.
        byte[][] chunk = new byte[world.getMaxHeight() / 16][];
        setLayer(0, chunk, Material.BEDROCK);
        setLayers(1, 51, chunk, Material.WATER, biome, Biome.OCEAN);
        return chunk;
    }

    /**
     * Sets all blocks for a specified y-value to the specific material.
     * 
     * @param y The y value of the layer to set to the specified material.
     * @param chunk The chunk containing the layer.
     * @param material The material to set the layer to.
     */
    void setLayer(int y, byte[][] chunk, Material material) {
        for (int x = 0; x <16; x++)
            for (int z = 0; z < 16; z++)
                setBlock(x, y, z, chunk, material);
    }
    /**
     *  Sets all of the blocks within the layers whose y-values are between the start(inclusive) and stop(exclusive) to the specified material.
     * 
     * @param start The y value of the layer to start setting to the specified material.  Inclusive.
     * @param stop The y value of the layer to stop setting to the specified material.  Exclusive.
     * @param chunk The chunk containing the layers.
     * @param material The material to set the layers to.
     */
    public void setLayers(int start, int stop, byte[][] chunk, Material material){
        for (int y = start; y < stop; y++)
            setLayer(y, chunk, material);
    }

    /**
     *  Sets all of the blocks within the layers whose y-values are between the start(inclusive) and stop(exclusive) to the specified material.
     *  Also sets the biomes of the blocks to the specified biome.
     * @param start The y value of the layer to start setting to the specified material.  Inclusive.
     * @param stop The y value of the layer to stop setting to the specified material.  Exclusive.
     * @param chunk The chunk containing the layers.
     * @param material The material to set the layers to.
     * @param biomes The BiomeGrid of the chunk.
     * @param biome  The Biome to set the layers to.
     */
    public void setLayers(int start, int stop, byte[][] chunk, Material material, BiomeGrid biomes,Biome biome){
        for (int y = start; y < stop; y++){
            setLayer(y, chunk, material);
        }
    }
    /**
     * Sets all blocks for a specified y-value to the specific material.
     * 
     * @param y The y value of the layer to set to the specified material.
     * @param chunk The chunk containing the layer.
     * @param material The material to set the layer to.
     * @param biomes The BiomeGrid of the chunk.
     * @param biome The biome to set this layer to.
     */
    void setLayer(int y, byte[][] chunk, Material material, BiomeGrid biomes, Biome biome) {
        for (int x = 0; x <16; x++)
            for (int z = 0; z < 16; z++)
                setBlock(x, y, z, chunk, material);
    }
    
    
    /*@Override  - Islands will be dynamically generated.
    public List<BlockPopulator> getDefaultPopulators(World world) {
        ArrayList<BlockPopulator> pops = new ArrayList<BlockPopulator>();
        pops.add(new IslandPopulator());
        return pops;
        
    }*/



}
