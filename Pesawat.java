import javax.swing.*;
import java.awt.*;

public class Pesawat extends JLabel{
	Icon ic;
	Image im,im1,im2,im3;
	int X,Y;
	int life=3;
	int cek=0,y=0,x=100,z=0;
	String temp;
	Suara sEk=new Suara("snd/explode.wav");
	
  public Pesawat(String gb1,String gb2,String gb3) {
  	temp=gb1;
  	im1=Toolkit.getDefaultToolkit().getImage(gb1);
  	im2=Toolkit.getDefaultToolkit().getImage(gb2);
  	im3=Toolkit.getDefaultToolkit().getImage(gb3);
  	ic=new ImageIcon(im1);
  	setIcon(ic);
  }
  public void normal(){
  	ic=new ImageIcon(im1);
  	setIcon(ic);
  }
  public void maju(){
  	ic=new ImageIcon(im1);
  	setIcon(ic);
  	if(getX()<X){
  	  setLocation(getX()+5,getY());
  	}
  }
  public void mundur(){
  	ic=new ImageIcon(im1);
  	setIcon(ic);
  	if(getX()>0){
  		setLocation(getX()-5,getY());
  	}
  }
  public void atas(){
  	ic=new ImageIcon(im2);
  	setIcon(ic);
  	if(getY()>0){
  	  setLocation(getX(),getY()-5);
  	}
  }
  public void bawah(){
  	ic=new ImageIcon(im3);
  	setIcon(ic);
  	if(getY()<Y){
  		setLocation(getX(),getY()+5);
  	}
  }
  public void hancur(boolean b){
  	if(b==true){
  		if(cek==0){
  			x=x-30;
  			if(x<=0){
  	      x=100;
  	      y++;
  	      if(z==0){
  			    z=1;
  			    setBounds(getX()-40,getY()-35,109,96);
  			    sEk.ulang(true);
  			    sEk.hidup(true);
  		    }
  	      im=Toolkit.getDefaultToolkit().getImage("gb/e"+y+".png");
  	      ic=new ImageIcon(im);
  	      setIcon(ic);
  	      if(y>12){
  	   	    setVisible(false);
  	   	    cek=1;
  	   	    hancur(false);
  	   	    y=0;
  	   	    life--;
  	      }
  	    }	
  		}
  	}else{
  		if(cek==1){
  		  if(z==1){
  			  z=0;
  			  setBounds(0,200,60,49);
  			  sEk.hidup(false);
  		  }
  		  setVisible(true);
  		  im=Toolkit.getDefaultToolkit().getImage(temp);
  	    ic=new ImageIcon(im);
  	    setIcon(ic);
  		}
  	}
  }
}