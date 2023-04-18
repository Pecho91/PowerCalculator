package service;

public class CalculatorService {
	
	//private double resistance;
	//private double current;
	//private double voltage;
	//private double power;
	
	
}  /* saved:

//handle button clicks.
		if(source == calculateButton) {
			String emptyTextField = "";
			int emptyCount = 0;
			
			//Determine which text fields are empty
			if(resistanceTextField.getText().equals(emptyTextField)) {
				emptyCount++;
			}
			if(currentTextField.getText().equals(emptyTextField)) {
				emptyCount++;
			}
			if(voltageTextField.getText().equals(emptyTextField)) {
				emptyCount++;
			}
			if(powerTextField.getText().equals(emptyTextField)) {
				emptyCount++;
			}
			
			
			//Calculate missing values based on which  textFields are empty
			if(emptyCount == 1) {
				
				if (resistanceTextField.getText().equals(emptyTextField)) {
	                // Calculate resistance.
	                double voltage = Double.parseDouble(voltageTextField.getText());
	                double current = Double.parseDouble(currentTextField.getText());
	                double resistance = voltage / current;
	                resistance = convertResistanceToSelectedUnit(resistance, selectedUnit);
	                current = convertCurrentToSelectedUnit(current, selectedUnit);
	                voltage = convertCurrentToSelectedUnit(voltage, selectedUnit);
	                resistanceTextField.setText(String.valueOf(resistance));
	            } else if (currentTextField.getText().equals(emptyTextField)) {
	                // Calculate current.
	                double voltage = Double.parseDouble(voltageTextField.getText());
	                double resistance = Double.parseDouble(resistanceTextField.getText());
	                double current = voltage / resistance;
	                resistance = convertResistanceToSelectedUnit(resistance, selectedUnit);
	                current = convertCurrentToSelectedUnit(current, selectedUnit);
	                voltage = convertCurrentToSelectedUnit(voltage, selectedUnit);
	                currentTextField.setText(String.valueOf(current));
	            } else if (voltageTextField.getText().equals(emptyTextField)) {
	                // Calculate voltage.
	                double current = Double.parseDouble(currentTextField.getText());
	                double resistance = Double.parseDouble(resistanceTextField.getText());
	                double voltage = current * resistance;
	                resistance = convertResistanceToSelectedUnit(resistance, selectedUnit);
	                current = convertCurrentToSelectedUnit(current, selectedUnit);
	                voltage = convertCurrentToSelectedUnit(voltage, selectedUnit);
	                voltageTextField.setText(String.valueOf(voltage));
	            } else if (powerTextField.getText().equals(emptyTextField)) {
	                // Calculate power.
	                double voltage = Double.parseDouble(voltageTextField.getText());
	                double current = Double.parseDouble(currentTextField.getText());
	                double power = voltage * current;
	                power = convertPowerToSelectedUnit(power, selectedUnit);
	                current = convertCurrentToSelectedUnit(current, selectedUnit);
	                voltage = convertCurrentToSelectedUnit(voltage, selectedUnit);
	                powerTextField.setText(String.valueOf(power));
	            }
	        } else if (emptyCount == 2) {
	            // Two text fields are empty - calculate missing values.
	            if (resistanceTextField.getText().equals(emptyTextField) && currentTextField.getText().equals(emptyTextField)) {
	                // Calculate resistance and current.
	                double voltage = Double.parseDouble(voltageTextField.getText());
	                double power = Double.parseDouble(powerTextField.getText());
	                double resistance = Math.pow(voltage, 2) / power;
	                double current = power / voltage;
	                resistance = convertResistanceToSelectedUnit(resistance, selectedUnit);
	                current = convertCurrentToSelectedUnit(current,selectedUnit);
	                voltage = convertVoltageToSelectedUnit(voltage,selectedUnit);
	                power = convertPowerToSelectedUnit(power,selectedUnit);
	                resistanceTextField.setText(String.valueOf(resistance));
	                currentTextField.setText(String.valueOf(current));
	            } else if (resistanceTextField.getText().equals(emptyTextField) && voltageTextField.getText().equals(emptyTextField)) {
	                // Calculate resistance and voltage.
	                double current = Double.parseDouble(currentTextField.getText());
	                double power = Double.parseDouble(powerTextField.getText());
	                double resistance = Math.pow(current, 2) * power;
	                double voltage = power / current;
	                resistance = convertResistanceToSelectedUnit(resistance, selectedUnit);
	                current = convertCurrentToSelectedUnit(current,selectedUnit);
	                voltage = convertVoltageToSelectedUnit(voltage,selectedUnit);
	                power = convertPowerToSelectedUnit(power,selectedUnit);
	                resistanceTextField.setText(String.valueOf(resistance));
	                voltageTextField.setText(String.valueOf(voltage));
	            } else if (resistanceTextField.getText().equals(emptyTextField) && powerTextField.getText().equals(emptyTextField)) {
	                // Calculate resistance and power.
	                double voltage = Double.parseDouble(voltageTextField.getText());
	                double current = Double.parseDouble(currentTextField.getText());
	                double power = voltage * current;
	                double resistance = Math.pow(voltage, 2) / power;
	                resistance = convertResistanceToSelectedUnit(resistance, selectedUnit);
	                current = convertCurrentToSelectedUnit(current,selectedUnit);
	                voltage = convertVoltageToSelectedUnit(voltage,selectedUnit);
	                power = convertPowerToSelectedUnit(power,selectedUnit);
	                resistanceTextField.setText(String.valueOf(resistance));
	                powerTextField.setText(String.valueOf(power));
				}else if (currentTextField.getText().equals(emptyTextField) && voltageTextField.getText().equals(emptyTextField)) {
			        // Calculate current and voltage.
			        double resistance = Double.parseDouble(resistanceTextField.getText());
			        double power = Double.parseDouble(powerTextField.getText());
			        double current = Math.sqrt(power / resistance);
			        double voltage = current * resistance;
			        resistance = convertResistanceToSelectedUnit(resistance, selectedUnit);
	                current = convertCurrentToSelectedUnit(current,selectedUnit);
	                voltage = convertVoltageToSelectedUnit(voltage,selectedUnit);
	                power = convertPowerToSelectedUnit(power,selectedUnit);
			        currentTextField.setText(String.valueOf(current));
			        voltageTextField.setText(String.valueOf(voltage));
			    } else if (currentTextField.getText().equals(emptyTextField) && powerTextField.getText().equals(emptyTextField)) {
			        // Calculate current and power.
			        double voltage = Double.parseDouble(voltageTextField.getText());
			        double resistance = Double.parseDouble(resistanceTextField.getText());
			        double current = voltage / resistance;
			        double power = Math.pow(voltage, 2) / resistance;
			        resistance = convertResistanceToSelectedUnit(resistance, selectedUnit);
	                current = convertCurrentToSelectedUnit(current,selectedUnit);
	                voltage = convertVoltageToSelectedUnit(voltage,selectedUnit);
	                power = convertPowerToSelectedUnit(power,selectedUnit);
			        currentTextField.setText(String.valueOf(current));
			        powerTextField.setText(String.valueOf(power));
			    } else if (voltageTextField.getText().equals(emptyTextField) && powerTextField.getText().equals(emptyTextField)) {
			        // Calculate voltage and power.
			        double current = Double.parseDouble(currentTextField.getText());
			        double resistance = Double.parseDouble(resistanceTextField.getText());
			        double voltage = current * resistance;
			        double power = Math.pow(current, 2) * resistance;
			        resistance = convertResistanceToSelectedUnit(resistance, selectedUnit);
	                current = convertCurrentToSelectedUnit(current,selectedUnit);
	                voltage = convertVoltageToSelectedUnit(voltage,selectedUnit);
	                power = convertPowerToSelectedUnit(power,selectedUnit);
			        voltageTextField.setText(String.valueOf(voltage));
			        powerTextField.setText(String.valueOf(power));
			    }
			}
	       
		}
		else if(source == resetButton) {
			final String emptyTextField = "";
			resistanceTextField.setText(emptyTextField);
			currentTextField.setText(emptyTextField);
			voltageTextField.setText(emptyTextField);
			powerTextField.setText(emptyTextField);
			resistanceComboBox.setSelectedIndex(0);
		
		}
		
	}

*/