package parser;

import java.util.List;

public class SwitchStatement extends ExpressionNode {
	List<ExpressionNode> expressions;
	List<Statement> statements;
	
	public SwitchStatement(List<ExpressionNode> expressions, 
			List<Statement> statements) {
		this.expressions = expressions;
		this.statements = statements;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		//TODO Default Problem
		BlockContext switchContext = new BlockContext(context);
		boolean entered = false;
		int caseNumber=0;
		for(ExpressionNode exp : expressions) { 
			if (exp.evaluate(context).toBooleanType().toBoolean()) {
				entered = true;
				break;
			}
			caseNumber++;
		}
		if (entered) {
			for(int i=caseNumber; i<statements.size(); i++) {
				StatementStatus status =  statements.get(i).execute(switchContext);
				if (status.type == StatementStatus.Type.Break)
					return new StatementStatus(StatementStatus.Type.Normal, null, null);
			}
		}
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}

}
