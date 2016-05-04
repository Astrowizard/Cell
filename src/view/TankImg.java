package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tank.*;

@SuppressWarnings("serial")
public class TankImg extends Component {
	
	BufferedImage surface;
	JLabel view;
	Color[] colors = {Color.BLACK,Color.PINK,Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,Color.BLUE,
			Color.MAGENTA,Color.WHITE};
	int b = 10;
	
	Tank tank;
	
	public TankImg(Tank tank, int blocksize){
		
		b = blocksize;
		int z = tank.getZ();
		this.tank = tank;
		
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
		for (int i = 0; i<tank.getZ();i++){
			for (int j = 0; j<tank.getZ(); j++){
				if (tank.position[i][j].getLiveCell()){
					drawRect(i,j,Colors.cellColor(),g);
				}
				else{
					drawRect(i,j,Colors.acidColor(tank.position[i][j].getAcid()),g);
				}
			}
		}
	}
	
	public TankImg(Tank tank, int blocksize, Point p){
		
		b = blocksize;
		int z = tank.getZ();
		this.tank = tank;
		
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
		for (int i = 0; i<tank.getZ();i++){
			for (int j = 0; j<tank.getZ(); j++){
				if (tank.position[i][j].getLiveCell()){
					drawRect(i,j,Colors.cellColor(),g);
				}
				else{
					drawRect(i,j,Colors.acidColor(tank.position[i][j].getAcid()),g);
				}
			}
		}
	}
	
	public void drawRect(int x, int y, Color color, Graphics g){
		
		int x1 = x*b;
		int y1 = y*b;
		g.setColor(color);
		g.fillRect(x1, y1, b-1, b-1);
		
	}

}
