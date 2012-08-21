package extras;

public class Debugger {

	private static Debugger instance;
	
	private Debugger(){}
	
	public static Debugger getInstance(){
		if(instance == null) instance = new Debugger();
		return instance;
	}
	
	public void showOnConsole(String text){
		System.out.println(text);
	}
}
