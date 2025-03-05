package practical.assignment1.Problem3;

import java.awt.Point;

public class MazeSolver {
	
	char[][] maze;
	final int [][] blueprint;
	
	Point start;
	Point end;
	int counter = 0; // steps

	/*
	 * constructor
	 */
	public MazeSolver(char[][] maze, int [][] blueprint)
	{
		this.maze = maze;
		this.blueprint = blueprint;
	}
	
	/*
	 * get starting node coordinates (x, y)
	 */
	public Point getStartCoordinates() throws Exception
	{
		int index = 0;
		int row = 0;
		boolean flag = false;
		for(int i = 0; i < blueprint.length; i++)
		{
			// better check before and after, cauze paranoia
			if(flag)
				break;
			for(int j = 0; j < blueprint[i].length; j++)
			{
				// check top of maze for entrance
				if(blueprint[0][j] == 0) {
					index = j;
					row = i;
					flag = true;
				}
				// check left side of maze for entrance
				if(blueprint[i][0] == 0) {
					index = 0;
					row = i;
					flag = true;
				}
				if(flag)
					break;
			}
			// better check before and after, cauze paranoia
			if(flag)
				break;
		}
		if(!flag)
			throw new Exception("The maze has no entrance!"); // the entrance can't be at the right side or bottom of the maze
		return new Point(row, index);
	}
	
	/*
	 * get ending node coordinates (x, y)
	 */
	public Point getEndCoordinates() throws Exception
	{
		int index = 0;
		int row = 0;
		boolean flag = false;
		for(int i = 0; i < blueprint.length; i++)
		{
			// better check before and after, cauze paranoia
			if(flag)
				break;
			for(int j = 0; j < blueprint[i].length; j++)
			{
				// check bottom of maze for exit
				if(blueprint[blueprint.length - 1][j] == 0) {
					index = j;
					row = blueprint.length - 1;
					flag = true;
				}
				// check right side of maze for exit
				if(blueprint[i][blueprint[i].length - 1] == 0) {
					index = blueprint[i].length - 1;
					row = i;
					flag = true;
				}
				if(flag)
					break;
			}
			// better check before and after, cauze paranoia
			if(flag)
				break;
		}
		if(!flag)
			throw new Exception("The maze has no exit!"); // same logic as with entrance
		return new Point(row, index);
	}
	
	/*
	 * get number of steps made to solve maze
	 */
	public int getCounter()
	{
		return counter;
	}
	
	/*
	 * locates the start node and end node for the maze and saves them into MazeSolver's global variables
	 */
	public void locateStartandExit()
	{
		try {
			start = this.getStartCoordinates();
			end = this.getEndCoordinates();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// starting point 
	public boolean startSolving() {
		if (solveMaze(start.x, start.y)) {
			maze[start.x][start.y] = '·'; // ascii 250 · path
			maze[end.x][end.y] = 'X'; // endpoint 'X' just like a pirate
			return true;
		}
		else {
			maze[start.x][start.y] = '·'; // ascii 250 · path
			return false;
		}
	}
	
	// Backtracking method
	public boolean solveMaze (int x, int y) {
		
		counter++;
		
		// TODO explore dynamic printout
		// print maze here for impressions
		
		/** End node **/
		if ((x == end.x) && (y == end.y)) {
			return true; // done!
		}
		
		/** Reject case - we hit a wall or our path **/
		if (blueprint[x][y] == 1 || maze[x][y] == '·') { // ascii 178 ▓ walls || ascii 250 · path 
			return false;
		}
		
		/** Backtracking **/
		
		// Mark this location as part of our path
		maze[x][y] = '·'; // ascii 250 · path
		boolean result;	
		
		// Try to go Left
		if((y != 0)) { // Don't try to go Left if y == 0... duh! There is nothing behind the horizon! The Earth is flat!
			result = solveMaze(x, y - 1);
			if (result) { return true; }		
		}
		
		// Try to go Up
		if((x != 0)) { // Don't try to go Up if x == 0... duh! There is nothing behind the horizon! The Earth is flat!
			result = solveMaze(x - 1, y);
			if (result) { return true; }
		}
		
		// Try to go Down
		result = solveMaze(x + 1, y);
		if (result) { return true; }
		
		// Try to go Right
		result = solveMaze(x, y + 1);
		if (result) { return true; }
		
				


		// Hecking bamboozle
		// Revert changes
		maze[x][y] = ' ';
			
		// Fuck, Go back!
		return false;
	}
}
