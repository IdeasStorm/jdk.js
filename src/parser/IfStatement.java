package parser;

import java.util.LinkedList;

public class IfStatement extends JavaScriptNode {
	
	private ExpressionNode exprssion;
	private BlockStatement ifBlock;
	private BlockStatement elseBlock;

	public IfStatement(ExpressionNode exprssion, BlockStatement ifBlock, 
			BlockStatement elseBlock) {
		this.exprssion = exprssion;
		this.ifBlock = ifBlock;
		this.elseBlock = elseBlock;
	}
	
	@Override
	public void execute(Context context) {
		// Get the boolean value of expression
		if (exprssion.evaluate(context).toBooleanType().toBoolean()) { // if value true
			Context ifBlockContext = new BlockContext(context);
			ifBlock.execute(ifBlockContext);
		} else { // if the value false
			Context elseBlockContext = new BlockContext(context);
			elseBlock.execute(elseBlockContext);
		}
	}

}
