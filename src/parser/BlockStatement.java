package parser;

import java.util.LinkedList;

public class BlockStatement extends Statement {
	
	LinkedList<Statement> statements;
	
	public BlockStatement(LinkedList<Statement> statements) {
		this.statements = statements;
	}
	
	@Override
	public Trilogy execute(Context context) {
		BlockContext blockContext = new BlockContext(context);
		for(Statement statement : statements) {
			Trilogy trilogy = statement.execute(blockContext);
			if (trilogy.type == Trilogy.Type.Break)
				return new Trilogy(Trilogy.Type.Break, null, trilogy.getIdentifier());
			if (trilogy.type == Trilogy.Type.Continue)
				return new Trilogy(Trilogy.Type.Continue, null, trilogy.getIdentifier());
		}
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}
}
