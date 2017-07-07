package controller;

import java.awt.Button;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import tank.Cell;
import tank.Tank;
import view.TankImg;
import view.Window1;
import view.Window2;

public class Control {
	
	Window1 window1;
	Window2 window2;
	Tank tank;
	TankImg img;
	boolean pause = false;
	boolean first = true;

	Thread t = new Thread(new threader());
	
	int size = 9;
	int count = 0;
	int sqSize = 40;
	double[] defCellStats ={.05,.3,.01};
	
	public Control(){}
	
	public void advance(){
    	tank.tankLogic();
    	img = new TankImg(tank, sqSize);
    	window1.repaintWindow(img);
    	count++;
	}
	
	public void play(){
		if (first){
			t.start();
			first = false;
			pause = true;
		}
		else{
			pause = true;
		}
		System.out.println("running");
	}
	
	public void pause(){
		pause = false;
		System.out.println("paused");
	}
	
	public Button resetButton(){
		
		Button button = new Button("Reset");
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	reset();
            }
        });
		
		return button;
		
	}
	
	public void reset(){
		tank = new Tank(size);
		img = new TankImg(tank,sqSize);
		pause();
		first = true;
		t = null;
		t = new Thread(new threader());
		window1.repaintWindow(img);
	}
	
	public void reset(int zz){
		tank = new Tank(zz);
		size = zz;
		while(sqSize*zz>800){sqSize-=1;};
		img = new TankImg(tank,sqSize);
		pause();
		first = true;
		t = null;
		t = new Thread(new threader());
		window1.repaintWindow(img);
	}
	
	public void printCells(){
		tank.printCells();
	}
	
	public Button changeSizeButton(){
		
		Button button = new Button("Change Size");
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	String s = window2.getNewSize();
            	boolean bool = true;
            	int f = 0;
            	for (int i = 0; i < s.length(); i++){
            		if (!Character.isDigit(s.charAt(i)) || s == null){
            			bool = false;
            		}
            	}
            	if (bool){
            		try{
            			f = Integer.parseInt(s);
            		}
            		catch(Exception e){
            			System.out.println("not an integer");
            		}
            	}
            	else {
            		f = 9;
            		System.out.println("Not an integer");
            	}
            	if (f > 800){
            		f = 9;
            		System.out.println("too big");
            	}
            	reset(f);
            }
		});
		return button;
	}
	
	public Button printCellsButton(){

		Button button = new Button("Print Cells");
		
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	printCells();
            }
        });
		
		return button;
	}
	
	public Button addRandomCellButton(){
		Button button = new Button("Add Random Cell");
		
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	tank.addCellRandom(defCellStats);
            	window1.repaintWindow(img);
            }
        });
		
		return button;
	}
	
	public Button playButton(){
		
		Button button = new Button("Play");
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				play();
			}
		});
		
		return button;
	}
	
	public Button pauseButton(){
		
		Button button = new Button ("Pause");
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				pause();
			}
		});
		
		return button;
	}
	
	public class threader implements Runnable{
		
		public void run(){
			try{
				while(true){
					if (pause){
						advance();
						Thread.sleep(10);
					}
					else{
						Thread.sleep(1);
					}
				}}
			catch(Exception e){
				
			}
		}
	}
	
	class CustomKeyListener implements KeyListener{
		
		public CustomKeyListener(){
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_SPACE){
				advance();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class CustomMouseListener implements MouseListener{

		public CustomMouseListener(){
			
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			Point p = arg0.getPoint();
			int xx = (int) p.getX();
			int yy = (int) p.getY();
			
			yy = yy - 25;
			
			int x = (int) Math.floor(xx/sqSize);
			int y = (int) Math.floor(yy/sqSize);
			
			
			tank.position[x][y].putCell(new Cell());
			System.out.println(Math.floor(xx/sqSize) + "," + Math.floor(yy/sqSize));
			System.out.println(xx + "," + yy);
			//window2.showMousePos((int)p.getX(), (int)p.getY());

			img = new TankImg(tank,sqSize,p);
			window1.repaintWindow(img);
			System.out.println("done");
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			//Point p = arg0.getPoint();
			
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	public void init(){
		tank = new Tank();
		tank.addCell(size/2, size/2, defCellStats);
		
		img = new TankImg(tank, 40);
		img.view.addMouseListener(new CustomMouseListener());
		
		window1 = new Window1(tank, img);
		window2 = new Window2(defCellStats);
		
		window1.thing(new CustomKeyListener(), new CustomMouseListener());
		window2.init(resetButton(), changeSizeButton(), printCellsButton(), addRandomCellButton(), playButton(), pauseButton());
	}

}
