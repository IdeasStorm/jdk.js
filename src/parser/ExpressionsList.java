package parser;

import java.util.List;

public class ExpressionsList extends ExpressionNode {
	List<ExpressionNode> expressions;
	
	public ExpressionsList(List<ExpressionNode> expressions) {
		this.expressions = expressions;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		for (ExpressionNode exp : expressions)
			value = exp.evaluate(context);
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}

}
