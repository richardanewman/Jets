package com.skilldistillery.jets.app;

public class JetImpl extends Jet {


	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		double time = getRange()/getSpeed();
		System.out.println("Flight time for " + getModel() + " is " + time);

	}

}
