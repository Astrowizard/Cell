package tank;

import java.util.Random;

public class Cell {
	
	int age;
	int energy;
	Random r = new Random();
	
	public Cell(){
		
		this.age = 0;
		this.energy = 1;
		
	}
	
	public int logic(int acid){
		
		int inf = 0;
		
		if (energy>4){//Split
			inf = 1;
		}
		else if (acid > 0){//Eat
			inf = 2;
		}
		else if (acid <= 0 || r.nextDouble()<.1) inf = 3;//Move
		if (energy == 0){//Die
			inf = 4;
		}
		return inf;
	}
	
	public void eat(){
		energy++;
	}
	
	public void move(){
		energy--;
	}
	
	public void split(){
		energy = energy/2;
	}
	
	public int die(){
		return energy;
	}

}
