package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {
	private AirField airField;
	private Scanner scanner; 

	public JetsApplication() {
		airField = new AirField();
	}

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
		app.displayUserMenu();

	}

	private void launch() {
		List<Jet> jets = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("jets.txt"));

			String line = null;
			while ((line = reader.readLine()) != null) {

				String[] planeDetails = line.split(",");
				String subclass = planeDetails[0].trim();
				String model = planeDetails[1].trim();
				double speed = Double.parseDouble(planeDetails[2].trim());
				int range = Integer.parseInt(planeDetails[3].trim());
				long price = Long.parseLong(planeDetails[4].trim());

				if (subclass.equals("FighterJet")) {
					Jet fj = new FighterJet(model, speed, range, price);
					jets.add(fj);
				}

				if (subclass.equals("CargoPlane")) {
					Jet cp = new CargoPlane(model, speed, range, price);
					jets.add(cp);
				} 
				if (subclass.equals("JetImpl")) {
					Jet ca = new JetImpl(model, speed, range, price);
					jets.add(ca);
				}

			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		airField.setJets(jets);

	}

	private void displayAirField() {
		List<Jet> allJets = airField.getJets();
		for (Jet jet : allJets) {
			System.out.println(jet);
		}
	}

	private void flyAllJets() {
		List<Jet> allJets = airField.getJets();
		for (Jet jet : allJets) {
			jet.fly();
		}
	}

	private void loadingCargoNow() {
		List<Jet> allJets = airField.getJets();
		CargoPlane cp;
		for (Jet jet : allJets) {
			if (jet instanceof CargoPlane) {
				cp = new CargoPlane(jet.getModel(), jet.getSpeed(), jet.getRange(), jet.getPrice());
				cp.loadCargo();
			}

		}
	}

	private void readyForDogfight() {
		List<Jet> allJets = airField.getJets();
		FighterJet fj;
		for (Jet jet : allJets) {
			if (jet instanceof FighterJet) {
				fj = new FighterJet(jet.getModel(), jet.getSpeed(), jet.getRange(), jet.getPrice());
				fj.fight();
			}

		}
	}

	private void fastestJet() {
		List<Jet> allJets = airField.getJets();
		Comparator<Jet> comparator = Comparator.comparing(Jet::getSpeed);
		Jet fastest = allJets.stream().max(comparator).get();
		System.out.println("The fastest jet is:\n" + fastest);
		System.out.println("It's speed in mach is " + fastest.getSpeedInMach(fastest.getSpeed()));

	}

	private void longestRange() {
		List<Jet> allJets = airField.getJets();
		Comparator<Jet> comparator = Comparator.comparing(Jet::getRange);
		Jet longest = allJets.stream().max(comparator).get();
		System.out.println("The jet with the longest range is:\n" + longest);

	}

	private void addNewJet() {
		System.out.println("******************************************************************");
		System.out.println("*                   Add New Aircraft to Fleet                    *");
		System.out.println("******************************************************************");
		System.out.println("* Please enter a number (1-3) & press enter to select an option  *");
		System.out.println("* 1. New Cargo Plane                                             *");
		System.out.println("* 2. New Fighter                                                 *");
		System.out.println("* 3. New Civilian Aircraft                                       *");
		System.out.println("* 4. Return to main menu                                         *");
		System.out.println("* 5. Quit                                                        *");
		System.out.println("******************************************************************");
		scanner = new Scanner(System.in);
		int selection = scanner.nextInt();
		switch (selection) {
		case 1:
			newJet(1);
			break;
		case 2:
			newJet(2);
			break;
		case 3:
			newJet(3);
			break;
		case 4:
			displayUserMenu();
			break;
		case 5:
			break;
		default:
			System.out.println("You have entered an invalid choice, please re-enter your choice: ");
			break;
		}
	}

	private void newJet(int select) {

		String subclass = (select == 1) ? "CargoPlane" : (select == 2) ? "FighterJet" : "JetImpl";
		String model, newPlane;
		double speed;
		int range;
		long price;
		System.out.println("Please enter model name: ");
		scanner.useDelimiter("\\n");
		model = scanner.next().trim();
		System.out.println("Please enter speed: ");
		speed = scanner.nextDouble();
		System.out.println("Please enter range: ");
		range = scanner.nextInt();
		System.out.println("Please enter price: ");
		price = scanner.nextLong();
		newPlane = (subclass + ", " + model + ", " + speed + ", " + range + ", " + price);
		newPlane.trim();
		
	
		if (subclass.equals("FighterJet")) {
			Jet fj = new FighterJet(model, speed, range, price);
			airField.addNewJet(fj);
		}

		if (subclass.equals("CargoPlane")) {
			Jet cp = new CargoPlane(model, speed, range, price);
			airField.addNewJet(cp);
			
		} 
		if (subclass.equals("JetImpl")) {
			Jet ca = new JetImpl(model, speed, range, price);
			airField.addNewJet(ca);

		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("jets.txt", true));
			writer.newLine();
			writer.write(newPlane);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Your new " + subclass + " has been added to the file and is waiting at the air field.");


	}
	
	private void removeJet() {
		List<Jet> getJets = airField.getJets();
		System.out.println("Here is the current list of jets in our fleet.\n");
			for (int i=0; i<getJets.size(); i++) {
				System.out.print(i + " ");
				System.out.println(getJets.get(i));
			}
			System.out.println("\nPlease enter the corresponding number of the jet you would like to remove.");
			int remove = scanner.nextInt();
			try {
				File oldJets = new File("jets.txt");
				File newJets = new File("newJets.txt");
				newJets.createNewFile();
				
				BufferedReader reader = new BufferedReader(new FileReader(oldJets));
				BufferedWriter writer = new BufferedWriter(new FileWriter(newJets));
				String toRemove = ("" + getJets.get(remove).toString());
				String line = null;
				boolean executed = false;
				System.out.println("You have scheduled " + toRemove + " \nfor removal from the fleet.");
				while ((line = reader.readLine()) != null) {
					String newLine = line.trim();
					if ((newLine.equals(toRemove) && !executed)){
						executed = true;
						continue;
					}
					writer.write(newLine.trim() + "\n");
				}
				writer.close();
				reader.close();
				
				
				boolean delete = oldJets.delete();
				boolean rename = newJets.renameTo(oldJets);
				if (delete && rename) {
					System.out.println("\nSuccessfully updated file.");
				}else {
					System.out.println("\nFile failed to update.");
				}
				
				airField.removeJet(remove);
				System.out.println("Successfully removed aircraft from the airfield.");
				
				
			
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}

	private void displayUserMenu() {
		int selection = 0;
		while (selection != 9) {
			System.out.println();
			System.out.println("******************************************************************");
			System.out.println("*                          Air Command                           *");
			System.out.println("******************************************************************");
			System.out.println("* Please enter a number (1-9) & press enter to select an option  *");
			System.out.println("* 1. List fleet                                                  *");
			System.out.println("* 2. Fly all jets                                                *");
			System.out.println("* 3. View fastest jet                                            *");
			System.out.println("* 4. View jet with longest range                                 *");
			System.out.println("* 5. Load all Cargo Jets                                         *");
			System.out.println("* 6. Dogfight!                                                   *");
			System.out.println("* 7. Add a jet to Fleet                                          *");
			System.out.println("* 8. Remove a jet from Fleet                                     *");
			System.out.println("* 9. Quit                                                        *");
			System.out.println("******************************************************************");
			scanner = new Scanner(System.in);
			selection = scanner.nextInt();
			switch (selection) {
			case 1:
				displayAirField();
				break;
			case 2:
				flyAllJets();
				break;
			case 3:
				fastestJet();
				break;
			case 4:
				longestRange();
				break;
			case 5:
				loadingCargoNow();
				break;
			case 6:
				readyForDogfight();
				break;
			case 7:
				addNewJet();
				break;
			case 8:
				removeJet();
				break;
			case 9:
				System.out.println("Eagles 1-9! Eagle 1-9! Hold it right there. Super secret cable incoming.");
				System.out.println("Message reads: The chair is against the wall. I say again, the chair is against the wall.");
				System.out.println("\"Wright\" you are, Sir! \"Wright\" you are! But the year can't be wrong.");
				System.out.println("If this is above your paygrade, enter 9 to exit. Super secret squirrels enter secret code:");
				int secret = 0;
				secret = scanner.nextInt();
				if (secret == 1903) {
					superSecretMenu();
					break;
				}else if (secret == 9){
					System.out.println("Goodbye!");
					break;
				}
			default:
				System.out.println("You have entered an invalid choice, please re-enter your choice: ");
				selection = scanner.nextInt();
				break;
			}

		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airField == null) ? 0 : airField.hashCode());
		result = prime * result + ((scanner == null) ? 0 : scanner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JetsApplication other = (JetsApplication) obj;
		if (airField == null) {
			if (other.airField != null)
				return false;
		} else if (!airField.equals(other.airField))
			return false;
		if (scanner == null) {
			if (other.scanner != null)
				return false;
		} else if (!scanner.equals(other.scanner))
			return false;
		return true;
	}

	
	//Stretch Goals
	private void superSecretMenu() {
		System.out.println();
		System.out.println("******************************************************************");
		System.out.println("*                       Super Secret Menu                        *");
		System.out.println("******************************************************************");
		System.out.println("* Please enter a number (1-3) & press enter to select an option  *");
		System.out.println("* 1. Fly Solo                                                    *");
		System.out.println("* 2. TODO                                                        *");
		System.out.println("* 3. TODO                                                        *");
		System.out.println("* 4. Return to main menu                                         *");
		System.out.println("* 5. Quit                                                        *");
		System.out.println("******************************************************************");
		scanner = new Scanner(System.in);
		int selection = scanner.nextInt();
		switch (selection) {
		case 1:
			flyingSolo();
			break;
		case 2:
			//TODO
			break;
		case 3:
			//TODO
			break;
		case 4:
			displayUserMenu();
			break;
		case 5:
			break;
		default:
			System.out.println("You have entered an invalid choice, please re-enter your choice: ");
			selection = scanner.nextInt();
			break;
		}
	}

		
		
	private void flyingSolo() {
		List<Jet> getJets = airField.getJets();
		System.out.println("Here is the current list of jets in our fleet.\n");
			for (int i=0; i<getJets.size(); i++) {
				System.out.print(i + " ");
				System.out.println(getJets.get(i));
			}
			System.out.println("\nPlease enter the corresponding number of the jet you would like to fly.");
			int fly = scanner.nextInt();
			Jet flyBoy = getJets.get(fly);
			if (flyBoy instanceof FighterJet) {
				((FighterJet) flyBoy).flySolo();
			}
			if (flyBoy instanceof CargoPlane) {
				((CargoPlane) flyBoy).flySolo();
			}
			if (flyBoy instanceof JetImpl) {
				((JetImpl) flyBoy).flySolo();
			}
			superSecretMenu();
		
	}
	
	

}
