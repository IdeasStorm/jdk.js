package lang;
import java.util.Scanner;

public class ProgramObject extends ObjectType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ProgramObject() {
		// setting aliases
		this.setProperty("document", this);
		this.setProperty("console", this);
	}
	
	public ObjectType _Object() {
		return new ObjectType();
	}
	
	public ObjectType _write(ObjectType obj) {
		System.out.print(obj.toStringType().toString());
		return undefined;
	}
	
	public ObjectType _writeln(ObjectType obj) {
		System.out.println(obj.toStringType().toString());
		return undefined;
	}
	
	public ObjectType _log(ObjectType obj) {
		return _writeln(obj);
	}
	
	public ObjectType _read() {
		ObjectType res;
		Scanner scanIn = new Scanner(System.in);
		res = new StringType(scanIn.nextLine());
		return res;
	}
	
}
