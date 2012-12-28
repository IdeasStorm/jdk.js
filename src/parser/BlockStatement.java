package parser;

import java.util.LinkedList;

public class BlockStatement extends JavaScriptNode {
	
	LinkedList<ExpressionNode> exprssions;
	
	public BlockStatement(LinkedList<ExpressionNode> exprssions) {
		this.exprssions = exprssions;
	}
	
	@Override
	public void execute(Context context) {
		BlockContext blockContext = new BlockContext(context);
		for(ExpressionNode exp : exprssions) {
			exp.execute(blockContext);
		}
	}
}
