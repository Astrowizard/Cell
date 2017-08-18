package view;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Panel3 {

	JPanel p = new JPanel();
	
	Button changeSpeed = new Button();
	Button checkIntegrity = new Button();
	
	public Panel3() {
		
	}
	
	public Panel3(Button cS, Button chi){
		changeSpeed = cS;
		checkIntegrity = chi;
	}
	
	public JPanel init(){
		p.setLayout(new GridLayout(3,1));
		p.add(changeSpeed);
		p.add(checkIntegrity);
		return p;
	}

}
