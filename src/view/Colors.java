package view;

import java.awt.Color;

public class Colors {

	public static Color acidColor(double amount){
		
		float red = 1;
		float green = 1;
		float blue = 1;
		
		blue = (float) amount;
		
		Color color = new Color(red,green,blue);
		
		return color;
	}
	
	public static Color cellColor(){
		
		return new Color((float)1,(float)0,(float)0);
		
	}
	
	public static Color color(double amount, boolean live){
		
		Color color;
		float blue = 0;
		float red = 0;
		float green = 0;
		
		if (live){
			red = (float) amount;
			green = (float) amount;
			blue = (float) (1 - amount/2);
		}
		else{
			red = (float) 1;
			green = (float)1;
			blue = (float) (1 - amount);
		}
		try{
			color = new Color(red, green, blue);
		}
		catch(IllegalArgumentException e){
			color = new Color(red, green, 1);
		}

		
		return color;
		
	}
	
	
}
