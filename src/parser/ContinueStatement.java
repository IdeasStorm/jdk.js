package parser;

public class ContinueStatement extends Statement {

	public ContinueStatement() {}
	
	@Override
	public Trilogy execute(Context context) {
		return new Trilogy(Trilogy.Type.Continue, null, null);
	}

}
