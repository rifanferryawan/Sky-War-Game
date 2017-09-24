import javax.swing.*;
import java.awt.*;

public class Musuh extends JLabel{
  Icon ic;
  Image im;
  int y=0,x=100,z=0,cek=0;
  String temp;
  Suara sEk=new Suara("snd/explode.wav");
  
  public Musuh(String s) {
  	temp=s;
    im=Toolkit.getDefaultToolkit().getImage(s);
  	ic=new ImageIcon(im);
  	setIcon(ic);
  }
  public void letak(int a,int b,int c,int d){
  	setBounds(a,b,c,d);
  }
  public void hancur(boolean b){
  	if(b==true){
  		if(cek==0){
  		  x=x-20;
  	    if(x<=0){
  	      x=100;
  	      y++;
  	      if(z==0){
  			    z=1;
  			    setBounds(getX()-35,getY()-33,109,96);
  			    sEk.ulang(true);
  			    sEk.hidup(true);
  		    }
  	      im=Toolkit.getDefaultToolkit().getImage("gb/e"+y+".png");
  	      ic=new ImageIcon(im);
  	      setIcon(ic);
  	      if(y>12){
  	   	    setVisible(false);
  	   	    cek=1;
  	   	    y=0;
  	      }
  	    }
  		}
  	}else{
  		if(cek==1){
  		  if(z==1){
  			  z=0;
  			  setBounds(getX()+35,getY()+33,60,35);
  			  sEk.hidup(false);
  		  }
  		  setVisible(true);
  		  im=Toolkit.getDefaultToolkit().getImage(temp);
  	    ic=new ImageIcon(im);
  	    setIcon(ic);
  		}
  	}
  }
  public void batas(int a,int b,int c){
  	setLocation(getX()-3,getY());
  	if(getX()<=a){
    	hancur(false);
    	setLocation(b,c);
    }
  }
}