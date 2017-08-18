package cells;

import java.util.Random;

public class Cell {
	
	public double age;
	double energy;
	Random r = new Random();
	
	double splitEnergy;
	double maxAge;
	double moveChance;
	private double[] rsrcConsump = {0,0};
	private double[] rsrcReplen = {0,0};
	
	public float[] color;
	
	public int cellType;
	
	public Cell(){
		
		this.age = 0;
		this.energy = 0;
		this.splitEnergy = .02;
		this.maxAge = .5;
		this.moveChance = .01;
		
	}
	
	public Cell(double sE, double mA, double mC){
		this.age = 0;
		this.energy = .01;
		this.splitEnergy = sE;
		this.maxAge = mA;
		this.moveChance = mC;
	}
	
	public int logic(double[] resource){
		
		int inf = 0;
		double rr = r.nextDouble();
	
		if (energy>splitEnergy){//Split
			inf = 1;
		}
		if (resource[0] > getRsrcConsump()[0] && resource[1] > getRsrcConsump()[1] && rr>moveChance){//Eat
			inf = 2;
		}
		else if ((resource[0] <= getRsrcConsump()[0] && resource[1] <= getRsrcConsump()[1]) || rr<moveChance){
			inf = 3;//Move
		}
		if (energy == 0){//Die
			inf = 4;
			//System.out.println("out of energy");
		}
		if (age >= maxAge){
			inf = 4;
			//System.out.println("out of time");
		}
		energy = energy - .001;
		age = age + .01;
		return inf;
	}
	
	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public int getCellType() {
		return cellType;
	}

	public void setCellType(int cellType) {
		this.cellType = cellType;
	}

	public void eat(){
		energy+=.01;
	}
	
	public void move(){
		energy-=.01;
	}
	
	public void split(){
		energy = energy - splitEnergy;
	}
	
	public double[] die(){
		double[] ren = new double[2];
		for (int i = 0; i < rsrcConsump.length; i++){
			if (rsrcConsump[i] > 0){
				ren[i] = energy/2;
			}
		}
		return ren;
	}
	
	public double[] cellStats(){
		
		double[] inf = {splitEnergy,maxAge,moveChance};
		
		return inf;
		
	}
	
	public float[] getColor(){
		
		return this.color;
	}

	public double[] getRsrcConsump() {
		return rsrcConsump;
	}

	public void setRsrcConsump(double[] rsrcConsump) {
		this.rsrcConsump = rsrcConsump;
	}

	public double[] getRsrcReplen() {
		return rsrcReplen;
	}

	public void setRsrcReplen(double[] rsrcReplen) {
		this.rsrcReplen = rsrcReplen;
	}

}
