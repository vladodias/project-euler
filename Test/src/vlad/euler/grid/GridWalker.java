package vlad.euler.grid;
import java.io.IOException;

public class GridWalker {

	private static final int DOWN = 1;
	private static final int RIGHT = 1;
	private static final int LEFT = -1;
	private static final int UP = -1;
	private static final int NONE = 0;

	public static void main(String[] args) throws IOException {
		
		Long[][] grid1 = new GridReader().read("resources/grid1.txt");

		GridWalker gw = new GridWalker(grid1);
		
		ProductVisitor pv = new ProductVisitor(4);
		
		gw.walk(GridWalker.UP, GridWalker.RIGHT, pv);
		gw.walk(GridWalker.DOWN, GridWalker.RIGHT, pv);
		gw.walk(GridWalker.UP, GridWalker.LEFT, pv);
		gw.walk(GridWalker.DOWN, GridWalker.LEFT, pv);
		
		gw.walk(GridWalker.NONE, GridWalker.RIGHT, pv);
		gw.walk(GridWalker.NONE, GridWalker.LEFT, pv);

		gw.walk(GridWalker.DOWN, GridWalker.NONE, pv);
		gw.walk(GridWalker.UP, GridWalker.NONE, pv);
		
		System.out.println(pv.getMaxProduct());
	}
	
	private void walk(int vert, int horiz, GridVisitor v) {
		if(horiz != 0) {
			int row = (vert<=0) ? firstRow() : lastRow();
			int col = (horiz>=0) ? firstCol() : lastCol();
			while(isInRange(col,row)) {
				y = row;
				x = col;
				while(isInRange(x,y)) {
					v.nextValue(value());
					y += vert;
					x += horiz;
				}
				row -= (vert!=0) ? vert : -1;
				v.nextSequence();
			}
		}
		if(vert != 0) {
			int row = (vert>=0) ? firstRow() : lastRow();
			int col = (horiz>=0) ? firstCol() : lastCol();
			// the first navigation of the second loop
			// will be the same as the last of the first loop
			// so need to skip one
			col += (horiz==0) ? 0 : horiz;
			while(isInRange(col,row)) {
				y = row;
				x = col;
				while(isInRange(x,y)) {
					v.nextValue(value());
					y += vert;
					x += horiz;
				}
				col += (horiz!=0) ? horiz : 1;
				v.nextSequence();
			}
		}
	}
	
	private boolean isInRange(int x, int y) {
		if(x < 0 || x >= cols) {
			return false;
		}
		if(y < 0 || y >= rows) {
			return false;
		}
		return true;
	}

	private int firstCol() {
		return 0;
	}

	private int firstRow() {
		return 0;
	}
	
	private int lastCol() {
		return cols-1;
	}

	private int lastRow() {
		return rows-1;
	}

	Long[][] grid;
	private int rows;
	private int cols;
	private int x = 0;
	private int y = 0;
	
	
	public GridWalker(Long[][] grid) {
		this.grid = grid;
		rows = grid.length;
		cols = grid[0].length;
	}
	
	public long value() {
		return grid[y][x];
	}
	
	public long value(int x, int y) {
		return grid[y][x];
	}
	
	public int countElements() {
		return rows*cols;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean up() {
		y--;
		if(y < 0) {
			y = 0;
			return false;
		}
		return true;
	}

	public boolean down() {
		y++;
		if(y >= rows) {
			y = (rows-1);
			return false;
		}
		return true;
	}
	
	public boolean right() {
		x++;
		if(x >= cols) {
			x = (cols-1);
			return false;
		}
		return true;
	}
	
	public boolean left() {
		x--;
		if(x < 0) {
			x = 0;
			return false;
		}
		return true;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public static void main1(String[] args) throws IOException {
		

		Long[][] grid1 = new GridReader().read("resources/grid2.txt");

		GridWalker gw = new GridWalker(grid1);
		gw.setPosition(0, 0);

		/* up & right */
		for(int i=0; i<(gw.getRows() + gw.getCols() - 1); i++) {
			int row = Math.min(i, gw.getRows()-1);
			int col = Math.max(0, i-gw.getRows()+1);
			gw.setPosition(col, row);
			
			do {
				System.out.print(Helper.zeroPad(gw.value()) + " ");
			} while(gw.up() && gw.right());
			
			System.out.println();
		}
		
		/* down & right */
		for(int i=0; i<(gw.getRows() + gw.getCols() - 1); i++) {
			int row = Math.max(gw.getRows()-1 - i, 0);
			int col = Math.max(0, i-gw.getRows()+1);
			gw.setPosition(col, row);
			
			do {
				System.out.print(Helper.zeroPad(gw.value()) + " ");
			} while(gw.down() && gw.right());
			
			System.out.println();
		}
		
		/* up & left */
		for(int i=0; i<(gw.getRows() + gw.getCols() - 1); i++) {
			int row = Math.min(i, gw.getRows()-1);
			int col = Math.min(gw.getCols()-1, (gw.getCols()-1)+(gw.getRows()-i-1));
			gw.setPosition(col, row);
			
			do {
				System.out.print(Helper.zeroPad(gw.value()) + " ");
			} while(gw.up() && gw.left());
			
			System.out.println();
		}
		
		/* down & left */
		for(int row=gw.lastRow(); row>=gw.firstRow(); row--) {
			gw.setPosition(gw.lastCol(), row);
			do {
				System.out.print(Helper.zeroPad(gw.value()) + " ");
			} while(gw.down() && gw.left());
			
			System.out.println();		
		}
		for(int col=gw.lastCol()-1; col>=gw.firstCol(); col--) {
			gw.setPosition(col, gw.firstRow());
			do {
				System.out.print(Helper.zeroPad(gw.value()) + " ");
			} while(gw.down() && gw.left());
			
			System.out.println();
		}
		
	}
	
}
