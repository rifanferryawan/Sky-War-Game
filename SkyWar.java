public class SkyWar {
  public SkyWar() {
  } 
  public static void main (String[] args) {
  	Splash s=new Splash(4000);
    s.showSplash();
    Menu mn=new Menu();
    mn.show();
  }
}