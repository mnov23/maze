package practical.assignment1;

import java.io.IOException;

import practical.assignment1.Problem3.FileExtractor;
import practical.assignment1.Problem3.Grid;
import practical.assignment1.Problem3.MazeSolver;

public class Driver {
	public static void main(String... args) throws IOException, InterruptedException, Exception {

		System.out.println("Super Maze Solver 3000");
		FileExtractor fe = new FileExtractor();
		String[] strings = fe.get();
		Grid grid = new Grid(strings);
		MazeSolver ms;
		
		System.out.println("\n\n\n\n\n\nAll loaded successfully!");
		
		// moving on...
		System.out.println("Here is the loaded maze: \n");
		grid.printMaze();
		
		System.out.println("\nPress \"ENTER\" to solve...");
		try {
			Driver.getch();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// was supposed to clear
		Driver.clearConsole(); // not what I expected... DAMN IT!
		
		
		// TODO
		// solve the grid
		ms = new MazeSolver(grid.getMaze(), grid.getMazeBlueprint());
		
		// locate start and exit
		ms.locateStartandExit();
		
		// Start solving the maze from start
		if(ms.startSolving())
			System.out.println("Maze solved!\n");
		else
			System.out.println("No solution found. Sorry\n");
		
		// reflect on what happened
		grid.printMaze();
	
		// end of program
		System.out.println("\nNumber of steps made to solve this maze: " + ms.getCounter());
		System.out.println("end");
		System.exit(0);
	}
	
	

	/*
	 * method to clear console, coz fuck Java. C# is superior.
	 */
	private static void clearConsole() throws IOException, InterruptedException
	{
		try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    	// as if...
	    	// TODO
	    	//  NO!
	    }
	}
	
	/*
	 * another method that I wouldn't need in C#...
	 */
	public static void getch() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "pause > null").inheritIO().start().waitFor();
    }    
}
