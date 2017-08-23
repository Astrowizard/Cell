package view;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel11 {

	JLabel view;
	JPanel f;
	Image img;
	
	public Panel11(KeyListener listn, MouseListener mlistn, Image i){
		f = new JPanel();
		f.addKeyListener(listn);
		f.addMouseListener(mlistn);
		img = i;
		BufferedImage thing = img.newImg();
		view = new JLabel(new ImageIcon(thing));
		f.add(view);
	}
	
	public JPanel getPanel11(){
		return f;
	}
	
	public void repaint(){
		view.setIcon(new ImageIcon(img.newImg()));
		view.repaint();
	}
	
	public void reset(Image i){
		img = null;
		img = i;
	}

}
