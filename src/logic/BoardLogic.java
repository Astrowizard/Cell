package logic;


import java.text.DecimalFormat;
import java.util.Random;

import cells.Cell;
import cells.Cell1;
import cells.Cell2;

public class BoardLogic {
	
	public PositionLogic[][] position1 = null;
	public PositionLogic[][] position2 = null;
	int[] dir = {-1,0,1};
	Random r = new Random();
	int z = 9;
	boolean rand = false;
	int cellNum = 0;
	int cellTot = 0;
	int cellOb1 = 0;
	int cellOb2 = 0;
	int cellDeath = 0;
	

	public BoardLogic(){
		createBoard();
	}
	
	public BoardLogic(int zz){
		z = zz;
		createBoard();
	}
	
	public int getCellDeath() {
		return cellDeath;
	}

	public void setCellDeath(int cellDeath) {
		this.cellDeath = cellDeath;
	}

	public int getCellOb1() {
		return cellOb1;
	}

	public void setCellOb1(int cellOb1) {
		this.cellOb1 = cellOb1;
	}

	public int getCellOb2() {
		return cellOb2;
	}

	public void setCellOb2(int cellOb2) {
		this.cellOb2 = cellOb2;
	}

	public BoardLogic(boolean bool, int zz){
		z = zz;
		rand = bool;
		createBoard();
	}
	
	public int getNum(){
		return cellNum;
	}
	
	public void setNum(int i){
		cellNum = i;
	}
	
	public int getTot(){
		return cellTot;
	}
	
	public int getZ(){
		return z;
	}
	
	public void Logic(){
		
		int check = 0;
		position2 = position1.clone();
		
		for (int x = 0; x < z; x++){
			for (int y = 0; y < z; y++){try{
				check = position1[x][y].posLogic();}catch(Exception e){e.printStackTrace(System.out);;}
				if (check == 1){
					if (splitCell(x,y)){
						cellNum++;
						cellTot++;
					}
				}
				if (check == 2){
				}
				try{
				if (check == 3 ){
					if (!moveCell(x,y)){
						cellOb2++;
					}
				}
				}catch(Exception e){System.out.println(e + " in movecell");}
				if (check == 4){
					cellNum--;
					cellDeath++;
				}
			}
		}
		position1 = position2;
	}
	
	/*public void moveCell(int x, int y){
		
		double[] check2 = {-1.0,-1.0};
		int[][] pos = new int[9][2];
		int count = 0;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				for (int k = 0 ; k < 2; k++){
					try{
						if (position[pos[count][0]][pos[count][1]].resource[k] > check2[k]){
							pos[count][0] = x+dir[i];
							pos[count][1] = y+dir[j];
							check2[k] = position[pos[count][0]][pos[count][1]].resource[k];
						}
					}
					catch(Exception e){}
				}
				count++;
			}
		}
		
		count = 0;
		int count2 = 0;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				try{
					if (position[pos[count][0]][pos[count][1]].resource1 == check2 && (x+dir[i]!= x || y+dir[j] != y)){
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
	*/
	
	public boolean moveCell(int x, int y){
		boolean bool = false;
		int rxx = 0;
		int ryy = 0;
		int rx = 0;
		int ry = 0;
		boolean b = false;
		int count = 0;
		while (!bool){
			rx = r.nextInt(3);
			ry = r.nextInt(3);
			
			rxx = x+dir[rx];
			ryy = y+dir[ry];
			
			if (rxx >= z || ryy >= z || rxx < 0 || ryy < 0){
			}
			else if (!(rxx == x && ryy == y) && !position2[rxx][ryy].liveCell){
				//System.out.println(rxx + " ," + ryy + ",, "+ x + ", " + y);
				addCell(rxx,ryy,position1[x][y].cell);
				//System.out.println(position[rxx][ryy].getLiveCell());
				position2[x][y].cellRemove();
				bool = true;
			}
			count++;
			if (count > 10){
				break;
			}
		}
		return b;
	}
	
	public boolean splitCell(int x, int y){
		
		int rxx = 0;
		int ryy = 0;
		int xx = 1;
		int yy = 1;
		
		boolean b = true;
		
		int cellType = position1[x][y].cell.cellType;

		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				while (xx == 1 && yy == 1){
					xx = r.nextInt(3);
					yy = r.nextInt(3);
				}
			}
		}
		rxx = x + dir[xx];
		ryy = y + dir[yy];
		if (rxx >= z || ryy >= z || rxx < 0 || ryy < 0){
			b = false;
		}
		else if(!(rxx == x && ryy == y) && !position2[rxx][ryy].liveCell){
				if (cellType == 1){
					addCell(rxx,ryy,new Cell1());
				}
				if (cellType == 2){
					addCell(rxx,ryy,new Cell2());
				}
		}
		else b = false;
		return b;
	}
	
	public String toString(){
		
		StringBuffer s = new StringBuffer();
		
		for (int x = 0; x < z; x++){
			for (int y = 0; y < z; y++){
				
				if (position1[x][y].getLiveCell()){
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
	
	public void addCellRandom(){
		int xx = r.nextInt(z);
		int yy = r.nextInt(z);
		int k = r.nextInt(2);
		boolean bool = true;
		
		Cell cell = null;
		
		if (k == 0){
			cell = new Cell1();
		}
		
		if (k == 1){
			cell = new Cell2();
		}
		
		while (bool){
			if (!position1[xx][yy].liveCell){
				addCell(xx,yy,cell);
				bool = false;
			}
			else{
				xx = r.nextInt(z);
				yy = r.nextInt(z);
			}
		}
		
	}

	public void addCell(int xx, int yy, Cell cell){
		position2[xx][yy].putCell(cell);
	}
	
	public void createBoard(){
		position1 = new PositionLogic[z][z];
		position2 = new PositionLogic[z][z];
		cellNum = 0;
		cellTot = 0;
		for (int x = 0; x < z; x++){
			for (int y = 0; y < z; y++){
				position2[x][y] = new PositionLogic();
				if (r.nextDouble() < .1 && rand){
					
					int k = r.nextInt(2);
					Cell cell = null;
					
					if (k == 0){
						cell = new Cell1();
					}
					
					if (k == 1){
						cell = new Cell2();
					}
					
					addCell(x,y,cell);
					cellNum++;
					cellTot++;
					
				}
			}
		}
		position1 = position2;
		rand = false;
	}
	
	public boolean integrity(){
		boolean good = true;
		for (int i = 0; i < z; i++){
			for (int j = 0; j < z; j++){
				if (position1[i][j].liveCell && position1[i][j].cell == null){
					good = false;
					System.out.println(i + ", " + j);
				}
			}
		}
		return good;
	}
	
	public String printCells(){
		
		StringBuffer s = new StringBuffer();
		int count = 0;
		DecimalFormat twoDForm = new DecimalFormat("#.00");
		
		for (int i = 0; i < z; i++){
			for (int j = 0; j < z; j++){
				if (position1[i][j].liveCell){
					s.append("age = " + twoDForm.format(position1[i][j].cell.age) + " , x = " + i + " , y = " + j);
					s.append(" , r1 = " + twoDForm.format(position1[i][j].resource[0]) + " , r2 = " + twoDForm.format(position1[i][j].resource[1]) + " , ");
					s.append(position1[i][j].cell.cellType);
					s.append("\n");
					count++;
				}
			}
		}
		s.append(count + "\n" + cellNum);
		//System.out.println(s.toString());
		return s.toString();
	}
	
}