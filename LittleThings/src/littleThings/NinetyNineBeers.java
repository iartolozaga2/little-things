package littleThings;

public class NinetyNineBeers {
	
	public static void main(String[] args) {
		int beerNum = 99;
		//Simple counter
		while (beerNum != 0) {
			System.out.println(beerNum + " bottles of beer on the wall");
			System.out.println(beerNum + " bottles of beer");
			System.out.println("Take one down, pass it around");
			System.out.println((beerNum - 1) + " bottles of beer on the wall\n");
			beerNum--;
		}		
	}
}
