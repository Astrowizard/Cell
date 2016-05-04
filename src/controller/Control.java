package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Window1;

public class Control {
	
	
	public Button resetButton(final Window1 window){
		
		Button button = new Button("Reset");
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	window.reset();
            }
        });
		
		return button;
		
	}
	

}
