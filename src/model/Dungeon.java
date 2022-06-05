package model;

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
public class Dungeon {
	private int[][] myIntDungeon;
	private Room[][] myDungeon;
	private int myHeight;
	private int myWidth;
	
	public Dungeon (int theHeight, int theWidth) {
		myHeight = theHeight;
		myWidth = theWidth;
		
		myIntDungeon = new int[myHeight][myWidth];
		myIntDungeon = generateMaze(myHeight, myWidth, myIntDungeon);
		myDungeon = dungeonOfRooms(myIntDungeon);
		placePillars(myDungeon);
		populateDungeonPotions(myDungeon);
		populateDungeonPoisonPotions(myDungeon);

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

	 private void populateDungeonPotions(Room[][] theDungeon) {
	 final float POTION_ROOM_CHANCE = (float) 0.02;

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
		final float POTION_ROOM_CHANCE = (float) 0.01;

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
				 if (((RoomOccupiable) myDungeon[i][j]).getMyOccupant() instanceof Hero) {
					 str += ((RoomOccupiable) myDungeon[i][j]).getMyOccupant().getMyCharacterRepresentation();
				 } else {
					 str += ' ';
				 }
			 } else if (myDungeon[i][j] instanceof RoomWall) {
				 str += '#';
			 } else if (myDungeon[i][j] instanceof RoomPotion) {
				 str += "P";
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
}
 