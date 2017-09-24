import java.awt.*;
import javax.swing.*;

public class Splash extends JWindow{
  int durasi;
  public Splash(int d){
    durasi = d;
  }
  // Method yang bertanggung jawab dalam posisi dan durasi
  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.YELLOW);

    // Menentukan batas window splash screen, dan memposisikan ditengah layar.
    int w  = 406;
    int h = 178;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-w)/2;
    int y = (screen.height-h)/2;
    setBounds(x, y, w,h);

    Gambar logo=new Gambar("gb/splash.jpg");
    getContentPane().add(logo);

    setVisible(true);

    try {
      Thread.sleep(durasi);
    }catch (Exception e) {
    }
    setVisible(false);
  }
}