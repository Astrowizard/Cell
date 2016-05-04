package tank;

public class Position {
	
	int acid;
	Cell cell = null;
	boolean liveCell = false;
	
	public Position(){
		
		this.acid = 10;
		
	}
	
	public boolean getLiveCell(){
		return liveCell;
	}
	
	public int posLogic(){
		
		int inf = 0;
		int inff = 0;
		if (liveCell){
			inf = cell.logic(acid);
			if (inf == 1){ // Split
				inff = 1;
				cell.split();
			}
			if (inf == 2){ // Eat
				cellEat();
			}
			if (inf == 3){ // Move
				cell.move();
				inff = 2;
			}
			if (inf == 4){ // Die 
				cellDie();
			}
		}
		return inff;
	}
	
	public void putCell(Cell cell){
		
		this.cell = cell;
		liveCell = true;
		
	}
	
	public void cellEat(){
		
		cell.eat();
		acid --;
		
	}
	
	public void cellMove(){
		cell = null;
		liveCell = false;
	}
	
	public void cellDie(){
		
		this.acid = this.acid + cell.die();
		cell = null;
		liveCell = false;
		
	}

	public int getAcid() {
		return acid;
	}

}
