import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener,KeyListener{
	Gambar bg=new Gambar("gb/menu.png");
  Gambar p=new Gambar("gb/pick.png");
  Suara sBg=new Suara("msk/menu.wav");
  Timer tm;
  int pilih=1;
  
  public Menu() {
  	setTitle("SKY WAR");
  	setSize(600,520);
  	setDefaultCloseOperation(EXIT_ON_CLOSE);
  	setResizable(false);
  	setLocationRelativeTo(null);
  	setLayout(null);
  	init();
  	tm=new Timer(1,this);
		tm.start();
		addKeyListener(this);
  }
  public void init(){
  	getContentPane().add(p);
  	p.setBounds(230,235,32,26);
  	//p.setBounds(230,270,32,26);
  	
  	getContentPane().add(bg);
  	bg.setBounds(0,0,594,490);
  	
  	sBg.hidup(true);
    sBg.ulang(true);
  }
  public void keyTyped(KeyEvent ke){
  }
  public void keyPressed(KeyEvent ke){
  	if(ke.getKeyCode()==ke.VK_UP){
  		pilih=1;
  		p.setBounds(230,235,32,26);
  	}
  	if(ke.getKeyCode()==ke.VK_DOWN){
  		pilih=2;
  	  p.setBounds(230,270,32,26);
  	}
  }
  public void keyReleased(KeyEvent ke){
  	if(ke.getKeyCode()==ke.VK_ENTER){
  		if(pilih==1){
  			tm.stop();
  			sBg.hidup(false);
  			Gameku gm=new Gameku();
  			gm.show();
  			dispose();
  		}
  		if(pilih==2){
  			System.exit(0);
  		}
  	}
  }
  public void actionPerformed(ActionEvent ae){
  }
  //public static void main (String[] args) {
  //  Menu mn=new Menu();
  //  mn.show();
  //}
}