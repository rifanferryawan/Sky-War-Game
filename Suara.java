import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;
import javax.swing.*;
import java.awt.event.*;

public class Suara {
	Clip clip; 
	int x;
  public Suara(String s) {
    try{
      URL url=this.getClass().getClassLoader().getResource(s);
      AudioInputStream audioin=AudioSystem.getAudioInputStream(url);
      clip=AudioSystem.getClip();
      clip.open(audioin);
    }catch(UnsupportedAudioFileException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();	
    }catch(LineUnavailableException e){
      e.printStackTrace();
    }
    if(clip.isRunning()){
    	clip.stop();
    }
  }
  public void hidup(boolean b){
    if(b==false){
    	clip.stop();
    }else{
    	clip.start();
    }
  }
  public void trek(int t){
    clip.setFramePosition(t);
  }
  public void ulang(boolean b){
    if(b==false){
    	x=0;
    	if(clip.getFramePosition()==clip.getFrameLength()){
    		clip.setFramePosition(0);
    	}
    }else{
    	x=1;
    	if(clip.getFramePosition()==clip.getFrameLength()){
    		clip.setFramePosition(0);
    		clip.start();
    	}
    }
  }
}