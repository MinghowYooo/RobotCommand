/*
 * Minghao Li
 */

import java.util.Scanner;
public class TaskOrganizer {
	public static void main(String[] args)
	{
		TaskManager newTasks = new TaskManager();
		int priority;
		String action;
		boolean keepGoing = true;
		
		while(keepGoing)
		{
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Task Organizer");
		System.out.println("Enter 1. To Add a Task \n"
				+ "Enter 2. To Remove a Task \n"
				+ "Enter 3. To Print Tasks to Console \n"
				+ "Enter 4. To Read from a Task File \n"
				+ "Enter 5. To Write to a Task File \n"
				+ "Enter 0. To Quit");
		int choice = input.nextInt();
		input.nextLine();
		if(choice == 1)
		{
			System.out.println("Enter the priority of the task");
			 priority = input.nextInt();
			System.out.println("Enter the name of the action");
			 action = input.nextLine();
			 newTasks.addTask(action, priority);
			 
		}
		if(choice == 2)
		{
			System.out.println("Enter the priority of the task");
			 priority = input.nextInt();
			System.out.println("Enter the name of the action");
			 action = input.nextLine();
		}
		
		if(choice == 3)
		{
			
				newTasks.printTasks();
			
		}
		if(choice == 4)
		{
			System.out.println("Enter the file name");
			String fileName = input.nextLine();
			newTasks.readTasksFromFile(fileName);
		}
		
		if(choice == 5)
		{
			System.out.println("Enter the name of the file");
			String fileName = input.nextLine();
			newTasks.writeTasksToFile(fileName);
		}
		
		if(choice == 0)
		{
			keepGoing = false;
			
		}
		
	}
}
}
