package reverseReadFiles;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseReadFiles {

	public static void main(String[] args) {
		//Check for no command line args
		if(args.length == 0){
			System.out.println("The program must have atleast one command line argument to work");
			return;
		}
	for(int i=args.length-1;i>=0;i--){
				readFiles(args[i]);
			}
	}//End main

	/*
	 * Function to read files line by line
	 * Create a stack of input lines from file and get the lines in bottom to top order
	 * Call reverseLines function
	 */
	private static void readFiles(String fileName){
		
		try(BufferedReader in = new BufferedReader(new FileReader(fileName) )){
			Stack<String> lines = new Stack<String>();
			
			String line = in.readLine();
			while(line != null){
				lines.push(line);
				line=in.readLine();
			}
			
			while(!lines.empty()){
				System.out.println(reverseLines(lines.pop()));
			}
		}
		catch (FileNotFoundException fe){
			System.out.println(fileName+"-- File Doesnt exist");
		}
		catch(Exception e){
			System.out.println("Issue with reading"+fileName+" file");
		}
	} //End readFiles
	
	
	/*
	 * Function to reverse line
	*/
	private static String reverseLines(String line){
		StringBuilder sbline = new StringBuilder();
		sbline.append(line);
		return sbline.reverse().toString();
	} //End reverseLines
}
