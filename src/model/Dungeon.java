package model;

import org.sqlite.SQLiteDataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Dungeon generation and behaviours.
 *
 * @author Benjamin Goodman
 * @version 0.9 05/06/2022
 */
public class Dungeon implements Serializable {
	@Serial
	private static final long serialVersionUID = -1522663614213628512L;
	private int[][] myIntDungeon;
	private Room[][] myDungeon;
	private int myHeight;
	private int myWidth;

	private boolean encapsulationActivated;

	private boolean inheritanceActivated;

	private boolean abstractionActivated;

	private boolean polymorphismActivated;

	public static HashMap<String, ArrayList<Float>> monsterstats = new HashMap<String, ArrayList<Float>>();

	private static SaveManager sm;

	private Hero myPlayer;

	/**
	 * Dungeon constructor.
	 *
	 * @param theHeight The height of the dungeon
	 * @param theWidth The width of the dungeon
	 */
	public Dungeon (int theHeight, int theWidth) {
		myHeight = theHeight;
		myWidth = theWidth;
		myIntDungeon = new int[myHeight][myWidth];
		myIntDungeon = generateMaze(myHeight, myWidth, myIntDungeon);
		myDungeon = dungeonOfRooms(myIntDungeon);
		connectDBMonsters();
		placePillars(myDungeon);
		populateDungeonSkeletons(myDungeon);
		populateDungeonEldritch(myDungeon);
		populateDungeonGoblins(myDungeon);
		populateDungeonOverlord(myDungeon);
		populateDungeonOgre(myDungeon);
		populateDungeonPotions(myDungeon);
		populateDungeonPoisonPotions(myDungeon);
		setEncapsulationActivated(false);
		setAbstractionActivated(false);
		setPolymorphismActivated(false);
		setInheritanceActivated(false);
	}

	/**
	 * Generates a maze for the dungeon.
	 *
	 * @param theHeight The height of the maze
	 * @param theWidth The width of the maze
	 * @param theDungeon The dungeon in which the maze is being generated
	 * @return the maze
	 */
	public int[][] generateMaze(int theHeight, int theWidth, int[][] theDungeon) {
	    for (int i = 0; i < theHeight; i++)
	        for (int j = 0; j < theWidth; j++)
	        	theDungeon[i][j] = 1;
	 
	     Random rand = new Random();
	     // r for row, c for column
	     // Generate random r
	     int r = rand.nextInt(theHeight);
	     while (r % 2 == 0) {
	         r = rand.nextInt(theHeight);
	     }
	     // Generate random c
	     int c = rand.nextInt(theWidth);
	     while (c % 2 == 0) {
	         c = rand.nextInt(theWidth);
	     }
	     // Starting cell
	     theDungeon[r][c] = 0;
	 
	     // Allocate the theDungeon with recursive method
	     makeHallways(r, c, theDungeon, theWidth);
	 
	     return theDungeon;
	 }

	/**
	 * Constructs the hallways of the dungeon.
	 *
	 * @param r Rows
	 * @param c Columns
	 * @param theDungeon The dungeon in which the hallways exist
	 * @param theWidth The width of the hallways
	 */
	 public void makeHallways(int r, int c, int[][] theDungeon, int theWidth) {
	     // 4 random directions
	     int[] randDirs = generateRandomDirections();
	     // Examine each direction
	     for (int i = 0; i < randDirs.length; i++) {
	         switch(randDirs[i]){
	         case 1: // Up
	             //Whether 2 cells up is out or not
	             if (r - 2 <= 0)
	                 continue;
	             if (theDungeon[r - 2][c] != 0) {
	                 theDungeon[r-2][c] = 0;
	                 theDungeon[r-1][c] = 0;
	                 makeHallways(r - 2, c, theDungeon, theWidth);
	             }
	             break;
	         case 2: // Right
	             // Whether 2 cells to the right is out or not
	             if (c + 2 >= theWidth - 1)
	                 continue;
	             if (theDungeon[r][c + 2] != 0) {
	                 theDungeon[r][c + 2] = 0;
	                 theDungeon[r][c + 1] = 0;
	                 makeHallways(r, c + 2, theDungeon, theWidth);
	             }
	             break;
	         case 3: // Down
	             // Whether 2 cells down is out or not
	             if (r + 2 >= myHeight - 1)
	                 continue;
	             if (theDungeon[r + 2][c] != 0) {
	                 theDungeon[r+2][c] = 0;
	                 theDungeon[r+1][c] = 0;
	                 makeHallways(r + 2, c, theDungeon, theWidth);
	             }
	             break;
	         case 4: // Left
	             // Whether 2 cells to the left is out or not
	             if (c - 2 <= 0)
	                 continue;
	             if (theDungeon[r][c - 2] != 0) {
	                 theDungeon[r][c - 2] = 0;
	                 theDungeon[r][c - 1] = 0;
	                 makeHallways(r, c - 2, theDungeon, theWidth);
	             }
	             break;
	         }
	     }
	 }
	 
