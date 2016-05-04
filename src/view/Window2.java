package view;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window2 {
	
	JFrame f = new JFrame();
	Button resetButton = new Button("Reset");
	Button addCellRandom = new Button("Add Random Cell");
	Button changeSize = new Button("Change Size");
	JLabel countLabel = new JLabel();
	JTextField size = new JTextField();
	JLabel mousePos = new JLabel();

	public Window2(Window1 window1){
		init(window1);
		f.setVisible(true);
	}
	
	private void init(final Window1 window1){
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 100);
		f.setLocationByPlatform(true);
		f.setFocusable(true);
		size.setColumns(10);

		resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	window1.reset();
            }
        });
		
		addCellRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	Window1.tank.addCellRandom();
            	window1.repaintWindow();
            }
        });
		
		changeSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	String s = "";
            	s = size.getText();
            	boolean bool = true;
            	int f = 0;
            	for (int i = 0; i < s.length(); i++){
            		if (!Character.isDigit(s.charAt(i))){
            			bool = false;
            		}
            	}
            	if (bool){
            		f = Integer.parseInt(s);
            	}
            	else {
            		f = 9;
            		System.out.println("Not an integer");
            	}
            	window1.reset(f);
            }
		});
		
		f.add(resetButton);
		f.add(addCellRandom);
		f.add(size);
		f.add(changeSize);
		f.add(mousePos);
	}
	
	public void showMousePos(int xx, int yy){
		
		String s = xx + " " + yy;
		mousePos.setText(s);
		
		f.repaint();
		
	}

}
