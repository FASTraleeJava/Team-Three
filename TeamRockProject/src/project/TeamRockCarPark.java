package project;
import java.util.*;
import java.text.*;
//Good Job Gergios
//I imported this and pushed it as a serparate Java Project. It has its own Branch based on the branch you made it from. Branch no.1
//You pushed it to the repository and Branch No.1 that you cloned - and then I could see the Test1 folder and your Carpark program with a Branch no.1
//I then imported it as a separate project into my local repository from the remote and instead of merging pushed it as a separate project alongside TeamRock to my repository for all to see


class Parking {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("€##.##");
		Scanner input = new Scanner(System.in);
		double hr = 0.0;
		int menu = 0;
		System.out.println("Welcome to TEAM ROCK Car Park");
		System.out.println("Parking Charges:");
		System.out.println("MotorCycle: €0.00/hr first 3hr €1.50/hr after 3hr");
		System.out.println("CAR : €1.00/hr first 2hr €2.30/hr after 2hr");
		System.out.println("BUS : €2.00/hr first 1hr €3.70/hr after 1hr");
		System.out.println();
		System.out.println("1. MotorCycle");
		System.out.println("2. Car");
		System.out.println("3. Bus or Truck");
		System.out.println("4. Exit");
		boolean quit = false;
		do {
			System.out.print("Please enter your choice: ");
			menu = input.nextInt();
			System.out.println();

			switch (menu) {
			case 1:
				System.out.print("Enter Number of hours: ");
				hr = input.nextDouble();

				System.out.println("**********Charges**********");
				System.out.println("Vehicle type= MotorCycle");
				if (hr > 3) {
					double amount = (hr - 3) * 1.50;
					System.out.println("Charges= " + df.format(amount));
				} else {
					System.out.println("No charges");
				}
				break;
			case 2:
				System.out.print("Enter Number of hours: ");
				hr = input.nextDouble();

				System.out.println("**********Charges**********");
				System.out.println("Vehicle type= Car");
				if (hr > 2) {
					double amount = (hr - 2) * 2.30 + 2.00;
					System.out.println("Charges= " + df.format(amount));
				} else {
					double amount = (hr) * 1.00;
					System.out.println("Charges= " + df.format(amount));
				}

				break;
			case 3:
				System.out.print("Enter Number of hours: ");
				hr = input.nextDouble();

				System.out.println("**********Charges**********");
				System.out.println("Vehicle type= Bus/Truck");
				if (hr > 1) {
					double amount = (hr - 1) * 3.70 + 2.00;
					System.out.println("Charges= " + df.format(amount));
				} else {
					double amount = (hr) * 2.00;
					System.out.println("Charges= " + df.format(amount));
				}
				break;
			case 4:
				quit = true;
				break;
			default:
				System.out.println("Invalid Entry!");
			}
		}

		while (!quit);
	}
}