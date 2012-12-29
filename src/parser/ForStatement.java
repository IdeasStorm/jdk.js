package parser;

public class ForStatement extends ExpressionNode {
	ExpressionNode frExprssion;
	ExpressionNode sdExpression; 
	ExpressionNode thdExpression;
	BlockStatement forBlock;
	
	public ForStatement(ExpressionNode frExprssion, ExpressionNode sdExpression, 
			ExpressionNode thdExpression, BlockStatement forBlock) {
		this.frExprssion = frExprssion;
		this.sdExpression = sdExpression;
		this.thdExpression = thdExpression;
		this.forBlock = forBlock;
	}
	
	@Override
	public void execute(Context context) {
		BlockContext forBlockContext = new BlockContext(context); 
		frExprssion.execute(forBlockContext);
		while (sdExpression.evaluate(context).toBooleanType().toBoolean()) {
			forBlock.execute(forBlockContext);
			thdExpression.execute(forBlockContext);
		}
	}

}
