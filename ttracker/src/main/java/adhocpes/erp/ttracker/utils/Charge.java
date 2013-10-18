package adhocpes.erp.ttracker.utils;

public class Charge {

	private static double[] charges = {1,0.5,0.25,0};
	private double charge; 

	// Constructor 
	public Charge(double c) {
		charge = c;
	}

	public static boolean isAValidCharge(double c) {
		for(double d : charges){
			if(c == d)
				return true;
		}
		return false;
	}

	@Override
	public String toString(){
		return charge + "";
	}
}
