package fileHandlerPrototype;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	
	public static void listOfFiles() {
		System.out.println("\n List of files and Folder \n");
		File folder = new File("D://Workspace//LockedMe//src//dir//");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {

				System.out.println(file.getName());
			} else if (file.isFile()) {
				System.out.println(file.getName());
			}

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File directory = new File("D://Workspace//LockedMe//src//dir");
		
		System.out.println(directory.getAbsolutePath());
		char ch;
		String filename;
		Scanner input = new Scanner(System.in);
			System.out.println("------------------------------------------");
			System.out.println("******* Simplilearn Project 1 ************");
			System.out.println("******************************************");
			System.out.println("****** Shraddha Harshal Ganbote  *********");
			System.out.println("------------------------------------------");
			System.out.println("******* Full Stack Developer  ************");
			System.out.println("------------------------------------------");
			System.out.println();
			
			do {
				System.out.println("Select File Option to perform any operation:- \n");
				System.out.println("1.File Creation");
				System.out.println("2.File List");
				System.out.println("3.File Delete");
				System.out.println("4.Search file");
				System.out.println("5.Exit");
				
				System.out.print("Please enter you choice -> ");
				int choice = input.nextInt();
				System.out.println();
				
				switch (choice) {
				case 1:

					System.out.println("Enter the file name for crating new file");
					filename = input.next();
					try {
						File file = new File("D://Workspace//LockedMe//src//dir//" + filename + ".txt");

						if (file.createNewFile()) {
							
							System.out.println("File Created Successfully \n");
						} else {
							if (file.exists()) {
								System.out.println("File Already Exists");
							} else {
								System.out.println("File Doesen't exist");
							}

							// Delete the file code below

							boolean b = file.delete();
							if (b == true) {
								System.out.println("File  Deleted");
							} else {
								System.out.println("File  not Deleted");
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

					break;

				case 2:
					listOfFiles();
					break;
					
				case 3:
					System.out.println("Enter the file name which you want to delete ->");
					filename = input.next();

					File directory_delete = new File("D://Workspace//LockedMe//src//dir//");

					String[] flist_delete = directory_delete.list();

					// String[] flist = directory.list();
					int flag_d = 0;
					if (flist_delete == null) {
						System.out.println("There is no file preseent in the directory");
					} else {

						// Linear search in the array
						for (int i = 0; i < flist_delete.length; i++) {
							String delete_filename = flist_delete[i];
							if (delete_filename.equalsIgnoreCase(filename)) {

								File file = new File(
										"D://Workspace//LockedMe//src//dir//" + delete_filename);
								if (file.delete()) {
									System.out.println("File deleted successfully");
								} else {
									System.out.println("Failed to delete the file");
								}
								flag_d = 1;
							}
						}
					}

					if (flag_d == 0) {
						System.out.println("File Not Found");
					}

					break;
					
				case 4:
					// Create an object of the File class
					// Replace the file path with path of the directory
					System.out.println("Enter the file name for searching");

					filename = input.next();

					File directory_search = new File("D://Workspace//LockedMe//src//dir//");

					String[] flist_search = directory_search.list();
					int flag_s = 0;
					if (flist_search == null) {
						System.out.println("There is no file preseent in the directory");
					} else {

						// Linear search in the array
						for (int i = 0; i < flist_search.length; i++) {
							String search_filename = flist_search[i];
							if (search_filename.equalsIgnoreCase(filename)) {
								System.out.println(search_filename + " found");
								flag_s = 1;
							}
						}
					}

					if (flag_s == 0) {
						System.out.println("File Not Found");
					}

					break;
				case 5:

					System.out.println("Thank you User");
					break;

				}
				System.out.println("Do you want to continue Type (y or n) \n");
				ch = input.next().charAt(0);
			} while(ch == 'Y' || ch == 'y');
		} 


}
