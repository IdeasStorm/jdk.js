package lang;

import java.util.ArrayDeque;

public class ArrayType extends ObjectType {
	protected ArrayDeque<ObjectType> value;
	
	public ArrayType(ArrayDeque<ObjectType> value) {
		this.value = value;
	}
	
	@Override
	public ObjectType clone() {
		// TODO Auto-generated method stub
		return new ArrayType((ArrayDeque<ObjectType>)value.clone());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
