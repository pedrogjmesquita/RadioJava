package pages.components;

import javax.swing.JTextField;

public class RadioDisplay extends JTextField{
    public RadioDisplay(String text){
        super(text);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setFont(this.getFont().deriveFont(30f));
        this.setEditable(false);
        this.setBorder(null);
    }
    
}
