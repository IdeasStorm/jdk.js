package lang;
import gui.Window;

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
	
	public ObjectType _createWindow() {
		return new Window();
	}
	
	public ObjectType _createButton(ObjectType text) {
		return new Window.Button(text.toStringType().toString());
	}
	
	public ObjectType _createTextField(ObjectType text) {
		return new Window.TextField(text.toStringType().toString());
	}
	
	public ObjectType _createTextField() {
		return new Window.TextField("");
	}
	
}
