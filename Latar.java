import javax.swing.*;
import java.awt.*;

public class Latar extends JLabel{
  Icon ic;
  Image im;
  int temp=10000;
  
  public Latar(String b) {
  	im=Toolkit.getDefaultToolkit().getImage(b);
  	ic=new ImageIcon(im);
  	setIcon(ic);
  }
  public void letak(int a,int b,int c,int d){
  	setBounds(a,b,c,d);
  }
  public void batas(int a,int b){
  	if(temp<=0){
  		temp=10000;
  		 setLocation(getX()-1,getY());
  		if(getX()<=a){
  			setLocation(b,getY());
  		}	
  	}
  }
  public void jeda(int a){
  	temp=temp-a;
  }
}