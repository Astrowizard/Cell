package view;

import java.awt.Button;
/*import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/
import java.awt.GridLayout;

//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Panel2 {
	
	JPanel f = new JPanel();
	
	JPanel p = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	
	Button resetButton = new Button();
	Button addCellRandom = new Button();
	Button changeSize = new Button();
	Button printCells = new Button();
	Button confirmStats = new Button("Confirm Stats");
	Button playButton = new Button();
	Button pauseButton = new Button();
	Button cellTypeButton = new Button();
	Button resetRandomButton = new Button();
	
	JLabel countLabel = new JLabel();
	JLabel cellNum = new JLabel();
	JLabel splitLabel = new JLabel("Split Energy");
	JLabel maxLabel = new JLabel("Max Age");
	JLabel moveLabel = new JLabel("Move Chance");
	JLabel typeLabel = new JLabel("Cell 1");
	
	JTextField size = new JTextField("9");
	//JTextField splitE = new JTextField();
	//JTextField maxA = new JTextField();
	//JTextField moveC = new JTextField();
	
	
	//double[] cellStats;

	public Panel2(){
		f.setVisible(true);
		
		//cellStats = cellS;
		
		//splitE.setText(Double.toString(cellStats[0]));
		//maxA.setText(Double.toString(cellStats[1]));
		//moveC.setText(Double.toString(cellStats[2]));
		
	}
	
	public JPanel init(Button rsb, Button csb, Button pcb, Button acrb, Button pb, Button pab, Button ctb, Button rsr){
		
		f.setSize(300, 300);
		//f.setLocationByPlatform(true);
		f.setFocusable(true);
		size.setColumns(10);
		//splitE.setColumns(10);
		//maxA.setColumns(10);
		//moveC.setColumns(10);
		
		resetButton = rsb;
		changeSize = csb;
		printCells = pcb;
		addCellRandom = acrb;
		playButton = pb;
		pauseButton = pab;
		cellTypeButton = ctb;
		resetRandomButton = rsr;
		
		p3.setLayout(new GridLayout(3,1));
		p3.add(resetButton);
		p3.add(resetRandomButton);
		p3.add(cellNum);
		
		p.setLayout(new GridLayout(3,2));
		p.add(cellTypeButton);
		p.add(typeLabel);
		p.add(changeSize);
		p.add(size);
		p.add(addCellRandom);
		p.add(printCells);
		//p.add(splitE);
		//p.add(splitLabel);
		//p.add(maxA);
		//p.add(maxLabel);
		//p.add(moveC);
		//p.add(moveLabel);
		
		p2.setLayout(new GridLayout(3,1));
		p2.add(confirmStats);
		p2.add(playButton);
		p2.add(pauseButton);
		
		f.add(p3);
		f.add(p);
		f.add(p2);
		
		return f;
	}
	
	public void changeTypeLabel(String s){
		typeLabel.setText(s);
		f.repaint();
	}
	
	public void cellNumber(String cellN){
		
		cellNum.setText(cellN);
		
		//f.repaint();
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
