package parser;

import java.util.List;
import lang.ObjectType;

public class ObjectLiteral extends ExpressionNode {
	List<Pair> hash; 
	
	public ObjectLiteral(List<Pair> hash) {
		this.hash = hash;
	}
	
	@Override
	public StatementStatus execute(Context context) {
		ObjectType obj = new ObjectType();
		if (hash != null) {
			for(Pair pair : hash)
				obj.setProperty(pair.getLeft(), pair.getRight().evaluate(context));
		}
		value = obj;
		return new StatementStatus(StatementStatus.Type.Normal, null, null);
	}

}
