package view;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;

import tank.*;

public class Window1 {
	
	static int size = 9;
	static int sqSize = 40;
	BufferedImage surface;
	static JLabel view;
	static Tank tank;
	static TankImg img;
	static JFrame f = new JFrame();
	int count = 0;
	Window2 window2;
	
	public Window1(){
		init();
	}
	
	private void init(){
		
		tank = new Tank();
		tank.addCell(size/2, size/2);
        
		img = new TankImg(tank, sqSize);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.setFocusable(true);
        f.setResizable(false);
        f.pack();
	}
	
	void thing(){
		f.setContentPane(img.view);
		f.pack();
		f.setVisible(true);
		f.addKeyListener(new CustomKeyListener());
		img.view.addMouseListener(new CustomMouseListener());
	}

	class CustomKeyListener implements KeyListener{
	      public void keyTyped(KeyEvent e) {
	    	  if (e.getKeyChar()==KeyEvent.VK_SPACE){
		    	tank.tankLogic();
		    	repaintWindow();
		    	count++;
	    	  }
	      }

	      public void keyPressed(KeyEvent e) {
	      }

	      public void keyReleased(KeyEvent e) {
	      }   
	   }
	
	class CustomMouseListener implements MouseListener{

		public CustomMouseListener(){
			
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			Point p = arg0.getPoint();
			int xx = (int) p.getX();
			int yy = (int) p.getY();
			
			
			tank.position[(xx/img.b)][((yy)/img.b)].putCell(new Cell());
			//window2.showMousePos((int)p.getX(), (int)p.getY());
			
			repaintWindow();
			System.out.println("done");
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			//Point p = arg0.getPoint();
			
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public void reset(){
		tank = new Tank(size);
		repaintWindow();
	}
	
	public void reset(int zz){
		tank = new Tank(zz);
		size = zz;
		sqSize = 40;
		repaintWindow();
		
	}
	
	public void repaintWindow(){
    	img = new TankImg(tank, sqSize);
    	img.view.repaint();
    	f.setContentPane(img.view);
    	img.view.addMouseListener(new CustomMouseListener());
    	f.pack();
    	f.setVisible(true);
	}
	
	public void getWindow2(Window2 window2){
		this.window2 = window2;
	}
	
	}
