package parser;

public class Pair {

	private final String left;
	private final ExpressionNode right;

	public Pair(String left, ExpressionNode right) {
		this.left = left;
		this.right = right;
	}

	public String getLeft() {
		return left;
	}

	public ExpressionNode getRight() {
		return right;
	}

	@Override
	public int hashCode() {
		return left.hashCode() ^ right.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Pair))
			return false;
		Pair pairo = (Pair) o;
		return this.left.equals(pairo.getLeft())
				&& this.right.equals(pairo.getRight());
	}

}