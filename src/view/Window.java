package view;
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextArea;

public class Window {

	JFrame f = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	
	public Window() {
	}
	
	public Window(JPanel panel1, JPanel panel2, JPanel panel3/*, JTextArea jta*/){
		f.setLayout(new GridLayout(1,2));
		p1 = panel1;
		p2 = panel2;
		
		p3.setLayout(new GridLayout(2,1));
		p3.add(p2);
		p3.add(panel3);
		//p3.add(jta);
		
		f.add(p1);
		f.add(p3);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.setFocusable(true);
        f.setResizable(true);
        f.setVisible(true);
        f.pack();
	}
	
	public void repaint(){
		f.repaint();
    	f.pack();
    	f.setVisible(true);
	}

}
