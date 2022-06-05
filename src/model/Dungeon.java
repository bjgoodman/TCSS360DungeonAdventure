package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Algorithm taken from:
 * 
 * http://www.migapro.com/depth-first-search/
 * @author Benji
 */
public class Dungeon implements Serializable {
	@Serial
	private static final long serialVersionUID = -1522663614213628512L;
	private int[][] myIntDungeon;
	private Room[][] myDungeon;
	private int myHeight;
	private int myWidth;

	private ArrayList<Monster> monsterList = new ArrayList<>();
	private boolean encapsulationActivated;

	private boolean inheritanceActivated;

	private boolean abstractionActivated;

	private boolean polymorphismActivated;
	
	public Dungeon (int theHeight, int theWidth) {
		myHeight = theHeight;
		myWidth = theWidth;
		myIntDungeon = new int[myHeight][myWidth];
		myIntDungeon = generateMaze(myHeight, myWidth, myIntDungeon);
		myDungeon = dungeonOfRooms(myIntDungeon);
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

	private void placePillars(Room[][] theDungeon) {
		 theDungeon[1][1] = new RoomOOPPolymorphism();
		 theDungeon[33][1] = new RoomOOPAbstraction();
		 theDungeon[33][73] = new RoomOOPInheritance();
		 theDungeon[1][73] = new RoomOOPEncapsulation();
	}

	private void populateDungeonSkeletons(Room[][] theDungeon) {
		final float SKELLY_CHANCE = (float) 0.02;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterSkeleton skelly = new MonsterSkeleton("skeleton", this);
					if(SKELLY_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						monsterList.add(skelly);
						((RoomPlain) theDungeon[i][j]).addOccupant(skelly);
					}
				}
			}
		}
	}

	private void populateDungeonGoblins(Room[][] theDungeon) {
		final float GOBBO_CHANCE = (float) 0.02;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterGoblin goblin = new MonsterGoblin("gobbo", this);
					if(GOBBO_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						monsterList.add(goblin);
						((RoomPlain) theDungeon[i][j]).addOccupant(goblin);
					}
				}
			}
		}
	}

	private void populateDungeonEldritch(Room[][] theDungeon) {
		final float ELDY_CHANCE = (float) 0.005;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterEldritch eldritch = new MonsterEldritch("skeleton", this);
					if(ELDY_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						monsterList.add(eldritch);
						((RoomPlain) theDungeon[i][j]).addOccupant(eldritch);
					}
				}
			}
		}
	}

	private void populateDungeonOverlord(Room[][] theDungeon) {
		final float OVERLORD_CHANCE = (float) 0.0008;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterOverlord overlord = new MonsterOverlord("overlord", this);
					if(OVERLORD_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						monsterList.add(overlord);
						((RoomPlain) theDungeon[i][j]).addOccupant(overlord);
					}
				}
			}
		}
	}

	private void populateDungeonOgre(Room[][] theDungeon) {
		final float OGRE_CHANCE = (float) 0.0008;

		for (int i = 0; i <= (this.myIntDungeon.length - 1); i++) {
			for (int j = 0; j <= (this.myIntDungeon[0].length - 1); j++) {
				if (theDungeon[i][j] instanceof RoomPlain && !((RoomPlain) theDungeon[i][j]).hasOccupant()) {
					MonsterOgre ogre = new MonsterOgre("ogre", this);
					if(OGRE_CHANCE >= ThreadLocalRandom.current().nextFloat()) {
						monsterList.add(ogre);
						((RoomPlain) theDungeon[i][j]).addOccupant(ogre);
					}
				}
			}
		}
	}

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
			 if (myDungeon[i][j] instanceof RoomOccupiable) {
				 if (((RoomOccupiable) myDungeon[i][j]).hasOccupant()) {
					 str += ((RoomOccupiable) myDungeon[i][j]).getMyOccupant().getMyCharacterRepresentation();
				 } else {
					 str += ' ';
				 }
			 } else if (myDungeon[i][j] instanceof RoomWall) {
				 str += '?';
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

	public ArrayList<Monster> getMonsterList() {
		return monsterList;
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
 