package domain;

public enum Schip 
{
	VLIEGDEKSCHIP(5),
	SLAGSCHIP(4),
	ONDERZEEËR(3),
	TORPEDOBOOTJAGER(3),
	PATROUILLESCHIP(2);
	
	private int size;
	
	private Schip(int size)
	{
		this.size = size;
	}
	
	public int getSize()
	{
		return this.size;
	}
}