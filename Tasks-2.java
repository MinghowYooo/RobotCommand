/*
 * Minghao Li
 */
public class Tasks {
	private String action;
	private int priority;
	
	public Tasks()
	{
		this.action = "none";
		this.priority = 4;
	}
	
	public Tasks(String anA, int aP)
	{
		setAction(anA);
		setPriority(aP);
	}
	
	public String getAction()
	{
		return this.action;
	}
	
	public int getPriority()
	{
		return this.priority;
	}
	
	public void setAction(String anA)
	{
		if(anA == null)
			anA = null;
		else
			anA = this.action;
	}
	
	public void setPriority(int aP)
	{
		if(aP >= 0 && aP <= 4)
			aP = this.priority;
		else
			aP = 4;
	}
	
	public boolean equals(Tasks aT)
	{
		return aT != null &&
				this.action.equals(aT.getAction()) &&
				this.priority == aT.getPriority();
	}
}
