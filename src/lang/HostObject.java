package lang;

public class HostObject extends ObjectType {
	@SuppressWarnings("rawtypes")
	Class hostClass;
	Object hostObject;
	
	public HostObject(String classPath, String args) {
		try {
			hostClass = Class.forName(classPath);
			hostObject = hostClass.getConstructor(String.class).newInstance(args);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("cannot find java class " + classPath);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HostObject a = new HostObject("java.lang.String","test");
		System.out.println(a.hostObject.toString());
	}

}
