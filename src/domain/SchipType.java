package domain;

import java.util.Random;

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
	
	  private static final SchipType[] VALUES = values();
	  private static final int SIZE = VALUES.length;
	  private static final Random RANDOM = new Random();

	  public static SchipType getRandomSchip()  {
	    return VALUES[RANDOM.nextInt(SIZE)];
	  }
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
	
}