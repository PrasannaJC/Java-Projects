// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Prasanna Chandrasekar
// RESOURCES: CANVAS

package snake;
/**
 * This class defines the Snake object for use in the Snake game.
 * @author pchandrasekar@unomaha.edu
 *
 */
public class Snake
{
	/**
	 * Static final value stored in integer TWENTY of 25.
	 */
	private static final int TWENTY = 20;
	/**
	 * Static final value stored in integer FTHOU of 5000.
	 */
	private static final int FTHOU = 5000;
	/**
	 * The variable storing the direction of the head of the snake.
	 */
	private Direction head;
	/**
	 * The integer that stores the length of the snake.
	 */
	private int sLength;
	/**
	 * The integer array for the snake grid and its position.
	 */
	private int[][] arrayGrid;

	/**
	 * The default constructor for the Snake.
	 * It should do the same as the specific constructor except that it will use the value. 
	 * of 20 as the Default value for both the X and Y valuesfor the head as the parameters.
	 */
	public Snake()
	{
		/*
		arrayGrid = new int[FTHOU][2];
		head = Direction.DOWN;
		sLength = 4;
		xHeadCord = TWENTY;
		arrayGrid[0][0] = xHeadCord;
		yHeadCord = TWENTY;
		arrayGrid[0][1] = yHeadCord;
		int j = 1;
		for (int i = 1; i < sLength; i++)
		{
			arrayGrid[i][0] = TWENTY;
			arrayGrid[i][1] = TWENTY - j;
			j++;
		}*/
		
		this(TWENTY, TWENTY);
	
	}
	
	/**
	 * The specific constructor for the Snake.
	 * The snake 2d array should be initialized with a size of [5000][2].
	 * The snake should have its head's X and Y values set.
	 * The snake should then form out of the head to an initial length of 4. 
	 * @param headXIn The X coordinate for the head.
	 * @param headYIn The Y coordinate for the head.
	 */
	public Snake(int headXIn, int headYIn)
	{
		arrayGrid = new int[FTHOU][2];
		int xHeadCord;
		int yHeadCord;
		head = Direction.DOWN;
		sLength = 4;
		xHeadCord = headXIn;
		yHeadCord = headYIn;
		arrayGrid[0][0] = xHeadCord;
		arrayGrid[0][1] = yHeadCord;
		//int a, b, c;
		int newX = headXIn;
		int newY = headYIn;
/*
		for (a = 1; a < headYIn; a++)
		{
			newY -= 1;
			arrayGrid[a][0] = headXIn;
			arrayGrid[a][1] = newY;
		}
		if (yHeadCord - sLength < 0 && sLength - xHeadCord > 0)
		{
			for (b = 1; b < headXIn; b++)
			{
				newX -= 1;
				arrayGrid[a][0] = newX;
				arrayGrid[a][1] = newY;
				a++;
			}
			if (xHeadCord - sLength < 0)
			{
				for (c = a; c < sLength; c++)
				{
					newY += 1;
					arrayGrid[c][0] = newX;
					arrayGrid[c][1] = newY;
					//a++;
				}
			}
		}
		*/
		for (int i = 1; i < sLength; i++)
		{
			if (arrayGrid[i - 1][1] != 0)
			{
				newY--;
				arrayGrid[i][0] = newX;
				arrayGrid[i][1] = newY;
			}
			
			else if (arrayGrid[i - 1][0] != 0)
			{
				newX--;
				arrayGrid[i][0] = newX;
				arrayGrid[i][1] = newY;
			}
			/*
			else if (arrayGrid[i - 1][0] > 1 && arrayGrid[i - 1][1] <= 1)
			{
				newX -= 1;
				arrayGrid[i][0] = newX;
				arrayGrid[i][1] = newY;
			}
			*/
			else
			{
				newY += 1;
				arrayGrid[i][0] = newX;
				arrayGrid[i][1] = newY;
				//newX += 1;
			}
		}
	}
	
	/**
	 * Returns the current X value for the head of the Snake.
	 * @return The current X value for the head of the Snake.
	 */
	public int getHeadX()
	{
		return arrayGrid[0][0];
	}
	
	/**
	 * Returns the current Y value for the head of the Snake.
	 * @return The current Y value for the head of the Snake.
	 */
	public int getHeadY()
	{
		return arrayGrid[0][1];
	}
	
	/**
	 * Changes the Direction of the Snake, except if the new Direction isdirectly opposite of the current one.
	 * @param dirIn the Direction that the Snake is trying to change to be facing.
	 */
	public void changeDir(Direction dirIn)
	{
		if (head == Direction.UP && dirIn != Direction.DOWN)
		{
			head = dirIn;
		}
		if (head == Direction.DOWN && dirIn != Direction.UP)
		{
			head = dirIn;
		}
		if (head == Direction.LEFT && dirIn != Direction.RIGHT)
		{
			head = dirIn;
		}
		if (head == Direction.RIGHT && dirIn != Direction.LEFT)
		{
			head = dirIn;
		}
	}
	
	/**
	 * The current Direction of the Snake.
	 * @return The current Direction of the Snake.
	 */
	public Direction getDirection()
	{
		return head;
	}
	
	/**
	 * The current length value of the Snake.
	 * @return The current length value of the Snake.
	 */
	public int getLength()
	{
		return sLength;
	}
	
	/**
	 * Returns the current Snake 2d array.
	 * @return the current Snake 2d array.
	 */
	public int[][] getSnake()
	{
		return arrayGrid;
	}
	
	/**
	 * Increases the current length of the Snake by 1 and grows the snake.
	 * This means that it also sets the newly added part of the tail (n)
	 *  to thevalue of the previous tail (n-1) values in the Snake.
	 */
	public void increaseLength()
	{
		
		arrayGrid[sLength][0] = arrayGrid[sLength - 1][0];
		arrayGrid[sLength][1] = arrayGrid[sLength - 1][1];
				// also increase the tail length position
		sLength += 1;
	}
	
	/**
	 * The move method should move the Snake forward one space in the current Direction.
	 */
	public void move()
	{
		int[][] dummyArray = new int[FTHOU][2];
		for (int z = 0; z < sLength; z++)
		{
			dummyArray[z][0] = arrayGrid[z][0];
			dummyArray[z][1] = arrayGrid[z][1];
		}
		
		for (int j = sLength - 1; j > 0; j--)
		{
			arrayGrid[j][0] = dummyArray[j - 1][0];
			arrayGrid[j][1] = dummyArray[j - 1][1];	
		}
		if (head == Direction.UP)
		{
			
			arrayGrid[0][1] -= 1;
		}
		if (head == Direction.DOWN)
		{
			
			arrayGrid[0][1] += 1;
		}
		if (head == Direction.LEFT)
		{
			
			arrayGrid[0][0] -= 1;
		}
		if (head == Direction.RIGHT)
		{
			
			arrayGrid[0][0] += 1;
		}
		
	}
	
	/**
	 * Determines if the head of the Snake has hit another part of the Snake.
	 * @return true if the snake hits itself.
	 */
	public boolean hitSelf()
	{
		boolean output = false;
		for (int i = 1; i < sLength; i++)
		{
			if (arrayGrid[i][0] == arrayGrid[0][0] && arrayGrid[i][1] == arrayGrid[0][1])
			{
				output = true;
			}	
		}
		return output;
	}
	/*
	public static void main(String[] args)
	{
		Snake tester = new Snake(2,2);
		System.out.println(tester.getSnake());
		
	}
	*/
	
}

