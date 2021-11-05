// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Prasanna Chandrasekar
// RESOURCES: CANVAS

package snake;

import java.util.Random;
/**
 * This class defines the Level for use in the Snake game.
 * It will control major portions of the game like updating the Snake and.
 * Item positions and determining when the game has been lost.
 * @author Prasanna
 *
 */
public class Level
{
	/**
	 * GameState Object gState created.
	 */
	private GameState gState;
	/**
	 * Snake Object snakeOne created.
	 */
	private Snake snakeOne;
	/**
	 * Item Object itemOne created.
	 */
	private Item itemOne;
	/**
	 * 2D array gameMap for the total snake playable area.
	 */
	private int[][] gameMap;
	/**
	 * Integer that stores the width of the 2d array gameMap.
	 */
	private int width;
	/**
	 * Integer that stores the height of the 2d array gameMap.
	 */
	private int height;
	/**
	 * random number generator variable.
	 */
	private Random rand;
	
	/**
	 * Method that starts the game and sets the coordinate range of the gameMap.
	 * @param widthIn The input width for the gameMap.
	 * @param heightIn The input height for the gameMap.
	 * @param randIn The random number generator input.
	 */
	
	public Level(int widthIn, int heightIn, java.util.Random randIn)
	{
		gState = GameState.PLAYING;
		snakeOne = new Snake();
		itemOne = new Item();
		width = widthIn;
		height = heightIn;
		rand = randIn;
		gameMap = new int[height][width];
		//this.generateMap();
	}
	
	/**
	 * Generates the 2-dimensional map of the game area.
	 * Sets coordinate to 0 for nothing, 1 for snake, -1 for item.
	 */
	public void generateMap()
	{
		
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				gameMap[i][j] = 0;
			}
		}
		
		for (int k = 0; k < snakeOne.getLength(); k++)
		{
			int sY = snakeOne.getSnake()[k][1];
			int sX = snakeOne.getSnake()[k][0];
			gameMap[sY][sX] = 1;
		}
		
		for (int x = 0; x < height; x++)
		{
			for (int y = 0; y < width; y++)
			{
				if (y == itemOne.getX() 
						&& x == itemOne.getY() && gameMap[x][y] != 1)
				{
					gameMap[x][y] = -1;
				}
			}
		}
	}
	
	/**
	 * Returns the current GameState.
	 * @return gState the current GameState.
	 */
	public GameState getGameState()
	{
		return gState;
	}
	
	
	/**
	 * Returns the current Item.
	 * @return itemOne the current Item.
	 */
	public Item getItem()
	{
		//this.generateMap();
		return itemOne;
	}
	
	
	/**
	 * Returns the current 2d array map.
	 * @return gmeMap the current 2d array map.
	 */
	public int[][] getMap()
	{
		//this.generateMap();
		return gameMap;
	}
	
	
	/**
	 * Returns the current Snake.
	 * @return snakeOne the current Snake.
	 */
	public Snake getSnake()
	{
		//this.generateMap();
		return snakeOne;
	}
	
	
	/**
	 * Updates the snake by one step.
	 */
	public void updateOneStep()
	{
	
		snakeOne.move();
		
		if (snakeOne.hitSelf() || snakeOne.getHeadX() >= width
				|| snakeOne.getHeadY() >= height || snakeOne.getHeadX() < 0 || snakeOne.getHeadY() < 0)
		{
			gState = GameState.LOST;
		}
		else
		{
			this.generateMap();
		}
		if (snakeOne.getHeadX() == itemOne.getX() && snakeOne.getHeadY() == itemOne.getY())
		{
			snakeOne.increaseLength();
			//this.generateMap();
			int yC, xC;
			do
			{
				xC = rand.nextInt(width);
				yC = rand.nextInt(height);
			} while (gameMap[yC][xC] == 1);
			itemOne.setNewLocation(xC, yC);
			//this.generateMap();
		}		
	}
	
	
	
}
