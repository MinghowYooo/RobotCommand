/*
 * Minghao Li
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
public class TaskManager {
	public static final String DELIM = "\t";
	Scanner input = new Scanner(System.in);
	public GenLL<Tasks>[] tasks;
	
	public TaskManager()
	{
		tasks = new GenLL[5];
		for(int i = 0; i < tasks.length; i++)
		{
			tasks[i] = new GenLL<Tasks>();
		}
	}
	
	public void addTask(String action, int priority)
	{
		System.out.println("Enter the action");
		action = input.nextLine();
		System.out.println("Enter the priority");
		priority = input.nextInt();
		Tasks task = new Tasks(action, priority);
		tasks[task.getPriority()].add(task);
		
	}
	
	public void removeTask(String action, int priority)
	{
		System.out.println("Enter the action of the task you want to remove");
		action = input.nextLine();	
		System.out.println("Enter the priority");
		priority = input.nextInt();
		Tasks task = new Tasks(action, priority);
		tasks[task.getPriority()].remove(task);
	}
	
	public void readTasksFromFile(String fileName)
	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = reader.readLine()) != null)
			{
				String[] splitString = line.split(DELIM);
				if(splitString.length == 2)
				{
					int priority = Integer.parseInt(splitString[0]);
					String action = splitString[1];
					Tasks task = new Tasks(action, priority);
					if(priority >= 0 && priority <= tasks.length)
						tasks[priority].add(task);
				}
			}
			reader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public  void writeTasksToFile(String fileName)
	{
		Tasks aT = new Tasks();
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for(int i = 0; i < tasks.length; i++)
			{
				tasks[i].reset();
				while(tasks[i].hasMore())
				{
					System.out.println(tasks[i].getCurrent());
					tasks[i].goToNext();
				}
				
				{
					writer.write(i + DELIM + aT.getAction() + DELIM + aT.getPriority());
				}
			}
			writer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void printTasks()
	{
		for(int i = 0; i < tasks.length; i++)
		{
			while(tasks[i].hasMore())
			{
				System.out.println(tasks[i].getCurrent());
				tasks[i].goToNext();
			}
		}
	}
	
	
}
