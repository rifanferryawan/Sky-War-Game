import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Gameku extends JFrame implements ActionListener,KeyListener{
	Timer tm;
	Random rnd=new Random();
	int cekJeda=1;
	int r,cekGame=0;
	int atas,bawah,maju,mundur,tembak;
	int skor,level=1,x=0;
	boolean hasil;
	
	Gambar gb=new Gambar("gb/info.png");
	Gambar gm=new Gambar("gb/gameover.png");
	Gambar pas=new Gambar("gb/pause.png");
	Pesawat ps=new Pesawat("gb/1.png","gb/2.png","gb/3.png");
  Tembakkan bul=new Tembakkan("gb/peluru.png");
  Suara sBg=new Suara("msk/level1.wav");
  Suara sGm=new Suara("msk/over.wav");
  Latar lt1=new Latar("gb/hill1.png");
  Latar lt2=new Latar("gb/hill2.png");
  Latar lt3=new Latar("gb/hill3.png");
  Latar lt4=new Latar("gb/hill4.png");
  Latar lt5=new Latar("gb/hill5.png");
  Latar lt6=new Latar("gb/hill6.png");
  Latar lt7=new Latar("gb/hill7.png");
  Latar lt8=new Latar("gb/cloud1.png");
  Latar lt9=new Latar("gb/cloud2.png");
  Latar lt10=new Latar("gb/mountain.png");
  Latar lt11=new Latar("gb/moon.png");
  Latar lt12=new Latar("gb/bg.png");
  Info iLevel=new Info(1);
  Info iSkor=new Info(0);
  Info iLife=new Info(3);
  Musuh m1=new Musuh("gb/m1.png");
  Musuh m2=new Musuh("gb/m1.png");
  Musuh m3=new Musuh("gb/m1.png");
  Musuh m4=new Musuh("gb/m1.png");
  Musuh m5=new Musuh("gb/m1.png");
  Musuh m6=new Musuh("gb/m1.png");
  Musuh m7=new Musuh("gb/m1.png");
  Musuh m8=new Musuh("gb/m1.png");
  Musuh m9=new Musuh("gb/m1.png");
  Musuh m10=new Musuh("gb/m1.png");
  Musuh m11=new Musuh("gb/m1.png");
  Musuh m12=new Musuh("gb/m1.png");
  Musuh m13=new Musuh("gb/m1.png");
  Musuh m14=new Musuh("gb/m1.png");
  Musuh m15=new Musuh("gb/m1.png");
  Musuh m16=new Musuh("gb/m1.png");
  
	public Gameku(){
		setSize(600,580);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SKY WAR");
		setLayout(null);
		setLocationRelativeTo(null);
		init();
		tm=new Timer(1,this);
		tm.start();
		addKeyListener(this);
	}
	
	//method untuk inisialisasi awal
	public void init(){
		//Informasi
		getContentPane().add(gm);
		gm.letak(120,130,350,150);
		gm.setVisible(false);
		getContentPane().add(pas);
		pas.letak(120,130,350,150);
		pas.setVisible(false);
    getContentPane().add(iLife);
    iLife.letak(80,487,100,20);
    iLife.jenis("Arial",20);
		getContentPane().add(iLevel);
		iLevel.letak(237,487,100,20);
		iLevel.jenis("Arial",20);
		getContentPane().add(iSkor);
    iSkor.letak(400,487,200,20);
    iSkor.jenis("Arial",20);
    getContentPane().add(gb);
		gb.letak(0,470,593,78);
		//Gambar Pesawat
		getContentPane().add(ps);
		ps.cek=1;
		ps.setBounds(0,200,60,49);
		ps.X=530;
		ps.Y=415;
		//Menambah Gambar Musuh
		getContentPane().add(m1);
		getContentPane().add(m2);
		getContentPane().add(m3);
		getContentPane().add(m4);
		getContentPane().add(m5);
		getContentPane().add(m6);
		getContentPane().add(m7);
		getContentPane().add(m8);
		getContentPane().add(m9);
		getContentPane().add(m10);
		getContentPane().add(m11);
		getContentPane().add(m12);
		getContentPane().add(m13);
		getContentPane().add(m14);
		getContentPane().add(m15);
		getContentPane().add(m16);
		//mengatur Letak Musuh
		m1.letak(3000,350,60,35);
		m1.cek=1;
		m2.letak(2500,75,60,35);
		m2.cek=1;
		m3.letak(2850,150,60,35);
		m3.cek=1;
		m4.letak(2700,220,60,35);
		m4.cek=1;
		m5.letak(-100,150,60,35);
		m5.cek=1;
		m6.letak(-100,150,60,35);
		m6.cek=1;
		m7.letak(-100,150,60,35);
		m7.cek=1;
		m8.letak(-100,150,60,35);
		m8.cek=1;
		m9.letak(-100,150,60,35);
		m9.cek=1;
		m10.letak(-100,150,60,35);
		m10.cek=1;
		m11.letak(-100,150,60,35);
		m11.cek=1;
		m12.letak(-100,150,60,35);
		m12.cek=1;
		m13.letak(-100,150,60,35);
		m13.cek=1;
		m14.letak(-100,150,60,35);
		m14.cek=1;
		m15.letak(-100,150,60,35);
		m15.cek=1;
		m16.letak(-100,150,60,35);
		m16.cek=1;
		//Gambar Peluru
    getContentPane().add(bul);
    //Efek Suara
    sBg.hidup(true);
    sBg.ulang(true);
    //Menambahkan gambar background
    getContentPane().add(lt1);
    getContentPane().add(lt2);
    getContentPane().add(lt3);
    getContentPane().add(lt4);
    getContentPane().add(lt5);
    getContentPane().add(lt6);
    getContentPane().add(lt7);
    getContentPane().add(lt8);
    getContentPane().add(lt9);
    getContentPane().add(lt10);
    getContentPane().add(lt11);
    getContentPane().add(lt12);
    //mengatur letak gambar background
    lt1.letak(0,220,4346,260);
    lt2.letak(-1000,220,3260,263);
    lt3.letak(-500,225,2443,197);
    lt4.letak(-750,220,2064,148);
    lt5.letak(-250,215,1726,111);
    lt6.letak(-500,210,1417,83);
    lt7.letak(0,205,1258,62);
    lt8.letak(50,50,520,299);
    lt9.letak(500,45,260,75);
    lt10.letak(0,10,1774,248);
    lt11.letak(100,50,56,56);
    lt12.letak(0,0,4500,600);
	}
	
  //Event-Event Untuk Game yang berhubungan dengan tombol keyboard
	public void keyTyped(KeyEvent k){
	}
	public void keyPressed(KeyEvent k){
		if(k.getKeyCode()==k.VK_RIGHT){
			if(ps.cek==1){
				maju=1;
			}else{
				maju=0;
			}
		}
		if(k.getKeyCode()==k.VK_LEFT){
			if(ps.cek==1){
			  mundur=1;
			}else{
				mundur=0;
			}
		}
		if(k.getKeyCode()==k.VK_UP){
			if(ps.cek==1){
			  atas=1;
			}else{
				atas=0;
			}
		}
		if(k.getKeyCode()==k.VK_DOWN){
			if(ps.cek==1){
			  bawah=1;
			}else{
				bawah=0;
			}
		}
		if(k.getKeyCode()==k.VK_SPACE){
			if(ps.cek==1){
			  tembak=1;
			}else{
				tembak=0;
			}
		}
	}
	public void keyReleased(KeyEvent k){
	  if(k.getKeyCode()==k.VK_RIGHT){
			maju=0;
		}
		if(k.getKeyCode()==k.VK_LEFT){
			mundur=0;
		}
		if(k.getKeyCode()==k.VK_UP){
			atas=0;
			ps.normal();
		}
		if(k.getKeyCode()==k.VK_DOWN){
			bawah=0;
			ps.normal();
		}
		if(k.getKeyCode()==k.VK_SPACE){
			tembak=0;
		}
		if(k.getKeyCode()==k.VK_M){
			if(cekGame==1){
				sGm.hidup(false);
				Menu mn=new Menu();
				mn.show();
				dispose();
			}
		}
		if(k.getKeyCode()==k.VK_P){
		  if(cekGame==0){
		    if(cekJeda==1){
		    	cekJeda=0;
			    pas.setVisible(true);
			    tm.stop();
		    }else{
		    	cekJeda=1;
			    pas.setVisible(false);
			    tm.start();
	 	    }
	    }
		}
	}
	
	//Method aksi-aksi yang dibagi menjadi beberapa bagian
	public void aksiPesawat(){
		if(maju==1){
			if(ps.cek==1){
			  ps.maju();
			}
		}
		if(mundur==1){
		  if(ps.cek==1){
		    ps.mundur();
		  }
		}
		if(atas==1){
			if(ps.cek==1){
			  ps.atas();
			}
		}
		if(bawah==1){
			if(ps.cek==1){
			  ps.bawah();
			}
		}
	}
	public void aksiTembakan(){
		if(tembak==1){
     	bul.nonaktif(ps.getX(),ps.getY());
    }
    bul.aktif(bul.getX(),bul.getY());
    bul.batas(570);
	}
	public void aksiSuara(){
		if(bul.sBul.x==1){
    	bul.sBul.ulang(true);
    }else{
    	bul.sBul.ulang(false);
    }
	}
	public void aksiLatar(){
		lt1.jeda(10000);
    lt1.batas(-3266,0);
    lt2.jeda(5000);
    lt2.batas(-2450,0);
    lt3.jeda(2500);
    lt3.batas(-1836,0);
    lt4.jeda(1250);
    lt4.batas(-1376,0);
    lt5.jeda(625);
    lt5.batas(-1034,0);
    lt6.jeda(500);
    lt6.batas(-774,0);
    lt7.jeda(400);
    lt7.batas(-580,0);
    lt8.jeda(1000);
    lt8.batas(-2000,600);
    lt9.jeda(300);
    lt9.batas(-2000,700);
    lt10.jeda(250);
    lt10.batas(-1179,0);
    lt11.jeda(125);
    lt11.batas(-1500,620);
	}
	public void aksiMusuh(){
		if(level>=1){
			m1.batas(-100,1000,r=rnd.nextInt(415));
		  m2.batas(-200,900,r=rnd.nextInt(415));
		  m3.batas(-150,1800,r=rnd.nextInt(415));
		  m4.batas(-175,1000,r=rnd.nextInt(415));
		}
		if(level>=2){
		  m5.batas(-70,900,r=rnd.nextInt(415));
		  m6.batas(-425,1800,r=rnd.nextInt(415));
		  m7.batas(-225,800,r=rnd.nextInt(415));
		  m8.batas(-215,900,r=rnd.nextInt(415));
		}
		if(level>=3){
		  m9.batas(-115,1800,r=rnd.nextInt(415));
		  m10.batas(-222,2000,r=rnd.nextInt(415));
		  m11.batas(-123,1755,r=rnd.nextInt(415));
		  m12.batas(-321,656,r=rnd.nextInt(415));
		}
		if(level>=4){
			m13.batas(-50,750,r=rnd.nextInt(415));
			m14.batas(-111,1555,r=rnd.nextInt(415));
			m15.batas(-180,700,r=rnd.nextInt(415));
			m16.batas(-275,1234,r=rnd.nextInt(415));
		}
		iSkor.nilai(skor);
	}
	public void aksiLevel(){
		if(skor>=20&&x==0){
			x=1;
			level=2;
			iLevel.nilai(level);
			sBg.hidup(false);
			sBg=new Suara("msk/level2.wav");
			sBg.hidup(true);
			sBg.ulang(true);
			ps.life++;
		}
		if(skor>=40&&x==1){
			x=2;
			level=3;
			iLevel.nilai(level);
			sBg.hidup(false);
			sBg=new Suara("msk/level3.wav");
			sBg.hidup(true);
			sBg.ulang(true);
			ps.life++;
		}
		if(skor==60&&x==2){
			x=3;
			level=4;
			iLevel.nilai(level);
			sBg.hidup(false);
			sBg=new Suara("msk/level4.wav");
			sBg.hidup(true);
			sBg.ulang(true);
			ps.life++;
		}
	}
	public void cekTabrak(JLabel a,JLabel b,int z){
		if(
			  ((a.getX()+a.getWidth()>=b.getX()) && (a.getX()+a.getWidth()<=(b.getX()+b.getWidth()))) &&
			  ((a.getY()+a.getHeight())>=b.getY()) && (a.getY()+a.getHeight()<=b.getY()+b.getHeight()+z)
			){
			hasil=true;
			bul.batas(a.getX());
		}else{
			hasil=false;
		}
	}
	public void aksiTumbukan(){
		//musuh1 dan peluru
		if(m1.z==0){
      cekTabrak(bul,m1,10);
    }
    if(hasil==true){
      m1.cek=0;
      skor++;
      hasil=false;
    }
    m1.hancur(true);
    //musuh 2 dan peluru
    if(m2.z==0){
      cekTabrak(bul,m2,10);
    }
    if(hasil==true){
      m2.cek=0;
      skor++;
      hasil=false;
    }
    m2.hancur(true);
    //musuh 3 dan peluru
    if(m3.z==0){
      cekTabrak(bul,m3,10);
    }
    if(hasil==true){
      m3.cek=0;
      skor++;
      hasil=false;
    }
    m3.hancur(true);
    //musuh 4 dan peluru
    if(m4.z==0){
      cekTabrak(bul,m4,10);
    }
    if(hasil==true){
      m4.cek=0;
      skor++;
      hasil=false;
    }
    m4.hancur(true);
    //musuh 5 dan peluru
    if(m5.z==0){
      cekTabrak(bul,m5,10);
    }
    if(hasil==true){
      m5.cek=0;
      skor++;
      hasil=false;
    }
    m5.hancur(true);
    //musuh 6 dan peluru
    if(m6.z==0){
      cekTabrak(bul,m6,10);
    }
    if(hasil==true){
      m6.cek=0;
      skor++;
      hasil=false;
    }
    m6.hancur(true);
    //musuh 7 dan peluru
    if(m7.z==0){
      cekTabrak(bul,m7,10);
    }
    if(hasil==true){
      m7.cek=0;
      skor++;
      hasil=false;
    }
    m7.hancur(true);
    //musuh 8 dan peluru
    if(m8.z==0){
      cekTabrak(bul,m8,10);
    }
    if(hasil==true){
      m8.cek=0;
      skor++;
      hasil=false;
    }
    m8.hancur(true);
    //musuh 9 dan peluru
    if(m9.z==0){
      cekTabrak(bul,m9,10);
    }
    if(hasil==true){
      m9.cek=0;
      skor++;
      hasil=false;
    }
    m9.hancur(true);
    //musuh 10 dan peluru
    if(m10.z==0){
      cekTabrak(bul,m10,10);
    }
    if(hasil==true){
      m10.cek=0;
      skor++;
      hasil=false;
    }
    m10.hancur(true);
    //musuh 11 dan peluru
    if(m11.z==0){
      cekTabrak(bul,m11,10);
    }
    if(hasil==true){
      m11.cek=0;
      skor++;
      hasil=false;
    }
    m11.hancur(true);
    //musuh 12 dan peluru
    if(m12.z==0){
      cekTabrak(bul,m12,10);
    }
    if(hasil==true){
      m12.cek=0;
      skor++;
      hasil=false;
    }
    m12.hancur(true);
    //musuh 13 dan peluru
    if(m13.z==0){
      cekTabrak(bul,m13,10);
    }
    if(hasil==true){
      m13.cek=0;
      skor++;
      hasil=false;
    }
    m13.hancur(true);
    //musuh 14 dan peluru
    if(m14.z==0){
      cekTabrak(bul,m14,10);
    }
    if(hasil==true){
      m14.cek=0;
      skor++;
      hasil=false;
    }
    m14.hancur(true);
    //musuh 15 dan peluru
    if(m15.z==0){
      cekTabrak(bul,m15,10);
    }
    if(hasil==true){
      m15.cek=0;
      skor++;
      hasil=false;
    }
    m15.hancur(true);
    //musuh 16 dan peluru
    if(m16.z==0){
      cekTabrak(bul,m16,10);
    }
    if(hasil==true){
      m16.cek=0;
      skor++;
      hasil=false;
    }
    m16.hancur(true);
    
    
    //musuh 1 dan pesawat
    if(m1.z==0){
      cekTabrak(ps,m1,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 2 dan pesawat
    if(m2.z==0){
      cekTabrak(ps,m2,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 3 dan pesawat
    if(m3.z==0){
      cekTabrak(ps,m3,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 4 dan pesawat
    if(m4.z==0){
      cekTabrak(ps,m4,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 5 dan pesawat
    if(m5.z==0){
      cekTabrak(ps,m5,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 6 dan pesawat
    if(m6.z==0){
      cekTabrak(ps,m6,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 7 dan pesawat
    if(m7.z==0){
      cekTabrak(ps,m7,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 8 dan pesawat
    if(m8.z==0){
      cekTabrak(ps,m8,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 9 dan pesawat
    if(m9.z==0){
      cekTabrak(ps,m9,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 10 dan pesawat
    if(m10.z==0){
      cekTabrak(ps,m10,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 11 dan pesawat
    if(m11.z==0){
      cekTabrak(ps,m11,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 12 dan pesawat
    if(m12.z==0){
      cekTabrak(ps,m12,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 13 dan pesawat
    if(m13.z==0){
      cekTabrak(ps,m13,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 14 dan pesawat
    if(m14.z==0){
      cekTabrak(ps,m14,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 15 dan pesawat
    if(m15.z==0){
      cekTabrak(ps,m15,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    //musuh 16 dan pesawat
    if(m16.z==0){
      cekTabrak(ps,m16,50);
    }
    if(hasil==true){
      ps.cek=0;
      hasil=false;
    }
    ps.hancur(true);
    iLife.nilai(ps.life);
	}
	public void selesai(){
		if(ps.life<0){
			//iLevel.nilai(1);
			//iSkor.nilai(0);
			//ps.life=3;
			cekGame=1;
			tm.stop();
			ps.setVisible(false);
			ps.life=0;
			gm.setVisible(true);
			sBg.hidup(false);
			sGm.hidup(true);
		}
	}
	
	//Method untuk aksi-aksi
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==tm){
			//cek game over
			selesai();
			//cek Tumbukkan
		  aksiTumbukan();
			//Level
			aksiLevel();
			//aksi pesawat
			aksiPesawat();
			//aksi tembakkan
      aksiTembakan();
    	//aksi suara
    	aksiSuara();
    	//aksi background
    	aksiLatar();
    	//aksi musuh
    	aksiMusuh();
		}
	}
	
	//Method Program Utama
  //public static void main (String[] args) {
  //	Gameku f=new Gameku();
  //	f.show();
  //}   
}