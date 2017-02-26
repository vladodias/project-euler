package vlad.euler.grid2;

public class GridNavigator2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		GridNavigator gn = new GridNavigator(6,6);
		
		gn.walk(0,0,new String());
		
		System.out.println("maxRoutes = " + GridNavigator.maxRoutes);
	}

}
