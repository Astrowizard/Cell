package view;

public class Open {
	
	public static void main(String args[]){
		
		Window1 window1 = new Window1();
		Window2 window2 = new Window2(window1);
		window1.thing();
		window1.getWindow2(window2);
		
	}

}
