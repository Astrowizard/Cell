package view;

import java.awt.Point;

public class Test {
	
	public static void main(String args[]){
		

		String s = "10";
		
		for (int i = 0; i < s.length(); i++){
			System.out.println(Character.isDigit(s.charAt(i)));
		}
		
		Point p = new Point(485,599);
		
		int x = (int) p.getX();
		int y = (int) p.getY();
		
		int xx = x/10;
		int yy = y/10;
		
		System.out.println(xx + " " + yy);
	}

}
