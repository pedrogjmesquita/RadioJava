package pages.components;

import java.awt.Cursor;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FuncButton extends JButton {
    public FuncButton(char func) {
        switch (func){
            case '>':
            this.setIcon(new ImageIcon("./lib/imagens/botoes_func/fwd.png"));
            this.setPressedIcon(new ImageIcon("./lib/imagens/botoes_func/clicked/fwd.png"));
            this.setMnemonic(KeyEvent.VK_RIGHT);
            break;
            case '<':
            this.setIcon(new ImageIcon("./lib/imagens/botoes_func/bwd.png"));
            this.setPressedIcon(new ImageIcon("./lib/imagens/botoes_func/clicked/bwd.png"));
            this.setMnemonic(KeyEvent.VK_LEFT);
            break;
            case 'r':
            this.setIcon(new ImageIcon("./lib/imagens/botoes_func/reset.png"));
            this.setPressedIcon(new ImageIcon("./lib/imagens/botoes_func/clicked/reset.png"));
            this.setMnemonic(KeyEvent.VK_R);
        }

        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            

    }
}
