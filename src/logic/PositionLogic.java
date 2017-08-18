package logic;

import cells.Cell;

public class PositionLogic implements Cloneable{
	
	double[] resource;
	Cell cell = null;
	boolean liveCell = false;
	
	public double[] getResource() {
		return resource;
	}

	public void setResource(double[] resource) {
		this.resource = resource;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public boolean getLiveCell(){
		return liveCell;
	}
	
	public void setLiveCell(boolean liveCell) {
		this.liveCell = liveCell;
	}

	public PositionLogic(){
		
		double[] temp = {.3,.3};
		this.resource = temp;
		
	}
	
	public int posLogic(){
		
		int inf = 0;
		if (liveCell){
			inf = cell.logic(resource);
			if (inf == 1){ // Split
				//System.out.println("split");
				cell.split();
			}
			if (inf == 2){ // Eat
				cellEat();
				if (resource[0] > 1 || resource[1] > 1 || resource[0] < 0 || resource[1] < 0){
					//System.out.println(resource[0] + " " + resource[1]);
				}
			}
			if (inf == 3){ // Move
			}
			if (inf == 4){ // Die 
				cellDie();
			}
		}
		return inf;
	}
	
	public boolean putCell(Cell cell){
		
		this.cell = cell;
		liveCell = true;
		return liveCell;
		
	}
	
	public void cellEat(){
		
		cell.eat();
		double[] consumption = cell.getRsrcConsump();
		double[] replenishment = cell.getRsrcReplen();
		for (int i = 0; i < resource.length; i++){
			if (resource[i] > consumption[i]){
				resource[i] = resource[i] - consumption[i] + replenishment[i];
			}
		}
	}
	
	public void cellRemove(){
		
		//System.out.println("Cell Remove");
		cell = null;
		liveCell = false;
	}
	
	public void cellDie(){

		//System.out.println("Cell Death");
		double[] ren = cell.die();
		for (int i = 0; i < resource.length; i++){
			resource[i] = resource[i] + ren[i];
		}
		cell = null;
		liveCell = false;
		
	}
	
	public double[] getBoardColor(){
		
		for (int i = 0; i < resource.length; i++){
			if (resource[i] < 0){
				resource[i] = 0;
			}
			if (resource[i] > 1){
				resource[i] = 1;
			}
		}
		
		double[] color = {resource[1], resource[0],0};
		return color;
	}
	
	public float[] getCellColor(){
		try{
		if (liveCell){
			return cell.getColor();
		}
		else{
			float[] color = {0,0,0};
			return color;
		}}
		catch(Exception e){
			System.out.println("here");
			float[] color = {0,0,0};
			return color;
		}
	}
	
	public PositionLogic clone() throws CloneNotSupportedException{
		return (PositionLogic) super.clone();
	}

}