	 /**
	 * Generate an array with random directions 1-4
	 * @return Array containing 4 directions in random order
	 */
	 private int[] generateRandomDirections() {
	      ArrayList<Integer> randoms = new ArrayList<Integer>();
	      for (int i = 0; i < 4; i++)
	           randoms.add(i + 1);
	      Collections.shuffle(randoms);
	      
	      int index = 0;
	      int[] array = new int[randoms.size()];
	      for (int value: randoms) {
	        array[index++] = value;
	      }
     return array;
	 }

	/**
	 * Create Object Dungeon out of integer Dungeon.
	 * @param theDungeon the 2d integer Dungeon
	 * @return 2d array of Rooms
	 */
	private Room[][] dungeonOfRooms(int[][] theDungeon) {
	 Room[][] roomDungeon = new Room[this.myIntDungeon.length][this.myIntDungeon[0].length];
	 
	 for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
		 for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] == 1) {
					roomDungeon[i][j] = new RoomWall();
				} else if (theDungeon[i][j] == 0) {
					roomDungeon[i][j] = new RoomPlain();
				}
	 		}
 		}
	 return roomDungeon;
	 }

	/**
	 * Method for polling monster stats from SQLite database.
	 *
	 * Credit to Manny & Bryce for helping me.
	 */
	private void connectDBMonsters() {
		 SQLiteDataSource ds = null;

		 try {
			 ds = new SQLiteDataSource();
			 ds.setUrl("jdbc:sqlite:monsterDB.db");
		 } catch (Exception e) {
			 e.printStackTrace();
			 System.exit(0);
		 }

		 System.out.println("Opened database successfully!");
		 String query = "SELECT * FROM monster_table";

		 try (Connection conn = ds.getConnection();
			  Statement stmt = conn.createStatement(); ) {

			 ResultSet rs = stmt.executeQuery(query);
			 //walk through each 'row' of results, grab data by column/field name
			 while (rs.next()) {
				 ArrayList<Float> stats = new ArrayList<>();
				 String type = rs.getString("TYPE");
				 float abilitydamage = rs.getFloat("ABILITYDMG");
				 float maxhp = rs.getFloat("MAXHP");
				 float admax = rs.getFloat("ADMAX");
				 float admin = rs.getFloat("ADMIN");
				 float attackchance = rs.getFloat("ACHANCE");
				 float abilitychance = rs.getFloat("ABILITYCHANCE");
				 float healchance = rs.getFloat("HEALCHANCE");
				 stats.add(abilitydamage);
				 stats.add(maxhp);
				 stats.add(admax);
				 stats.add(admin);
				 stats.add(attackchance);
				 stats.add(abilitychance);
				 stats.add(healchance);
				 monsterstats.put(type, stats);
 			 }


		 } catch ( SQLException e ) {
			 e.printStackTrace();
			 System.exit( 0 );
		 }
	 }

	/**
	 * Places the hero in at a random starting point in the dungeon.
	 *
	 * @param theHero The hero being placed
	 */
	public void placeHero(Hero theHero) {
		 int i = ThreadLocalRandom.current().nextInt(getMyWidth());
		 int j = ThreadLocalRandom.current().nextInt(getMyHeight());

		 while (!(this.getMyDungeon()[j][i] instanceof RoomPlain)) {
			 i = ThreadLocalRandom.current().nextInt(getMyWidth());
			 j = ThreadLocalRandom.current().nextInt(getMyHeight());
		 }

		 ((RoomPlain) this.getMyDungeon()[j][i]).addOccupant(theHero);
		 theHero.setMyX(j);
		 theHero.setMyY(i);
	 }

	/**
	 * Places the pillars in the dungeon.
	 *
	 * @param theDungeon The dungeon in which the pillars are being placed
	 */
	private void placePillars(Room[][] theDungeon) {
		 theDungeon[1][1] = new RoomOOPPolymorphism();
		 theDungeon[33][1] = new RoomOOPAbstraction();
		 theDungeon[33][73] = new RoomOOPInheritance();
		 theDungeon[1][73] = new RoomOOPEncapsulation();
	}

	/**
	 * Populates the dungeon with skeletons.
	 *
	 * @param theDungeon The dungeon in which the skeletons are being placed
	 */
	private void populateDungeonSkeletons(Room[][] theDungeon) {
		final float SKELLY_CHANCE = (float) 0.02;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterSkeleton skelly = new MonsterSkeleton("skeleton", this);
					if(SKELLY_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						((RoomPlain) theDungeon[i][j]).addOccupant(skelly);
					}
				}
			}
		}
	}

	/**
	 * Populates the dungeon with goblins.
	 *
	 * @param theDungeon The dungeon in which the goblins are being placed
	 */
	private void populateDungeonGoblins(Room[][] theDungeon) {
		final float GOBBO_CHANCE = (float) 0.02;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterGoblin goblin = new MonsterGoblin("gobbo", this);
					if(GOBBO_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						((RoomPlain) theDungeon[i][j]).addOccupant(goblin);
					}
				}
			}
		}
	}

	/**
	 * Populates the dungeon with eldritch monsters.
	 *
	 * @param theDungeon The dungeon in which the eldritch monsters are being placed
	 */
	private void populateDungeonEldritch(Room[][] theDungeon) {
		final float ELDY_CHANCE = (float) 0.005;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterEldritch eldritch = new MonsterEldritch("skeleton", this);
					if(ELDY_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						((RoomPlain) theDungeon[i][j]).addOccupant(eldritch);
					}
				}
			}
		}
	}

	/**
	 * Populated the dungeon with overlords.
	 *
	 * @param theDungeon The dungeon in which the overlords are being placed
	 */
	private void populateDungeonOverlord(Room[][] theDungeon) {
		final float OVERLORD_CHANCE = (float) 0.0008;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterOverlord overlord = new MonsterOverlord("overlord", this);
					if(OVERLORD_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						((RoomPlain) theDungeon[i][j]).addOccupant(overlord);
					}
				}
			}
		}
	}

	/**
	 * Populates the dungeon with ogres.
	 *
	 * @param theDungeon The dungeon in which the ogres are being placed
	 */
	private void populateDungeonOgre(Room[][] theDungeon) {
		final float OGRE_CHANCE = (float) 0.0008;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterOgre ogre = new MonsterOgre("ogre", this);
					if(OGRE_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						((RoomPlain) theDungeon[i][j]).addOccupant(ogre);
					}
				}
			}
		}
	}

	/**
	 * Populates the dungeon with potions.
	 *
	 * @param theDungeon The dungeon in which the potions are being placed
	 */
	 private void populateDungeonPotions(Room[][] theDungeon) {
	 final float POTION_ROOM_CHANCE = (float) 0.03;

	 for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
		 for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain) {
					if(POTION_ROOM_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						theDungeon[i][j] = new RoomPotion();
					}
				}
	 		}
 		}
	 }

	/**
	 * Populates the dungeon with poison potions.
	 *
	 * @param theDungeon The dungeon in which the poison potions are being placed
	 */
	private void populateDungeonPoisonPotions(Room[][] theDungeon) {
		final float POTION_ROOM_CHANCE = (float) 0.005;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain) {
					if(POTION_ROOM_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						theDungeon[i][j] = new RoomPoisonPotion();
					}
				}
			}
		}
	}
	 
	 @Override
	 public String toString() {
	 String str = "";
	 
	 for (int i = 0; i <= (this.myDungeon.length - 1); i++) {
		 for (int j = 0; j <= (this.myDungeon[0].length - 1); j++) {
			 if (myDungeon[i][j] instanceof RoomPlain) {
				 if (((RoomPlain) myDungeon[i][j]).hasOccupant()) {
					 str += ((RoomOccupiable) myDungeon[i][j]).getMyOccupant().getMyCharacterRepresentation();
				 } else {
					 str += ' ';
				 }
			 } else if (myDungeon[i][j] instanceof RoomWall) {
				 str += '#';
			 } else if (myDungeon[i][j] instanceof RoomPotion) {
				 str += "P";
			 } else if (myDungeon[i][j] instanceof RoomPoisonPotion) {
				 str += "p";
			 }
		   }
		 str += '\n';
	 	}
	 return str;
	}

	public Dungeon getDungeon() {
		 return this;
	}

	public int[][] getMyIntDungeon() {
		return myIntDungeon;
	}

	public Room[][] getMyDungeon() {
		return myDungeon;
	}

	public int getMyHeight() {
		return myHeight;
	}

	public int getMyWidth() {
		return myWidth;
	}

	public Hero getMyPlayer() {
		return myPlayer;
	}

	public void setMyPlayer(Hero myPlayer) {
		this.myPlayer = myPlayer;
	}

	public boolean isEncapsulationActivated() {
		return encapsulationActivated;
	}

	public void setEncapsulationActivated(boolean encapsulationActivated) {
		this.encapsulationActivated = encapsulationActivated;
	}
	public boolean isPolymorphismActivated() {
		return polymorphismActivated;
	}

	public void setPolymorphismActivated(boolean polymorphismActivated) {
		this.polymorphismActivated = polymorphismActivated;
	}

	public boolean isInheritanceActivated() {
		return inheritanceActivated;
	}

	public void setInheritanceActivated(boolean inheritanceActivated) {
		this.inheritanceActivated = inheritanceActivated;
	}

	public boolean isAbstractionActivated() {
		return abstractionActivated;
	}

	public void setAbstractionActivated(boolean abstractionActivated) {
		this.abstractionActivated = abstractionActivated;
	}

}
 