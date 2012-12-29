package parser;

import java.util.LinkedList;

public class BlockStatement extends Statement {
	
	LinkedList<Statement> statements;
	
	public BlockStatement(LinkedList<Statement> statements) {
		this.statements = statements;
	}
	
	@Override
	public void execute(Context context) {
		BlockContext blockContext = new BlockContext(context);
		for(Statement statement : statements) {
			statement.execute(blockContext);
		}
	}
}
