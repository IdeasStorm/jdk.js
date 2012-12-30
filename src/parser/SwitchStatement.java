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
	public Trilogy execute(Context context) {		
		//TODO made one block
		return new Trilogy(null, null, null);
	}

}
