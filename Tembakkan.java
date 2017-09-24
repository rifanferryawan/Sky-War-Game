import javax.swing.*;
import java.awt.*;

public class Tembakkan extends JLabel{
  Icon ic;
  Image im;
  boolean bol=false;
  Suara sBul=new Suara("snd/shot.wav");
  
  public Tembakkan(String b) {
  	im=Toolkit.getDefaultToolkit().getImage(b);
  	ic=new ImageIcon(im);
  	setIcon(ic);
  	setVisible(false);
  }
  public void aktif(int a,int b){
  	if(bol==true){
  		setBounds(a+8,b,65,7);
  	}
  }
  public void nonaktif(int a,int b){
  	if(bol==false){
  		sBul.hidup(true);
  		bol=true;
    	setBounds(a,b+30,65,7);
    	setVisible(true);
  	}
  }
  public void batas(int a){
  	if(getX()>=a){
    	bol=false;
    	setBounds(-300,-300,65,7);
    	setVisible(false);
    	sBul.hidup(false);
    }
  }
  public void letak(int a,int b,int c,int d){
  	setBounds(a,b,c,d);
  }
}