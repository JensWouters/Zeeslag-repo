package domain;

public enum SchipType {
	Vliegdekschip(5),
	Slagschip(4),
	Onderzee�r(3),
	Torpedobootjager(3),
	Patrouilleschip(2);
	
	private int size;
	
	private SchipType(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
	
}