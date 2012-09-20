/**
 * 
 */
package com.codeorb.myisle.exp;


public class PlayerLevel {

    int xp;
    int level;

    public PlayerLevel(int xp, int level){
        this.xp = xp;
        this.level = level;
    }

    /**
     * @return The current experience of the player.  Not related to their level.
     */
    public int getXp() {
        return xp;
    }

    /**
     * @param xp The experience of the player.  Increases their level if necessary.
     */
    public void setXp(int newval) {

        int nextlevel = getExpToNextLevel();
        if (newval > nextlevel)
            newval = addLevels(newval);
        xp = newval;
    }

    private int addLevels(int amount){
        int nextlevel = getExpToNextLevel();
        int newXp = amount;
        if (amount > nextlevel){
            level++;
            newXp = addLevels(amount - nextlevel);
        }
        return newXp;
    }


    /**
     * @param amount The amount to be added to the player's exp.  Increases level as necessary.
     */
    public void addXp(int amount){
        setXp(amount + xp);
    }



    /**
     * @return The current level of the player.
     */
    public int getLevel() {
        return level;
    }


    /**
     * @param level The new level for the player.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return The Exp required for the next level of the player.
     */
    public int getExpToNextLevel(){
        return getExpForLevel(level+1)- xp;
    }
    /**
     * @return The Exp required for the specified level.
     */
    public int getExpForLevel(int theLevel) {
        return (int) ((Math.pow(2, theLevel-1) * 5));
    }
    
    public float getPercentToNext(){
        return ((float)xp) / ((float)getExpToNextLevel());
    }
    
}
