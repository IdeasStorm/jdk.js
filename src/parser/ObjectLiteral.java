package parser;

import java.util.List;
import lang.ObjectType;

public class ObjectLiteral extends ExpressionNode {
	List<Pair> hash; 
	
	public ObjectLiteral(List<Pair> hash) {
		this.hash = hash;
	}
	
	@Override
	public Trilogy execute(Context context) {
		ObjectType obj = new ObjectType();
		for(Pair pair : hash)
			obj.setProperty(pair.getLeft(), pair.getRight().evaluate(context));
		return null;
	}

}
