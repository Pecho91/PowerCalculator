package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CalculatorGui extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private final JFrame frame;
	private final DCPanel dcPanel;
	
	private static final Dimension APP_SIZE = new Dimension (620, 280);
	
	public CalculatorGui(){
		
		this.frame = new JFrame("Power Calculator by Pečo");
		this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.frame.setSize(APP_SIZE);
		this.setLocationRelativeTo(null);
		final JMenuBar menuBar = createMenuBar();
		this.frame.setJMenuBar(menuBar);
		this.dcPanel = new DCPanel();
	
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		
		this.pack();
		this.frame.add(dcPanel);	
	}

	private JMenuBar createMenuBar() {
		final JMenuBar menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createPreferencesMenu());
		return menuBar;
	}
	
	private JMenu createFileMenu() {
		final JMenu fileMenu = new JMenu("File");
		//TODO add clear/reset
		final JMenuItem clearMenuItem = new JMenuItem("Clear");
		clearMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//clear (add new label)
			}		
		});
		
		final JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}		
		});
		
		fileMenu.add(exitMenuItem);
		return fileMenu;
	}
	
	private JMenu createPreferencesMenu() {
		final JMenu preferencesMenu = new JMenu("Preferences");
		//TODO add DC/AC/Energy calc - JPanel switching
		final JMenuItem dcPowerCalc = new JMenuItem("DC power calc");
		final JMenuItem acPowerCalc	= new JMenuItem("AC power calc");
		final JMenuItem energyPowerCalc = new JMenuItem("Energy & power calc");
		
		preferencesMenu.add(dcPowerCalc);
		preferencesMenu.add(acPowerCalc);
		preferencesMenu.add(energyPowerCalc);
		return preferencesMenu;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
