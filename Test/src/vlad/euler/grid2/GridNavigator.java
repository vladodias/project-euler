package vlad.euler.grid2;

public class GridNavigator implements Cloneable {

	public static void main(String[] args) throws CloneNotSupportedException {
		GridNavigator gn = new GridNavigator(20,20);
		
		gn.walk(0,0,new String());
		
		System.out.println("maxRoutes = " + GridNavigator.maxRoutes);
	}

	private int x = 0;
	private int y = 0;
	private int rows = 0;
	private int cols = 0;
	
	public static int maxRoutes = 0;
	
	public GridNavigator(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}
	
	public void walk(int startX, int startY, String path) throws CloneNotSupportedException {
		
		if(x == lastCol() && y == lastCol()) {
			System.out.println(path);
			maxRoutes++;
		}
		
		if(right(startX, startY)) {
			GridNavigator r = (GridNavigator) this.clone();
			r.walk(x,y,path + "RIGHT ");
		}
		
		if(down(startX, startY)) {
			GridNavigator d = (GridNavigator) this.clone();
			d.walk(x,y,path + "DOWN ");
		}
	}
	
	public boolean down(int startX, int startY) {
		x = startX;
		y = startY;

		y++;
		if(y > lastRow()) {
			y = lastRow();
			return false;
		}
		return true;
	}
	
	public boolean right(int startX, int startY) {
		x = startX;
		y = startY;

		x++;
		if(x > lastCol()) {
			x = lastCol();
			return false;
		}
		return true;
	}
	
	public int lastRow() {
		return rows;
	}
	
	public int lastCol() {
		return cols;
	}
}
