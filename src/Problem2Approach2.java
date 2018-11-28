import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Problem2Approach2 {

	public static void main(String[] args) throws ParseException {

		Scanner input = new Scanner(System.in);
		System.out.print("How many pair of dates you want to enter? ");
		int noOfPairs = input.nextInt();

		int[] startDate = new int[noOfPairs];
		int[] endDate = new int[noOfPairs];

		for (int i = 0; i < noOfPairs; i++) {
			System.out.print("\n" + "Enter Start Date: ");
			startDate[i] = diffOfInputAndCurrentDate(input.next());

			System.out.print("Enter End Date: ");
			endDate[i] = diffOfInputAndCurrentDate(input.next());
		}

		for (int j = 0; j < noOfPairs; j++) {
			for (int k = j + 1; k < noOfPairs; k++) {

				/*
				 * Given inputs: (startDate1 , endDate1) and (startDate2 , endDate2)
				 * 
				 * Logic: if any of the following condition matches that meaning date ranges
				 * overlap: startDate2 falls between startDate1 and endDate1 OR endDate2 falls
				 * between startDate1 and endDate1 OR startDate1 falls between startDate2 and
				 * endDate2 OR endDate1 falls between startDate2 and endDate2
				 */

				if ((startDate[j] < startDate[k] || startDate[k] < endDate[j]) == true) {
					System.out.println("\n" + "Overlapping Ranges:");
					System.out.println("(" + startDate[j] + ", " + endDate[j] + ")");
					System.out.println("(" + startDate[k] + ", " + endDate[k] + ")");
				} else if ((startDate[j] < endDate[k] || endDate[k] < endDate[j]) == true) {
					System.out.println("\n" + "Overlapping Ranges:");
					System.out.println("(" + startDate[j] + ", " + endDate[j] + ")");
					System.out.println("(" + startDate[k] + ", " + endDate[k] + ")");
				} else if ((startDate[k] < startDate[j] || startDate[j] < endDate[k]) == true) {
					System.out.println("\n" + "Overlapping Ranges:");
					System.out.println("(" + startDate[j] + ", " + endDate[j] + ")");
					System.out.println("(" + startDate[k] + ", " + endDate[k] + ")");
				} else if ((startDate[k] < endDate[j] || endDate[j] < endDate[k]) == true) {
					System.out.println("\n" + "Overlapping Ranges:");
					System.out.println("(" + startDate[j] + ", " + endDate[j] + ")");
					System.out.println("(" + startDate[k] + ", " + endDate[k] + ")");
				}

			}

		}

	}

	public static int diffOfInputAndCurrentDate(String inputDate) throws ParseException {

		Date b = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);

		Date date = new Date();
		String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
		Date now = new SimpleDateFormat("dd/MM/yyyy").parse(formattedDate);

		int c = (int) (now.getTime() - b.getTime()) / (1000 * 60 * 60 * 24);
		return c;

	}
}