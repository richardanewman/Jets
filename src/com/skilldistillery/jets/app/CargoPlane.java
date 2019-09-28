package com.skilldistillery.jets.app;

public class CargoPlane extends Jet implements CargoCarrier {


	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void loadCargo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fly() {
		double time = getRange()/getSpeed();
		System.out.println("Flight time for " + getModel() + " is " + time);

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
