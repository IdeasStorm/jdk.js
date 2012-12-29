package parser;

public class WhileStatement extends ExpressionNode {
	ExpressionNode exprssion;
	BlockStatement whileBlock;
	
	public WhileStatement(ExpressionNode exprssion, BlockStatement whileBlock) {
		this.exprssion = exprssion;
		this.whileBlock = whileBlock;
	}
	
	@Override
	public void execute(Context context) {
		Context whileBlockContext = new BlockContext(context);
		while (exprssion.evaluate(context).toBooleanType().toBoolean()) {
			whileBlock.execute(whileBlockContext);
		}
	}

}
