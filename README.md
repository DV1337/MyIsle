<a href="http://cooltext.com"><img src="http://images.cooltext.com/2774578.png" width="260" height="93" alt="MyIsle
" /></a>

<html>
<body>
//READ_ME
<br>
WRITTEN BY DV1337
<br>
!MyIsle is not open source! It will be released as open source in the future.
<br>
<br>
V1.0
<br>
<h1> For the Developers </h1>
<a href>This</a> is the link to the document with the features we need to be working on right now.

<h1> Background </h1>
MyIsle is a Bukkit plugin for the server MyIsle. It creates an interface for the player, allowing them to generate their own island in an open ocean-world map. They own and inhabit this Isle, and they can play it solo or invite others. There are many features that go along with this, owning the island is just the tip of the iceberg. There is a unique leveling system, random events, and many other features that will be mentioned below.
<br>
<h1> Synopsis of Features </h1>
<br>
For commands, please jump to the Commands section.
<br>
<h3> Isle Generation </h3>
<ul>
<li> Creates an island with a radius of 200. Island is populated with wildlife and trees. Island has a glass dome.
<li> Player's home is bound to middle of island, player cannot change /home.(link to simpleSpawn maybe?)
<li> Island should start with the default protection. Use factions for this.(factions for factions)
</li>
</ul>
<br>
<h3> Player, Mob, & World Restrictions </h3>
<ul>
<li> World is flat. Grass and water are at the same level.(not plugin but world gens & multiverse)
<li> Random islands with treasure are generated. Same size as Player Owned Island, but with possibility of diamond ores and chests filled with goods.(...)
<li> Islands are always 500 blocks away from each other, on all sides. That which is not an island is water.
<li> Player can build ONLY in their protection(see protection for more details). They can break blocks (for harvesting wood) outside their protection, and pick them up, but they CANNOT place ANYTHING outside their protection.
<li> Player cannot build above 10 blocks from the surface. Player cannot build below the first level of grass.(above is simply server block hight)
<li> Creepers can only blow up the first layer of grass, and up to 10 blocks from the surface.(compleatly guard this layer(as if it was bedrock)
</li>
</ul>
<br>
<h3> Protection and Leveling </h3>
<ul>
<li> The player starts with a circle protection that centers around their spawn point (dead center of the island, that block). The protection is 10 in radius, 20 in diameter.
<li> There is an EXP system. Every day spent on the Isle is 10 EXP if there is only you on the island, 20 EXP if you have one friend, and so on, up to 3 other players with you.
<li> Every Creeper killed gives 5 EXP. Every other mob gives 3 EXP. 
<li> Leveling goes on until level 100. The EXP for level 1 is 20 EXP. The EXP for level 2 is 40 EXP. And so on. EXP doubles each level. There will at times be "EXP weeks" in which people receive double the EXP. But that's for later.
<li> If a player dies that night, subtract 5 EXP, giving them 5 EXP because they spent a day, but died. If a player survives, give 5 EXP + the points from what the kills gave. Rendering at least 15 points if they didn't kill any mobs.
<li> Once player reaches level 15, unlock the glass Dome.
<li> At level 50, give access to the warp called "Nexus 1".
<li> Your protection should GROW every 10 levels. Meaning it should increase by around 50% every 10 levels.
</li>
</ul>
<br>
<h3> Mob Squads and Night Raids </h3>
<ul>
<li> Mobs Squads are important. You must override Minecraft's spawning of mobs, and create your own. At the edge of Player X's protection, the following mobs must spawn:
<li> Levels 1 - 10: 1 Creeper and 2 Skeletons.
<li> Levels 11 - 15: 2 Creepers, 3 Skeletons, 2 Zombies.
<li> Levels 16 - 30: 3 Creepers, 5 Spiders, 5 Zombies, 2 Blazes.
<li> Levels 31 - 60: 5 Creepers, 4 Spiders, 8 Zombies, 4 Blazes.
<li> Levels 61 - 100: 10 Creepers, 10 Zombies, 10 Spiders, 2 Blazes.
<li> Remember to make mobs spawn on the edges of the protection area, not in the middle! Also, make sure they don't swim or leave the island.
</li>
</ul>
<br>
<h3> Co Op </h3>
<ul>
<li> You can have up to four people per Isle. Use factions for this.
<li> Use aliases for faction commands. i.e /isle join [name] should be /f join, /isle invite [name] should be /f invite [name] and so on. And of course, /isle list should be /f list.
<li> When someone kills a mob in the party of players on one island, give ALL of the players the EXP for killing the mob. Say Player 1 kills a mob. Players 2, 3, and 4 also get 3 EXP.
<li> If one player dies in a party, subtract 5 from all and force them to execute /kill on themselves.
<li> If one player dies, take away all EXP earned from that night as well.
</li>
</ul>
PVP should be enabled. Players cannot break other players' things. If they swim to another island to PvP and there is a Dome over that island, tough luck for them. They need to find someone who is lvl 15 or up.

DISABLE claiming of land or setting of /f home for people. 

At level 15 give all the players in a party a compass which shows where other players are.

Side Note: We are also utilizing RealisticChat for our chat needs.

Oh, and also create a PointShop plugin. Not only should they get 3 EXP for killing a mob, but 3 Points which they can use to buy items.

Some items have specific effects.

Cobweb - regular effects, lasts 9 minutes when placed.
Glowstone - lasts 2 minutes, drives away mobs in a certain radius of it.







