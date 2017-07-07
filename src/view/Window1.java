package view;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;

import tank.*;

public class Window1 {
	
	static int size = 9;
	static int sqSize = 40;
	BufferedImage surface;
	static JLabel view;
	public static Tank tank;
	static TankImg img;
	static JFrame f = new JFrame();
	int count = 0;
	//Thread t = new Thread(new threader());
	boolean pause = false;
	boolean first = true;
	
	double[] defCellStats ={.05,.3,.01};
	
	public Window1(Tank tank, TankImg imgT){
		
		/*tank = new Tank();
		tank.addCell(size/2, size/2, defCellStats);*/
        
		img = imgT;
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.setFocusable(true);
        f.setResizable(false);
        f.pack();
	}
	
	public void thing(KeyListener listn){
		f.setContentPane(img.view);
		f.pack();
		f.setVisible(true);
		f.addKeyListener(listn);
		//img.view.addMouseListener(new CustomMouseListener());
	}
	
	public void repaintWindow(TankImg imgT){
    	img = imgT;
    	img.view.repaint();
    	f.setContentPane(img.view);
    	f.pack();
    	f.setVisible(true);
	}
	
}
