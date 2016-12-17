package domain;

public enum SchipType {
	Vliegdekschip(5),
	Slagschip(4),
	Onderzeeer(3),
	Torpedobootjager(3),
	Patrouilleschip(2);
	
	private int size;
	
	private SchipType(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}
	
}