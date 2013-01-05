package parser;

public class ContinueStatement extends Statement {

	public ContinueStatement() {}
	
	@Override
	public StatementStatus execute(Context context) {
		return new StatementStatus(StatementStatus.Type.Continue, null, null);
	}

}
