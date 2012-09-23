/**
 * 
 */
package com.codeorb.myisle.exp;


public class PlayerExperience {

    int xp;
    int level;

    public PlayerExperience(int xp, int level){
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
     * @return The remaining exp required for the next level.
     */
    public int getExpToNextLevel(){
        return getExpForLevel(level+1)- xp;
    }
    
    /**
     * @return The experience required for the next level of the player.
     */
    public int getExpForNextLevel(){
        return getExpForLevel(level+1);
    }
    
    /**
     * @return The percent(represented as a float) to the next level.  Calculated as xp / getExpForNextLevel().
     */
    public float getPercentageToNext(){
        return ((float) xp) / ((float)getExpForNextLevel());
    }
    /**
     * @return The Exp required for the specified level.
     */
    public static int getExpForLevel(int theLevel) {
        //1 -10, 2 - 10, 3 - 20, 4- 40
        return (theLevel <= 0 ? 5 : (int) ((Math.pow(2, theLevel) * 5)));
    }
    
}
