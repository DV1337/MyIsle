/**
 * 
 */
package com.codeorb.myisle.exp;

import java.util.TreeMap;

import net.minecraft.server.Packet43SetExperience;

public class ExpManager {
    TreeMap<String, PlayerExperience> experience = new TreeMap<String, PlayerExperience>();
    
    /*
     * This currently isn't done, and as such, it won't be modifying the packets.  We'll probably be using a custom CB build to allow for this.
     */
    public void modifyPacket(Packet43SetExperience exp, String name){
        containsCheck(name);
        PlayerExperience pe = experience.get(name);
        exp.a = pe.getPercentageToNext();
        exp.b = pe.getXp();
        exp.c = pe.getLevel();
    }
    
    public void grantExp(String name, int amount) {
        containsCheck(name);
        PlayerExperience level = experience.get(name);
        level.addXp(amount);
    }
    
    private void containsCheck(String name){
        if (!experience.containsKey(name))
            experience.put(name, new PlayerExperience(0, 0));
    }

}
