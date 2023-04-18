package constants;

public class Units {
	
	public static double convertToSelectedUnit(double unit, String selectedUnit) {
     	if (selectedUnit.equals("micro")) {
     		return unit * 0.000001;
     	}
     	else if (selectedUnit.equals("mili")) {
     		return unit *  0.001;
     	}
     	else if (selectedUnit.equals("kilo")) {
     		return unit * 1000;
     	}
     	else if (selectedUnit.equals("mega")) {
     		return unit * 1000000;
     	} 
     	else  {
     		return unit;
     	}
	}
	
}
	
