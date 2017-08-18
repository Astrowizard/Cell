package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
//import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
//import javax.swing.SwingUtilities;

import logic.*;

@SuppressWarnings("serial")
public class BoardImg extends Component {
	
	BufferedImage surface;
	JLabel view;
	Color[] colors = {Color.BLACK,Color.PINK,Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,Color.BLUE,
			Color.MAGENTA,Color.WHITE};
	public int b = 10;
	
	
	BoardLogic board;
	Color color;
	
	public BoardImg(MouseListener msl){
		view = new JLabel();
		view.addMouseListener(msl);
	}
	
	public BoardImg(BoardLogic board, int blocksize, MouseListener msl){
		
		b = blocksize;
		int z = board.getZ();
		this.board = board;
		
		
		while (z*b>800){b-=1;}
		
		surface = new BufferedImage(z*b,z*b,BufferedImage.TYPE_INT_RGB);
		view = new JLabel(new ImageIcon(surface));
		view.addMouseListener(msl);
		Graphics g = surface.getGraphics();
		//g.setColor(new Color(139,30,0));
		//g.fillRect(0, 0, z*b, z*b);
		g.setColor(Color.BLACK);
		for (int i= b;i<z*b;i=i+b){
			g.drawLine(i, 0, i, z*b);
			g.drawLine(0, i, z*b, i);
		}
		for (int i = 0; i<board.getZ();i++){
			for (int j = 0; j<board.getZ(); j++){
				color = Colors.color(board.position1[i][j].getBoardColor(), board.position1[i][j].getCellColor());
				drawRect(i,j,color, g);
			}
		}
	}
	
	public BoardImg(BoardLogic board, int blocksize, Point p){
		
		b = blocksize;
		int z = board.getZ();
		this.board = board;
		
		while (z*b>800){b-=1;}
		
		surface = new BufferedImage(z*b,z*b,BufferedImage.TYPE_INT_RGB);
		view = new JLabel(new ImageIcon(surface));
		Graphics g = surface.getGraphics();
		//g.setColor(new Color(139,30,0));
		//g.fillRect(0, 0, z*b, z*b);
		g.setColor(Color.BLACK);
		for (int i= b;i<z*b;i=i+b){
			g.drawLine(i, 0, i, z*b);
			g.drawLine(0, i, z*b, i);
		}
		for (int i = 0; i<board.getZ();i++){
			for (int j = 0; j<board.getZ(); j++){
				color = Colors.color(board.position1[i][j].getBoardColor(), board.position1[i][j].getCellColor());
				drawRect(i,j,color, g);
			}
		}
	}
	
	public boolean newImg(BoardLogic board, int blocksize){
		b = blocksize;
		int z = board.getZ();
		this.board = board;
		
		while (z*b>800){b-=1;}
		
		surface = new BufferedImage(z*b,z*b,BufferedImage.TYPE_INT_RGB);
		Graphics g = surface.getGraphics();
		//g.setColor(new Color(139,30,0));
		//g.fillRect(0, 0, z*b, z*b);
		g.setColor(Color.BLACK);
		for (int i= b;i<z*b;i=i+b){
			g.drawLine(i, 0, i, z*b);
			g.drawLine(0, i, z*b, i);
		}
		for (int i = 0; i<board.getZ();i++){
			for (int j = 0; j<board.getZ(); j++){
				color = Colors.color(board.position1[i][j].getBoardColor(), board.position1[i][j].getCellColor());
				drawRect(i,j,color, g);
			}
		}
		view.setIcon(new ImageIcon(surface));
		return true;
	}
	
	public void drawRect(int x, int y, Color color, Graphics g){
		
		int x1 = x*b;
		int y1 = y*b;
		g.setColor(color);
		g.fillRect(x1, y1, b-1, b-1);
		
	}
	
	public void repaint(){
    	view.setIcon(new ImageIcon(surface));
    	view.repaint();
	}

	public BufferedImage getSurface(){
		return surface;
	}
	
	public JLabel getView(){
		return view;
	}
}
