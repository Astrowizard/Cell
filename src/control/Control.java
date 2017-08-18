package control;

import java.awt.Button;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.JPanel;
//import javax.swing.JTextArea;

import cells.Cell;
import cells.Cell1;
import cells.Cell2;
import logic.BoardLogic;
import view.BoardImg;
import view.Window;
import view.Panel1;
import view.Panel2;
import view.Panel3;

public class Control {
	
	Panel1 panel1;
	Panel2 panel2;
	Panel3 panel3;
	Window window;
	BoardLogic board;
	BoardImg img;
	CustomMouseListener msl = new CustomMouseListener();
	
	boolean random = false;
	boolean pause = false;
	boolean first = true;
	int cellType = 0;
	int speed = 100;
	int[] speeds = {1,10,100,250,500};
	int speedCnt = 3;
	
	DecimalFormat tDF = new DecimalFormat("#.00");
	
	//JTextArea jta = new JTextArea(5,2);

	Thread t = new Thread(new threader());
	
	int size = 9;
	int count = 0;
	int sqSize = 40;
	
	public Control(){}
	
	public void advance(){
		board.Logic();
    	panel2.cellNumber(Integer.toString(board.getNum()));
    	if (board.getNum()<=0){
    		pause();
    		saySomething("No more Cells\n" + board.getTot());
    	}
    	img.newImg(board, sqSize);
    	panel1.repaintWindow(img);
    	window.repaint();
    	count++;
    	//System.out.println(count);
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
		saySomething("running");
	}
	
	public void pause(){
		pause = false;
		saySomething(board.getCellOb1() + " ," + board.getCellOb2() + " ," + board.getCellDeath() + " ," + board.getTot());
		saySomething("paused");
	}
	
	public void reset(int zz){
		board = null;
		board = new BoardLogic(random, zz);
		size = zz;
		while(sqSize*zz>800){sqSize-=1;};
    	img.newImg(board, sqSize);
		pause();
		first = true;
		t = null;
		t = new Thread(new threader());
		panel1.repaintWindow(img);
		window.repaint();
	}	
	
	public void checkIntegrity(){
		boolean good = board.integrity();
		System.out.println(good);
	}
	
	public void printCells(){
		saySomething(board.printCells());
	}
	
	public void changeSpeed(){
		speed = speeds[speedCnt%5];
		speedCnt++;
	}
	
	public Button changeSpeedButton(){
		
		Button button = new Button("Change Speed");
		
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	changeSpeed();
            }
        });
		
		return button;
	}
	
	public Button resetButton(){
		
		Button button = new Button("Reset");
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	random = false;
            	reset(size);
            }
        });
		random = false;
		return button;
		
	}
	
	public Button checkIntegrityButton(){
		Button button = new Button("Check Integrity");
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	checkIntegrity();
            }
        });
		
		return button;
		
	}
	
	public Button resetRButton(){
		
		Button button = new Button("Reset R");
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	random = true;
            	reset(size);
            }
        });
		
		return button;
		
	}
	
	public Button changeCellType(){
		
		Button button = new Button("Change Cell");
			button.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent event) {
		        	if (cellType == 0){
		        		cellType = 1;
		        		saySomething("To Cell Type 2");
		        		panel2.changeTypeLabel("Cell 2");
		        	}
		        	else if (cellType == 1){
		        		cellType = 0;
		        		saySomething("To Cell Type 1");
		        		panel2.changeTypeLabel("Cell 1");
		        	}
		        }
    });
	
	return button;
		
	}
	
	public Button changeSizeButton(){
		
		Button button = new Button("Change Size");
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	String s = panel2.getNewSize();
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
            			saySomething("not an integer");
            		}
            	}
            	else {
            		f = 9;
            		saySomething("Not an integer");
            	}
            	if (f > 800){
            		f = 9;
            		saySomething("too big");
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
            	board.addCellRandom();
    			img.newImg(board,sqSize);
            	panel1.repaintWindow(img);
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
						Thread.sleep(speed);
					}
					else{
						Thread.sleep(1);
					}
				}}
			catch(Exception e){
				e.printStackTrace(System.out);
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
			if (arg0.getButton() == MouseEvent.BUTTON1){
				Point p = arg0.getPoint();
				int xx = (int) p.getX();
				int yy = (int) p.getY();
				
				System.out.println(xx + " " + yy);
				
				//yy = yy - 25;
				
				System.out.println(yy);
				
				int x = (int) xx/sqSize;
				int y = (int) yy/sqSize;

				System.out.println(x + " " + y);
				
				Cell cell = null;
				String s = " ";
				
				if (cellType == 0){
					cell = new Cell1();
					s = "Cell 1";
				}
				else if (cellType == 1){
					cell = new Cell2();
					s = "Cell 2";
				}
				
				board.addCell(x,y,cell);
				board.setNum(board.getNum()+1);
				StringBuffer string = new StringBuffer();
				string.append(Math.floor(xx/sqSize) + "," + Math.floor(yy/sqSize) + "\n");
				string.append(xx + "," + yy + "\n");
				string.append(s + "\n");
				//panel2.showMousePos((int)p.getX(), (int)p.getY());
	
				img.newImg(board,sqSize);
				img.repaint();
				panel1.repaintWindow(img);
				string.append("done");
				//saySomething(s);
			}
			if (arg0.getButton() == MouseEvent.BUTTON3){
				Cell cell = null;
				StringBuffer s = new StringBuffer();
				Point p = arg0.getPoint();
				int xx = (int) p.getX();
				int yy = (int) p.getY();
				
				yy = yy - 25;
				
				int x = (int) Math.floor(xx/sqSize);
				int y = (int) Math.floor(yy/sqSize);
				
				if (board.position1[x][y].getLiveCell()){
					cell = board.position1[x][y].getCell();
					String c = "";
					if (cellType == 0){
						cell = new Cell1();
						c = "Cell 1";
					}
					else if (cellType == 1){
						cell = new Cell2();
						c = "Cell 2";
					}
					s.append("Cell Type: " + c + ", " + "Age: " + cell.getAge() + ", " + "Energy: " + cell.getEnergy() + "\n");
				}
				
				double[] r = board.position1[x][y].getResource();
				s.append("R1: " + tDF.format(r[0]) + ", " + "R2: " + tDF.format(r[1]) + "\n");
				saySomething(s.toString());
			}
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
	
	public void saySomething(String s){
		System.out.println(s);
	}

	public void init(){
		board = new BoardLogic(true, size);
		
		img = new BoardImg(msl);
		img.newImg(board, 40);
		
		panel1 = new Panel1(img);
		panel2 = new Panel2();
		panel3 = new Panel3(changeSpeedButton(), checkIntegrityButton());
		
		JPanel p1 = panel1.thing(new CustomKeyListener(),msl);
		JPanel p2 = panel2.init(resetButton(), changeSizeButton(), printCellsButton(), addRandomCellButton(), playButton(), pauseButton(), changeCellType(), resetRButton());
		window = new Window(p1, p2, panel3.init());
		
		}

}
