package littleThings;

public class HundredDoors {
	
	/*	
	 	There are 100 doors in a row that are all initially closed.

		You make 100 passes by the doors.

		The first time through, visit every door and  toggle  the door  (if the door is closed,  open it;   if it is open,  close it).

		The second time, only visit every 2nd door   (door #2, #4, #6, ...),   and toggle it.

		The third time, visit every 3rd door   (door #3, #6, #9, ...), etc,   until you only visit the 100th door.
		
		Answer the question:   what state are the doors in after the last pass?   Which are open, which are closed?
	 */
	
	// http://rosettacode.org/wiki/100_doors
	
	public static void main (String[] args) {
		int[] doors = new int[100];
		for (int i : doors) {
			doors[i] = 0;
		}
		int num = 1;
		for (int door : hundredPasses(doors)) {
			if (door == 0) {
				System.out.println("Door number " + num + " is closed.");
			} else {
				System.out.println("Door number " + num + " is open.");
			}
			num++;
		}
	}
	
	public static int[] hundredPasses(int[] doors) {
		for (int iterator = 1; iterator <= 100; iterator++) {
			for (int i = 1; i <= 100; i++) {
				if (i%iterator == 0) {
					doors[i-1] = (doors[i-1] + 1) % 2;
				}
			}
		}
		return doors;
	}

}
