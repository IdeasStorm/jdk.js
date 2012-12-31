package parser;

import java.util.List;

public class BlockStatement extends Statement {
	
	List<Statement> statements;
	
	public BlockStatement(List<Statement> statements) {
		this.statements = statements;
	}
	
	@Override
	public Trilogy execute(Context context) {
		BlockContext blockContext = new BlockContext(context);
		for(Statement statement : statements) {
			Trilogy trilogy = statement.execute(blockContext);
			if (trilogy.type == Trilogy.Type.Break)
				return new Trilogy(Trilogy.Type.Break, null, trilogy.getIdentifier());
		}
		return new Trilogy(Trilogy.Type.Normal, null, null);
	}
}
