package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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

		
	}

	private void launch() {
		List<Jet> jets = new ArrayList<>();
		try {
			BufferedReader buffIn = new BufferedReader(new FileReader("jets.txt"));

			String line = null;
			while ((line = buffIn.readLine()) != null) {

				String[] planeDetails = line.split(", ");
				String subclass = planeDetails[0];
				String model = planeDetails[1];
				double speed = Double.parseDouble(planeDetails[2]);
				int range = Integer.parseInt(planeDetails[3]);
				long price = Long.parseLong(planeDetails[4]);

				if (subclass.equals("FighterJet")) {
					Jet fj = new FighterJet(model, speed, range, price);
					jets.add(fj);
				}

				else if (subclass.equals("CargoPlane")) {
					Jet cp = new CargoPlane(model, speed, range, price);
					jets.add(cp);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		airField.setJets(jets);
		List<Jet> print = airField.getJets();
		for (Jet jet : print) {
			System.out.println(jet);
			
		}

	}

	private void displayMenu() {

	}

}
