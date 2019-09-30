package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatReady, StretchGoals {
	


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
		System.out.println("\nSir, cargo plane " + getModel() + " is in the air.");
		double time = getRange()/getSpeed();
		System.out.printf("Flight time for " + getModel() + " is %.2f", time);
		System.out.println("hours, which covers a range of " + getRange());
		System.out.println("hours without a reserve tank." );
		System.out.println(getModel() + " flies at " + getSpeed() + " MPH or Mach " + getSpeedInMach(getSpeed()) + ".");
		System.out.println("Average cost for this aircraft is $" + getPrice());
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


	@Override
	public void flySolo() {
		System.out.println("Wooooohooooooo! This freaking " + getModel() + " sure is sweet! ");
		System.out.println("But I think I might have messed myself on that last barrel roll.");
		
	}


	@Override
	public void assignPilot() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void hirePilot() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void jetPilotInfo() {
		// TODO Auto-generated method stub
		
	}




	
	
	
	

}
