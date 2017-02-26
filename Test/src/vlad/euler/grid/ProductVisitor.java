package vlad.euler.grid;
import java.util.ArrayList;
import java.util.Collections;

public class ProductVisitor implements GridVisitor {
	
	private ArrayList<Product> list = new ArrayList<Product>();
	private int adjacents;
	private long maxProduct = 0;
	
	public ProductVisitor(int adjacents) {
		this.adjacents = adjacents;
	}

	@Override
	public void nextValue(long value) {
		for(Product p : list) {
			p.include(value);
		}
		Product p = new Product(value);
		list.add(p);
	}

	@Override
	public void nextSequence() {
		long candidate = Collections.max(list).getProduct();
		if(candidate > maxProduct) {
			maxProduct = candidate;
			System.out.println(maxProduct);
		}
		list = new ArrayList<Product>();
	}
	
	private class Product implements Comparable<Product> {
		
		private int count = 0;
		private long product = 1L;
		
		public Product(long value) {
			product = value;
			count++;
		}
		
		void include(long n) {
			if(count < adjacents) {
				product *= n;
				count++;
			}
		}

		@Override
		public String toString() {
			return "" + product;
		}

		public long getProduct() {
			return product;
		}

		@Override
		public int compareTo(Product o) {
			return (int) (this.product - o.product);
		}
	}

	public long getMaxProduct() {
		return maxProduct;
	}

}
