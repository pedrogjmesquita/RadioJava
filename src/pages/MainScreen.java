package pages;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pages.components.SaveButton;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.io.IOException;

public class MainScreen extends JFrame implements ActionListener {
    private JButton botaoFwd;
    private JButton botaoBwd;
    private JButton resetSaves;    
    private JButton save1;
    private JButton save2;
    private JButton save3;
    private JButton save4;
    private JButton save5;
    private JButton save6;
    JButton [] btsSave;
    private String [] saves = {"0 MHz","0 MHz","0 MHz","0 MHz","0 MHz","0 MHz"};
    private JTextField display;
    private JTextField nome;
    private Clip midia;
    
    public MainScreen(){
        super("Radin");
        setIconImage(new ImageIcon("./lib/imagens/icone.png").getImage());        

        // Inicializa os componentes
        nome = new JTextField("Radio ABC");
        display = new JTextField("81.9 MHz");
        midia = reproduzir(display.getText());
        botaoFwd = new JButton(new ImageIcon("./lib/imagens/botoes_func/fwd.png"));
        botaoBwd = new JButton(new ImageIcon("./lib/imagens/botoes_func/bwd.png"));
        resetSaves = new JButton(new ImageIcon("./lib/imagens/botoes_func/reset.png"));
        save1 = new SaveButton(1);
        save2 = new SaveButton(2);
        save3 = new SaveButton(3);
        save4 = new SaveButton(4);
        save5 = new SaveButton(5);
        save6 = new SaveButton(6);
        JButton [] bts = {save1,save2,save3,save4,save5,save6};
        JButton [] btsFunc = {botaoBwd,resetSaves,botaoFwd};
        this.btsSave = bts;
        JTextField [] displays = {display,nome};
        Container botoes = new Container();        
        JPanel painelDir = new JPanel(); 
        JPanel painelEsq = new JPanel(); 
        
        
        // Seta e adiciona os paineis
        setLayout(new GridLayout(1,2));
        add(painelEsq);
        add(painelDir);
        painelEsq.setLayout(new GridLayout(3,1));
        painelDir.setLayout(null);

        
        // Adiciona os componentes aos paineis
        painelEsq.add(display);
        painelEsq.add(nome);
        painelEsq.add(botoes);
        
        
        // Configura os displays e botoes
        
        
            // Configura os displays
        Font digitalFont = setCustomFont("./lib/fonts/alarm clock.ttf");
        display.setFont(digitalFont);
        nome.setFont(new Font("DialogInput",Font.BOLD,50));
        for(JTextField disp:displays){
            disp.setHorizontalAlignment(JTextField.CENTER);
            disp.setForeground(Color.black);
            disp.setEditable(false);
            disp.setBorder(null);
        }
            
        for(JButton botao: this.btsSave){
            painelDir.add(botao);
            botao.addActionListener(this);
        }
            
            
            // Configura os botoes de funcao
            botoes.setLayout(new GridLayout(1,3));

            resetSaves.setMnemonic(KeyEvent.VK_R);
            botaoFwd.setMnemonic(KeyEvent.VK_RIGHT);
            botaoBwd.setMnemonic(KeyEvent.VK_LEFT);
            botaoBwd.setPressedIcon(new ImageIcon("./lib/imagens/botoes_func/clicked/bwd.png"));
            botaoFwd.setPressedIcon(new ImageIcon("./lib/imagens/botoes_func/clicked/fwd.png"));
            resetSaves.setPressedIcon(new ImageIcon("./lib/imagens/botoes_func/clicked/reset.png"));
            
            for(JButton botao:btsFunc){
                botoes.add(botao);
                botao.addActionListener(this);
                botao.setContentAreaFilled(false);
                botao.setBorder(null);
                botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            } 


        // Configura a janela
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1030,800);
        setLocation(295,140);
        setVisible(true);
    }

    // Funcoes para os botoes
    @Override
    public void actionPerformed(ActionEvent e) {
        String freq = display.getText();
        playSound("./lib/sound/sfx/sfx.wav");

        // Lida com botoes de funcao
        if(e.getSource() == botaoFwd){
            display.setText(aumentaFreq(freq));
            try{midia.stop();}
            catch(Exception ex){}
            midia = reproduzir(display.getText());
        }
        else if(e.getSource() == botaoBwd){
            display.setText((diminuiFreq(freq)));
            try{midia.stop();}
            catch(Exception ex){}
            midia = reproduzir(display.getText());
        }  
        else if(e.getSource() == resetSaves){
            String [] savesOriginais = {"0 MHz","0 MHz","0 MHz","0 MHz","0 MHz","0 MHz"}; 
            this.saves = savesOriginais;
            resetaIcones();
        }

        // Lida com botões numéricos
        else{
            for(int i = 0; i < btsSave.length; i++){
                if(e.getSource() == btsSave[i]) display.setText(botaoSave(freq,i));
            }
            try{midia.stop();}
            catch(Exception ex){}
            midia = reproduzir(display.getText());
        }
        
        
        // Atualiza o nome no display
        nome.setText(freqGetInfo(display.getText(), "nome"));
    }
    

    // Funcoes para reproduzir o som apartir da frequencia
    private Clip reproduzir(String freq) {        
        Clip som = playSound(freqGetInfo(freq, "path"));
        return som;
    }
    
    // Busca o nome e o path da frequencia no banco de dados
    private String freqGetInfo(String freq,String info){
        String q = "SELECT "+info+ " FROM frequencias WHERE freq = '"+freq+"';";
        return DatabaseQuery.buscaDB(q,info);
    }


    private Font setCustomFont(String font) {
        Font customFont = new Font("Dialog-Input",Font.BOLD,40);
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(font)).deriveFont(80f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        } finally{
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        }
        return customFont;
    }


    public String aumentaFreq(String freq){
        freq = freq.split(" ")[0];
        if(freq.equals("107.9"))   return "76.7 MHz";
        else    return String.format("%.1f MHz",(Double.parseDouble(freq)+0.2)).replace(",",".");
    }

    public String diminuiFreq(String freq){
        freq = freq.split(" ")[0];
        if(freq.equals("76.7"))  return "107.9 MHz";
        else    return String.format("%.1f MHz",(Double.parseDouble(freq)-0.2)).replace(",",".");
    }

    public String botaoSave(String freq, int bt){
            if(this.saves[bt].equals("0 MHz")){
                this.saves[bt] = freq;
                this.btsSave[bt].setIcon(new ImageIcon("./lib/imagens/botoes_num/saved/b_"+(bt+1)+"_saved.png"));
                return freq;
            }
            else{
                return this.saves[bt];
            }
    }

    public void resetaIcones(){
        for(int i=0; i < this.btsSave.length; i++){
            String path = "./lib/imagens/botoes_num/b_"+(i+1)+".png";
            this.btsSave[i].setIcon(new ImageIcon(path));
        }
    }

    public static Clip playSound(String soundFilePath) {
        try {
            File som = new File(soundFilePath);
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(som));
            c.start();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
