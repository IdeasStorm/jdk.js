package parser;

import java.util.List;

public class BlockStatement extends Statement {
	
	List<Statement> statements;
	
	public BlockStatement(List<Statement> statements) {
		this.statements = statements;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		BlockContext blockContext = new BlockContext(context);
		for(Statement statement : statements) {
			StatementStatus statementStatus = statement.execute(blockContext);
			if (statementStatus.type == StatementStatus.Type.Break)
				return new StatementStatus(StatementStatus.Type.Break, null, statementStatus.getIdentifier());
			if (statementStatus.type == StatementStatus.Type.Continue)
				return new StatementStatus(StatementStatus.Type.Continue, null, statementStatus.getIdentifier());
		}
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}
}
