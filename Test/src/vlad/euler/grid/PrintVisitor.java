package vlad.euler.grid;

public class PrintVisitor implements GridVisitor {

	@Override
	public void nextValue(long value) {
		System.out.print(Helper.zeroPad(value) + " ");
	}

	@Override
	public void nextSequence() {
		System.out.println();
	}

}
