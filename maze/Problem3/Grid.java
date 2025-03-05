package practical.assignment1.Problem3;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	// don't even ask
	String [] grid_blueprint; // file input
	List<int[]> grid_template = new ArrayList<>(); // used for reference only
	
	char [][] maze; // the dynamic grid
	final int [][] maze_blueprint; // should be of final "const"
	
	// deprecated
	int height;
	int length;
	
	/* 
	 * This is more meaningful...
	 * Refer to this comment
	 * 
	 * ascii 178 ▓ walls
	 * ascii 250 · chosen path
	 * ascii 120 [x] start\end nodes (maybe) (perhaps) only end node
	 * ascii 32  [spacebar] empty space
	 * 
	 * ▓ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
	 * ▓    ▓    ▓       ▓	
	 * ▓ ▓▓ ▓ ▓▓ ▓ ▓▓▓▓▓ ▓
	 * ▓ ▓  ▓  ▓ ▓ ▓ ▓   ▓
	 * ▓ ▓▓▓▓▓ ▓     ▓ ▓▓▓
	 * ▓  ▓  ▓ ▓▓▓▓ ▓▓ ▓ ▓
	 * ▓▓ ▓ ▓▓    ▓▓▓▓ ▓ ▓
	 * ▓    ▓   ▓  ▓     ▓
	 * ▓ ▓▓▓▓ ▓ ▓▓▓▓ ▓▓▓▓▓
	 * ▓      ▓   ▓      ▓
	 * ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ▓▓▓
	 * 
	 */
	
	/*
	 * WARNING!
	 * A mental retard coded this section
	 */
	public Grid(String[] grid)
	{
//////////////////////////////////////////////////////////////////////////////
//							CRUTCH CODE										//	
//										//======================||			//
//									,///  			||    	    ||			//
//		[===========================<{{        		||       	||			//
//									'\\\ 			||     	  	||			//
//										\\======================||			//   
//																			//
//////////////////////////////////////////////////////////////////////////////
		int tempo[][] = null;
		try {
			grid_blueprint = grid;
			
			// replace this code
			for(int i = 0; i < grid_blueprint.length; i++) 
			{	
				/*
				 * whoever made Problem 3 pulled a sneaky one on us...
				 * file contains 2 empty lines after the maze
				 * i bet it was Darth Vorster
				 * this 'if' removes the "null" crap out of muh.. arrays!!!
				 * "Make Arrays Great Again!" (c) Donald Trump
				 */
				if(!grid_blueprint[i].equals(""))
				{
					final int[] line = grid_blueprint[i].chars() // it works on MAGIC DON'T TOUCH IT!!!
						    .map(x -> x - '0')
						    .toArray();
					grid_template.add(line); // plz work
				}
			}
			
			tempo = grid_template.toArray(new int[grid_template.size()][grid_template.get(0).length]); // look at that...
			
			maze = new char [tempo.length][tempo[0].length];
			
			for(int i = 0; i < tempo.length; i++)
			{
				for(int j = 0; j < tempo[i].length; j++)
				{
					if(tempo[i][j] == 0)
						maze[i][j] = ' '; // ascii 32  [spacebar] empty space
					else if(tempo[i][j] == 1)
						maze[i][j] = '▓'; // ascii 178 ▓ wall
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("Someting wong! +\n Read dis shit..\n" + e.getMessage());
			e.printStackTrace();
		}
		
		 maze_blueprint = tempo;
	}
	
	/*
	 * print the grid
	 */
	public void printMaze()
	{
		for(int i = 0; i < maze.length; i++)
		{
			for(int j = 0; j < maze[i].length; j++)
			{
				System.out.print(maze[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	// get
	public char[][] getMaze() {
		return maze;
	}
	
	public int[][] getMazeBlueprint()
	{
		return maze_blueprint.clone(); // could be null value, check if not null
	}
}
