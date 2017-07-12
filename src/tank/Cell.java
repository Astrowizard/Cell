package tank;

import java.util.Random;

public class Cell {
	
	double age;
	double energy;
	Random r = new Random();
	
	double splitEnergy;
	double maxAge;
	double moveChance;
	
	public Cell(){
		
		this.age = 0;
		this.energy = .01;
		this.splitEnergy = .05;
		this.maxAge = .3;
		this.moveChance = .01;
		
	}
	
	public Cell(double sE, double mA, double mC){
		this.age = 0;
		this.energy = .01;
		this.splitEnergy = sE;
		this.maxAge = mA;
		this.moveChance = mC;
	}
	
	public int logic(double acid){
		
		int inf = 0;
		
		if (energy>splitEnergy){//Split
			inf = 1;
		}
		else if (acid > 0){//Eat
			inf = 2;
		}
		else if (acid <= 0 || r.nextDouble()<moveChance) inf = 3;//Move
		if (energy == 0 || age >= maxAge){//Die
			inf = 4;
		}
		age = age + .01;
		return inf;
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
	
	public float die(){
		return  (float) energy/2;
	}
	
	public double[] cellStats(){
		
		double[] inf = {splitEnergy,maxAge,moveChance};
		
		return inf;
		
	}

}
