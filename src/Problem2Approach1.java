

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Problem2Approach1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("How many pair of dates you want to enter? ");
		int noOfPairs = input.nextInt();

		String[] startDate = new String[noOfPairs];
		String[] endDate = new String[noOfPairs];

		for (int i = 0; i < noOfPairs; i++) {
			System.out.print("\n" + "Enter Start Date: ");
			startDate[i] = input.next();

			System.out.print("Enter End Date: ");
			endDate[i] = input.next();
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

				try {
					if (overlapCheck(startDate[j], endDate[j], startDate[k], false) == true) {
						System.out.println("\n" + "Overlapping Ranges:");
						System.out.println("(" + startDate[j] + ", " + endDate[j] + ")");
						System.out.println("(" + startDate[k] + ", " + endDate[k] + ")");
					} else if (overlapCheck(startDate[j], endDate[j], endDate[k], true) == true) {
						System.out.println("\n" + "Overlapping Ranges:");
						System.out.println("(" + startDate[j] + ", " + endDate[j] + ")");
						System.out.println("(" + startDate[k] + ", " + endDate[k] + ")");
					} else if (overlapCheck(startDate[k], endDate[k], startDate[j], false) == true) {
						System.out.println("\n" + "Overlapping Ranges:");
						System.out.println("(" + startDate[j] + ", " + endDate[j] + ")");
						System.out.println("(" + startDate[k] + ", " + endDate[k] + ")");
					} else if (overlapCheck(startDate[k], endDate[k], endDate[j], true) == true) {
						System.out.println("\n" + "Overlapping Ranges:");
						System.out.println("(" + startDate[j] + ", " + endDate[j] + ")");
						System.out.println("(" + startDate[k] + ", " + endDate[k] + ")");
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
		}

	}

	// Parameter: start date, end date, test date and a flag which checks whether
	// test date is an end date or not.
	// This function will check whether given test date falls between start date and
	// end date
	public static boolean overlapCheck(String startDate, String endDate, String testDate, boolean testDateIsEndDate)
			throws ParseException {

		// Converting start date from String to Date
		Date a = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);

		// Converting end date from String to Date
		// Reducing 1 day from end date since end date is excluded
		Date bTemp = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(bTemp);
		cal1.add(Calendar.DATE, -1);
		Date b = cal1.getTime();

		Date c;

		Calendar cal2 = Calendar.getInstance();

		// Checking if the test date is end date or not, if it's end date the reducing 1
		// day since end date is excluded.
		if (testDateIsEndDate = false)
			c = new SimpleDateFormat("dd/MM/yyyy").parse(testDate);
		else {
			Date cTemp = new SimpleDateFormat("dd/MM/yyyy").parse(testDate);
			cal2.setTime(cTemp);
			cal2.add(Calendar.DATE, -1);
			c = cal1.getTime();
		}

		return c.after(a) && c.before(b);
	}
}
