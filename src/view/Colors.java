package view;

import java.awt.Color;

public class Colors {

	public static Color acidColor(int amount){
		
		float red = 1;
		float green = 1;
		float blue = 1;
		
		blue = (float) (1 - .1*amount);
		
		Color color = new Color(red,green,blue);
		
		return color;
	}
	
	public static Color cellColor(){
		
		return new Color((float)1,(float)0,(float)0);
		
	}
	
	
}
