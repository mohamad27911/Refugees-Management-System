package Refugees_Management_System;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Admin admin = new Admin();
		admin.setUsername("MohamadDana");
		admin.setPassword("md2023");

		boolean adminLoggedIn = false;

		CountriesList countriesList = new CountriesList();
		RefugeesQueue country1 = new RefugeesQueue("Country1");
		country1.addRefugee(new Refugee("Alice", 25, "Country1", 500, "Country 1", 3, "Needs food"));
		country1.addRefugee(new Refugee("Bob", 30, "Country1", 700, "Country 1", 2, "Needs shelter"));
		country1.addRefugee(new Refugee("Charlie", 20, "Country1", 600, "Country 1", 1, "Needs medical aid"));
		countriesList.addCountry(country1);

		RefugeesQueue country2 = new RefugeesQueue("Country2");
		country2.addRefugee(new Refugee("David", 22, "Country2", 400, "Country 2", 2, "clothing"));
		country2.addRefugee(new Refugee("Eva", 28, "Country2", 800, "Country 2", 4, "education"));
		country2.addRefugee(new Refugee("Frank", 26, "Country2", 750, "Country 2", 3, "healthcare"));
		countriesList.addCountry(country2);

		Donor donor1 = new Donor("John", 30, "USA", 500);
		Donor donor2 = new Donor("Alice", 25, "UK", 300);

		DonationQueue dq = new DonationQueue();
		dq.addDonation(new Donation(donor1, donor1.getDonatedAmount()));
		dq.addDonation(new Donation(donor2, donor2.getDonatedAmount()));
		System.out.println("**************************************");
        System.out.println("*   Welcome to Our Refugees System   *");
        System.out.println("**************************************");
		while (true) {
			System.out.println("\n----------------------------------");
            System.out.println("   1. Display Countries");
            System.out.println("   2. Search for a Country");
            System.out.println("   3. Display Donors");
            System.out.println("   4. Display Refugees");
            System.out.println("   5. Login as Admin");
            System.out.println("   6. Exit");
            System.out.println("----------------------------------\n");
			System.out.print("Enter your choice: ");
			System.out.println();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("\nList of Countries:");
				countriesList.display();
				System.out.println();
				break;
			case 2:
				System.out.println("Enter country name to search: ");
				String searchName = scan.next();
				RefugeesQueue foundCountry = countriesList.searchCountry(searchName);
				if (foundCountry != null) {
					System.out.println("\nFound Country:");
					foundCountry.displayRefugees();
					System.out.println();
				} else {
					System.out.println("\nCountry not found.");
				}
				break;
			case 3:
				System.out.println("------------------------------------------");
				System.out.println("\nDonors List : ");
				System.out.println();
				dq.Display();
				System.out.println("------------------------------------------");

				break;
			case 4:
				System.out.println("Enter country name to display its refugees : ");
				String s = scan.next();
				RefugeesQueue f = countriesList.searchCountry(s);
				if (f != null) {
					System.out.println("------------------------------------------");
					System.out.println("\nRefugees List : ");
					System.out.println();
					f.displayRefugees();
					System.out.println("------------------------------------------");
					System.out.println();

				}else {
					System.out.println("The refugee List cannot be displayed as the specified country does not exist !");
				}
				break;
			case 5:
				System.out.print("Enter username: ");
				String username = scan.next();
				System.out.print("Enter password: ");
				String password = scan.next();
				adminLoggedIn = admin.verifyLogin(username, password);
				if (adminLoggedIn) {
					while (adminLoggedIn) {
						System.out.println("------------------------------");
						System.out.println("   1. Display Countries");
						System.out.println("   2. Search for a Country");
						System.out.println("   3. Add a Refugee");
						System.out.println("   4. Add a Donor");
						System.out.println("   5. Distribute Aid to refugees");
						System.out.println("   6. Display Donors");
						System.out.println("   7. Display Refugees");
						System.out.println("   8. Delete Refugee");
						System.out.println("   9. Delete Country");
						System.out.println("   10. Log out");
						System.out.println("------------------------------");
						System.out.println();
						System.out.print("Enter your choice: ");
						System.out.println();
						int ch = scan.nextInt();
						switch (ch) {
						case 1:
							System.out.println("\nList of Countries:");
							countriesList.display();
							System.out.println();
							break;
						case 2:
							System.out.println("Enter country name to search: ");
							String sn = scan.next();
							RefugeesQueue fc = countriesList.searchCountry(sn);
							if (fc != null) {
								System.out.println("\nFound Country:");
								fc.displayRefugees();
								System.out.println();
							} else {
								System.out.println("\nCountry not found.");
							}
							break;
						case 3:
							System.out.println("Enter country name to add a refugee: ");
							String countryForRefugee = scan.next();
							System.out.println("Enter refugee name: ");
							String refugeeName = scan.next();
							System.out.println("Enter refugee age: ");
							int refugeeAge = scan.nextInt();
							System.out.println("Enter refugee description: ");
							String desc = scan.next();
							System.out.println("Enter amount of donation needed: ");
							int donationNeeded = scan.nextInt();
							System.out.println("Enter refugee nationality: ");
							String nationality = scan.next();

							System.out.print("Enter number of children: ");
							int nbChildren = scan.nextInt();

							Refugee newRefugee = new Refugee(refugeeName, refugeeAge, nationality, donationNeeded,
									countryForRefugee, nbChildren, desc);
							RefugeesQueue targetCountryRefugees = countriesList.searchCountry(countryForRefugee);

							if (targetCountryRefugees != null) {
								targetCountryRefugees.addRefugee(newRefugee);
								System.out.println("Refugee added to " + countryForRefugee);
							} else {
								RefugeesQueue newQ = new RefugeesQueue(countryForRefugee);
								newQ.addRefugee(newRefugee);
								countriesList.addCountry(newQ);
								System.out.println("New country created: " + countryForRefugee);
							}
							break;

						case 4:
							System.out.print("Enter donor name: ");
							String donorName = scan.next();
							System.out.print("Enter donor age: ");
							int donorAge = scan.nextInt();
							System.out.print("Enter donation amount : ");
							int donationAmount = scan.nextInt();
							System.out.print("Enter donor nationality: ");
							String Donornationality = scan.next();
							Donor d = new Donor(donorName, donorAge, Donornationality, donationAmount);
							Donation don = new Donation(d, donationAmount);
							dq.addDonation(don);
							System.out.println("Donor added successfully ! ");
							System.out.println();
							break;
						case 5:
							System.out.println("Please enter the country name to distribute aid to refugees : ");
							String country = scan.next();
							RefugeesQueue target = countriesList.searchCountry(country);
							if (target != null) {
								target.distributeAid(dq);
								System.out.println();
							} else {
								System.out.println(country + " is not found !");
							}

							break;
						case 6:
							System.out.println("------------------------------------------");
							System.out.println("\nDonors List : ");
							System.out.println();
							dq.Display();
							System.out.println("------------------------------------------");

							break;
						case 7:
							System.out.println("Enter country name to display its refugees : ");
							String se = scan.next();
							RefugeesQueue foc = countriesList.searchCountry(se);
							if (foc!=null) {
								System.out.println("------------------------------------------");
								System.out.println("\nRefugees List : ");
								System.out.println();
								foc.displayRefugees();
								System.out.println("------------------------------------------");
								System.out.println();
								
							}else {
								System.out.println(se+" is not found !");
							}
							break;
						case 8:
							System.out.println("Please enter the country name to Search for the refugee : ");
							String c = scan.next();
							RefugeesQueue targ = countriesList.searchCountry(c);
							if (targ != null) {
								System.out.println("Enter refugee id : ");
								int id = scan.nextInt();
								Refugee toBeDeleted = targ.searchRefugee(id);
								if (toBeDeleted != null) {
									targ.removeRefugee(toBeDeleted);
								}
								else {
									System.out.println("Refugee is not found !");
								}
								System.out.println();
							} else {
								System.out.println(c + " is not found !");
							}
							break;
						case 9:
							System.out.println("Please enter the country name that you want to delete : ");
							String cd = scan.next();
							RefugeesQueue tar = countriesList.searchCountry(cd);
							if (tar!=null) {
								countriesList.removeCountry(tar);
								System.out.println(cd+" removed successfully !");
								System.out.println();
							}else {
								System.out.println(cd +" is not found !");
							}
							break;
						case 10:
							System.out.println("Logging out...");
							adminLoggedIn=false;
							break;
							
						default:
							System.out.println("Invalid choice.");
							break;
						}
					}
				} else {
					System.out.println("Login failed. Invalid credentials.");
				}
				break;
			
			case 6:
				System.out.println("Exiting...");
				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
			
		}
	}
}
