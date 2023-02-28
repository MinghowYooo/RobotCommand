/*
 * Minghao Li
 */
import java.util.Scanner;

public class GenLL <T> {
	Scanner input = new Scanner(System.in);
	private class ListNode
	{
		T data;
		ListNode link;
		
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	
	public GenLL()
	{
		head = current = previous = null;
	}
	
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null)
		{
			head = current = newNode;
			head = newNode;
			current = head;
			return;
		}
		ListNode temp = head;
		while(temp.link != null)
		{
			temp = temp.link;
		}
		temp.link = newNode;
	}
	
	public void remove(T aData)
	{
		if(head == null)
			return;
		if(head.data.equals(aData))
		{
			head = head.link;
			current = head.link;
			previous = head; 
		}
	}
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	public boolean hasMore()
	{
		return current != null;
	}
	
	public boolean contains(T aData)
	{
		ListNode current = head;
		while(current != null)
		{
			if(current.data.equals(aData))
				return true;
			current = current.link;
		}
		return false;
		
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	public void reset()
	{
		current = head;
		previous = null;
	}
	
	public T getCurrent()
	{
		if(current!= null)
			return current.data;
		else
			return null;
	}

	public void goToNext()
	{
		if(current != null)
		{
			previous = current;
			current = current.link;
		}
	} 
	
}

