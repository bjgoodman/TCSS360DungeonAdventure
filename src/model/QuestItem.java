/* QuestItem.java */

package model;

/**
 * characters receive quest items within Dungeon Adventure
 * 
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public abstract class QuestItem extends Item {

	/**
	 * Solidifies the name of the quest item
	 * 
	 * @param theItemName the name of the item
	 */
	public QuestItem(String myItemName) {
		super(myItemName);
	}

	/**
	 * Tom's code review notes (05/20/22)
	 * - needs ability to done in subclass
	 * - if not, does not follow liskov's substitution
	 * - attack abilities should be more divided, abilities should not rely on outside methods
	 * 		- hook methods -> informed by Tom but do not do
	 * 		- https://www.google.com/search?client=safari&rls=en&q=hook+method+java&ie=UTF-8&oe=UTF-8
	 * - need a method called "apply damage" -> much better design
	 * - parent classes -> never make mention to children from parent classes
	 * 		- (bc we don't know what they will look like till they exist)
	 * - recursion should be called "traversed dungeon/place rooms/potions" in dungeon making class that Ben referenced from a website
	 * 
	 */

}
