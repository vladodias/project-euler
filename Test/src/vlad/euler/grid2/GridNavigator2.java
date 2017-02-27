package vlad.euler.grid2;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;

public class GridNavigator2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		int gridSize = 20;
		int digits = gridSize * 2;
		BigInteger number = new BigInteger("2").pow(digits);
		
		int count = 0;
		String binary;
		do {
			number = number.add(new BigInteger("-1"));
			binary = StringUtils.leftPad(number.toString(2),digits,'0');
			System.out.println(
					StringUtils.leftPad(number.toString(),gridSize,'0')
					+ " : "
					+ binary
					+ " : "
					+ StringUtils.countMatches(binary, '0')
					);
			
			if(StringUtils.countMatches(binary, '0') == gridSize) {
				count++;
			}
			
		} while(!StringUtils.containsOnly(binary, '0'));
		
		System.out.println(count);
	}

	public static void main1(String[] args) throws CloneNotSupportedException {

		String[] directions = {"d", "r"};
		int routeSize = 2*2;
		int possibleRoutes = (int)Math.pow(directions.length, routeSize);
		String[][] routes = new String[possibleRoutes][routeSize];
		
		for(int i=0; i<possibleRoutes; i++) {
			for(int j=0; j<routeSize; j++) {
				routes[i][j] = directions[(i+j) %2];
			}
			System.out.println(StringUtils.join(routes[i]));
		}
	}

}
