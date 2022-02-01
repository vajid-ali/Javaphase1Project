package com.lockers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class LockedMe
{
	static final String projectfilepath = "F:\\JAVAFSD-11DEC-2021\\LockedMeFiles";
	static final String errormessage = "Some error occured. Please contact:admin@lockedme.com";
	
	public static void main(String[] args)
	{
		
		//Developer Details
		System.out.println("Designed by: VAJID ALI ");
				
		//input for service request number
		int choice;
		
		//Object creation
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			//Options
			System.out.println("\n ********************** Company Lockers Pvt. Ltd. ******************************");
			System.out.println("1. List files (Asc.) ");
			System.out.println("2. Delete a file");
			System.out.println("3. Search a file");
			System.out.println("4. Create a file");
			System.out.println("5. Exit ");
			
			System.out.print("Please enter your choice : ");
			
			//Choice Input for calculation
			choice = scan.nextInt();
			
			switch(choice) {
				
				case 1:
					
					//List function feature to list all files in ascending order.
					listFiles();
					break;
				
				case 2:
					
					//Input for filename to be deleted
					System.out.print("Enter filename to be deleted: ");
					String fileToBeDeleted = scan.next();
					
					//Function to delete a specific file given by user
					deleteFile(fileToBeDeleted);
					break;
				
				case 3:
					
					//Input for filename to be searched
					System.out.println("Please enter filename to be searched: ");
					String fileToBeSearched = scan.next();
					
					//Function to search a specific file given by user
					searchFile(fileToBeSearched);
					break;
				
				case 4:
					
					//Input for filename to be created
					System.out.println("Please enter filename to be created: ");
					String fileToBeCreated = scan.next();
					
					//Function to create a specific file given by user
					createFile(fileToBeCreated);
					break;
					
				case 5:
					
					//Releasing scanner resource
					scan.close();
					System.out.println("\n ****************** Exiting ************************");
					System.exit(1);
					break;
				
				default:
					//Releasing scanner resource
					System.out.println("\n ****************** Please enter an option between 1-5 ************************");
					break;
				
					
				
			}		
			
		}
	}
			//Insertion sort to sort file names in ascending order
			protected static String[] sort_sub(String array[], int size){
				String temp = "";
				for(int i=0; i<size; i++){
					for(int j=i+1; j<size; j++){
						if(array[i].compareToIgnoreCase(array[j])>0){
							temp = array[i];
							array[i]=array[j];
							array[j]=temp;
						}
					}
				}
				return array;
			}
			
			//File listing function
			protected static void listFiles() {
				
				int fileCount = 0;
			    ArrayList<String> filenames = new ArrayList<String>();
			
				File directoryPath = new File(projectfilepath);
				File[] listOfFiles = directoryPath.listFiles();
				fileCount = listOfFiles.length;
				
				
				System.out.println("All files: ");
				for (int i = 0; i < fileCount; i++) {
				  if (listOfFiles[i].isFile()) {
				    filenames.add(listOfFiles[i].getName());
				  } 
				}
				
				String[] str = new String[filenames.size()];
				 
			    for (int i = 0; i < filenames.size(); i++) {
			        str[i] = filenames.get(i);
			    }
				
			    String[] sorted_filenames = sort_sub(str, str.length);
				
				for(String currentFile: sorted_filenames) {
					System.out.println(currentFile);
				}

			}
			
			//File delete function
			protected static void deleteFile(String fileToBeDeleted) {
				
				File file = new File(projectfilepath + "\\" + fileToBeDeleted );
				
				if(file.exists()) {
					if ( file.delete() ) {
						System.out.println("File deleted successfully!");
					}
				} else {
					System.out.println("Error 404 (Not Found)");
				}
			}
			
			//File search function
			protected static void searchFile(String fileToBeSearched) {
				File file = new File(projectfilepath + "\\" + fileToBeSearched );
				
				//Check whether file whether file exists or not.
				//If yes then display corresponding message
				if(file.exists()) {
					System.out.println("File exits!");
				} else {
					System.out.println("Error 404 (Not Found)");
				}
			}

			//File creation function
			protected static void createFile (String fileToBeCreated) {
				File file = new File( projectfilepath + "\\" + fileToBeCreated );
				
				try {
					if (file.createNewFile() ) {
						System.out.println("File Created!");
					} else {
						System.out.println("File already exists :(");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
	}

