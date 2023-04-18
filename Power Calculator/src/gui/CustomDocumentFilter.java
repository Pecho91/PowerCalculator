package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CustomDocumentFilter extends DocumentFilter {
	
		// CustomDocumentFilter (JTextField only numbers and ".")
	private Pattern regxCheck = Pattern.compile("[0-9]*\\.?[0-9]*");
	private int maxCharacters = 3;
	
	
	@Override
	public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
		if(str == null || fb.getDocument().getLength() + str.length() > maxCharacters) {
			return;
		}
		if(regxCheck.matcher(str).matches()) {
			super.insertString(fb, offs, str, a);
		}
	}
	@Override
	public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException{
		if(str == null) {
			return;	
		}
		if(regxCheck.matcher(str).matches()) {
			fb.replace(offset, length, str, attrs);
		}
	}
	
	// JTextField font change
	public void changeFont(final Component component, final Font font) {
		if(component instanceof JLabel || component instanceof JTextField || component instanceof JButton) {
				component.setFont(font);
		}
		if(component instanceof Container) {
			for(Component child : ((Container) component).getComponents()) {
				changeFont(child, font);
			}
		}
	}
	
	// JTextfield align text right
	public void alignTextFieldsRight(final Component component) {
		if(component instanceof JTextField) {
			((JTextField) component).setHorizontalAlignment(SwingConstants.RIGHT);
	
		}
		else if (component instanceof JLabel) {
			((JLabel) component).setHorizontalAlignment(SwingConstants.RIGHT);	
		
		}
		else if (component instanceof JButton) {
			((JButton) component).setHorizontalAlignment(SwingConstants.RIGHT);	
		
		}
		else if(component instanceof Container) {
			for(Component child : ((Container) component).getComponents()) {
				alignTextFieldsRight(child);
			}
		}		
	}  	
}
