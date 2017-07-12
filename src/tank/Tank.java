package tank;

import java.util.Random;

public class Tank {
	
	public Position[][] position = new Position[9][9];
	int[] dir = {-1,0,1};
	Random r = new Random();
	int z = 9;
	
	public Tank(){
		createTank();
	}
	
	public Tank(int zz){
		z = zz;
		createTank();
	}
	
	public int getZ(){
		return z;
	}
	
	public void tankLogic(){
		
		int check = 0;
		
		for (int x = 0; x < z; x++){
			for (int y = 0; y < z; y++){
				check = position[x][y].posLogic();
				if (check == 1){
					splitCell(x,y);
				}
				if (check == 2 ){
					//moveCell(x,y);
				}
			}
		}
	}
	
	public void moveCell(int x, int y){
		
		double check2 = -1;
		int[][] pos = new int[9][2];
		int count = 0;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				try{
					if (position[pos[count][0]][pos[count][1]].acid > check2){
						pos[count][0] = x+dir[i];
						pos[count][1] = y+dir[j];
						check2 = position[pos[count][0]][pos[count][1]].acid;
					}
				}
				catch(Exception e){}
				count++;
			}
		}
		
		count = 0;
		int count2 = 0;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				try{
					if (position[pos[count][0]][pos[count][1]].acid == check2 && (x+dir[i]!= x || y+dir[j] != y)){
						pos[count2][0] = x+dir[i];
						pos[count2][1] = y+dir[j];
						count2++;
					}
				}
				catch(Exception e){}
				count++;
			}
		}
		boolean bool = false;
		while (!bool){
			try{
				int rr = r.nextInt(count2);
				
				position[pos[rr][0]][pos[rr][1]].putCell(position[x][y].cell);
				position[x][y].cellMove();
				bool = true;
			}
			catch(Exception e){
			}
		}
		
	}
	
	public void splitCell(int x, int y){
		
		int xx = 1;
		int yy = 1;
		
		double[] cellStats = position[x][y].cell.cellStats();

		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				while (xx == 1 && yy == 1){
					xx = r.nextInt(3);
					yy = r.nextInt(3);
				}
			}
		}
		try{
			position[x+dir[xx]][y+dir[yy]].putCell(new Cell(cellStats[0],cellStats[1],cellStats[2]));
		}
		catch(Exception e){}
	}
	
	public String toString(){
		
		StringBuffer s = new StringBuffer();
		
		for (int x = 0; x < z; x++){
			for (int y = 0; y < z; y++){
				
				if (position[x][y].getLiveCell()){
					s.append(1);
				}
				else{
					s.append(0);
				}
			}
			s.append("\n");
		}
		
		return s.toString();
	}
	
	public void addCellRandom(double[] cellStats){
		int xx = r.nextInt(z);
		int yy = r.nextInt(z);
		boolean bool = true;
		
		while (bool){
			if (!position[xx][yy].liveCell){
				position[xx][yy].putCell(new Cell(cellStats[0],cellStats[1],cellStats[2]));
				bool = false;
			}
			else{
				xx = r.nextInt(z);
				yy = r.nextInt(z);
			}
		}
		
	}

	public void addCell(int xx, int yy, double[] cellStats){
		position[xx][yy].putCell(new Cell(cellStats[0],cellStats[1],cellStats[2]));
	}
	
	public void createTank(){
		position = new Position[z][z];
		for (int x = 0; x < z; x++){
			for (int y = 0; y < z; y++){
				position[x][y] = new Position();
			}
		}
	}
	
	public void printCells(){
		
		StringBuffer s = new StringBuffer();
		int count = 0;
		int k = 0;
		
		for (int i = 0; i < z; i++){
			for (int j = 0; j < z; j++){
				if (position[i][j].liveCell){
					s.append(position[i][j].cell.age + " , " + i + "," + j + "    ");
					count++;
					k++;
				}
				if (k >= 5){
					s.append("\n");
					k = 0;
				}
			}
		}
		s.append("\n" + count);
		System.out.println(s.toString());
	}
	
}
