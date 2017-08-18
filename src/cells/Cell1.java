package cells;

public class Cell1 extends Cell {
	
	public Cell1() {
		super();
		this.energy = .01;
		float[] temp1 = {0,0,(float).5};
		double[] temp2 = {.02, 0};
		double[] temp3 = {0,.02};
		this.color = temp1;
		this.setRsrcConsump(temp2);
		this.cellType = 1;
		this.setRsrcReplen(temp3);
	}

	public Cell1(double sE, double mA, double mC) {
		super(sE, mA, mC);
		float[] temp = {0,0,(float).5};
		this.color = temp;
	}
	
	public float[] getColor(){
		
		return this.color;
	}
	

}
