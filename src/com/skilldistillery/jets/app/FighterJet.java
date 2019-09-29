package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatReady {
	


	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void fight() {
		System.out.println("Sir, the " + getModel() + " is equipped and ready for a dogfight!");
		

	}

	@Override
	public void fly() {
		System.out.println("Sir, fighter jet " + getModel() + " is in the air.");
		double time = getRange()/getSpeed();
		System.out.printf("Flight time for " + getModel() + " is %.2f", time);
		System.out.println(" hours without a reserve tank." );

	}


	@Override
	public int hashCode() {
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}




	
	
	
	

}
