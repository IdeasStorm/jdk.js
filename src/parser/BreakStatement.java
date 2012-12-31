package parser;

public class BreakStatement extends Statement {

	public BreakStatement() {}

	@Override
	public Trilogy execute(Context context) {
		return new Trilogy(Trilogy.Type.Break, null, null);
	}
}
