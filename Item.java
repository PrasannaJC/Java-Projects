// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Prasanna Chandrasekar
// RESOURCES: Canvas

package snake;
/**
 * This is the Item class for the SnakeApp project.
 * Creates new Item objects.
 * @author pchandrasekar@unomaha.edu
 *
 */
public class Item
{
	/**
	 * Static final value stored in integer TWENTY_FIVE of 25.
	 */
	private static final int TWENTY_FIVE = 25;
		
	/**
	 * The integer that stores the x coordinate of the object.
	 */
	private int xCord;
	/**
	 * The integer that stores the y coordinate of the object.
	 */
	private int yCord;
		
	/**
	 * Sets the values of (25,25) to the integers xCord and yCord.
	 * base values set.
	 */
	public Item()
	{
		xCord = TWENTY_FIVE;
		yCord = TWENTY_FIVE;
	}
	
	/**
	 * Sets the coordinates of the object based on the users input 
	 * if the input meets the criteria of above zero.
	 * @param itemXIn the x-coordinate value inputted by the user
	 * @param itemYIn the y-coordinate value inputted by the user
	 */
	
	public Item(int itemXIn, int itemYIn)
	{
		if (itemXIn >= 0 && itemYIn >= 0)
		{
			xCord = itemXIn;
			yCord = itemYIn;
		}
	}
	
	/**
	 * Retrieves the x coordinate value. 
	 * @return the x-coordinate value stored in xCord
	 */
	
	public int getX()
	{
		return xCord;
	}

	/**
	 * Retrieves the y coordinate value. 
	 * @return the y-coordinate value stored in xCord
	 */
	
	public int getY()
	{
		return yCord;
	}
	/**
	 * Sets a new location for the item as long as both values are valid (>=0).
	 * @param itemXIn the supposed new X value for the Item.
	 * @param itemYIn the supposed new Y value for the Item.
	 */
	public void setNewLocation(int itemXIn, int itemYIn)
	{
		if (itemXIn >= 0 && itemYIn >= 0)
		{
			xCord = itemXIn;
			yCord = itemYIn;
		}
	}
	/**
	 * This method outputs the String illustrating the location of the Item.
	 * @return output The String output for the method.
	 */
	public java.lang.String toString()
	{
		String output = "The item is located at position (" + xCord + ", " + yCord + ")";
		return output;		
	}
	
	
}
