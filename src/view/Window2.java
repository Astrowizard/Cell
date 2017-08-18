package view;

import java.awt.Button;
/*import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Window2 {
	
	JFrame f = new JFrame();
	
	JPanel p = new JPanel();
	JPanel p2 = new JPanel();
	
	Button resetButton = new Button();
	Button addCellRandom = new Button();
	Button changeSize = new Button();
	Button printCells = new Button();
	Button confirmStats = new Button("Confirm Stats");
	Button playButton = new Button();
	Button pauseButton = new Button();
	
	JLabel countLabel = new JLabel();
	JLabel mousePos = new JLabel();
	JLabel splitLabel = new JLabel("Split Energy");
	JLabel maxLabel = new JLabel("Max Age");
	JLabel moveLabel = new JLabel("Move Chance");
	
	JTextField size = new JTextField();
	//JTextField splitE = new JTextField();
	//JTextField maxA = new JTextField();
	//JTextField moveC = new JTextField();
	
	
	double[] cellStats;

	public Window2(){
		f.setVisible(true);
		
	}
	
	public void init(Button rsb, Button csb, Button pcb, Button acrb, Button pb, Button pab){
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		//f.setLocationByPlatform(true);
		f.setFocusable(true);
		size.setColumns(10);
		
		resetButton = rsb;
		changeSize = csb;
		printCells = pcb;
		addCellRandom = acrb;
		playButton = pb;
		pauseButton = pab;
		
		f.add(resetButton);
		f.add(addCellRandom);
		f.add(printCells);
		f.add(size);
		f.add(changeSize);
		f.add(mousePos);
		
		p.setLayout(new GridLayout(3,2));
		p.add(splitLabel);
		p.add(maxLabel);
		p.add(moveLabel);
		
		p2.add(confirmStats);
		p2.add(playButton);
		p2.add(pauseButton);
		
		f.add(p);
		f.add(p2);
		
		f.pack();
	}
	
	public void showMousePos(int xx, int yy){
		
		String s = xx + " " + yy;
		mousePos.setText(s);
		
		f.repaint();
	}
	
	/*public void getCellStats(){
		
		String[] s = {splitE.getText(),maxA.getText(),moveC.getText()};
		
		double d = 0;
		
		for (int i = 0; i < 3; i++){
			
			boolean bool = false;
			
			try{
				d = Double.valueOf(s[i]);
				bool = true;
			}
			catch(Exception e){
				System.out.println("Not a double");
			}
			if (bool && d>=0 && d<=1){
				cellStats[i] = d;
			}
			
		}
		
		splitE.setText(Double.toString(cellStats[0]));
		maxA.setText(Double.toString(cellStats[1]));
		moveC.setText(Double.toString(cellStats[2]));
	}*/
	
	public String getNewSize(){
		return size.getText();
	}

}
