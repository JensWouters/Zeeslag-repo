package domain;

public enum SchipType 
{
	VLIEGDEKSCHIP(5),
	SLAGSCHIP(4),
	ONDERZEEER(3),
	TORPEDOBOOTJAGER(3),
	PATROUILLESCHIP(2);
	
	private int size;
	
	private SchipType(int size)
	{
		this.size = size;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
}