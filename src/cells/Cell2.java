package cells;

public class Cell2 extends Cell {

	public Cell2() {
		super();
		this.energy = .01;
		float[] temp1 = {0,0,(float).5};
		double[] temp2 = {0,.02};
		double[] temp3 = {.02,0};
		this.color = temp1;
		this.setRsrcConsump(temp2);
		this.cellType = 2;
		this.setRsrcReplen(temp3);
	}

	public Cell2(double sE, double mA, double mC) {
		super(sE, mA, mC);
		float[] temp = {0,0,(float).5};
		this.color = temp;
	}
	
	public float[] getColor(){
		
		return this.color;
	}

}
