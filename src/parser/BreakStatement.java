package parser;

public class BreakStatement extends Statement {

	public BreakStatement() {}

	@Override
	public StatementStatus execute(Context context) {
		return new StatementStatus(StatementStatus.Type.Break, null, null);
	}
}
