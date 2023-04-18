package engine;

public class Calculations {
	
	public double resistance;
	public double current;
	public double voltage;
	public double power;
	
	
	public Calculations(double resistance, double current, double voltage, double power) {
		this.resistance = resistance;
		this.current = current;
		this.voltage = voltage;
		this.power = power;
		
	}

	public void calculateResistance(final int calcOption) {
		
		if (calcOption == 0) {
			resistance = voltage / current;
		}
		else if (calcOption == 1){
			resistance = power / Math.pow(current, 2);
		}	
		else {
			resistance = Math.pow(voltage, 2) / power;
		}
	}
	
	public void calculateCurrent(final int calcOption) {
		
		if(calcOption == 0)	{
			current = voltage / resistance;
		}
		else if(calcOption == 1){
			current = Math.sqrt(power / resistance);
		}
		else {
			current = power / voltage;
		}		 		
	}
	public void calculateVoltage(final int calcOption) {
		
		if(calcOption == 0) {
			voltage = resistance * current;
		}
		else if(calcOption == 1){
			voltage = power / current;
		}	
		else {
			voltage = Math.sqrt(power * resistance);
		}
	}
	public void calculatePower(final int calcOption) {
		
		if(calcOption == 0) {
			power = voltage * current;
		}
		else if (calcOption == 1) {
			power  = Math.pow(voltage, 2) / resistance;
		}
		else {
			power = Math.pow(current, 2) * resistance;
		}		
	}
}
