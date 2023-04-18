package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.text.AbstractDocument;

import engine.Calculations;
//import javax.swing.text.DocumentFilter;




public class DCPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	CustomDocumentFilter customDocumentFilter;
	private static final long serialVersionUID = 1L;
	
	
	private JPanel topPanel;
//	private JPanel centerPanel;
//	private JPanel bottomPanel;
	
	
	//private JLabel label;
	
	private JLabel resistanceLabel;
	private JLabel currentLabel;
	private JLabel voltageLabel;
	private JLabel powerLabel;
	
	private JLabel ohmLabel;
	private JLabel ampLabel;
	private JLabel voltLabel;
	private JLabel wattLabel;
	
	private JTextField resistanceTextField;
	private JTextField currentTextField;
	private JTextField voltageTextField;
	private JTextField powerTextField;
	
	private JButton calculateButton;
	private JButton clearButton;
	

	
	//private JComboBox<String> resistanceComboBox;
	//private JComboBox<String> currentComboBox;
	//private JComboBox<String> voltageComboBox;
	//private JComboBox<String> powerComboBox;
	
	//private Double originalValue = 0.0;
	
	//private Font labelFont;
	//private Font textFieldFont;
	
	private Font font = new Font("BOLD",Font.ITALIC,20);

	
		
//	private static final Dimension PANEL_SIZE = new Dimension (600, 280);
	//private static final Dimension FONTSIZE = new Dimension(20,20);
	
	
	public DCPanel() {
	
		addGuiComponents();
		this.setVisible(true);
		calculateButton.addActionListener(this);
		clearButton.addActionListener(this);
		
	}
	
	private void addGuiComponents() {
		addPanels();

	}
	
	private void addPanels() {
		// Set the layout manager to GridLayout with 3 rows and 1 column
        setLayout(new GridLayout(1, 1));

        // Create the top, center, and bottom panels with GroupLayout
        topPanel = topGroupLayoutPanel();
      //  centerPanel = centerGroupLayoutPanel();
      //  bottomPanel = bottomGroupLayoutPanel();

        // Add the panels to the container panel
        add(topPanel);
       // add(centerPanel);
       // add(bottomPanel);
	}
	
	private JPanel topGroupLayoutPanel() {
		
		JPanel topPanel = new JPanel();
		GroupLayout layout = new GroupLayout(topPanel);
		customDocumentFilter = new CustomDocumentFilter();
		
		resistanceLabel = new JLabel("Resistance (R): ");
        currentLabel = new JLabel("      Current (I): ");
        voltageLabel = new JLabel("     Voltage (V): ");
        powerLabel = new JLabel("        Power (P): ");
        
        ohmLabel = new JLabel(" [Ω]");
        ampLabel = new JLabel(" [A]");
        voltLabel = new JLabel(" [V]");
        wattLabel = new JLabel(" [W]");
        
        resistanceTextField = new JTextField(20);
        currentTextField = new JTextField(20);
        voltageTextField = new JTextField(20);
        powerTextField = new JTextField(20);
        
        ((AbstractDocument) resistanceTextField.getDocument()).setDocumentFilter(new CustomDocumentFilter());
        ((AbstractDocument) currentTextField.getDocument()).setDocumentFilter(new CustomDocumentFilter());
        ((AbstractDocument) voltageTextField.getDocument()).setDocumentFilter(new CustomDocumentFilter());
        ((AbstractDocument) powerTextField.getDocument()).setDocumentFilter(new CustomDocumentFilter());
        
        calculateButton = new JButton("Calculate");
        clearButton = new JButton("  Clear  ");
        
        // Set auto-create gaps and auto-create container gaps to true
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Create horizontal group
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(resistanceLabel)
                .addComponent(resistanceTextField)
        		.addComponent(ohmLabel));
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(currentLabel)
                .addComponent(currentTextField)
        		.addComponent(ampLabel));
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(voltageLabel)
                .addComponent(voltageTextField)
        		.addComponent(voltLabel));
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(powerLabel)
                .addComponent(powerTextField)
        		.addComponent(wattLabel));
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addComponent(calculateButton)
        		.addComponent(clearButton));		
        layout.setHorizontalGroup(hGroup);

        // Create vertical group
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(resistanceLabel)
                .addComponent(currentLabel)
                .addComponent(voltageLabel)
                .addComponent(powerTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(resistanceTextField)
                .addComponent(currentTextField)
                .addComponent(voltageTextField)
                .addComponent(powerTextField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(ohmLabel)
                .addComponent(ampLabel)
                .addComponent(voltageLabel)
                .addComponent(wattLabel));
        layout.setVerticalGroup(vGroup);
        
        customDocumentFilter.changeFont(topPanel, font);
        customDocumentFilter.alignTextFieldsRight(topPanel);
        
        

        return topPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		// get the source of the event
		Object source = e.getSource();
				
		//handle button clicks.
		if (source == calculateButton) { // TODO calculate double/ string = find solution
			try {
				String resistanceStr = resistanceTextField.getText();
		        String currentStr = currentTextField.getText();
		        String voltageStr = voltageTextField.getText();
		        String powerStr = powerTextField.getText();
		        
		        // Parse the values into appropriate data types, handling empty strings
		        double resistance = resistanceStr.isEmpty() ? 0 : Double.parseDouble(resistanceStr);
		        double current = currentStr.isEmpty() ? 0 : Double.parseDouble(currentStr);
		        double voltage = voltageStr.isEmpty() ? 0 : Double.parseDouble(voltageStr);
		        double power = powerStr.isEmpty() ? 0 : Double.parseDouble(powerStr);
		        
		        performCalculations(resistance, current, voltage, power);
				
			}catch(NumberFormatException ex){
				System.out.println("error");
				return;
			}
		}
		else if (source == clearButton) {
		    // clear all text fields
		    resistanceTextField.setText("");
		    currentTextField.setText("");
		    voltageTextField.setText("");
		    powerTextField.setText("");   
		}
	}
	        
	private void performCalculations(double resistance, double current, double voltage, double power) {
		
		Calculations calc = new Calculations(resistance, current, voltage, power);
		
		if (resistance !=0  && current !=0 && voltage !=0 && power !=0) {
	 	// no empty
	        calc.calculateCurrent(0);    
	        calc.calculatePower(0);
	        currentTextField.setText(String.valueOf(calc.current));
	        powerTextField.setText(String.valueOf(calc.power));
	    } 
		// empty (resistance)
		else if (resistance ==0  && current !=0 && voltage !=0 && power !=0) {
	        calc.calculateResistance(0);
	        calc.calculatePower(0);
	        resistanceTextField.setText(String.valueOf(calc.resistance));
	        powerTextField.setText(String.valueOf(calc.power));
	    } 
		// empty (current)
	    else if (resistance !=0  && current ==0 && voltage !=0 && power !=0) {
	    	calc.calculateCurrent(0);
	    	calc.calculatePower(0);
	        currentTextField.setText(String.valueOf(calc.current));
	        powerTextField.setText(String.valueOf(calc.power));
	    } 
		// empty (voltage)
	    else if (resistance !=0  && current !=0 && voltage ==0 && power !=0) {
	    	calc.calculateVoltage(0);
	    	calc.calculatePower(0);
	        voltageTextField.setText(String.valueOf(calc.voltage));
	        powerTextField.setText(String.valueOf(calc.power));
	    } 
		// empty (power)
	    else if (resistance !=0  && current !=0 && voltage !=0 && power ==0) {
	    	calc.calculatePower(0);
	    	calc.calculateResistance(0);
	        powerTextField.setText(String.valueOf(calc.power));
	        resistanceTextField.setText(String.valueOf(calc.resistance));
	    } 
		// empty (resistance, current)
	    else if (resistance ==0  && current ==0 && voltage !=0 && power !=0) {
	    	calc.calculateResistance(2);
	        calc.calculateCurrent(2);
	        resistanceTextField.setText(String.valueOf(calc.resistance));
	        currentTextField.setText(String.valueOf(calc.current));
	    } 
		// empty (current, voltage)
	    else if (resistance !=0  && current ==0 && voltage ==0 && power !=0) {
	    	calc.calculateCurrent(1);
	        calc.calculateVoltage(2);
	        currentTextField.setText(String.valueOf(calc.current));
	        voltageTextField.setText(String.valueOf(calc.voltage));
	    } 
		// empty (voltage, power)
	    else if (resistance != 0  && current !=0 && voltage ==0 && power ==0) {
	    	calc.calculateVoltage(0);
	        calc.calculatePower(2);
	        voltageTextField.setText(String.valueOf(calc.voltage));
	        powerTextField.setText(String.valueOf(calc.power));
	    } 
		// empty (resistance, power)
	    else if (resistance ==0  && current !=0 && voltage !=0 && power ==0) {
	    	calc.calculateResistance(0);
	        calc.calculatePower(0);
	        resistanceTextField.setText(String.valueOf(calc.resistance));
	        powerTextField.setText(String.valueOf(calc.power));
	    } 
		// empty (resistance, voltage)
	    else if (resistance ==0  && current !=0 && voltage ==0 && power !=0) {
	    	calc.calculateResistance(1);
	        calc.calculateVoltage(1);
	        resistanceTextField.setText(String.valueOf(calc.resistance));
	        voltageTextField.setText(String.valueOf(calc.voltage));
	    } 
		// empty (current, power)
	    else if (resistance !=0  && current ==0 && voltage !=0 && power ==0) {
	    	calc.calculateCurrent(0);
	        calc.calculatePower(1);
	        currentTextField.setText(String.valueOf(calc.current));
	        powerTextField.setText(String.valueOf(calc.power));
	    }
	}
}
