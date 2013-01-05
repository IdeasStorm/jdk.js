package parser;

import java.util.List;

import parser.OperatorNode.OperatorType;

public class SwitchStatement extends ExpressionNode {
	ExpressionNode firstExp;
	List<ExpressionNode> expressions;
	List<Statement> statements;
	
	public SwitchStatement(ExpressionNode firstExp, List<ExpressionNode> expressions, 
			List<Statement> statements) {
		this.firstExp = firstExp;
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
			if (exp.evaluate(context).toBooleanType()
					.operator(OperatorType.Equals, firstExp.evaluate(context))
					.toBooleanType().toBoolean()) {
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
