package domain;

import java.util.Random;


public enum Richting 
{
	HORIZONTAAL,
	VERTICAAL;
	
	

	 private static final Richting[] VALUES = values();
	  private static final int SIZE = VALUES.length;
	  private static final Random RANDOM = new Random();

	  public static Richting getRandomRichting()  {
	    return VALUES[RANDOM.nextInt(SIZE)];
	  }

}
