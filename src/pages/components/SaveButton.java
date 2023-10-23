package pages.components;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Cursor;

public class SaveButton extends JButton{
    public SaveButton(int num){
        this.setIcon(new ImageIcon("./lib/imagens/botoes_num/b_"+(num)+".png"));
        this.setContentAreaFilled(false);
        this.setBorder(new RoundedBorder(120));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBounds(55 + (230 * ((num-1)%2)), 55 + (230 * ((num-1)/2)), 175, 175);
        this.setMnemonic(48+num);
    }
}
