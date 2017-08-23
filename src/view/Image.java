package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import logic.BoardLogic;

public class Image {

	BufferedImage surface;
	Color[] colors = {Color.BLACK,Color.PINK,Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,Color.BLUE,
			Color.MAGENTA,Color.WHITE};
	int b;
	
	
	BoardLogic board;
	Color color;
	
	public Image(BoardLogic bb){
		this.board = bb;
	}
	
	public BufferedImage newImg(){
		
		b = 40;
		
		int z = board.getZ();
		
		
		while (z*b>800){b-=1;}
		
		surface = new BufferedImage(z*b,z*b,BufferedImage.TYPE_INT_RGB);
		Graphics g = surface.getGraphics();
		
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
		return this.surface;
	}
	
	public void drawRect(int x, int y, Color color, Graphics g){
		
		int x1 = x*b;
		int y1 = y*b;
		g.setColor(color);
		g.fillRect(x1, y1, b-1, b-1);
		
	}
}
