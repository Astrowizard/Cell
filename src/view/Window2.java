package view;

import java.awt.Button;
/*import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Control;

public class Window2 {
	
	Control control;
	
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
	JTextField splitE = new JTextField();
	JTextField maxA = new JTextField();
	JTextField moveC = new JTextField();
	
	
	double[] cellStats;

	public Window2(double[] cellS){
		f.setVisible(true);
		
		cellStats = cellS;
		
		splitE.setText(Double.toString(cellStats[0]));
		maxA.setText(Double.toString(cellStats[1]));
		moveC.setText(Double.toString(cellStats[2]));
		
	}
	
	/*private void init(final Window1 window1){
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setLocationByPlatform(true);
		f.setFocusable(true);
		size.setColumns(10);
		splitE.setColumns(10);
		maxA.setColumns(10);
		moveC.setColumns(10);
		
		resetButton = control.resetButton();
		changeSize = control.changeSizeButton();
		printCells = control.printCellsButton();
		addCellRandom = control.addRandomCellButton(cellStats);
		playButton = control.playButton();
		pauseButton = control.pauseButton();
		
		confirmStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	getCellStats();
            }
        });
		
		f.add(resetButton);
		f.add(addCellRandom);
		f.add(printCells);
		f.add(size);
		f.add(changeSize);
		f.add(mousePos);
		
		p.setLayout(new GridLayout(3,2));
		p.add(splitE);
		p.add(splitLabel);
		p.add(maxA);
		p.add(maxLabel);
		p.add(moveC);
		p.add(moveLabel);
		
		p2.add(confirmStats);
		p2.add(playButton);
		p2.add(pauseButton);
		
		f.add(p);
		f.add(p2);
		
		f.pack();
	}*/
	public void showMousePos(int xx, int yy){
		
		String s = xx + " " + yy;
		mousePos.setText(s);
		
		f.repaint();
	}
	
	public void getCellStats(){
		
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
	}
	
	public String getNewSize(){
		return size.getText();
	}

}
