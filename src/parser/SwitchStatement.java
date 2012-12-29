package parser;

import java.util.LinkedList;

public class SwitchStatement extends ExpressionNode {
	LinkedList<ExpressionNode> exprssions;
	LinkedList<BlockStatement> blocksStatement;
	
	public SwitchStatement(LinkedList<ExpressionNode> exprssions, 
			LinkedList<BlockStatement> blocksStatement) {
		this.exprssions = exprssions;
		this.blocksStatement = blocksStatement;
	}
	
	@Override
	public void execute(Context context) {		
		for (int i=0; i<exprssions.size(); i++) {
			if (exprssions.get(i).evaluate(context).toBooleanType().toBoolean()) {
				BlockContext caseBlock = new BlockContext(context);
				blocksStatement.get(i).execute(caseBlock);
			}
		}
	}

}
