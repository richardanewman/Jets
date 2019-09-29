package com.skilldistillery.jets.app;

public class CargoPlane extends Jet implements CargoCarrier {


	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void loadCargo() {
		System.out.println("Sir, the airmen are loading cargo on " + getModel() + " as we speak.");

	}

	@Override
	public void fly() {
		System.out.println("Sir, cargo plane " + getModel() + " is in the air.");
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
