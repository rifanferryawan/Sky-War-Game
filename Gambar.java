import javax.swing.*;
import java.awt.*;

public class Gambar extends JLabel{
  Icon ic;
	Image im;
	
  public Gambar(String s) {
  	im=Toolkit.getDefaultToolkit().getImage(s);
  	ic=new ImageIcon(im);
  	setIcon(ic);
  }
  public void letak(int a,int b,int c,int d){
  	setBounds(a,b,c,d);
  }
}