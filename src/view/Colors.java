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
	
	public static Color color(double[] amount, float[] cellColor){
		
		Color color;
		float red = 0;
		float blue = 0;
		float green = 0;
		try{
			red = (float) (1 - (amount[0]+cellColor[0]));
			blue = (float) (1 - (amount[1] + cellColor[1]));
			green = (float) (1 - (amount[2] + cellColor[2]));
			color = new Color(red, green, blue);
		}
		catch(IllegalArgumentException e){
			color = new Color(0, 0, 0);
			System.out.println("***************Black box*****************");
		}

		return color;
		
	}
	
	
}
