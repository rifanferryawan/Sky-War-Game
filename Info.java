import javax.swing.*;
import java.awt.*;

public class Info extends JLabel{
	Font fn;
	
  public Info(int a) {
    setText(Integer.toString(a));
    setForeground(Color.ORANGE);
  }
  public void nilai(int a) {
    setText(Integer.toString(a));
  }
  public void letak(int a,int b,int c,int d){
  	setBounds(a,b,c,d);
  }
  public void jenis(String s,int a){
  	fn=new Font(s,Font.BOLD,a);
  	setFont(fn);
  }
}