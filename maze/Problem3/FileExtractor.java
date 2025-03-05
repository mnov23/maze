package practical.assignment1.Problem3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileExtractor {
	String filepath = "./src/practical/assignment1/problem3/maze.txt"; // please change filepath if you change the packages
	File file;
	FileReader fr;
	BufferedReader buffer;

	public FileExtractor() {
		// default filepath
		filepath = "./src/practical/assignment1/problem3/maze.txt"; // please change filepath if you change the packages
	}

	public FileExtractor(String str) {
		try {
			// try this
			file = new File(str);
			System.out.println("\n========================\nIs this path correct?\nThe file is located here: " + file.getCanonicalPath()
			+ "\n========================\n"); // debugging..?
			fr = new FileReader(file);
			buffer = new BufferedReader(fr);
			// if successful, assign filepath
			filepath = str;
		} catch (Exception e) {
			System.out.println("Something went wrong... Check this error msg.\n" + e.getMessage());

		}
	}

	public boolean set(String str) {
		boolean returnval = true;
		try {
			// try this
			file = new File(str);
			System.out.println("\n========================\nIs this path correct?\nThe file is located here: " + file.getCanonicalPath()
			+ "\n========================\n"); // debugging..?
			fr = new FileReader(file);
			buffer = new BufferedReader(fr);
			// if successful, assign filepath
			filepath = str;
		} catch (Exception e) {
			System.out.println("Something went wrong... Check this error msg.\n" + e.getMessage());
			e.printStackTrace();

		} finally {
			returnval = false; // set unsuccessful
		}
		return returnval;
	}

	public String[] get() {
		List<String> content = new ArrayList<String>();
		try {
			// try this
			file = new File(filepath);
			System.out.println("\n========================\nIs this path correct?\nThe file is located here: " + file.getCanonicalPath()
			+ "\n========================\n"); // debugging..?
			fr = new FileReader(file);
			buffer = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = buffer.readLine()) != null) {
				if(sCurrentLine != "")
					content.add(sCurrentLine);
			}

		} catch (Exception e) {
			System.out.println("Something went wrong... Check this error msg.\n" + e.getMessage());
			e.printStackTrace();
		}

		return content.toArray(new String[content.size()]);
	}

}
