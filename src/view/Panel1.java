package view;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.BoardLogic;

public class Panel1 {
	
	static int size = 9;
	static int sqSize = 40;
	BufferedImage surface;
	static JLabel view;
	public static BoardLogic board;
	static BoardImg img;
	static JPanel f = new JPanel();
	int count = 0;
	//Thread t = new Thread(new threader());
	boolean pause = false;
	boolean first = true;
	
	public Panel1(BoardImg imgT){
		
		/*tank = new Tank();
		tank.addCell(size/2, size/2, defCellStats);*/
        
		img = imgT;
		//view = new JLabel(new ImageIcon(img.getSurface()));
    	f.add(img.getView());
		
	}
	
	public JPanel thing(KeyListener listn, MouseListener mlistn){
		f.addKeyListener(listn);
		f.addMouseListener(mlistn);
		//img.view.addMouseListener(new CustomMouseListener());
		return f;
	}
	
	public void repaintWindow(BoardImg imgT){
    	img = imgT;
    	//view.setIcon(new ImageIcon(img.surface));
    	//view.repaint();
    	img.repaint();
	}
	
}
